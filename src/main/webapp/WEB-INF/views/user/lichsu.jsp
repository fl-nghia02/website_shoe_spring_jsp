<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Chọn</th>
                    <th scope="col">Mã sản phẩm</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Đơn giá</th>
                    <th scope="col">Đơn giá khi giảm</th>
                    <th scope="col">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listGhct}" var="obj">
                    <tr>
                        <th><input type="checkbox" name="choiceToOrder" value="${obj.id.chiTietSanPham.sanPham.ma}">
                        </th>
                        <th>${obj.id.chiTietSanPham.sanPham.ma}</th>
                        <th>${obj.id.chiTietSanPham.sanPham.ten}</th>
                        <td>${obj.soLuong}</td>
                        <td>${obj.donGia}</td>
                        <td>${obj.donGiaKhiGiam}</td>
                        <td><a href="/webstore/giohang/xoa/${obj.id.chiTietSanPham.id}" class="btn btn-warning"
                                role="button">Xóa</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>