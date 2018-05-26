package com.chuan.servlet.flight.controller.flight;

import com.chuan.servlet.flight.service.FlightService;
import com.chuan.servlet.flight.service.FlightServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteFlightServlet", urlPatterns = "/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListFlightServlet";
        int fId = Integer.parseInt(request.getParameter("flight_id"));
        FlightService fs = new FlightServiceImpl();

        if (fs.deleteFlightById(fId) > 0) {
            // success
            System.out.println("flight delete success");
        } else {
            // failed
            System.out.println("flight delete failed");
        }
        response.sendRedirect(page);
    }
}
