<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div>
      <form action="/admin/sanpham/modify/${ctsp.id}" method="post">
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mã san pham</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ma"
            value="${ctsp.sanPham.ma}">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Tên san pham</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ten"
            value="${ctsp.sanPham.ten}">
        </div>

        <div>
          <label for="exampleInputEmail1" class="form-label">Nhà sản xuất</label>
          <select class="form-select" aria-label="Default select example" name="idNsx">
            <c:forEach items="${listNsx}" var="obj">
              <option value="${obj.id}" ${obj.id == ctsp.nsx.id ? 'selected="selected"':''}>${obj.ten}</option>
            </c:forEach>
          </select>
        </div>

        <div>
          <label for="exampleInputEmail1" class="form-label">Màu sắc</label>
          <select class="form-select" aria-label="Default select example" name="idMauSac">
            <c:forEach items="${listMauSac}" var="obj">
              <option value="${obj.id}" ${obj.id == ctsp.mauSac.id ? 'selected="selected"':''}>${obj.ten}</option>
            </c:forEach>
          </select>
        </div>

        <div>
          <label for="exampleInputEmail1" class="form-label">Dòng sản phẩm</label>
          <select class="form-select" aria-label="Default select example" name="idDongSp">
            <c:forEach items="${listDongSp}" var="obj">
              <option value="${obj.id}" ${obj.id == ctsp.dongSP.id ? 'selected="selected"':''}>${obj.ten}</option>
            </c:forEach>
          </select>
        </div>

        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Năm bảo hành</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="namBH"
            value="${ctsp.namBH}">
        </div>

        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mô tả</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="moTa"
            value="${ctsp.moTa}">
        </div>

        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Số lượng tồn</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="soLuongTon"
            value="${ctsp.soLuongTon}">
        </div>

        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Giá nhập</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="giaNhap"
            value="${ctsp.giaNhap}">
        </div>

        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Giá bán</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="giaBan"
            value="${ctsp.giaBan}">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </div>