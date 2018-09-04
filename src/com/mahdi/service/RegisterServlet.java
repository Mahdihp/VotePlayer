package com.mahdi.service;

import com.mahdi.service.dao.ItemDao;
import com.mahdi.service.dao.QuestionDao;
import com.mahdi.service.dao.UserDao;
import com.mahdi.service.dao.VoteResultDao;
import com.mahdi.service.entity.VoteResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    VoteResultDao voteResultDao = null;
    QuestionDao questionDao = null;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            voteResultDao = new VoteResultDao();
            questionDao = new QuestionDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int questionId = Integer.parseInt(request.getParameter("questionId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int itemId = Integer.parseInt(request.getParameter("item"));
        try {
            if (!voteResultDao.isRegisterVote(userId))
                voteResultDao.create(new VoteResult(userId, questionId, itemId));
                request.setAttribute("question", questionDao.getLastQuestion().getQuestion());
                request.setAttribute("items", voteResultDao.getLastResult());
                request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
