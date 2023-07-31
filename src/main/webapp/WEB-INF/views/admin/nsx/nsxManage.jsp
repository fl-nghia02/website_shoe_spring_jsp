<%@ include file="/WEB-INF/commom/taglib/taglib.jsp" %>
   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <div class="mt-4">
      <h1>CHỨC VỤ</h1>
         <div class="row m-0 p-0 d-flex flex-row-reverse">
            <div class="col-3">
               <a href="/admin/nsx/create" class="btn btn-success" role="button">Add</a>
            </div>
         </div>
         <table class="table">
            <thead>
               <tr>
                  <th scope="col">Mã nsx</th>
                  <th scope="col">Tên nsx</th>
                  <th scope="col" colspan="2">Thao tác</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${listNsx}" var="obj">
                  <tr>
                     <td>${obj.ma}</td>
                     <td>${obj.ten}</td>
                     <td>
                        <a href="/admin/nsx/detail/${obj.id}" class="btn btn-warning" role="button">Detail</a>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>