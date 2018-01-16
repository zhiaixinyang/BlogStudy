package blog.com.blogstudy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import blog.com.blogstudy.R;
import blog.com.blogstudy.view.path.DynamicHeartView;

/**
 * Created by admin on 18/1/16.
 */

public class PathActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        DynamicHeartView view = (DynamicHeartView) findViewById(R.id.path);
        view.startPathAnim(10000);
    }
}
