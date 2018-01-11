package blog.com.blogstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import blog.com.blogstudy.recyclerview.zhihuad.RlvZhiHuAdActivity;
import blog.com.blogstudy.recyclerview.banner.activity.RlvBannerRlvActivity;
import blog.com.blogstudy.recyclerview.refresh.activity.RlvRefreshListActivity;

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

    }
}
