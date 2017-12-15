package blog.com.blogstudy.recyclerview.banner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import blog.com.blogstudy.R;
import blog.com.blogstudy.recyclerview.banner.view.RecyclerViewBannerBase;
import blog.com.blogstudy.recyclerview.banner.view.RecyclerViewBannerMz;

/**
 * Created by MDove on 17/12/15.
 */

public class BannerRlvActivity extends AppCompatActivity {
    private RecyclerViewBannerMz banner, banner2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlv_banner);
        banner = (RecyclerViewBannerMz) findViewById(R.id.banner);
        banner2 = (RecyclerViewBannerMz) findViewById(R.id.banner2);
        List<String> list = new ArrayList<>();
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/69427561.jpg");
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/23738150.jpg");
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/30127126.jpg");
        list.add("http://oo6pz0u05.bkt.clouddn.com/17-12-13/36125492.jpg");
        banner.initBannerImageView(list, new RecyclerViewBannerBase.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(BannerRlvActivity.this, "clicked:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        banner2.initBannerImageView(list, new RecyclerViewBannerBase.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(BannerRlvActivity.this, "clicked:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void jump(View view) {
        startActivity(new Intent(BannerRlvActivity.this, BannerNormalActivity.class));
    }
}
