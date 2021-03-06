package tw.com.shiaoshia.ex2018011701;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import tw.com.shiaoshia.ex2018011701.data.Student;

public class DetailActivity extends AppCompatActivity {
    Student s;
    TextView tv1,tv2,tv3;
    int id;
    boolean fastBack = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        id = getIntent().getIntExtra("ID",0);

        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);

    }

    //重抓資料
    @Override
    protected void onResume() {
        super.onResume();
        if(fastBack) {
            finish();
        }
        s = MainActivity.dao.getStudent(id);
        tv1.setText(Integer.valueOf(s.id).toString());
        tv2.setText(s.name);
        tv3.setText(Integer.valueOf(s.score).toString());
    }

    public void click01(View v) {
        finish();
    }

    public void click02(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
        builder.setTitle("刪除確認");
        builder.setMessage("確認刪除本筆料嗎?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.dao.delete(id);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    //修改資料
    public void click03(View v) {
        fastBack = true;
        Log.d("TestID:",tv1.getText().toString());
        Intent it = new Intent(DetailActivity.this,EditActivity.class);
        it.putExtra("ID",id);
        startActivity(it);
    }
}
