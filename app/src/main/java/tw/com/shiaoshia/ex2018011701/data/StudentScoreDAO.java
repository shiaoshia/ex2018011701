package tw.com.shiaoshia.ex2018011701.data;

import java.util.ArrayList;

/**
 * Created by USER-NB on 2018/1/17.
 */

public class StudentScoreDAO implements StudentDAO{
    public ArrayList<Student> mylist;
    public StudentScoreDAO() {
        mylist = new ArrayList<>();
    }
    public boolean add(Student s) { //加入學生資料
        mylist.add(s);
        return true;
    }
    public ArrayList<Student> getList() {   //取出所有學生資料
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
                return true;
            }
        }
        return false;
    }
    public boolean delete(int id) { //刪除id=X的學生資料
        for(int i=0;i<mylist.size();i++) {
            if (mylist.get(i).id == id) {
                mylist.remove(i);
                return true;
            }
        }
        return false;
    }
}
