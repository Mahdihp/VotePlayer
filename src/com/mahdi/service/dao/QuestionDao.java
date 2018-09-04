package com.mahdi.service.dao;

import com.mahdi.service.entity.Question;
import com.mahdi.service.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao extends Dao<Question,Integer> {

    public QuestionDao() throws Exception {
    }

    public Question getLastQuestion() throws SQLException {
        String sql = "select max(id) as id,question from question ;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int question_id = rs.getInt("id");
        String question = rs.getString("question");
        return new Question(question_id, question);
    }

    @Override
    public void create(Question entity) throws SQLException {
        String sql = "INSERT INTO question(question) VALUES(?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getQuestion());
        ps.executeUpdate();
    }

    @Override
    public Question read(Integer id) throws SQLException {
        String sql = "SELECT * FROM question WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int question_id = rs.getInt("id");
        String question = rs.getString("question");
        return new Question(question_id, question);
    }

    @Override
    public void update(Question entity) throws SQLException {
        String sql = "UPDATE question SET question=? WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getQuestion());
        ps.executeUpdate();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM question WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Question> readAll() throws SQLException {
        String sql = "SELECT * FROM question";
        List<Question> userList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String question = rs.getString("question");
            userList.add(new Question(id, question));
        }
        return userList;
    }
}
