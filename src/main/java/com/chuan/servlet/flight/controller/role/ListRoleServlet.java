package com.chuan.servlet.flight.controller.role;

import com.chuan.servlet.flight.bean.RoleBean;
import com.chuan.servlet.flight.service.RoleService;
import com.chuan.servlet.flight.service.RoleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListRoleServlet", urlPatterns = "/ListRoleServlet")
public class ListRoleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        RoleService rs = new RoleServiceImpl();
        List<RoleBean> rl = rs.getAllRoles();

        if (rl != null && rl.size() != 0) {
            page = "/admin/manage-role.jsp";
            request.setAttribute("roleList", rl);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
