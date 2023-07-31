<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div>
      <form action="/admin/cuahang/modify/${cuaHang.id}" method="post">
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mã</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ma" value="${cuaHang.ma}">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Tên</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "ten" value="${cuaHang.ten}">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Địa chỉ</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "diaChi" value="${cuaHang.diaChi}">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Thành phố</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "thanhPho" value="${cuaHang.thanhPho}">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Quốc gia</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "quocGia" value="${cuaHang.quocGia}">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>