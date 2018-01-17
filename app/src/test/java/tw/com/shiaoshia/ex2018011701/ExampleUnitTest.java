package tw.com.shiaoshia.ex2018011701;

import org.junit.Test;

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
    @Test   //需加才會執行
    public void test2() throws Exception {
        assertEquals(5,2+4);
    }

    @Test   //驗証MyTest正不正常
    public void test3() throws Exception {
        MyTest myTest = new MyTest();
        assertEquals(8,myTest.getAdd(5,3));
    }
}