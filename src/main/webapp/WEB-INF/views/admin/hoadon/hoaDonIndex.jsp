<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Tên khách hàng</th>
                    <th scope="col">Mã hóa đơn</th>
                    <th scope="col">Ngày tạo</th>
                    <th scope="col">Ngày thanh toán</th>
                    <th scope="col">Ngày ship</th>
                    <th scope="col">Ngày nhận</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">Sdt</th>
                    <th scope="col">Tình trạng</th>
                    <th scope="col">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listHoaDon}" var="obj">
                    <tr>
                        <th>${obj.khachHang.ten}</th>
                        <th>${obj.ma}</th>
                        <td>${obj.ngayTao}</td>
                        <td>${obj.ngayThanhToan}</td>
                        <td>${obj.ngayShip}</td>
                        <td>${obj.ngayNhan}</td>
                        <td>${obj.diaChi}</td>
                        <td>${obj.sdt}</td>
                        <td>
                            <c:choose>
                                <c:when test="${obj.tinhTrang == 0}">
                                    Chờ xác nhận
                                </c:when>
                                <c:when test="${obj.tinhTrang == 1}">
                                    Đã xác nhận
                                </c:when>
                                <c:when test="${obj.tinhTrang == 2}">
                                    Đang giao
                                </c:when>
                                <c:when test="${obj.tinhTrang == 3}">
                                    Giao thành công
                                </c:when>
                            </c:choose>
                        </td>
                        <td>
                            <a href="/admin/hoadon/trangthai/${obj.id}" ${obj.tinhTrang == 3 ? 'hidden' : ''} class="btn ${obj.tinhTrang == 2 ? 'btn-success':'btn-primary'}"
                                role="button">
                                <c:choose>
                                    <c:when test="${obj.tinhTrang == 0}">
                                        Xác nhận
                                    </c:when>
                                    <c:when test="${obj.tinhTrang == 1}">
                                        Giao hàng đi
                                    </c:when>
                                    <c:when test="${obj.tinhTrang == 2}">
                                        Xác nhận thành công
                                    </c:when>
                                </c:choose>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>