package tw.com.shiaoshia.ex2018011701.data;

import android.content.Context;

/**
 * Created by USER-NB on 2018/1/18.
 */

public class StudentDAOFactory {
    public static StudentDAO getDAOInstance(Context context,DBType dbType) {
        switch (dbType) {
            case MEMORY: //存取記憶體
                return new StudentScoreDAO();
            case FILE: //存取檔案
                return new StudentFileDAO(context);
            case DB:
                return new StudentDAODBImpl(context);
            case CLOUD:
                return new StudentDAOCloudImpl(context);
        }
        return null;    //都沒有時傳回null
    }
}

