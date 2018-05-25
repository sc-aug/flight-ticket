package com.chuan.servlet.flight.controller.airplane;

import com.chuan.servlet.flight.service.AirplaneService;
import com.chuan.servlet.flight.service.AirplaneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAirplaneServlet", urlPatterns = "/DeleteAirplaneServlet")
public class DeleteAirplaneServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListAirplaneServlet";
        int airplaneId = Integer.parseInt(request.getParameter("airplane_id"));
        AirplaneService as = new AirplaneServiceImpl();

        if (as.deleteAirplaneById(airplaneId) > 0) {
            // success
            System.out.println("airplane delete success");
        } else {
            // failed
            System.out.println("airplane delete failed");
        }
        response.sendRedirect(page);
    }

}
