package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiezhanghua on 2017/2/23.
 */
public class StudentSql {
    private Statement stmt;
    StudentSql(Statement stmt) {
        this.stmt = stmt;
    }
    public void addStudent() {
        try {
            stmt.executeUpdate("CREATE TABLE student(" +
                    "id INT PRIMARY KEY NOT NULL," +
                    "name VARCHAR(50) NOT NULL," +
                    "info VARCHAR(50) NOT NULL, " +
                    "className VARCHAR(50) NOT NULL," +
                    "classNum INT NOT NULL)");
            System.out.println("创建成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addStudentInfo() {
        try {
            //stmt.executeUpdate("INSERT INTO student(id, name, info, className, classNum) VALUES (1, '张三', '张三 info', '一班', '1')");
            //stmt.executeUpdate("INSERT INTO student(id, name, info, className, classNum) VALUES (2, '李四', '李四 info', '一班', '1')");
            //stmt.executeUpdate("INSERT INTO student(id, name, info, className, classNum) VALUES (3, '王五', '王五 info', '一班', '1')");
            stmt.executeUpdate("INSERT INTO student(id, name, info, className, classNum) VALUES (10, '赵六10', '赵六10 info', '二班', '2')");
            System.out.println("添加数据成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Student> selectStudent() {
        List<Student> list = new ArrayList<Student>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id = 4");
            System.out.println("查询数据成功");
            while (rs.next()) {
                Student std = new Student();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                std.setInfo(rs.getString("info"));
                std.setClassName(rs.getString("className"));
                std.setClassNum(rs.getInt("classNum"));
                list.add(std);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void batchSql() throws Exception {
        stmt.addBatch("INSERT INTO student(id, name, info, className, classNum) VALUES (5, 'xzh5', 'xzh5 info', '三班', '3')");
        stmt.addBatch("INSERT INTO student(id, name, info, className, classNum) VALUES (6, 'xzh6', 'xzh6 info', '三班', '3')");
        stmt.addBatch("INSERT INTO student(id, name, info, className, classNum) VALUES (7, 'xzh7', 'xzh7 info', '三班', '3')");
        stmt.addBatch("INSERT INTO student(id, name, info, className, classNum) VALUES (8, 'xzh8', 'xzh8 info', '三班', '3')");
        stmt.executeBatch();
        System.out.println("执行批量成功");
    }
}
