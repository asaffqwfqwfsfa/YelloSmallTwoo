package com.example.john.yellosmalltwo;

import android.content.Intent;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

public class WelcomeActivity extends AppCompatActivity  implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager load_viewPager;
    int[] imgs={R.mipmap.one,R.mipmap.two,R.mipmap.three,};
    private MyPageAdapter pagerAdapter;
    private ImageView login_into;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        if (NotificationsUtils.isNotificationEnabled(this)) {
//            Log.e(TAG, "onCreate: 通知权限 已开启");
//            setBasicSetup(1);
//            setBasicSetup(4);
//        } else {
//            Log.e(TAG, "onCreate: 通知权限 未开启");
//            //提示用户去设置，跳转到应用信息界面
//            Intent intent = new Intent(Settings.ACTION_SETTINGS);
//            startActivity(intent);
//        }
        initView();
        initData();

    }


    private void initView() {
        login_into = findViewById(R.id.login_into);
        load_viewPager = findViewById(R.id.load_viewPager);
        load_viewPager.setOnPageChangeListener(this);
        login_into.setOnClickListener(this);
    }
    private void initData() {
        pagerAdapter = new MyPageAdapter(this);
        load_viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==3)
        {
            login_into.setVisibility(View.VISIBLE);
        }else{
            login_into.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
//    public void setBasicSetup(int type) {
//        if (type == 1) {
//            //设置别名（新的调用会覆盖之前的设置）
//            JPushInterface.setAlias(this, 0, "0x123");
//            //设置标签（同上）
//            JPushInterface.setTags(this, 0, setUserTags());
//        } else if (type == 2) {
//            //删除别名
//            JPushInterface.deleteAlias(this, 0);
//            //删除指定标签
//            JPushInterface.deleteTags(this, 0, setUserTags());
//            //删除所有标签
//            JPushInterface.cleanTags(this, 0);
//        } else if (type == 3) {
//            //增加tag用户量(一般都是登录成功设置userid为目标，在别处新增加比较少见)
//            JPushInterface.addTags(this, 0, setUserTags());
//        } else if (type == 4) {
//            //查询所有标签
//            JPushInterface.getAllTags(this, 0);
//            //查询别名
//            JPushInterface.getAlias(this, 0);
//            //查询指定tag与当前用户绑定的状态（MyJPushMessageReceiver获取）
//            JPushInterface.checkTagBindState(this, 0, "0x123");
//            //获取注册id
//            JPushInterface.getRegistrationID(this);
//        }
//    }
//
//    /**
//     * 标签用户
//     */
//    private static Set<String> setUserTags() {
//        //添加3个标签用户（获取登录userid较为常见）
//        Set<String> tags = new HashSet<>();
//        tags.add("0x123");
//        tags.add("0x124");
//        tags.add("0x125");
//        return tags;
//    }
}
