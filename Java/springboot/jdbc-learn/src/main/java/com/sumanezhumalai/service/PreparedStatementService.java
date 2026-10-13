package com.sumanezhumalai.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sumanezhumalai.utility.DbConnection;

public class PreparedStatementService {

    private void printAll(ResultSet rs) throws SQLException {
        System.out.println("Connection Established Successfully");
        while (rs.next()) {
            System.out.printf("ID: %5d | NAME: %-25.25s | IS_ACTIVE: %-10b \n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("isActive"));
        }
        System.out.println("Connection Closed");
    }

    public void selectAll() {
        String sql = "SELECT * FROM person";
        try (Connection con = DbConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {
            printAll(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                printAll(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(String name) {
        String sql = "INSERT INTO person (name) VALUES (?)";
        try (Connection con = DbConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateName(int id, String name) {
        String sql = "UPDATE person SET name = ? WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setInt(2, id);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "DELETE FROM person WHERE id = ?";
        try (Connection con = DbConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
