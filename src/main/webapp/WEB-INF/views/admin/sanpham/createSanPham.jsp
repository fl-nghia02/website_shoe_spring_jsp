<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div>
      <form action="/admin/sanpham/save" method="post">
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mã san pham</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ma">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Tên san pham</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "ten">
        </div>  

        <div>
          <label for="exampleInputEmail1" class="form-label">Nhà sản xuất</label>
          <select class="form-select" aria-label="Default select example" name="idNsx">
            <c:forEach items="${listNsx}" var="obj">
              <option value="${obj.id}">${obj.ten}</option>
            </c:forEach>
          </select>
        </div>
        
        <div>
          <label for="exampleInputEmail1" class="form-label">Màu sắc</label>
          <select class="form-select" aria-label="Default select example" name="idMauSac">
            <c:forEach items="${listMauSac}" var="obj">
              <option value="${obj.id}">${obj.ten}</option>
            </c:forEach>
          </select>
        </div>
        
        <div>
          <label for="exampleInputEmail1" class="form-label">Dòng sản phẩm</label>
          <select class="form-select" aria-label="Default select example" name="idDongSp">
            <c:forEach items="${listDongSp}" var="obj">
              <option value="${obj.id}">${obj.ten}</option>
            </c:forEach>
          </select>
        </div>

        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Năm bảo hành</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "namBH">
        </div> 
        
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mô tả</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "moTa">
        </div> 
        
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Số lượng tồn</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "soLuongTon">
        </div> 
        
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Giá nhập</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "giaNhap">
        </div> 
        
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Giá bán</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "giaBan">
        </div> 
        
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>