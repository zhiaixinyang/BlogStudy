package blog.com.blogstudy.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;

import blog.com.blogstudy.R;
import blog.com.blogstudy.base.BaseActivity;

/**
 * Created by MDove on 2017/12/12.
 */

public class RecyclerViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
    }
}
