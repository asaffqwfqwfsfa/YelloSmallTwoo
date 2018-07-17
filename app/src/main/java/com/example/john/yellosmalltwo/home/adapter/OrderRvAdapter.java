package com.example.john.yellosmalltwo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.OffSetZeroBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by john on 2018/7/17.
 */

public class OrderRvAdapter extends RecyclerView.Adapter<OrderRvAdapter.MyViewHolder>{
    private List<OffSetZeroBean.DataBean> list;
    private Context context;

    public OrderRvAdapter(List<OffSetZeroBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.orderrv_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sdv.setImageURI(list.get(position).getPic_url()
        );
        holder.tv1.setText(list.get(position).getName());
        holder.tv2.setText(list.get(position).getMonth_sales_tip());
        holder.tv3.setText("评分"+list.get(position).getQuality_score());
        holder.tv4.setText(list.get(position).getAverage_price_tip());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv1,tv2,tv3,tv4;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv_orderrv);
            tv1 = itemView.findViewById(R.id.tv1_orderrv);
            tv2=itemView.findViewById(R.id.tv2_orderrv);
            tv3=itemView.findViewById(R.id.tv3_orderrv);
            tv4=itemView.findViewById(R.id.tv4_orderrv);

        }
    }
}
