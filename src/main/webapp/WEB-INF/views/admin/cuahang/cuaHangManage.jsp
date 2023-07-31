<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <div class="mt-4">
         <h1>CỬA HÀNG</h1>
         <div class="row m-0 p-0 d-flex flex-row-reverse">
            <div class="col-3">
               <a href="/admin/cuahang/create" class="btn btn-success" role="button">Add</a>
            </div>
         </div>
         <table class="table">
            <thead>
               <tr>
                  <th scope="col">Mã</th>
                  <th scope="col">Tên</th>
                  <th scope="col">Địa chỉ</th>
                  <th scope="col">Thành phố</th>
                  <th scope="col">Quốc gia</th>
                  <th scope="col" colspan="2">Thao tác</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${listCuaHang}" var="obj">
                  <tr>
                     <td>${obj.ma}</td>
                     <td>${obj.ten}</td>
                     <td>${obj.diaChi}</td>
                     <td>${obj.thanhPho}</td>
                     <td>${obj.quocGia}</td>
                     <td>
                        <a href="/admin/cuahang/detail/${obj.id}" class="btn btn-warning" role="button">Detail</a>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>