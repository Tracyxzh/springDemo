package com.example;

import java.sql.*;

/**
 * Created by xiezhanghua on 2017/2/23.
 */
public class Sql {
    public Connection getCon(String url, String user, String password) {
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("连接成功");
        return con;
    }

    public void free(ResultSet rs, Connection con, Statement stm) {
        try {
            if (rs != null) {
               rs.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭 resultset失败");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("关闭connection失败");
                e.printStackTrace();
            } finally {
                try {
                    if (stm != null) {
                        stm.close();
                    }
                } catch (SQLException e) {
                    System.out.println("关闭statement 失败");
                    e.printStackTrace();
                }
            }
        }
    }
}
