<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div>
      <h4>Tạo mới nhân viên</h4>
      <form action="/admin/nhanvien/save" method="post">
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

        <!-- radio button gioi tinh -->
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1" checked value="1">
          <label class="form-check-label" for="flexRadioDefault1">
            Nam
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" value="0">
          <label class="form-check-label" for="flexRadioDefault2">
            Nữ
          </label>
        </div>

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
          <input type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
            name="matKhau">
        </div>

        <div>
          <label for="exampleInputEmail1" class="form-label">Cửa hàng</label>
          <select class="form-select" aria-label="Default select example" name="idCuaHang">
            <c:forEach items="${listCuaHang}" var="obj">
              <option value="${obj.id}">${obj.ten}</option>
            </c:forEach>
          </select>
        </div>

        <div>
          <label for="exampleInputEmail1" class="form-label">Chức vụ</label>
          <select class="form-select" aria-label="Default select example" name="idChucVu">
            <c:forEach items="${listChucVu}" var="obj">
              <option value="${obj.id}">${obj.ten}</option>
            </c:forEach>
          </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>