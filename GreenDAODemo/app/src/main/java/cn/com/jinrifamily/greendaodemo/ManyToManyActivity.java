package cn.com.jinrifamily.greendaodemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import cn.com.jinrizhushi.Students;
import cn.com.jinrizhushi.Teachers;
import cn.com.jinrizhushi.StuAndtea;

/**
 * 描述: 多对多
 * 作者: 刘倩
 * 日期: 16/1/19 18:39
 */
public class ManyToManyActivity extends Activity implements View.OnClickListener {
    private TextView tvShow;
    private EditText etStuName;
    private EditText etStuSex;
    private EditText etTeaName;
    private EditText etTeaSex;
    private Button btnStuSave;
    private Button btnTeaSave;
    private TextView tvStu;
    private TextView tvTea;
    long count;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_to_many);
        tvShow = (TextView) findViewById(R.id.tv_show);
        etStuName = (EditText) findViewById(R.id.et_stu_name);
        etStuSex = (EditText) findViewById(R.id.et_stu_sex);
        etTeaName = (EditText) findViewById(R.id.et_tea_name);
        etTeaSex = (EditText) findViewById(R.id.et_tea_sex);
        btnStuSave = (Button) findViewById(R.id.btn_stu_save);
        btnTeaSave = (Button) findViewById(R.id.btn_tea_save);
        tvStu = (TextView) findViewById(R.id.tv_stu_show);
        tvTea = (TextView) findViewById(R.id.tv_tea_show);
        btnStuSave.setOnClickListener(this);
        btnTeaSave.setOnClickListener(this);
        dbHelper = DBHelper.getInstance(getApplicationContext());
        Students stu = new Students();
        stu.setStuName("小明");
        stu.setStuSex("男");
        dbHelper.addToStudentsTable(stu);

        Teachers tea = new Teachers();
        tea.setTeaName("小何");
        tea.setTeaSex("女");
        dbHelper.addToTeachersTable(tea);

        StuAndtea st = new StuAndtea();
        st.setStudentId(Long.parseLong("1"));
        st.setTeacherId(Long.parseLong("1"));
        dbHelper.addToStuAndtea(st);

        tvShow.setText(dbHelper.getStudentsList().get(0).getStuName() + "--" +
                dbHelper.getStudentsList().get(0).getManystu().get(0).getOnetea().getTeaName());

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.equals(btnStuSave)) {
            Students stu = new Students();
            stu.setStuName(etStuName.getText().toString());
            stu.setStuSex(etStuSex.getText().toString());
            dbHelper.addToStudentsTable(stu);
            List<Students> studentsList = dbHelper.getStudentsList();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < studentsList.size(); i++) {
                Students students = studentsList.get(i);
                buffer.append(students.getStuName() + students.getStuSex() + "   ");
            }
            tvStu.setText(buffer.toString());
            addStuAndTea();

        } else if (v.equals(btnTeaSave)) {
            Teachers tea = new Teachers();
            tea.setTeaName(etTeaName.getText().toString());
            tea.setTeaSex(etTeaSex.getText().toString());
            dbHelper.addToTeachersTable(tea);
            List<Teachers> teachersList = dbHelper.getTeachersList();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < teachersList.size(); i++) {
                Teachers teachers = teachersList.get(i);
                buffer.append(teachers.getTeaName() + teachers.getTeaSex() + "    ");
            }
            tvTea.setText(buffer.toString());
            addStuAndTea();
        }

    }

    /**
     * 添加多对多关系
     */
    public void addStuAndTea() {
//        List<Students> studentsList = dbHelper.getStudentsList();
//        List<Teachers> teachersList = dbHelper.getTeachersList();
//        int maxCount=0;
//        if (studentsList != null && studentsList.size() > 0 && teachersList != null && teachersList.size() > 0) {
//            int stuCount = studentsList.size();
//            int teaCount = teachersList.size();
//            maxCount = stuCount > teaCount ? teaCount : stuCount;
//            StringBuffer buffer = new StringBuffer();
//            for(int i =1;i<maxCount;i++){
//                StuAndtea st = new StuAndtea();
//                st.setStudentId((long)i);
//                st.setTeacherId((long)i);
//                dbHelper.addToStuAndtea(st);
//            }
//            if(maxCount>0){
//                for(int i = 1;i<=maxCount;i++){
//                    Students students = dbHelper.getStudentsList().get(i);
////                    String teaName =  students.getManystu().get(i).getOnetea().getTeaName();
//                    String teaName ="";
//                    buffer.append( students.getStuName()+ "--" +
//                            teaName  +"    ");
//                }
//            }
//            tvShow.setText(buffer.toString());
//        }
    }
}
