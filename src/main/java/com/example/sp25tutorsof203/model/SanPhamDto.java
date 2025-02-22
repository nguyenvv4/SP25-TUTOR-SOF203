package com.example.sp25tutorsof203.model;

public class SanPhamDto {

    private Integer id;

    private String maSanPham;

    private String tenSanPham;

    private String moTa;

    private String tenDanhMuc;

    private String trangThai;

    public SanPhamDto() {
    }

    public SanPhamDto(String trangThai, String tenDanhMuc, String moTa, String tenSanPham, String maSanPham, Integer id) {
        this.trangThai = trangThai;
        this.tenDanhMuc = tenDanhMuc;
        this.moTa = moTa;
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
}
