package blog.com.blogstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import blog.com.blogstudy.R;
import blog.com.blogstudy.kotlin.KotlinActivity;
import blog.com.blogstudy.opengl.custom.CustomOpenGLActivity;
import blog.com.blogstudy.opengl.custom.show3d.OpenGL3DActivity;
import blog.com.blogstudy.opengl.google.OpenGLGoogleActivity;
import blog.com.blogstudy.recyclerview.zhihuad.RlvZhiHuAdActivity;
import blog.com.blogstudy.recyclerview.banner.activity.RlvBannerRlvActivity;
import blog.com.blogstudy.recyclerview.refresh.activity.RlvRefreshListActivity;
import blog.com.blogstudy.view.bitmap.BitmapActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_banner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RlvBannerRlvActivity.class));
            }
        });
        findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RlvRefreshListActivity.class));
            }
        });
        findViewById(R.id.btn_zhihu_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RlvZhiHuAdActivity.class));
            }
        });
        findViewById(R.id.btn_surfaceview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SurfaceViewActivity.class));
            }
        });
        findViewById(R.id.btn_opengl_3d).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OpenGL3DActivity.class));
            }
        });
        findViewById(R.id.btn_opengl_google).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OpenGLGoogleActivity.class));
            }
        });
        findViewById(R.id.btn_right_mark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RightMarkActivity.class));
            }
        });
        findViewById(R.id.btn_path).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PathActivity.class));
            }
        });
        findViewById(R.id.btn_leaf_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LeafLoadingActivity.class));
            }
        });
        findViewById(R.id.btn_xiaomi_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XiaoMiActivity.class));
            }
        });
        findViewById(R.id.btn_opengl_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomOpenGLActivity.class));
            }
        });
        findViewById(R.id.btn_kotlin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KotlinActivity.class));
            }
        });
        findViewById(R.id.btn_bitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BitmapActivity.class));
            }
        });
    }
}
