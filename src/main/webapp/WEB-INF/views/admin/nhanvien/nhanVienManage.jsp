<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <div class="mt-4">
         <h1>NHÂN VIÊN</h1>
         <div class="row m-0 p-0 d-flex flex-row-reverse">
            <div class="col-3">
               <a href="/admin/nhanvien/create" class="btn btn-success" role="button">Add</a>
            </div>
         </div>
         <table class="table">
            <thead>
               <tr>
                  <th scope="col">Mã</th>
                  <th scope="col">Tên</th>
                  <th scope="col">Tên đệm</th>
                  <th scope="col">Họ</th>
                  <th scope="col">Giới tính</th>
                  <th scope="col">Ngày sinh</th>
                  <th scope="col">Địa chỉ</th>
                  <th scope="col">Sdt</th>
                  <th scope="col">Mật khẩu</th>
                  <th scope="col">Cửa hàng</th>
                  <th scope="col">Chức vụ</th>
                  <th scope="col">Trang thái</th>
                  <th scope="col" colspan="2">Thao tác</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${listNhanVien}" var="obj">
                  <tr>
                     <td>${obj.ma}</td>
                     <td>${obj.ten}</td>
                     <td>${obj.tenDem}</td>
                     <td>${obj.ho}</td>
                     <td>${obj.gioiTinh == true ? 'Nam' : 'Nữ'}</td>
                     <td>${obj.ngaySinh}</td>
                     <td>${obj.diaChi}</td>
                     <td>${obj.sdt}</td>
                     <td>${obj.matKhau}</td>
                     <td>${obj.cuaHang.ten}</td>
                     <td>${obj.chucVu.ten}</td>
                     <td>${obj.trangThai == true ? 'Có' : 'Không'}</td>
                     <td>
                        <a href="/admin/nhanvien/detail/${obj.id}" class="btn btn-warning" role="button">Detail</a>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>