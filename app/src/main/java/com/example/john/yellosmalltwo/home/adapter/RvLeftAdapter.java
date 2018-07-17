package com.example.john.yellosmalltwo.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.CatagoryBean;
import com.example.john.yellosmalltwo.home.view.OnItemClickListener;

import java.util.List;

/**
 * Created by john on 2018/7/17.
 */

public class RvLeftAdapter extends RecyclerView.Adapter<RvLeftAdapter.MyViewHolder>{
    private List<CatagoryBean.DataBean> list;
    private Context context;
    private OnItemClickListener onItemClickListener;
    public RvLeftAdapter(List<CatagoryBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rvleft_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv.setText(list.get(position).getName());
        if (list.get(position).getChecked()){
            holder.tv.setTextColor(Color.WHITE);
            holder.tv.setBackgroundColor(Color.GRAY);
        }else{
            holder.tv.setTextColor(Color.BLACK);
            holder.tv.setBackgroundColor(Color.WHITE);
        }
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.rv_left_tv);
        }
    }

    public void changeCheck(int position,boolean b){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setChecked(false);
        }
        list.get(position).setChecked(b);
        notifyDataSetChanged();
    }
}