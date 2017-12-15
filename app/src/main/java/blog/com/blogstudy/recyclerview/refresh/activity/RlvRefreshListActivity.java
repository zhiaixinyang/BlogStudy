package blog.com.blogstudy.recyclerview.refresh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import blog.com.blogstudy.R;

/**
 * Created by admin on 17/12/15.
 */

public class RlvRefreshListActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlv_refresh_list);

        findViewById(R.id.btn_base).setOnClickListener(this);
        findViewById(R.id.btn_wrapper).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_base:
                intent = new Intent(this, RlvRefreshActivity.class);
                break;

            case R.id.btn_wrapper:
                intent = new Intent(this, RlvRefreshWrapperActivity.class);
                break;

            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
