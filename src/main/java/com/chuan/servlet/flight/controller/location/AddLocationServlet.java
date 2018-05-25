package com.chuan.servlet.flight.controller.location;

import com.chuan.servlet.flight.bean.LocationBean;
import com.chuan.servlet.flight.service.LocationService;
import com.chuan.servlet.flight.service.LocationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddLocationServlet", urlPatterns = "/AddLocationServlet")
public class AddLocationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/admin/location-add.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListLocationServlet";

        LocationBean loc = new LocationBean(
                -1,
                request.getParameter("location_name"),
                request.getParameter("timezone"));

        LocationService ls = new LocationServiceImpl();

        if (ls.addLocation(loc) > 0) {
            // success
            System.out.println("location add success");
        } else {
            // failed
            System.out.println("location add failed");
        }

        response.sendRedirect(page);
    }

}
