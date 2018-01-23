package tw.com.shiaoshia.ex2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tw.com.shiaoshia.ex2018011701.data.DBType;
import tw.com.shiaoshia.ex2018011701.data.Student;
import tw.com.shiaoshia.ex2018011701.data.StudentDAO;
import tw.com.shiaoshia.ex2018011701.data.StudentDAOFactory;
import tw.com.shiaoshia.ex2018011701.data.StudentFileDAO;
import tw.com.shiaoshia.ex2018011701.data.StudentScoreDAO;

public class MainActivity extends AppCompatActivity {
    //final public static StudentScoreDAO dao = new StudentScoreDAO();
    //public static StudentFileDAO dao;
    public static StudentDAO dao;
    DBType dbType;
    ListView lv;
    ArrayList<String> studentName;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dao = new StudentFileDAO(this);
        //dbType = 2; //1.存取記憶體 2.存取檔案
        //dbType = DBType.FILE;
        //dbType = DBType.DB;
        dbType = DBType.CLOUD;  //使用FireBase
        dao = StudentDAOFactory.getDAOInstance(this,dbType);
        lv = (ListView)findViewById(R.id.listView);
        studentName = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,studentName);
        lv.setAdapter(adapter);

        //點選ListView跳到DetailActivity
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this,DetailActivity.class);
                it.putExtra("ID",dao.getList().get(i).id);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }

    public void refreshData() { //更新資料
        studentName.clear();
        for(Student s : dao.getList()) {
            studentName.add(s.name);
        }
        adapter.notifyDataSetChanged();
    }

    //顯示Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //新增資料
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add) {
            Intent it =new Intent(MainActivity.this,AddActivity.class);
            startActivity(it);
        }

        return super.onOptionsItemSelected(item);
    }
}
