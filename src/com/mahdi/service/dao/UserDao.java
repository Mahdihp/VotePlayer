package com.mahdi.service.dao;

import com.mahdi.service.entity.DaoException;
import com.mahdi.service.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao<User, Integer> {

    public UserDao() throws Exception {
    }

    public boolean login(String username, String password) throws DaoException {
        String sql = "SELECT * FROM user WHERE username LIKE ? AND password LIKE ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() == 0)
                return false;
            else
                return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    public int loginWithUserId(String username, String password) throws DaoException {
        String sql = "SELECT * FROM user WHERE username LIKE ? AND password LIKE ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                rs.beforeFirst();
                rs.next();
                return rs.getInt("id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void create(User entity) throws SQLException {
        String sql = "INSERT INTO user(username,password,displayname) VALUES(?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getUserName());
        ps.setString(2, entity.getPassWord());
        ps.setString(3, entity.getDisplayName());
        ps.executeUpdate();
    }

    @Override
    public User read(Integer id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String username = rs.getString("username");
        String password = rs.getString("password");
        String displayname = rs.getString("displayname");
        return new User(username, password, displayname);
    }

    @Override
    public void update(User entity) throws SQLException {
        String sql = "UPDATE user SET username=?,password=?,displayname=? WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getUserName());
        ps.setString(2, entity.getPassWord());
        ps.setString(3, entity.getDisplayName());
        ps.executeUpdate();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM user WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<User> readAll() throws SQLException {
        String sql = "SELECT * FROM user";
        List<User> userList = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String displayname = rs.getString("displayname");
            userList.add(new User(id, username, password, displayname));
        }
        return userList;
    }
}
