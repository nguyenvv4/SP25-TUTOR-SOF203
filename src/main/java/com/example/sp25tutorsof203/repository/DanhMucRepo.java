package com.example.sp25tutorsof203.repository;

import com.example.sp25tutorsof203.model.DanhMuc;
import com.example.sp25tutorsof203.model.SanPham;
import com.example.sp25tutorsof203.model.SanPhamDto;

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

    public List<SanPhamDto> getListSpDto() {
        String sql = "\n" +
                "select sp.id, " +
                "sp.ten_san_pham, " +
                "sp.ma_san_pham, " +
                "sp.mo_ta, " +
                "d.ten_danh_muc, " +
                "sp.trang_thai " +
                "from san_pham sp inner join danh_muc d " +
                "on sp.id_danh_muc = d.id\n";

        List<SanPhamDto> list = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamDto sanPhamDto = new SanPhamDto();
                sanPhamDto.setId(rs.getInt("id"));
                sanPhamDto.setTenSanPham(rs.getString("ten_san_pham"));
                sanPhamDto.setMaSanPham(rs.getString("ma_san_pham"));
                sanPhamDto.setMoTa(rs.getString("mo_ta"));
                sanPhamDto.setTenDanhMuc(rs.getString("ten_danh_muc"));
                sanPhamDto.setTrangThai(rs.getString("trang_thai"));
                list.add(sanPhamDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(SanPham sanPham) {
        String sql = "insert into san_pham (ma_san_pham, ten_san_pham, mo_ta, trang_thai, id_danh_muc)\n" +
                "values (?,?,?,?,?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, sanPham.getMaSanPham());
            ps.setString(2, sanPham.getTenSanPham());
            ps.setString(3, sanPham.getMoTa());
            ps.setString(4, sanPham.getTrangThai());
            ps.setInt(5, sanPham.getIdDanhMuc());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SanPham getSanPhamById(Integer id) {
        String sql = "select * from san_pham where id = ?";
        SanPham sanPham = new SanPham();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPham.setId(rs.getInt("id"));
                sanPham.setTenSanPham(rs.getString("ten_san_pham"));
                sanPham.setMaSanPham(rs.getString("ma_san_pham"));
                sanPham.setMoTa(rs.getString("mo_ta"));
                sanPham.setTrangThai(rs.getString("trang_thai"));
                sanPham.setIdDanhMuc(rs.getInt("id_danh_muc"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return sanPham;
    }
}
