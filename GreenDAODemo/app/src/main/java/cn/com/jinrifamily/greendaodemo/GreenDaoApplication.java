package cn.com.jinrifamily.greendaodemo;

import android.app.Application;

import cn.com.jinrizhushi.DaoMaster;
import cn.com.jinrizhushi.DaoSession;
import cn.com.jinrizhushi.DaoMaster.OpenHelper;


/**
 * 描述:
 * 作者: 刘倩
 * 日期: 16/1/19 10:18
 */
public class GreenDaoApplication extends Application{
    private static GreenDaoApplication appContext;

    private static DaoMaster daoMaster;

    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        if (appContext == null) {
            appContext = this;
        }
    }
    /**
     * 取得DaoMaster
     *
     * @return
     */
    public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            OpenHelper helper = new DaoMaster.DevOpenHelper(appContext, Constants.DATABASE_NAME,
                    null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @return
     */
    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
