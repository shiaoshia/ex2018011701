package tw.com.shiaoshia.ex2018011701.data;

import java.util.ArrayList;

/**
 * Created by USER-NB on 2018/1/18.
 */

public interface StudentDAO {
    public boolean add(Student s);
    public ArrayList<Student> getList();
    public Student getStudent(int id);
    public boolean update(Student s);
    public boolean delete(int id);
}
