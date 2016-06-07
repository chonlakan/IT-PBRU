package pbru.yaemsak.chonlakan.itpbru;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;



    public MyManage(Context context) {
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();


    }//Constructor
}//Main class
