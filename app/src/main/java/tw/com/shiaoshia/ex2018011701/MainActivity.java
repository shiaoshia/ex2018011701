package tw.com.shiaoshia.ex2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tw.com.shiaoshia.ex2018011701.data.Student;
import tw.com.shiaoshia.ex2018011701.data.StudentScoreDAO;

public class MainActivity extends AppCompatActivity {
    final public static StudentScoreDAO dao = new StudentScoreDAO();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lv = (ListView)findViewById(R.id.listView);
        ArrayList<String> studentName = new ArrayList<>();
        for(Student s : dao.mylist) {
            studentName.add(s.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,studentName);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add) {
            Intent it =new Intent(MainActivity.this,AddActivity.class);
            startActivity(it);
        }

        return super.onOptionsItemSelected(item);
    }
}
