<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 2/22/25
  Time: 14:25
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
    <input type="text" name="maSanPham"> <br>
    <label>ten san pham</label>
    <input type="text" name="tenSanPham"> <br>
    <label>mo ta</label>
    <input type="text" name="moTa"> <br>
    <label>trang thai</label>
    <input type="radio" name="trangThai" value="hoat dong">hoat dong
    <input type="radio" name="trangThai" value="khong hoat dong">khong hoat dong
    <br>
    <label>Danh muc</label>
    <select name="idDanhMuc" id="">
        <c:forEach var="danhMuc" items="${listDanhMuc}">
        <option value="${danhMuc.id}"
        >${danhMuc.tenDanhMuc}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Add</button>
</form>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>ma san pham</td>
        <td>ten san pham</td>
        <td>mo ta</td>
        <td>ten danh muc</td>
        <td>trang thai</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sp" items="${list}">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.maSanPham}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.moTa}</td>
            <td>${sp.tenDanhMuc}</td>
            <td>${sp.trangThai}</td>
            <td><a href="/san-pham/detail?id=${sp.id}">Detail</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
