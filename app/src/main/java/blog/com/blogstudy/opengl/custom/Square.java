package blog.com.blogstudy.opengl.custom;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by MDove on 18/1/15.
 */

public class Square {
    private FloatBuffer vertexBuffer;

    private float[] vertices = {
            -1.0f, -1.0f, 0.0f,//左上
            1.0f, -1.0f, 0.0f,//左下
            -1.0f, 1.0f, 0.0f,//右下
            1.0f, 1.0f, 0.0f//右上
    };

    public Square() {

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

    }

    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }
}
