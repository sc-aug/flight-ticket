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
import java.util.List;

@WebServlet(urlPatterns = "/ListAccountServlet")
public class ListAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        AccountService as = new AccountServiceImpl();
        List<AccountBean> al = as.getAllAccounts();

        for (AccountBean a: al) {
            System.out.println(a.getUsername());
        }

        if (al != null && al.size() != 0) {
            page = "/admin/user-manage.jsp";
            request.setAttribute("accountList", al);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
