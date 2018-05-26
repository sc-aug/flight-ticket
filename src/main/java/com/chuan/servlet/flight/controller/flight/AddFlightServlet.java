package com.chuan.servlet.flight.controller.flight;

import com.chuan.servlet.flight.bean.AirplaneBean;
import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.bean.LocationBean;
import com.chuan.servlet.flight.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "AddFlightServlet", urlPatterns = "/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/admin/flight-add.jsp";

        List<AirplaneBean> al = new AirplaneServiceImpl().getAllAirplanes();
        List<LocationBean> ll = new LocationServiceImpl().getAllLocations();

        if (al != null && ll != null) {
            request.setAttribute("airplaneList", al);
            request.setAttribute("locationList", ll);
        } else {
            System.out.println("fetch data failed. " + (al == null) + " " + (ll == null));
            page = "/admin/admin.jsp";
        }

        request.getRequestDispatcher(page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int airplaneId = Integer.parseInt(request.getParameter("airplane_id"));
        int departureLocId = Integer.parseInt(request.getParameter("departure_loc_id"));
        int arrivalLocId = Integer.parseInt(request.getParameter("arrival_loc_id"));

        int depTimeHour = Integer.parseInt(request.getParameter("dep_time").split(":")[0]);
        int depTimeMin = Integer.parseInt(request.getParameter("dep_time").split(":")[1]);
        int arrTimeHour = Integer.parseInt(request.getParameter("arr_time").split(":")[0]);
        int arrTimeMin = Integer.parseInt(request.getParameter("arr_time").split(":")[1]);
        int dayChange = Integer.parseInt(request.getParameter("day_change"));

        LocalDateTime depT = LocalDateTime.of(2000, 1, 5, depTimeHour, depTimeMin, 0);
        LocalDateTime arrT = LocalDateTime.of(2000, 1, 5 + dayChange, arrTimeHour, arrTimeMin, 0);

        FlightService fs = new FlightServiceImpl();
        int res = fs.addFlight(new FlightBean(-1, depT, arrT,
                departureLocId, arrivalLocId, airplaneId, "", "",""));

        String page = "/ListFlightServlet";
        response.sendRedirect(page);
    }

}
