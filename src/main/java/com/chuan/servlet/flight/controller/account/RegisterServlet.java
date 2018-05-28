package com.chuan.servlet.flight.controller.account;

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

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String page = "";
        AccountService as = new AccountServiceImpl();

        int res = as.newAccount(new AccountBean(-1, username, password, 2, ""));

        if (res > 0) {
            // success
            System.out.println("register success");
            page = "account/login.jsp";
        } else {
            // failed
            System.out.println("register failed");
            page = "account/register.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
