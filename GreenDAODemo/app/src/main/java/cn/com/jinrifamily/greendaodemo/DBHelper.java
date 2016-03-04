
package cn.com.jinrifamily.greendaodemo;

import android.content.Context;

import java.util.List;

import cn.com.jinrizhushi.CounselorExtInfo;
import cn.com.jinrizhushi.CounselorExtInfoDao;
import cn.com.jinrizhushi.Customer;
import cn.com.jinrizhushi.DaoSession;
import cn.com.jinrizhushi.Order;
import cn.com.jinrizhushi.OrderDao;
import cn.com.jinrizhushi.Students;
import cn.com.jinrizhushi.Teachers;
import cn.com.jinrizhushi.User;
import cn.com.jinrizhushi.Users;
import cn.com.jinrizhushi.UsersDao;
import cn.com.jinrizhushi.StuAndtea;
import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.QueryBuilder;

public class DBHelper {
    private static Context mContext;

    private static DBHelper instance;

    private static DaoSession daoSession;

    private DBHelper() {
    }

    public static DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper();
            if (mContext == null) {
                mContext = context;
            }

            // 数据库对象
            daoSession = GreenDaoApplication.getDaoSession();
        }
        return instance;
    }
    

    /**
     * 添加数据
     * 
     * @param item
     */
    public void addToUserTable(User item){
        daoSession.getUserDao().insert(item);
    }
    public void addToUsersTable(Users item) {
        daoSession.getUsersDao().insert(item);
    }
    public void addToCounselorExtInfoTable(CounselorExtInfo item){
        daoSession.getCounselorExtInfoDao().insert(item);
    }
    public void addToCustomerTbale(Customer item){
        daoSession.getCustomerDao().insert(item);
    }
    public void addToOrderTable(Order item){
        daoSession.getOrderDao().insert(item);
    }
    public void addToStudentsTable(Students item){
        daoSession.getStudentsDao().insert(item);
    }
    public void addToTeachersTable(Teachers item){
        daoSession.getTeachersDao().insert(item);
    }
    public void addToStuAndtea(StuAndtea st){
        daoSession.getStuAndteaDao().insert(st);
    }


    /**
     * 查询表所有数据
     *
     * @return
     */
    public List<Users> getUsersList() {
        QueryBuilder<Users> qb = daoSession.getUsersDao().queryBuilder();
        return qb.list();
    }
    public List<CounselorExtInfo> getCounselorExtInfoList() {
        QueryBuilder<CounselorExtInfo> qb = daoSession.getCounselorExtInfoDao().queryBuilder();
        return qb.list();
    }
    public List<Customer> getCustomerList() {
        QueryBuilder<Customer> qb = daoSession.getCustomerDao().queryBuilder();
        return qb.list();
    }
    public List<Order> getOrderList() {
        QueryBuilder<Order> qb = daoSession.getOrderDao().queryBuilder();
        return qb.list();
    }
    public List<Students> getStudentsList() {
        QueryBuilder<Students> qb = daoSession.getStudentsDao().queryBuilder();
        return qb.list();
    }
    public List<Teachers> getTeachersList() {
        QueryBuilder<Teachers> qb = daoSession.getTeachersDao().queryBuilder();
        return qb.list();
    }



    /**
     * 查询表所有数据
     *
     * @return
     */
    public List<Users> getUsers() {
        return daoSession.getUsersDao().loadAll();

    }
    public List<CounselorExtInfo> getCounselorExtInfo() {
        return daoSession.getCounselorExtInfoDao().loadAll();
    }
    public List<Customer> getCustomer() {
        return daoSession.getCustomerDao().loadAll();

    }
    public List<Order> getOrder() {
        return daoSession.getOrderDao().loadAll();

    }
//
//    /**
//     * 查询是否保存
//     * 
//     * @param Id
//     * @return
//     */
//    public boolean isStudentInfoSaved(int Id) {
//        QueryBuilder<Users> qb = daoSession.getUsersDao().queryBuilder();
//        qb.where(Properties.Id.eq(Id));
//        qb.buildCount().count();
//        return qb.buildCount().count() > 0 ? true : false;
//    }
//
    /** 删除 */
    public void deleteUsersList(long Id) {
        QueryBuilder<Users> qb = daoSession.getUsersDao().queryBuilder();
        DeleteQuery<Users> bd = qb.where(UsersDao.Properties.Id.eq(Id)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }
    public void deleteCounselorExtInfoList(long Id) {
        QueryBuilder<CounselorExtInfo> qb = daoSession.getCounselorExtInfoDao().queryBuilder();
        DeleteQuery<CounselorExtInfo> bd = qb.where(CounselorExtInfoDao.Properties.Id.eq(Id)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }

    public void deleteOrderList(long Id) {
        QueryBuilder<Order> qb = daoSession.getOrderDao().queryBuilder();
        DeleteQuery<Order> bd = qb.where(OrderDao.Properties.Id.eq(Id)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }

    /** 删除 */
    public void clearUsers() {
        daoSession.getUsersDao().deleteAll();
    }
    public void clearCounselorExtInfo() {
        daoSession.getCounselorExtInfoDao().deleteAll();
    }
    public void clearCustomer() {
        daoSession.getCustomerDao().deleteAll();
    }

    public void clearOrder() {
        daoSession.getOrderDao().deleteAll();
    }

//
//    /** 通过姓名查找其性别 */
//    public String getSexByName(String name) {
//        QueryBuilder<Users> qb = daoSession.getUsersDao().queryBuilder();
//        qb.where(Properties.Name.eq(name));
//        if (qb.list().size() > 0) {
//            return qb.list().get(0).getSex();
//        } else {
//            return "";
//        }
//    }
//
//    /** 多重查询 */
//    public List<Users> getIphRegionList(String name, String sex) {
//        QueryBuilder<Users> qb = daoSession.getUsersDao().queryBuilder();
//        qb.where(qb.and(Properties.Name.eq(name), Properties.Sex.eq(sex)));
//        qb.orderAsc(Properties.Id);// 排序依据
//        return qb.list();
//    }
}
