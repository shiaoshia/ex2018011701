package tw.com.shiaoshia.ex2018011701.data;

import android.content.Context;
import android.util.Log;

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

public class StudentFileDAO implements StudentDAO{
    public ArrayList<Student> mylist;
    Context context;
    public StudentFileDAO(Context context)
    {
        this.context = context;
        mylist = new ArrayList<>();
    }
    private void saveFile() {   //儲存資料
        File f = new File(context.getFilesDir(),"mydata.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();
            Log.d("SAVEFILE=====","存檔");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {   //載入檔案
        Log.d("LOADFILE===========>","讀檔");
        File f = new File(context.getFilesDir(),"mydata.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Gson gson = new Gson();
            mylist = gson.fromJson(str,new TypeToken<ArrayList<Student>>(){}.getType());
            br.close();
            fr.close();
            Log.d("LOADFILE===========>","讀檔");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Student s) { //加入學生資料
        mylist.add(s);
        saveFile();
        return true;
    }
    public ArrayList<Student> getList() {   //取出所有學生資料
        load();
        Log.d("getList===========>","取所有學生資料");
        return mylist;
    }
    public Student getStudent(int id) { //取出id=X的學生資料
        load();
        for(Student s : mylist) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }
    public boolean update(Student s) { //更新學生資料
        load();
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
        load();
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
