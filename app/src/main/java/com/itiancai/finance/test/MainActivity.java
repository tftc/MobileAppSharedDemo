package com.itiancai.finance.test;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengRegistrar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnClick;
    private EditText etGoodsType;
    private EditText etGoodsNumber;
    private Button btnSubmit;
    private Button btnCalculate;
    private Button btnNext;
    private static final String TAG = "Umeng";
    PushAgent mPushAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = (Button) findViewById(R.id.btn_click);
        etGoodsType = (EditText)findViewById(R.id.et_goods_type);
        etGoodsNumber = (EditText)findViewById(R.id.et_goods_number);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        btnCalculate = (Button)findViewById(R.id.btn_calculate);
        btnNext = (Button)findViewById(R.id.btn_next);
        btnClick.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        AnalyticsConfig.enableEncrypt(false);
        Log.e(TAG, "json" + getDeviceInfo(this));//03-17 12:08:28.606 19908-19908/com.itiancai.finance.test E/Umeng: json{"mac":"D0:22:BE:95:B8:B6","device_id":"D0:22:BE:95:B8:B6"}
        mPushAgent = PushAgent.getInstance(this);
        mPushAgent.enable(new IUmengRegisterCallback() {

            @Override
            public void onRegistered(String registrationId) {
                //onRegistered方法的参数registrationId即是device_token
                Log.d("device_token", registrationId);
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        mPushAgent.onAppStart();

                    }
                });
            }
        });
        String device_token = UmengRegistrar.getRegistrationId(this);
        Log.e(TAG, "device_token:  " + device_token);

    }


    @Override
    public void onClick(View v) {
        if (v.equals(btnClick)) {
            //计数事件1:统计发生次数
            MobclickAgent.onEvent(this, "btn_click");
            Toast.makeText(this, "点击!", Toast.LENGTH_SHORT).show();
            /** 错误测试 */
            List list = new ArrayList();
            list.add("abc");
            list.get(2);
        }else if(v.equals(btnSubmit)){
            //计数事件2:统计点击行为各属性被触发的次数 示例：统计电商应用中“购买”事件发生的次数，以及购买的商品类型及数量
            String goodsType = etGoodsType.getText().toString();
            String goodsNumber = etGoodsNumber.getText().toString();
            if(goodsType.equals("")){
                Toast.makeText(MainActivity.this, "请输入商品类型", Toast.LENGTH_SHORT).show();
            }else if(goodsNumber.equals("")){
                Toast.makeText(MainActivity.this, "请输入购买商品数量", Toast.LENGTH_SHORT).show();
            }else{
                HashMap<String,String> map = new HashMap<String,String>();
                map.put("type",goodsType);
                map.put("quantity", goodsNumber);
                MobclickAgent.onEvent(this, "purchase", map);
                Toast.makeText(this,"恭喜您,购买成功!",Toast.LENGTH_SHORT).show();
            }
        }else if(v.equals(btnCalculate)){
            int duration = 12000; //开发者需要自己计算音乐播放时长
            Map<String, String> map_value = new HashMap<String, String>();
            map_value.put("type" , "popular" );
            map_value.put("artist", "JJLin");
            MobclickAgent.onEventValue(this, "music", map_value, duration);

            Map<String, String> map_value1 = new HashMap<String, String>();
            map_value1.put("type" , "basical" );
            map_value1.put("artist" , "LLQ" );
            MobclickAgent.onEventValue(this, "music", map_value1, duration);
            Toast.makeText(MainActivity.this, "点击计算事件!", Toast.LENGTH_SHORT).show();
        }else if(v.equals(btnNext)){
            Intent intent = new Intent();
            intent.setClass(this,SecondActivity.class);
            startActivity(intent);
        }
    }



    @SuppressLint("NewApi")
    public static boolean checkPermission(Context context, String permission) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        } else {
            PackageManager pm = context.getPackageManager();
            if (pm.checkPermission(permission, context.getPackageName()) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }
        return result;
    }

    public static String getDeviceInfo(Context context) {
        try {
            org.json.JSONObject json = new org.json.JSONObject();
            android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = null;
            if (checkPermission(context, Manifest.permission.READ_PHONE_STATE)) {
                device_id = tm.getDeviceId();
            }
            android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            String mac = wifi.getConnectionInfo().getMacAddress();
            json.put("mac", mac);
            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(),
                        android.provider.Settings.Secure.ANDROID_ID);
            }
            json.put("device_id", device_id);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("SplashScreen"); //统计页面(仅有Activity的应用中SDK自动调用，不需要单独写。"SplashScreen"为页面名称，可自定义)
        MobclickAgent.onResume(this);//session统计
        MobclickAgent.onProfileSignIn("userID");

    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("SplashScreen"); // （仅有Activity的应用中SDK自动调用，不需要单独写）保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息。"SplashScreen"为页面名称，可自定义
        MobclickAgent.onPause(this);
    }
}
