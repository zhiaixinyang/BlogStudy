package blog.com.blogstudy.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import blog.com.blogstudy.R;

/**
 * Created by MDove on 2017/12/20.
 */

public class Glide3Activity extends AppCompatActivity {
    private ImageView imageView;
    private Button btnLoad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide3);
        btnLoad = (Button) findViewById(R.id.btn_load);
        imageView = (ImageView) findViewById(R.id.image);

        SimpleTarget<Bitmap> target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageView.setImageBitmap(resource);
            }
        };

        Glide.with(this).load("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg")
                .asBitmap()
                .into(target);
    }
}
