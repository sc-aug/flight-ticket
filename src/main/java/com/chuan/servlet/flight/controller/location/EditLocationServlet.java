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

@WebServlet(name = "EditLocationServlet", urlPatterns = "/EditLocationServlet")
public class EditLocationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int locId = Integer.parseInt(request.getParameter("location_id"));
        String page = "";
        // get data service
        LocationService ls = new LocationServiceImpl();
        // get location by id
        LocationBean loc = ls.getLocationById(locId);

        if (loc != null) {
            page = "/admin/location-edit.jsp";
            request.setAttribute("location", loc);
        } else {
            System.out.println("Empty");
            page = "/admin/manage-location.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListLocationServlet";

        LocationBean loc = new LocationBean(
                Integer.parseInt(request.getParameter("location_id")),
                request.getParameter("location_name"),
                request.getParameter("timezone"));

        LocationService ls = new LocationServiceImpl();

        if (ls.updateLocation(loc) > 0) {
            // success
            System.out.println("location update success");
        } else {
            // failed
            System.out.println("location update failed");
        }

        response.sendRedirect(page);
    }

}
