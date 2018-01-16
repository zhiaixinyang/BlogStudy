package blog.com.blogstudy.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import blog.com.blogstudy.R;
import blog.com.blogstudy.view.RightMarkView;

/**
 * Created by admin on 18/1/16.
 */

public class RightMarkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_mark);
        final RightMarkView markView =
                (RightMarkView) findViewById(R.id.right_mark);
        // 设置开始和结束两种颜色
        markView.setColor(Color.parseColor("#FF4081"), Color.YELLOW);
        // 设置画笔粗细
        markView.setStrokeWidth(10f);
        markView.start();
    }
}
