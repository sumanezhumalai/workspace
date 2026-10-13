package com.sumanezhumalai.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sumanezhumalai.utility.DbConnection;

public class StatementService {

    public void selectAll(String sql) {
        try (Connection con = DbConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {

            System.out.println("Connection Established Successfully");
            while (rs.next()) {
                System.out.printf("ID: %5d | NAME: %-25.25s | IS_ACTIVE: %-10b \n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("isActive"));
            }
            System.out.println("Connection Closed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        try (Connection con = DbConnection.getConnection();
                Statement st = con.createStatement()) {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
