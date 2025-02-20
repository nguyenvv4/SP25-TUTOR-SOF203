<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 2/20/25
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Day la trang home</p>
<form action="/add" method="post">
    <label>ma danh muc</label>
    <input type="text" name="maDanhMuc"> <br>
    <label>ten danh muc</label>
    <input type="text" name="tenDanhMuc"> <br>
    <label>trang thai</label>
    <input type="radio" name="trangThai" value="hoat dong"> hoat dong
    <input type="radio" name="trangThai" value="khong hoat dong"> khong hoat dong <br>
    <button type="submit">Submit</button>
</form>

<table>
    <tr>
        <td>id</td>
        <td>ma danh muc</td>
        <td>ten danh muc</td>
        <td>trang thai</td>
        <td>ngay tao</td>
        <td>ngay sua</td>
    </tr>
    <tbody>
    <c:forEach var="danhMuc" items="${list}">
        <tr>
            <td>${danhMuc.id}</td>
            <td>${danhMuc.maDanhMuc}</td>
            <td>${danhMuc.tenDanhMuc}</td>
            <td>${danhMuc.trangThai}</td>
            <td>${danhMuc.ngayTao}</td>
            <td>${danhMuc.ngaySua}</td>
            <td>
                <a href="/delete?id=${danhMuc.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
