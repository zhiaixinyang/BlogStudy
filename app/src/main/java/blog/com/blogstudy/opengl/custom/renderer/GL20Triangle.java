package blog.com.blogstudy.opengl.custom.renderer;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by MDove on 18/1/25.
 */

public class GL20Triangle {
    /**
     * OpenGL在底层的实现是C语言，与Java默认的数据存储字节顺序可能不同，即大端小端问题。
     * 因此，为了保险起见，在将数据传递给OpenGL之前，我们需要指明使用本机的存储顺序。
     */
    private FloatBuffer vertexBuffer;

    /**
     * 坐标系中:
     * [0, 0, 0]代表View的中心
     * [1, 1, 0]对应的是右上角
     * [-1, -1, 0]对应的则是左下角
     */
    private float[] triangleCoords = {//按逆时针顺序
            0.0f,  0.622008459f, 0.0f,//上
            -0.5f, -0.311004243f, 0.0f,//左
            0.5f, -0.311004243f, 0.0f//右
    };
    //设置颜色坐标，对应A、R、G、B
    float color[] = {0.63671875f, 0.76953125f, 0.22265625f, 1.0f};

    private final static int COORDS_PER_VERTEX = 3;
    private final int vertexCount = triangleCoords.length / COORDS_PER_VERTEX;
    private final int vertexStride = COORDS_PER_VERTEX * 4;

    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
                    "void main() {" +
                    "  gl_Position = vPosition;" +
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";
    private final int mProgram;

    private int mPositionHandle;
    private int mColorHandle;

    public GL20Triangle() {
        //先初始化buffer，数组的长度*4，因为一个float占4个字节
        ByteBuffer vbb = ByteBuffer.allocateDirect(triangleCoords.length * 4);
        //以本机字节顺序来修改此缓冲区的字节顺序
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        //将给定float[]数据从当前位置开始，依次写入此缓冲区
        vertexBuffer.put(triangleCoords);
        //设置缓冲区来读取第一个坐标（如果标记已定义并且大于新的位置，则要丢弃该标记）
        vertexBuffer.position(0);

        int vertexShader = GL20DurianGLRender.loadShader(GLES20.GL_VERTEX_SHADER,
                vertexShaderCode);
        int fragmentShader = GL20DurianGLRender.loadShader(GLES20.GL_FRAGMENT_SHADER,
                fragmentShaderCode);
        // 创建一个空的OpenGL ES Program
        mProgram = GLES20.glCreateProgram();
        // 给Program添加顶点着色器
        GLES20.glAttachShader(mProgram, vertexShader);
        // 给Program添加片段（fragment）着色器
        GLES20.glAttachShader(mProgram, fragmentShader);
        // 创建OpenGL ES Program可执行文件
        GLES20.glLinkProgram(mProgram);
    }

    public void draw() {
        // 将程序添加到OpenGL ES环境
        GLES20.glUseProgram(mProgram);

        // 获取顶点着色器的vPosition成员的引用
        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");

        // 启用三角形顶点的引用
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // 准备三角形坐标数据
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                vertexStride, vertexBuffer);

        // 获取片段着色器的vColor对象
        mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");

        // 设置绘制三角形的颜色
        GLES20.glUniform4fv(mColorHandle, 1, color, 0);

        // 画三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);

        // 禁用顶点数组
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
    private int mMVPMatrixHandle;
    //接收组合后的变换矩阵，并将它应用到图形上
    public void draw(float[] mvpMatrix) {
        // 得到形状的变换矩阵的引用
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");
        // 将投影和视图转换传递给着色器
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);
        // 画三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);
        // 释放资源
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
