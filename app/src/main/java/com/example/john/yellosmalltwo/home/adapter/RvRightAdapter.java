package com.example.john.yellosmalltwo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.ProductCatagoryBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by john on 2018/7/17.
 */

public class RvRightAdapter extends RecyclerView.Adapter<RvRightAdapter.MyViewHolder>{
    private List<ProductCatagoryBean.DataBean.ListBean> list;
    private Context context;

    public RvRightAdapter(List<ProductCatagoryBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rvright_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String s = list.get(position).getIcon().split("\\|")[0];
        holder.sdv.setImageURI(s);
        holder.tv1.setText(list.get(position).getName());
        holder.tv2.setText(list.get(position).getPscid()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv1;
        private final TextView tv2;
        private final ImageView ivAdd;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv_rightrv);
            tv1 = itemView.findViewById(R.id.tv1_rightrv);
            tv2 = itemView.findViewById(R.id.tv2_rightrv);
            ivAdd = itemView.findViewById(R.id.iv_add);
        }
    }
}
