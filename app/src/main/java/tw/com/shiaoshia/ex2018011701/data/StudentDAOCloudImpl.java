package tw.com.shiaoshia.ex2018011701.data;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by USER-NB on 2018/1/18.
 */

public class StudentDAOCloudImpl implements StudentDAO{
    public ArrayList<Student> mylist;
    Context context;
    FirebaseDatabase database;
    DatabaseReference myRef;
    public StudentDAOCloudImpl(Context context)
    {
        this.context = context;

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("score");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override   //當資料改變時，立即更新
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                mylist = gson.fromJson(value,new TypeToken<ArrayList<Student>>(){}.getType());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if (mylist == null) {
            mylist = new ArrayList<>();
        }
    }
    private void saveFile() {   //儲存資料
        Gson gson = new Gson();
        String data = gson.toJson(mylist);
        myRef.setValue(data);
    }

    public boolean add(Student s) { //加入學生資料
        if(mylist == null) {
            mylist = new ArrayList<>();
        }
        mylist.add(s);
        saveFile();
        return true;
    }
    public ArrayList<Student> getList() {   //取出所有學生資料
        Log.d("getList===========>","取所有學生資料");
        return mylist;
    }
    public Student getStudent(int id) { //取出id=X的學生資料
        for(Student s : mylist) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }
    public boolean update(Student s) { //更新學生資料
        for(Student t : mylist) {
            if (t.id == s.id) {
                t.name = s.name;
                t.score = s.score;
                saveFile();
                return true;
            }
        }
        return false;
    }
    public boolean delete(int id) { //刪除id=X的學生資料
        for(int i=0;i<mylist.size();i++) {
            if (mylist.get(i).id == id) {
                mylist.remove(i);
                saveFile();
                return true;
            }
        }
        return false;
    }
}
