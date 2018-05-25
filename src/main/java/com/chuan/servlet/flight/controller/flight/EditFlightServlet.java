package com.chuan.servlet.flight.controller.flight;

import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.service.FlightService;
import com.chuan.servlet.flight.service.FlightServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditFlightServlet", urlPatterns = {"/EditFlightServlet"})
public class EditFlightServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // System.out.println(request.getParameter("flight_id"));
        int fId = Integer.parseInt(request.getParameter("flight_id"));
        FlightService fs = new FlightServiceImpl();
        System.out.println(fId);
        FlightBean f = fs.getFlightById(fId);
        System.out.println(f);

    }

}
