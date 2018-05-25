package com.chuan.servlet.flight.controller.account;

import com.chuan.servlet.flight.bean.AccountBean;
import com.chuan.servlet.flight.service.AccountService;
import com.chuan.servlet.flight.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAccountServlet", urlPatterns = "/AddAccountServlet")
public class AddAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/admin/account-add.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListAccountServlet";

        AccountBean account = new AccountBean(
                -1,
                request.getParameter("username"),
                request.getParameter("password"),
                Integer.parseInt(request.getParameter("role_id")));
        System.out.println(account);
        AccountService as = new AccountServiceImpl();

        if (as.newAccount(account) > 0) {
            // success
            System.out.println("account add success");
        } else {
            // failed
            System.out.println("account add failed");
        }

        response.sendRedirect(page);
    }
}
