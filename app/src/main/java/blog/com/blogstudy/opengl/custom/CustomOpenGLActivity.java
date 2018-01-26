package blog.com.blogstudy.opengl.custom;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import blog.com.blogstudy.opengl.custom.renderer.DurianGLRender;
import blog.com.blogstudy.opengl.custom.renderer.GL20DurianGLRender;
import blog.com.blogstudy.opengl.custom.renderer.GLRenderer;

/**
 * Created by MDove on 18/1/23.
 */

public class CustomOpenGLActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLSurfaceView surfaceView = new GLSurfaceView(this);
        surfaceView.setRenderer(new GLRenderer());
        setContentView(surfaceView);
    }
}
