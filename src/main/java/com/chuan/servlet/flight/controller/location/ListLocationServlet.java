package com.chuan.servlet.flight.controller.location;

import com.chuan.servlet.flight.bean.LocationBean;
import com.chuan.servlet.flight.service.LocationService;
import com.chuan.servlet.flight.service.LocationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListLocationServlet", urlPatterns = "/ListLocationServlet")
public class ListLocationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        LocationService ls = new LocationServiceImpl();
        List<LocationBean> ll = ls.getAllLocations();

        if (ll != null && ll.size() != 0) {
            page = "/admin/manage-location.jsp";
            request.setAttribute("locationList", ll);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
