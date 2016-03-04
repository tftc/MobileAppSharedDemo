package cn.com.jinrifamily.greendaodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import cn.com.jinrizhushi.CounselorExtInfo;
import cn.com.jinrizhushi.Users;

/**
 * 描述: 一对一
 * 作者: 刘倩
 * 日期: 16/1/19 15:03
 */
public class OneToOneActivity extends Activity implements View.OnClickListener {
    private EditText etMessage;
    private TextView tVShow;
    private Button btnSave;

    private EditText etMessage1;
    private TextView tVShow1;
    private TextView tVShow2;
    private Button btnSave1;
    private Button btnSearch;
    private EditText resultShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_one);
        etMessage = (EditText) findViewById(R.id.et_message);
        tVShow = (TextView) findViewById(R.id.tv_show);
        btnSave = (Button) findViewById(R.id.btn_save);
        etMessage1 = (EditText) findViewById(R.id.et_message1);
        tVShow1 = (TextView) findViewById(R.id.tv_show1);
        tVShow2 = (TextView) findViewById(R.id.tv_show2);
        btnSave1 = (Button) findViewById(R.id.btn_save1);
        btnSearch = (Button) findViewById(R.id.btn_search);
        resultShow = (EditText) findViewById(R.id.et_search_show);

        btnSave.setOnClickListener(this);
        btnSave1.setOnClickListener(this);
        btnSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnSave)) {
            Users user = new Users();
            user.setMobile(etMessage.getText().toString());
            DBHelper.getInstance(getApplicationContext()).addToUsersTable(user);
            List<Users> listUser = DBHelper.getInstance(getApplicationContext()).getUsers();
            if (listUser != null && listUser.size() > 0) {
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < listUser.size(); i++) {
                    buffer.append(listUser.get(i).getMobile() + "    ");
                    tVShow.setText(buffer.toString());
                }
            }
        } else if (v.equals(btnSave1)) {
            CounselorExtInfo coun = new CounselorExtInfo();
            coun.setCertificationGroup(etMessage1.getText().toString());
            DBHelper.getInstance(getApplicationContext()).addToCounselorExtInfoTable(coun);
            List<Users> listUsers = DBHelper.getInstance(getApplicationContext()).getUsers();
            Users user = listUsers.get(0);
            user.setCounselorExtInfo(coun);
            List<CounselorExtInfo> listCoun = DBHelper.getInstance(getApplicationContext()).getCounselorExtInfo();
            if (listCoun != null && listCoun.size() > 0) {
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < listCoun.size(); i++) {
                    buffer.append(listCoun.get(i).getCertificationGroup() + "    ");
                    tVShow1.setText(buffer.toString());
                }
            }

        } else if (v.equals(btnSearch)) {
            String id = resultShow.getText().toString();
            List<Users> listUsers = DBHelper.getInstance(getApplicationContext()).getUsers();
            Users user = listUsers.get(0);
            CounselorExtInfo info = user.getCounselorExtInfo();
//            userDao.queryBuilder()

            if(info!=null){
                String a = info.getId() +  info.getCertificationGroup() + "";
                tVShow2.setText(a);
            }else{
                CounselorExtInfo infos = new CounselorExtInfo();
                infos.setCertificationGroup("北京大学");
                infos.setId(0L);
                listUsers.get(0).setCounId(0L);
                DBHelper.getInstance(getApplicationContext()).addToCounselorExtInfoTable(infos);
            }

        }

    }
}
