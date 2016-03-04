package cn.com.jinrizhushi;

import java.util.List;
import cn.com.jinrizhushi.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "STUDENTS".
 */
public class Students implements java.io.Serializable {

    private Long id;
    private String stuName;
    private String stuSex;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient StudentsDao myDao;

    private List<StuAndtea> manystu;

    public Students() {
    }

    public Students(Long id) {
        this.id = id;
    }

    public Students(Long id, String stuName, String stuSex) {
        this.id = id;
        this.stuName = stuName;
        this.stuSex = stuSex;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentsDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<StuAndtea> getManystu() {
        if (manystu == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StuAndteaDao targetDao = daoSession.getStuAndteaDao();
            List<StuAndtea> manystuNew = targetDao._queryStudents_Manystu(id);
            synchronized (this) {
                if(manystu == null) {
                    manystu = manystuNew;
                }
            }
        }
        return manystu;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetManystu() {
        manystu = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
