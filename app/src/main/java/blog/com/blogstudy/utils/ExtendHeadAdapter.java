package blog.com.blogstudy.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import blog.com.blogstudy.R;

/**
 * Created by Renny on 2018/1/3.
 */

public class ExtendHeadAdapter extends RecyclerView.Adapter<ExtendHeadAdapter.ViewHolder> {
    private List<String> mData;

    public ExtendHeadAdapter(List<String> datas) {
        mData = datas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.button.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.item_title);
        }
    }

}
