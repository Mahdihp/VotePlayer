package com.mahdi.service.dao;

import com.mahdi.service.entity.VoteResult;
import com.mahdi.service.entity.VoteResultItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteResultDao extends Dao<VoteResult, Integer> {

    public VoteResultDao() throws Exception {
    }

    public boolean isRegisterVote(String username) throws SQLException {
        String sql = "SELECT * from vote_result " +
                "LEFT JOIN user u on vote_result.user_fk = u.id " +
                "where u.username LIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        rs.last();
        if (rs.getRow() > 0)
            return true;
        else
            return false;
    }
    public boolean isRegisterVote(int userId) throws SQLException {
        String sql = "SELECT * from vote_result " +
                "LEFT JOIN user u on vote_result.user_fk = u.id " +
                "where u.id LIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();
        rs.last();
        if (rs.getRow() > 0)
            return true;
        else
            return false;
    }

    public List<VoteResultItem> getLastResult() throws SQLException {
        String sql = "SELECT item.id,count(item.id) as count,item.item from item\n" +
                "  JOIN question q on item.question_fk = q.id\n" +
                "  JOIN vote_result v on item.id = v.item_fk\n" +
                "group by (item.id);";
        List<VoteResultItem> userList = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int count = rs.getInt("count");
            String item = rs.getString("item");
            userList.add(new VoteResultItem(id, count, item));
        }
        return userList;
    }

    @Override
    public void create(VoteResult entity) throws SQLException {
        String sql = "INSERT INTO" +
                " vote_result(user_fk,question_fk,item_fk) VALUES(?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, entity.getId());
        ps.setInt(2, entity.getQuestion_Fk());
        ps.setInt(3, entity.getItem_Fk());
        ps.executeUpdate();
    }

    @Override
    public VoteResult read(Integer id) throws SQLException {
        String sql = "SELECT * FROM vote_result WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int idquestion = rs.getInt("id");
        int question_fk = rs.getInt("question_fk");
        int item_fk = rs.getInt("item_fk");
        return new VoteResult(idquestion, question_fk, item_fk);
    }

    @Override
    public void update(VoteResult entity) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {

    }

    @Override
    public List<VoteResult> readAll() throws SQLException {
        return null;
    }

}
