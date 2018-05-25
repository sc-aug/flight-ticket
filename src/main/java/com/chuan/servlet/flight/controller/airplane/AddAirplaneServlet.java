package com.chuan.servlet.flight.controller.airplane;

import com.chuan.servlet.flight.bean.AirplaneBean;
import com.chuan.servlet.flight.service.AirplaneService;
import com.chuan.servlet.flight.service.AirplaneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAirplaneServlet" , urlPatterns = "/AddAirplaneServlet")
public class AddAirplaneServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/admin/airplane-add.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListAirplaneServlet";

        AirplaneBean airplane = new AirplaneBean(
                Integer.parseInt(request.getParameter("airplane_id")),
                request.getParameter("airplane_name"),
                Integer.parseInt(request.getParameter("seat_first")),
                Integer.parseInt(request.getParameter("seat_business")),
                Integer.parseInt(request.getParameter("seat_economy")));
        AirplaneService as = new AirplaneServiceImpl();

        if (as.addAirplane(airplane) > 0) {
            // success
            System.out.println("airplane add success");
        } else {
            // failed
            System.out.println("airplane add failed");
        }

        response.sendRedirect(page);
    }

}
