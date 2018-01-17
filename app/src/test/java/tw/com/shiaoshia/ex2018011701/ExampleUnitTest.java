package tw.com.shiaoshia.ex2018011701;

import org.junit.Test;

import tw.com.shiaoshia.ex2018011701.data.Student;
import tw.com.shiaoshia.ex2018011701.data.StudentScoreDAO;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

//可用來驗証程式的函式正不正常
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test   //需加才會執行
    public void test1() throws Exception {
        assertEquals(5,2+3);    //判斷5是否等於2+3
    }

    @Test   //驗証MyTest正不正常
    public void test2() throws Exception {
        MyTest myTest = new MyTest();
        assertEquals(8,myTest.getAdd(5,3));
    }

    @Test   //驗証dao.add是否正常存入資料
    public void test3() throws  Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Amy",90));
        assertEquals(2,dao.getList().size());
    }

    @Test   //驗証dao.getList().get(1)是否正常讀取資料, 成績=90
    public void test4() throws  Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Amy",90));
        assertEquals(90,dao.getList().get(1).score);
    }
    @Test   //驗証dao.getStudent是否正常讀取資料,id=2的成績=90
    public void test5() throws  Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Amy",90));
        assertEquals(90,dao.getStudent(2).score);
    }
    @Test   //驗証dao.getStudent是否正常讀取資料,當無此筆資料應回傳null
    public void test6() throws  Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Amy",90));
        assertEquals(null,dao.getStudent(3));
    }
    @Test   //驗証dao.getStudent是否正常更新資料,當無此筆資料應回傳null
    public void test7() throws  Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Amy",90));
        //dao.update(new Student(2,"Peter",100));
        assertEquals(true,dao.update(new Student(2,"Peter",100)));
        assertEquals(100,dao.getStudent(2).score);
    }
    @Test   //驗証dao.getStudent是否正常刪除資料,刪除回傳true
    public void test8() throws  Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Amy",90));
        dao.add(new Student(3,"QQ",91));
        //dao.delete(2);
        assertEquals(true,dao.delete(2));
        assertEquals(2,dao.getList().size());
        assertEquals(1,dao.getList().get(0).id);    //驗証是否刪錯筆
    }
}