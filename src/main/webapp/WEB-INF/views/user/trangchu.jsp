<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
        <div class="row">
            <c:forEach items="${listCtsp}" var="obj">
                <div class="card mt-5 mx-4 me-3" style="width: 18rem;">
                    <img src="https://cookbeo.com/media/2021/03/bun-ca/bun-ca-1920x1080.jpg" class="card-img-top"
                        alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${obj.sanPham.ten}</h5>
                        <p class="card-text" style="color: rgb(239, 130, 34); font-weight: bold;">${obj.giaBan}-VND</p>
                        <p class="card-text">Nhà sản xuất: ${obj.nsx.ten}.</p>
                        <a href="/webstore/giohang/them/${obj.id}" class="btn btn-success">Add to cart</a>
                        <a href="#" class="btn btn-primary">Mua</a>
                    </div>
                </div>
            </c:forEach>
        </div>