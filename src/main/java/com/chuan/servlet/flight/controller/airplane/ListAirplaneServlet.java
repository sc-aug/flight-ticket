package com.chuan.servlet.flight.controller.airplane;

import com.chuan.servlet.flight.bean.AirplaneBean;
import com.chuan.servlet.flight.service.AirplaneService;
import com.chuan.servlet.flight.service.AirplaneServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListAirplaneServlet", urlPatterns = "/ListAirplaneServlet")
public class ListAirplaneServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        AirplaneService as = new AirplaneServiceImpl();
        List<AirplaneBean> al = as.getAllAirplanes();

        if (al != null && al.size() != 0) {
            page = "/admin/manage-airplane.jsp";
            request.setAttribute("airplaneList", al);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
