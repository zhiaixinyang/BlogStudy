package blog.com.blogstudy.recyclerview.zhihuad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import blog.com.blogstudy.R;

/**
 * Created by admin on 17/12/18.
 */

public class RlvZhiHuAdActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlv_zhihu_ad);

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        final List<String> mockDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mockDatas.add(i + "");
        }

        mRecyclerView.setLayoutManager(mLinearLayoutManager = new LinearLayoutManager(this));

        mRecyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(RlvZhiHuAdActivity.this).inflate(R.layout.item_rlv_zhihu_ad, parent, false));
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                if (position > 0 && position % 7 == 0) {
                    holder.tvTitle.setVisibility(View.GONE);
                    holder.tvDesc.setVisibility(View.GONE);
                    holder.ad.setVisibility(View.VISIBLE);
                } else {
                    holder.tvTitle.setVisibility(View.VISIBLE);
                    holder.tvDesc.setVisibility(View.VISIBLE);
                    holder.ad.setVisibility(View.GONE);
                }
            }

            @Override
            public int getItemCount() {
                return mockDatas.size();
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int fPos = mLinearLayoutManager.findFirstVisibleItemPosition();
                int lPos = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                for (int i = fPos; i <= lPos; i++) {
                    View view = mLinearLayoutManager.findViewByPosition(i);
                    AdImageViewVersion1 adImageView = (AdImageViewVersion1) view.findViewById(R.id.id_iv_ad);
                    if (adImageView.getVisibility() == View.VISIBLE) {
                        adImageView.setDy(mLinearLayoutManager.getHeight() - view.getTop());
                    }
                }
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AdImageViewVersion1 ad;
        TextView tvTitle, tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            ad = (AdImageViewVersion1) itemView.findViewById(R.id.id_iv_ad);
            tvTitle = (TextView) itemView.findViewById(R.id.id_tv_title);
            tvDesc = (TextView) itemView.findViewById(R.id.id_tv_desc);
        }
    }
}
