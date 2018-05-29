package com.chuan.servlet.flight.controller.role;

import com.chuan.servlet.flight.bean.AccountBean;
import com.chuan.servlet.flight.bean.RoleBean;
import com.chuan.servlet.flight.service.AccountService;
import com.chuan.servlet.flight.service.AccountServiceImpl;
import com.chuan.servlet.flight.service.RoleService;
import com.chuan.servlet.flight.service.RoleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditRoleServlet", urlPatterns = "/EditRoleServlet")
public class EditRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListRoleServlet";

        RoleBean role = new RoleBean(
                Integer.parseInt(request.getParameter("role_id")),
                request.getParameter("role_name"));

        RoleService rs = new RoleServiceImpl();

        if (rs.updateRole(role) > 0) {
            // success
            System.out.println("role update success");
        } else {
            // failed
            System.out.println("role update failed");
        }

        response.sendRedirect(page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rId = Integer.parseInt(request.getParameter("role_id"));
        String page = "";
        // Airplane
        RoleService rs = new RoleServiceImpl();
        RoleBean role = rs.getRoleById(rId);

        if (role != null) {
            page = "/admin/role-edit.jsp";
            request.setAttribute("role", role);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}
