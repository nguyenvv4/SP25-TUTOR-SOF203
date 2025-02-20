package com.example.sp25tutorsof203.repository;

import com.example.sp25tutorsof203.model.DanhMuc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanhMucRepo {

    public List<DanhMuc> findAll() {

        String sql = "select * from danh_muc";
        List<DanhMuc> list = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setId(rs.getInt("id"));
                danhMuc.setTenDanhMuc(rs.getString("ten_danh_muc"));
                danhMuc.setMaDanhMuc(rs.getString("ma_danh_muc"));
                danhMuc.setTrangThai(rs.getString("trang_thai"));
                danhMuc.setNgaySua(rs.getDate("ngay_sua"));
                danhMuc.setNgayTao(rs.getDate("ngay_tao"));
                list.add(danhMuc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(DanhMuc danhMuc) {
        String sql = "insert into danh_muc(ma_danh_muc, ten_danh_muc, trang_thai, ngay_tao, ngay_sua) " +
                " values (?,?,?,GETDATE(),GETDATE())";
        List<DanhMuc> list = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, danhMuc.getMaDanhMuc());
            ps.setString(2, danhMuc.getTenDanhMuc());
            ps.setString(3, danhMuc.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String sql = "delete from danh_muc where id = ?";
        List<DanhMuc> list = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
