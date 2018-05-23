package com.chuan.servlet.flight.controller;

import com.chuan.servlet.flight.bean.AccountBean;
import com.chuan.servlet.flight.service.AccountService;
import com.chuan.servlet.flight.service.AccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " " + password);
        String page = "";
        AccountService as = new AccountServiceImpl();
        AccountBean acc = as.login(new AccountBean(-1, username, password, -1));
        if (acc != null) {
            // success
            System.out.println("success");
            if (acc.getRoleId() == 1) {
                page = "/admin/admin.jsp";
            } else {
                page = "/user/user.jsp";
            }
        } else {
            // failed
            System.out.println("failed");
            page = "/account/login.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
