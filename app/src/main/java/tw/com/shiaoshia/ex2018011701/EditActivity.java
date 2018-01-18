package tw.com.shiaoshia.ex2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tw.com.shiaoshia.ex2018011701.data.Student;

public class EditActivity extends AppCompatActivity {
    EditText ed4,ed5,ed6;
    Student s;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id = getIntent().getIntExtra("ID",0);
        s = MainActivity.dao.getStudent(id);
        ed4 = (EditText)findViewById(R.id.editText4);
        ed5 = (EditText)findViewById(R.id.editText5);
        ed6 = (EditText)findViewById(R.id.editText6);
        ed4.setText(Integer.valueOf(s.id).toString());
        ed5.setText(s.name);
        ed6.setText(Integer.valueOf(s.score).toString());
    }

    public void click05(View v) {
        finish();
    }

    public void click06(View v) {
        MainActivity.dao.update(new Student(Integer.valueOf(ed4.getText().toString()),ed5.getText().toString(),
                Integer.valueOf(ed6.getText().toString())));
    }
}
