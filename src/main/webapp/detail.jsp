<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 2/22/25
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/san-pham/add" method="post">
    <label>ma san pham</label>
    <input type="text" name="maSanPham" value="${sanPham.maSanPham}"> <br>
    <label>ten san pham</label>
    <input type="text" name="tenSanPham" value="${sanPham.tenSanPham}"> <br>
    <label>mo ta</label>
    <input type="text" name="moTa" value="${sanPham.moTa}"> <br>
    <label>trang thai</label>
    <input type="radio" name="trangThai" value="hoat dong" ${sanPham.trangThai == 'hoat dong' ? 'checked': ''}>hoat dong
    <input type="radio" name="trangThai"
           value="khong hoat dong"  ${sanPham.trangThai == 'khong hoat dong' ? 'checked': ''}>khong hoat dong
    <br>
    <label>Danh muc</label>
    <select name="idDanhMuc" id="">
        <c:forEach var="danhMuc" items="${listDanhMuc}">
            <option value="${danhMuc.id}"
                ${danhMuc.id == sanPham.idDanhMuc ? 'selected': ''}
            >${danhMuc.tenDanhMuc}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
