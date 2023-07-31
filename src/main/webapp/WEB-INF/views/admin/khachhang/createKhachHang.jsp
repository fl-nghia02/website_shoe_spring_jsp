<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div>
      <h4>Tạo mới khách hàng</h4>
      <form action="/admin/khachhang/save" method="post">
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mã</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ma">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Tên</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ten">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Tên đệm</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="tenDem">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Họ</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ho">
        </div>

        <label for="startDate">Ngày sinh</label>
        <input id="startDate" class="form-control" type="date" name="ngaySinh" />

        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Địa chỉ</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="diaChi">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Sdt</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="sdt">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mật khẩu</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
            name="matKhau">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Thành phố</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
            name="thanhPho">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Quốc gia</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
            name="quocGia">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>