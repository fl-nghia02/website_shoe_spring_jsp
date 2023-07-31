<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div>
      <form action="/admin/chucvu/modify/${chucVu.id}" method="post">
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Mã chức vụ</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="ma" value="${chucVu.ma}">
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Tên chức vụ</label>
          <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "ten" value="${chucVu.ten}">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>