package com.example.john.yellosmalltwo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.yellosmalltwo.home.SweepActivity;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_login_yanzhengma,iv_login_yanzhengma1,daojishi_img;
    private RelativeLayout relativeLayout1,relativeLayout2,daojishi;
    private TextView tv_login_changgui;
    private int num=0;
    private int mima=0;
    private TextView daojishi_text;
    private Timer timer;
    private int size=0;
    private ImageView showmima;
    private EditText et_login_pwd2;
    private Button login;
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;

    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            size=what;
            //倒计时==0时
            if(what==0)
            {
                iv_login_yanzhengma.setImageResource(R.mipmap.chongxinhuoquyanzhengma);//重新获取验证码
                daojishi.setVisibility(View.INVISIBLE);//倒计时
                daojishi_text.setText("30s后");
                timer.cancel();
                return;
            }else{
                daojishi_text.setText(what+"s后");
            }
        }

    };
    private ImageView ivQQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTencent = Tencent.createInstance(APP_ID,LoginActivity.this.getApplicationContext());

        initView();
        // 创建EventHandler对象
        EventHandler eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable)data;
                    final String msg = throwable.getMessage();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 处理你自己的逻辑
                    }
                }
            }
        };
        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);
    }

    private void initView() {
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        ivQQ = findViewById(R.id.iv_dxlogin_QQ);
        tv_login_changgui = findViewById(R.id.tv_login_changgui);
        iv_login_yanzhengma = findViewById(R.id.iv_yanzhengma);
        iv_login_yanzhengma.setOnClickListener(this);
        relativeLayout1 = findViewById(R.id.relativeLayout1);
        relativeLayout2 = findViewById(R.id.relativeLayout2);
        tv_login_changgui.setOnClickListener(this);
        iv_login_yanzhengma1 = findViewById(R.id.iv_yanzhengma);
        daojishi=findViewById(R.id.daojishi);
        daojishi_text=findViewById(R.id.daojishi_text);//倒计时Text
        showmima = findViewById(R.id.showmima);
        showmima.setOnClickListener(this);
        et_login_pwd2 = findViewById(R.id.et_pwd2);
        showmima.setImageResource(R.mipmap.yincangmima);//默认展示显示密码图片
        et_login_pwd2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        ivQQ.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {

            case R.id.tv_login_changgui:
                num++;
                if(num%2==1)
                {
                    relativeLayout1.setVisibility(View.INVISIBLE);
                    relativeLayout2.setVisibility(View.VISIBLE);
                    tv_login_changgui.setText("短信验证码登录方式");
                }else if(num%2==0){
                    relativeLayout2.setVisibility(View.INVISIBLE);
                    relativeLayout1.setVisibility(View.VISIBLE);
                    tv_login_changgui.setText("使用常规登录方式");
                }

                break;
            //获取验证码
            case R.id.iv_yanzhengma:
                if(size>0)
                {
                    //不作操作
                }
                else{
                    daojishi.setVisibility(View.VISIBLE);
                    timer = new Timer();
                    TimerTask timerTask= new TimerTask() {
                        int t=30;
                        @Override
                        public void run() {
                            t--;
                            Message msg=Message.obtain();
                            msg.what=t;
                            handler.sendMessage(msg);
                        }
                    };
                    timer.schedule(timerTask,1000,1000);
                }

                break;
            //隐藏显示密码
            case R.id.showmima:
                mima++;
                if(mima%2==0)
                {
                    //隐藏密码
                    showmima.setImageResource(R.mipmap.yincangmima);
                    et_login_pwd2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else if(mima%2==1){
                    showmima.setImageResource(R.mipmap.xianshimima);
                    et_login_pwd2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            case R.id.login:
                Intent intent=new Intent(LoginActivity.this,SweepActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_dxlogin_QQ:
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(LoginActivity.this,"all", mIUiListener);
                break;
        }

    }
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e("zzz","登录成功"+response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(LoginActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(LoginActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

