package com.example.sp25tutorsof203.model;

import java.util.Date;

public class DanhMuc {

    // id trong csdl dang de tu tang => khi ad khong truyen id
    private Integer id;

    private String maDanhMuc;

    private String tenDanhMuc;

    private String trangThai;

    private Date ngayTao;

    private Date ngaySua;

    public DanhMuc() {
    }

    // do id tu tang nen khong tuyen id vao constructor
    public DanhMuc(String maDanhMuc, String tenDanhMuc, String trangThai, Date ngayTao, Date ngaySua) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
}
