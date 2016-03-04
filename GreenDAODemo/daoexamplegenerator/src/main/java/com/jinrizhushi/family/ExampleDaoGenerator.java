package com.jinrizhushi.family;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;
import de.greenrobot.daogenerator.ToOne;

public class ExampleDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1,"cn.com.jinrizhushi");
        addNote(schema);
        new DaoGenerator().generateAll(schema,"/Users/bamboo/GitHub/GreenDaoDemo/app/src/main/java-gen");
    }

    /**
     * 添加用户表
     * @param schema
     */
    private static void addNote(Schema schema) {
        /**单个表*/
        Entity user = schema.addEntity("User");
        user.implementsSerializable();
        user.addIdProperty();
        user.addIntProperty("attitudes_count");
        user.addStringProperty("avatar_default");
        user.addStringProperty("avatar_hd");
        user.addStringProperty("avatar_large");
        user.addIntProperty("comments_count");
        user.addIntProperty("authentication");
        user.addStringProperty("certificationGroup");
        user.addStringProperty("create_time");
        user.addStringProperty("description_content");
        user.addIntProperty("favourites_count");
        user.addIntProperty("followers_count");
        user.addIntProperty("friends_count");
        user.addIntProperty("gender");
        user.addIntProperty("identifier");
        user.addStringProperty("mobile");
        user.addStringProperty("nick_name");
        user.addStringProperty("real_name");
        user.addStringProperty("password");
        user.addIntProperty("point_count");
        user.addIntProperty("user_type");


        /** 一对一 */
        Entity users = schema.addEntity("Users");
        users.implementsSerializable();
        users.addIdProperty();
        users.addStringProperty("mobile");

        Entity coun = schema.addEntity("CounselorExtInfo");
        coun.implementsSerializable();
        coun.addIdProperty();
        coun.addIntProperty("authentication");
        coun.addStringProperty("certificationGroup");
        coun.addLongProperty("create_time");
        coun.addStringProperty("description_content");

        Property counIdProperty = users.addLongProperty("counId").getProperty();
        users.addToOne(coun, counIdProperty);


        /** 一对多 (一个客户和其多个订单的关系)*/
        Entity customer = schema.addEntity("Customer");
        customer.implementsSerializable();
        customer.addIdProperty();
        customer.addStringProperty("name");

        Entity order = schema.addEntity("Order");
        order.implementsSerializable();
        order.addIdProperty();
        Property orderCode = order.addStringProperty("orderCode").getProperty();
        Property orderDate = order.addDateProperty("date").getProperty();
        Property customerId = order.addLongProperty("customerId").notNull().getProperty();
        order.addToOne(customer, customerId);

        ToMany customerToOrders = customer.addToMany(order, customerId);
        customerToOrders.setName("orders");
        customerToOrders.orderAsc(orderDate);



        /** 多对多 */
        Entity studentBean = schema.addEntity("Students");
        studentBean.implementsSerializable();
        studentBean.addIdProperty();
        studentBean.addStringProperty("stuName");
        studentBean.addStringProperty("stuSex");

        Entity teacherBean = schema.addEntity("Teachers");
        teacherBean.implementsSerializable();
        teacherBean.addIdProperty();
        teacherBean.addStringProperty("teaName");
        teacherBean.addStringProperty("teaSex");

        Entity stuAndteaBean = schema.addEntity("StuAndtea");
        Property studentId = stuAndteaBean.addLongProperty("studentId").getProperty();
        Property teacherId = stuAndteaBean.addLongProperty("teacherId").getProperty();

        //这里其实很简单，就是建立两个1：n的关系
        stuAndteaBean.addToOne(studentBean,studentId).setName("onestu");
        stuAndteaBean.addToOne(teacherBean,teacherId).setName("onetea");
        studentBean.addToMany(stuAndteaBean,studentId).setName("manystu");
        teacherBean.addToMany(stuAndteaBean,teacherId).setName("manytea");

    }
}
