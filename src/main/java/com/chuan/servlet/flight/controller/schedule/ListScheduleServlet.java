package com.chuan.servlet.flight.controller.schedule;

import com.chuan.servlet.flight.bean.ScheduleBean;
import com.chuan.servlet.flight.service.ScheduleService;
import com.chuan.servlet.flight.service.ScheduleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListScheduleServlet", urlPatterns = "/ListScheduleServlet")
public class ListScheduleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        ScheduleService ss = new ScheduleServiceImpl();
        List<ScheduleBean> sl = ss.getAllSchedules();

        if (sl != null) {
            page = "/admin/manage-schedule.jsp";
            request.setAttribute("scheduleList", sl);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
