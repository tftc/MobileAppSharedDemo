package cn.com.jinrizhushi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import cn.com.jinrizhushi.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Attitudes_count = new Property(1, Integer.class, "attitudes_count", false, "ATTITUDES_COUNT");
        public final static Property Avatar_default = new Property(2, String.class, "avatar_default", false, "AVATAR_DEFAULT");
        public final static Property Avatar_hd = new Property(3, String.class, "avatar_hd", false, "AVATAR_HD");
        public final static Property Avatar_large = new Property(4, String.class, "avatar_large", false, "AVATAR_LARGE");
        public final static Property Comments_count = new Property(5, Integer.class, "comments_count", false, "COMMENTS_COUNT");
        public final static Property Authentication = new Property(6, Integer.class, "authentication", false, "AUTHENTICATION");
        public final static Property CertificationGroup = new Property(7, String.class, "certificationGroup", false, "CERTIFICATION_GROUP");
        public final static Property Create_time = new Property(8, String.class, "create_time", false, "CREATE_TIME");
        public final static Property Description_content = new Property(9, String.class, "description_content", false, "DESCRIPTION_CONTENT");
        public final static Property Favourites_count = new Property(10, Integer.class, "favourites_count", false, "FAVOURITES_COUNT");
        public final static Property Followers_count = new Property(11, Integer.class, "followers_count", false, "FOLLOWERS_COUNT");
        public final static Property Friends_count = new Property(12, Integer.class, "friends_count", false, "FRIENDS_COUNT");
        public final static Property Gender = new Property(13, Integer.class, "gender", false, "GENDER");
        public final static Property Identifier = new Property(14, Integer.class, "identifier", false, "IDENTIFIER");
        public final static Property Mobile = new Property(15, String.class, "mobile", false, "MOBILE");
        public final static Property Nick_name = new Property(16, String.class, "nick_name", false, "NICK_NAME");
        public final static Property Real_name = new Property(17, String.class, "real_name", false, "REAL_NAME");
        public final static Property Password = new Property(18, String.class, "password", false, "PASSWORD");
        public final static Property Point_count = new Property(19, Integer.class, "point_count", false, "POINT_COUNT");
        public final static Property User_type = new Property(20, Integer.class, "user_type", false, "USER_TYPE");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ATTITUDES_COUNT\" INTEGER," + // 1: attitudes_count
                "\"AVATAR_DEFAULT\" TEXT," + // 2: avatar_default
                "\"AVATAR_HD\" TEXT," + // 3: avatar_hd
                "\"AVATAR_LARGE\" TEXT," + // 4: avatar_large
                "\"COMMENTS_COUNT\" INTEGER," + // 5: comments_count
                "\"AUTHENTICATION\" INTEGER," + // 6: authentication
                "\"CERTIFICATION_GROUP\" TEXT," + // 7: certificationGroup
                "\"CREATE_TIME\" TEXT," + // 8: create_time
                "\"DESCRIPTION_CONTENT\" TEXT," + // 9: description_content
                "\"FAVOURITES_COUNT\" INTEGER," + // 10: favourites_count
                "\"FOLLOWERS_COUNT\" INTEGER," + // 11: followers_count
                "\"FRIENDS_COUNT\" INTEGER," + // 12: friends_count
                "\"GENDER\" INTEGER," + // 13: gender
                "\"IDENTIFIER\" INTEGER," + // 14: identifier
                "\"MOBILE\" TEXT," + // 15: mobile
                "\"NICK_NAME\" TEXT," + // 16: nick_name
                "\"REAL_NAME\" TEXT," + // 17: real_name
                "\"PASSWORD\" TEXT," + // 18: password
                "\"POINT_COUNT\" INTEGER," + // 19: point_count
                "\"USER_TYPE\" INTEGER);"); // 20: user_type
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer attitudes_count = entity.getAttitudes_count();
        if (attitudes_count != null) {
            stmt.bindLong(2, attitudes_count);
        }
 
        String avatar_default = entity.getAvatar_default();
        if (avatar_default != null) {
            stmt.bindString(3, avatar_default);
        }
 
        String avatar_hd = entity.getAvatar_hd();
        if (avatar_hd != null) {
            stmt.bindString(4, avatar_hd);
        }
 
        String avatar_large = entity.getAvatar_large();
        if (avatar_large != null) {
            stmt.bindString(5, avatar_large);
        }
 
        Integer comments_count = entity.getComments_count();
        if (comments_count != null) {
            stmt.bindLong(6, comments_count);
        }
 
        Integer authentication = entity.getAuthentication();
        if (authentication != null) {
            stmt.bindLong(7, authentication);
        }
 
        String certificationGroup = entity.getCertificationGroup();
        if (certificationGroup != null) {
            stmt.bindString(8, certificationGroup);
        }
 
        String create_time = entity.getCreate_time();
        if (create_time != null) {
            stmt.bindString(9, create_time);
        }
 
        String description_content = entity.getDescription_content();
        if (description_content != null) {
            stmt.bindString(10, description_content);
        }
 
        Integer favourites_count = entity.getFavourites_count();
        if (favourites_count != null) {
            stmt.bindLong(11, favourites_count);
        }
 
        Integer followers_count = entity.getFollowers_count();
        if (followers_count != null) {
            stmt.bindLong(12, followers_count);
        }
 
        Integer friends_count = entity.getFriends_count();
        if (friends_count != null) {
            stmt.bindLong(13, friends_count);
        }
 
        Integer gender = entity.getGender();
        if (gender != null) {
            stmt.bindLong(14, gender);
        }
 
        Integer identifier = entity.getIdentifier();
        if (identifier != null) {
            stmt.bindLong(15, identifier);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(16, mobile);
        }
 
        String nick_name = entity.getNick_name();
        if (nick_name != null) {
            stmt.bindString(17, nick_name);
        }
 
        String real_name = entity.getReal_name();
        if (real_name != null) {
            stmt.bindString(18, real_name);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(19, password);
        }
 
        Integer point_count = entity.getPoint_count();
        if (point_count != null) {
            stmt.bindLong(20, point_count);
        }
 
        Integer user_type = entity.getUser_type();
        if (user_type != null) {
            stmt.bindLong(21, user_type);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // attitudes_count
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // avatar_default
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // avatar_hd
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // avatar_large
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // comments_count
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // authentication
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // certificationGroup
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // create_time
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // description_content
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // favourites_count
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // followers_count
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // friends_count
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13), // gender
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // identifier
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // mobile
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // nick_name
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // real_name
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // password
            cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19), // point_count
            cursor.isNull(offset + 20) ? null : cursor.getInt(offset + 20) // user_type
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAttitudes_count(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setAvatar_default(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAvatar_hd(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAvatar_large(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setComments_count(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setAuthentication(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setCertificationGroup(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCreate_time(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setDescription_content(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setFavourites_count(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setFollowers_count(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setFriends_count(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setGender(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
        entity.setIdentifier(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setMobile(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setNick_name(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setReal_name(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setPassword(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setPoint_count(cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19));
        entity.setUser_type(cursor.isNull(offset + 20) ? null : cursor.getInt(offset + 20));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
