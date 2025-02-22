package com.example.sp25tutorsof203.servlet;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.example.sp25tutorsof203.model.DanhMuc;
import com.example.sp25tutorsof203.model.SanPham;
import com.example.sp25tutorsof203.model.SanPhamDto;
import com.example.sp25tutorsof203.repository.DanhMucRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HomeServletServlet", value = {"/home",
        "/add",
        "/delete",
        "/san-pham/home",
        "/san-pham/add",
        "/san-pham/detail",

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
        } else if (uri.contains("/san-pham/home")) {
            List<DanhMuc> listDanhMuc = danhMucRepo.findAll();
            request.setAttribute("listDanhMuc", listDanhMuc);
            List<SanPhamDto> list = danhMucRepo.getListSpDto();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        } else if (uri.contains("/san-pham/detail")) {
            List<DanhMuc> listDanhMuc = danhMucRepo.findAll();
            request.setAttribute("listDanhMuc", listDanhMuc);
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sanPham = danhMucRepo.getSanPhamById(id);
            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
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
        } else if (uri.equals("/san-pham/add")) {
            String maSanPham = request.getParameter("maSanPham");
            String tenSanPham = request.getParameter("tenSanPham");
            String trangThai = request.getParameter("trangThai");
            String moTa = request.getParameter("moTa");
            String idDanhMuc = request.getParameter("idDanhMuc");
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham(maSanPham);
            sanPham.setTenSanPham(tenSanPham);
            sanPham.setTrangThai(trangThai);
            sanPham.setMoTa(moTa);
            sanPham.setIdDanhMuc(Integer.parseInt(idDanhMuc));
            danhMucRepo.add(sanPham);
            response.sendRedirect("/san-pham/home");
        }

    }
}