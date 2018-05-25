package com.chuan.servlet.flight.controller.location;

import com.chuan.servlet.flight.service.LocationService;
import com.chuan.servlet.flight.service.LocationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteLocationServlet", urlPatterns = "/DeleteLocationServlet")
public class DeleteLocationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListLocationServlet";
        int locId = Integer.parseInt(request.getParameter("location_id"));
        LocationService ls = new LocationServiceImpl();

        if (ls.deleteLocation(locId) > 0) {
            // success
            System.out.println("location delete success");
        } else {
            // failed
            System.out.println("location delete failed");
        }
        response.sendRedirect(page);
    }

}
