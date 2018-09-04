package com.mahdi.service;

import com.mahdi.service.dao.ItemDao;
import com.mahdi.service.dao.QuestionDao;
import com.mahdi.service.dao.UserDao;
import com.mahdi.service.dao.VoteResultDao;
import com.mahdi.service.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends javax.servlet.http.HttpServlet {


    UserDao userDao = null;
    QuestionDao questionDao = null;
    VoteResultDao voteResultDao = null;
    ItemDao itemDao =null;
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDao = new UserDao();
            questionDao = new QuestionDao();
            voteResultDao = new VoteResultDao();
            itemDao = new ItemDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {

            try {
                userDao = new UserDao();
                if (userDao.login(username, password)) {

                    HttpSession session = request.getSession(true);
                    session.setAttribute("sec_data", new User(username, password));



                    if (voteResultDao.isRegisterVote(username)) {
                        request.setAttribute("question", questionDao.getLastQuestion().getQuestion());
                        request.setAttribute("items", voteResultDao.getLastResult());
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    } else {
                        request.setAttribute("question", questionDao.getLastQuestion().getQuestion());
                        request.setAttribute("questionId", questionDao.getLastQuestion().getId());
                        request.setAttribute("userId", userDao.loginWithUserId(username, password));
                        request.setAttribute("items", itemDao.readAll());

                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    }
                } else {
                    response.sendRedirect("./login.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
