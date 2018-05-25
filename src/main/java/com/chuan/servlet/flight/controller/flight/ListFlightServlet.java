package com.chuan.servlet.flight.controller.flight;

import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.service.FlightService;
import com.chuan.servlet.flight.service.FlightServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListFlightServlet", urlPatterns = "/ListFlightServlet")
public class ListFlightServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        FlightService fs = new FlightServiceImpl();
        List<FlightBean> fl = fs.getAllFlights();

        if (fl != null && fl.size() != 0) {
            page = "/admin/manage-flight.jsp";
            request.setAttribute("flightList", fl);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
