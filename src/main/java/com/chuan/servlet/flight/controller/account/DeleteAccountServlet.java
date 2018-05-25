package com.chuan.servlet.flight.controller.account;

import com.chuan.servlet.flight.service.AccountService;
import com.chuan.servlet.flight.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAccountServlet", urlPatterns = "/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListAccountServlet";
        int uid = Integer.parseInt(request.getParameter("uid"));
        AccountService as = new AccountServiceImpl();

        if (as.deleteAccountById(uid) > 0) {
            // success
            System.out.println("account delete success");
        } else {
            // failed
            System.out.println("account delete failed");
        }
        response.sendRedirect(page);
    }

}
