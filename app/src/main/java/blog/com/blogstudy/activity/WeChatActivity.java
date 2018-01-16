package blog.com.blogstudy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import blog.com.blogstudy.R;
import blog.com.blogstudy.pullextend.ExtendListHeader;
import blog.com.blogstudy.pullextend.PullExtendLayout;
import blog.com.blogstudy.utils.ExtendHeadAdapter;
import blog.com.blogstudy.utils.OverFlyingLayoutManager;

/**
 * Created by MDove on 18/1/8.
 */

public class WeChatActivity extends AppCompatActivity{
    ExtendListHeader mPullNewHeader;
    PullExtendLayout mPullExtendLayout;
    RecyclerView listHeader;
    List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat);
        mPullNewHeader = (ExtendListHeader) findViewById(R.id.extend_header);
        mPullExtendLayout = (PullExtendLayout) findViewById(R.id.pull_extend);
        listHeader = mPullNewHeader.getRecyclerView();
        listHeader.setLayoutManager( new OverFlyingLayoutManager(OrientationHelper.HORIZONTAL));
        listHeader.setAdapter(new ExtendHeadAdapter(mDatas));
    }
}
