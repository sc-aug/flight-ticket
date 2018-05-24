package com.chuan.servlet.flight.controller.seat;

import com.chuan.servlet.flight.bean.SeatTypeBean;
import com.chuan.servlet.flight.service.SeatTypeService;
import com.chuan.servlet.flight.service.SeatTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ListSeatTypeServlet")
public class ListSeatTypeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        SeatTypeService sts = new SeatTypeServiceImpl();
        List<SeatTypeBean> stl = sts.getAllSeatTypes();

        if (stl != null && stl.size() != 0) {
            page = "/admin/manage-seat.jsp";
            request.setAttribute("seatTypeList", stl);
        } else {
            System.out.println("Empty");
            page = "/admin/admin.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
