package com.mdove.app2;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mdove.app2.opengl.DurianGLRender;

public class MainActivity extends AppCompatActivity {
    private GLSurfaceView glview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glview = new GLSurfaceView(this);
        //glinputview=new DurianInputSurfaceView(this);
        //glview.setRenderer(new DurianPhotoRender(this)/*new DurianTextureRender(this)*//*new Durian3DRender(this)*//*new DurianRotateRender(this)*//*new DurianGLRender(this)*/);
        glview.setRenderer(new DurianGLRender(this));
        setContentView(/*new DurianTextureFilterSurfaceView(this)*//*glinputview*/glview/*R.layout.activity_durian_main*/);
    }

    @Override
    protected void onResume() {
        super.onResume();
        glview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glview.onPause();
    }
}
