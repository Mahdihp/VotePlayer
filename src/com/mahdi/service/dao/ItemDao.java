package com.mahdi.service.dao;

import com.mahdi.service.entity.Item;
import com.mahdi.service.entity.Question;
import com.mahdi.service.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao extends Dao<Item,Integer> {

    public ItemDao() throws Exception {
    }

    public List<Item> getLastItem(int questionId) throws SQLException {
        String sql = "select * from item where question_Fk=?;";
        List<Item> userList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,questionId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String item = rs.getString("item");
            int question_Fk = rs.getInt("question_Fk");
            userList.add(new Item(id, item,question_Fk));
        }
        return userList;
    }
    @Override
    public void create(Item entity) throws SQLException {

    }

    @Override
    public Item read(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Item entity) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {

    }

    @Override
    public List<Item> readAll() throws SQLException {
        String sql = "SELECT * FROM item";
        List<Item> userList = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String titem = rs.getString("item");
            int question_fk = rs.getInt("question_fk");
            userList.add(new Item(id, titem, question_fk));
        }
        return userList;
    }
}
