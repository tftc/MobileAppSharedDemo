package cn.com.jinrifamily.greendaodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.com.jinrizhushi.User;
/**
 * 描述: 一对一
 * 作者: 刘倩
 * 日期: 16/1/19 15:03
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnInsert;
    private Button btnGoOne;
    private Button btnGoNext;
    private Button btnManyNext;
    private TextView tvTime;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.btn_go_insert);
        btnGoOne =(Button)findViewById(R.id.btn_go_one);
        btnGoNext = (Button)findViewById(R.id.btn_go_next);
        btnManyNext = (Button)findViewById(R.id.btn_go_many_next);
        tvTime = (TextView)findViewById(R.id.tv_all_time);

        btnInsert.setOnClickListener(this);
        btnGoOne.setOnClickListener(this);
        btnGoNext.setOnClickListener(this);
        btnManyNext.setOnClickListener(this);
        dbHelper = DBHelper.getInstance(getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnInsert)){
            long beforeTime = System.currentTimeMillis();
            for (int i = 0;i<10000;i++){
                User user = new User();
                user.setAttitudes_count(244);
                user.setAvatar_default("http://www.itiancai.com/1.jpg");
                user.setAvatar_hd("http://www.itiancai.com/2.jpg");
                user.setAvatar_large("http://www.itiancai.com/3.jpg");
                user.setComments_count(62660);
                user.setAuthentication(44812);
                user.setCertificationGroup("天风证券");
                user.setCreate_time("1450253028000");
                user.setDescription_content("本人擅长基本面");
                user.setFavourites_count(101);
                user.setFollowers_count(333);
                user.setFriends_count(121);
                user.setGender(0);
                user.setIdentifier(1);
                user.setMobile("13501081249");
                user.setNick_name("独家记忆");
                user.setReal_name("张三");
                user.setPassword("111111111");
                user.setPoint_count(345);
                user.setUser_type(1);

                dbHelper.addToUserTable(user);
            }
            long endTime = System.currentTimeMillis();
            long spendTime = endTime-beforeTime;
            tvTime.setText(String.valueOf(spendTime));

        }else if(v.equals(btnGoOne)){
            Intent intent = new Intent();
            intent.setClass(this, OneToOneActivity.class);
            startActivity(intent);
        }else if(v.equals(btnGoNext)){
            Intent intent = new Intent();
            intent.setClass(this, OneToManyActivity.class);
            startActivity(intent);
        }else if(v.equals(btnManyNext)){
            Intent intent = new Intent();
            intent.setClass(this,ManyToManyActivity.class);
            startActivity(intent);
        }

    }
}
