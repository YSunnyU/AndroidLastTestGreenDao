package com.sunny.androidlasttestgreendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunny.androidlasttestgreendao.R;
import com.sunny.androidlasttestgreendao.bean.GreenDaoMess;
import com.sunny.androidlasttestgreendao.bean.NewsMess;

import java.util.List;

/**
 * Created by 张玗 on 2018/3/27.
 */

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.Holder> implements View.OnClickListener {
    private List<GreenDaoMess> greenDaoMesses;
    private Context context;
    public void setData(List<GreenDaoMess> greenDaoMesses){
        this.greenDaoMesses=greenDaoMesses;
    }
    public MainPageAdapter( List<GreenDaoMess> resultBeanList, Context context) {
        this.greenDaoMesses = resultBeanList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_page, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Picasso.with(context).load(greenDaoMesses.get(position).getImage()).into(holder.item_image);
        holder.item_name.setText(greenDaoMesses.get(position).getName());
        holder.item_stage.setText(greenDaoMesses.get(position).getStage());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return greenDaoMesses.isEmpty() ? 0 : greenDaoMesses.size();
    }

    public interface OnShortListener {
        void setOnShortListener(View view, int position);
    }

    private OnShortListener shortListener;

    public void OnShortListener(OnShortListener shortListener) {
        this.shortListener = shortListener;
    };

    @Override
    public void onClick(View view) {
        if (shortListener != null) {
            shortListener.setOnShortListener(view, (int) view.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView item_image;
        public TextView item_name,item_stage;
        public Holder(View itemView) {
            super(itemView);
            this.item_image = (ImageView) itemView.findViewById(R.id.item_image);
            this.item_name=itemView.findViewById(R.id.item_name);
            this.item_stage=itemView.findViewById(R.id.item_stage);
        }
    }


}
