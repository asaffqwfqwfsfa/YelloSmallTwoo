package com.example.john.yellosmalltwo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.CommentBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by john on 2018/7/17.
 */

public class ScoreRvAdapter extends RecyclerView.Adapter<ScoreRvAdapter.MyViewHolder>{
    private List<CommentBean.DataBean> list;
    private Context context;

    public ScoreRvAdapter(List<CommentBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.scorerv_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sdv.setImageURI(list.get(position).getAvatar());
        holder.username.setText(list.get(position).getUser_name());
        holder.commentData.setText(list.get(position).getComment_data());
        holder.commentTime.setText(list.get(position).getComment_time());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView username,commentTime,commentData;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv_scorerv);
            username = itemView.findViewById(R.id.tv_username_scorerv);
            commentData=itemView.findViewById(R.id.tv_commentdata_scorerv);
            commentTime=itemView.findViewById(R.id.tv_commenttime_scorerv);
        }
    }
}
