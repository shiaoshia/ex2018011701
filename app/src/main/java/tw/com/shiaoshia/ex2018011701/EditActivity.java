package tw.com.shiaoshia.ex2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tw.com.shiaoshia.ex2018011701.data.Student;

public class EditActivity extends AppCompatActivity {
    EditText ed5,ed6;
    TextView tv4;
    Student s;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id = getIntent().getIntExtra("ID",0);
        //Log.d("Edit_ID:",String.valueOf(id));
        s = MainActivity.dao.getStudent(id);

        tv4 = (TextView) findViewById(R.id.textView4);
        ed5 = (EditText)findViewById(R.id.editText5);
        ed6 = (EditText)findViewById(R.id.editText6);
        tv4.setText(String.valueOf(s.id).toString());
        ed5.setText(s.name);
        ed6.setText(Integer.valueOf(s.score).toString());
    }

    public void click05(View v) {
        finish();
    }

    public void click06(View v) {
        MainActivity.dao.update(new Student(Integer.valueOf(tv4.getText().toString()),ed5.getText().toString(),
                Integer.valueOf(ed6.getText().toString())));
        finish();
    }
}
