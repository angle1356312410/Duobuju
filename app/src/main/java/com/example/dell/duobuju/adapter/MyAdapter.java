package com.example.dell.duobuju.adapter;

import android.content.Context;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.duobuju.Bean;
import com.example.dell.duobuju.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 张艳： on 2017/8/21.
 */
public class MyAdapter extends RecyclerView.Adapter {


    Context context;
    List<Bean.ResultBean.DataBean> list;

    public MyAdapter(Context context, List<Bean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item1, null);
            return new MyViewHolder1(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item2, null);
            return new MyViewHolder2(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);

        switch (itemViewType) {
            case 0:

                MyViewHolder1 holder1 = (MyViewHolder1) holder;
                Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder1.image);
                holder1.name.setText(list.get(position).getAuthor_name());
                holder1.price.setText(list.get(position).getTitle());
                break;

            case 1:
                MyViewHolder2 holder2 = (MyViewHolder2) holder;
                Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder2.image1);
                Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(holder2.image2);
                Glide.with(context).load(list.get(position).getThumbnail_pic_s03()).into(holder2.image3);


        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {

            return 0;
        }

        return 1;


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;
        private final TextView price;
        public MyViewHolder1(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);

            price = (TextView) itemView.findViewById(R.id.price);
        }
    }


    class MyViewHolder2 extends RecyclerView.ViewHolder {

        ImageView image1, image2, image3;

        public MyViewHolder2(View itemView) {
            super(itemView);

            image1 = (ImageView) itemView.findViewById(R.id.image1);
            image2 = (ImageView) itemView.findViewById(R.id.image2);
            image3 = (ImageView) itemView.findViewById(R.id.image3);
        }
    }
}
