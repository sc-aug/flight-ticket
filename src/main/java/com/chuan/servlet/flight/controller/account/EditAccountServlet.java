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

@WebServlet(name = "EditAccountServlet", urlPatterns = "/EditAccountServlet")
public class EditAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uId = Integer.parseInt(request.getParameter("uid"));
        String page = "";
        // Airplane
        AccountService as = new AccountServiceImpl();
        AccountBean acc = as.getAccountById(uId);

        if (acc != null) {
            page = "/admin/account-edit.jsp";
            request.setAttribute("account", acc);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListAccountServlet";

        AccountBean account = new AccountBean(
                Integer.parseInt(request.getParameter("uid")),
                request.getParameter("username"),
                request.getParameter("password"),
                Integer.parseInt(request.getParameter("role_id")));
        System.out.println(account);
        AccountService as = new AccountServiceImpl();

        if (as.updateAccount(account) > 0) {
            // success
            System.out.println("account update success");
        } else {
            // failed
            System.out.println("account update failed");
        }

        response.sendRedirect(page);
    }
}
