package com.skywalker.idouban.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skywalker.idouban.R;
import com.skywalker.idouban.models.AppItem;

import java.util.List;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/4               *
 *******************************/

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<AppItem> mAppItemList;

    public RecyclerViewAdapter(Context context,List<AppItem> list){
        this.mContext=context;
        this.mAppItemList=list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AppItem item=mAppItemList.get(position);
        holder.mAppName.setText(item.getName());
        holder.mAppIcon.setImageBitmap(item.getIcon());
    }

    @Override
    public int getItemCount() {
        return mAppItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mAppIcon;
        private TextView mAppName;

        public MyViewHolder(View itemView) {
            super(itemView);
            mAppIcon = (ImageView) itemView.findViewById(R.id.iv_appIcon);
            mAppName = (TextView) itemView.findViewById(R.id.tv_appName);
        }
    }
}
