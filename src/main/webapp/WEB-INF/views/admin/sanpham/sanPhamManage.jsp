<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <div class="mt-4">
         <h1>Sản Phẩm</h1>
         <div class="row m-0 p-0 d-flex flex-row-reverse">
            <div class="col-3">
               <a href="/admin/sanpham/create" class="btn btn-success" role="button">Add</a>
            </div>
         </div>
         <table class="table">
            <thead>
               <tr>
                  <th scope="col">Mã sản pham</th>
                  <th scope="col">Tên sản pham</th>
                  <th scope="col">Nhà sản xuất</th>
                  <th scope="col">Màu sắc</th>
                  <th scope="col">Dòng sản phẩm</th>
                  <th scope="col">Năm bảo hành</th>
                  <th scope="col">Mô tả</th>
                  <th scope="col">Số lượng tồn</th>
                  <th scope="col">Giá nhập</th>
                  <th scope="col">Giá bán</th>
                  <th scope="col" colspan="2">Thao tác</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${listCtsp}" var="obj">
                  <tr>
                     <td>${obj.sanPham.ma}</td>
                     <td>${obj.sanPham.ten}</td>
                     <td>${obj.nsx.ten}</td>
                     <td>${obj.mauSac.ten}</td>
                     <td>${obj.dongSP.ten}</td>
                     <td>${obj.namBH}</td>
                     <td>${obj.moTa}</td>
                     <td>${obj.soLuongTon}</td>
                     <td>${obj.giaNhap}</td>
                     <td>${obj.giaBan}</td>
                     <td>
                        <a href="/admin/sanpham/detail/${obj.id}" class="btn btn-warning" role="button">Detail</a>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>