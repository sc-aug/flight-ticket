package com.chuan.servlet.flight.controller.airplane;

import com.chuan.servlet.flight.bean.AirplaneBean;
import com.chuan.servlet.flight.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditAirplaneServlet", urlPatterns = "/EditAirplaneServlet")
public class EditAirplaneServlet extends HttpServlet {

    // for loading info of edit page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aId = Integer.parseInt(request.getParameter("airplane_id"));
        String page = "";
        // Airplane
        AirplaneService as = new AirplaneServiceImpl();
        AirplaneBean airplane = as.getAirplaneById(aId);

        if (airplane != null) {
            page = "/admin/airplane-edit.jsp";
            request.setAttribute("airplane", airplane);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    // for update airplane info
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListAirplaneServlet";

        AirplaneBean airplane = new AirplaneBean(
                Integer.parseInt(request.getParameter("airplane_id")),
                request.getParameter("airplane_name"),
                Integer.parseInt(request.getParameter("seat_first")),
                Integer.parseInt(request.getParameter("seat_business")),
                Integer.parseInt(request.getParameter("seat_economy")));
        AirplaneService as = new AirplaneServiceImpl();

        if (as.updateAirplane(airplane) > 0) {
            // success
            System.out.println("airplane update success");
        } else {
            // failed
            System.out.println("airplane update failed");
        }

        response.sendRedirect(page);
    }

}
