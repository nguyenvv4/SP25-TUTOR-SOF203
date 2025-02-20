package com.example.sp25tutorsof203.servlet;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.example.sp25tutorsof203.model.DanhMuc;
import com.example.sp25tutorsof203.repository.DanhMucRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HomeServletServlet", value = {"/home",
        "/add",
        "/delete"
})
public class HomeServlet extends HttpServlet {
    DanhMucRepo danhMucRepo = new DanhMucRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/home")) {
            List<DanhMuc> list = danhMucRepo.findAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            danhMucRepo.delete(id);
            response.sendRedirect("/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/add")) {
            String maDanhMuc = request.getParameter("maDanhMuc");
            String tenDanhMuc = request.getParameter("tenDanhMuc");
            String trangThai = request.getParameter("trangThai");
            DanhMuc danhMuc = new DanhMuc(maDanhMuc, tenDanhMuc, trangThai, new Date(), new Date());
            danhMucRepo.add(danhMuc);
            response.sendRedirect("/home");
        }
    }
}