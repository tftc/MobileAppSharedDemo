package cc.dayku.sqlcipherdemo;

import android.app.Activity;
import android.os.Bundle;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeSQLCipher();
    }
    private void InitializeSQLCipher() {
        SQLiteDatabase.loadLibs(this);
        //“data/data/包名/databases/demo.db”
        File databaseFile = getDatabasePath("demo.db");
        if (!databaseFile.getParentFile().exists()) {
            databaseFile.getParentFile().mkdirs();
        }
        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(
                databaseFile,"111111",null);
        try {
            database.execSQL("create table t1(a, b)");
        }catch (Exception e) {
            // TODO Auto-generated catch block
        }
        for (int i = 0; i < 10; i++) {
            database.execSQL("insert into t1(a, b) values(?, ?)", new Object[] {
                    "one for the money"+i, "two for the show"+i});
        }

    }
}
