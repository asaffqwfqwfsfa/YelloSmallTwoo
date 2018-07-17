package com.example.john.yellosmalltwo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by john on 2018/7/17.
 */

public class MyPageAdapter extends PagerAdapter {

    private Context context;

    public MyPageAdapter(Context context) {
        this.context = context;
    }

    int[] imgs={R.mipmap.one,R.mipmap.two,R.mipmap.three,R.drawable.spdh};


    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(context, R.layout.mypage_item,null);
        SimpleDraweeView load_img=view.findViewById(R.id.load_img);
        GifImageView load_img_gif=view.findViewById(R.id.load_img_gif);
        if(position==3)
        {
            load_img_gif.setImageResource(R.drawable.spdh);
        }
        else{
            load_img.setImageResource(imgs[position]);

        }
        container.addView(view);
        return view;
    }

}
