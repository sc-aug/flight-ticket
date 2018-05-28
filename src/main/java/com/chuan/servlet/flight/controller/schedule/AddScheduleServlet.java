package com.chuan.servlet.flight.controller.schedule;

import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.bean.ScheduleBean;
import com.chuan.servlet.flight.service.FlightServiceImpl;
import com.chuan.servlet.flight.service.ScheduleService;
import com.chuan.servlet.flight.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "AddScheduleServlet", urlPatterns = "/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/admin/schedule-add.jsp";
        List<FlightBean> fl = new FlightServiceImpl().getAllFlights();
        if (fl != null) {
            request.setAttribute("flightList", fl);
        } else {
            System.out.println("fetch data failed. " + (fl == null) );
            page = "/admin/admin.jsp";
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/ListScheduleServlet";

        Integer fId = Integer.parseInt(request.getParameter("flight_id"));
        String dTimeStr = request.getParameter("departure_time");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dTime = LocalDateTime.parse(dTimeStr, formatter);

//        System.out.println(dTime);

        ScheduleBean airplane = new ScheduleBean(-1, fId, 0, dTime);
        ScheduleService ss = new ScheduleServiceImpl();

        if (ss.addSchedule(airplane) > 0) {
            // success
            System.out.println("schedule add success");
        } else {
            // failed
            System.out.println("schedule add failed");
        }

        response.sendRedirect(page);
    }

}
