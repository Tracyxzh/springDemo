package com.example;

/**
 * Created by xiezhanghua on 2017/2/23.
 */
import java.sql.*;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:h2:~/Workspace/sqlh2/test";
        String user = "root";
        String password = "root";
        Class.forName("org.h2.Driver"); // 1.创建驱动
        System.out.println("驱动成功");
        Sql sqlt = new Sql();
        Connection conn = sqlt.getCon(url, user, password); // 2. 建立连接
        Statement stms = conn.createStatement(); // 3.创建Statement
        System.out.println("创建Statement成功");
        StudentSql stdsql = new StudentSql(stms);
        //stdsql.addStudent(); //creat
        stdsql.addStudentInfo(); //insert
        List<Student> list = stdsql.selectStudent(); //select
        for (Student std : list) {
            System.out.println("id: " + std.getId() + "name: " + std.getName());
        }
        stdsql.batchSql();
        sqlt.free(null, conn,null);
    }
}
