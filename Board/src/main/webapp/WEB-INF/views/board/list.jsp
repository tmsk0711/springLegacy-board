<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <c:import url="header.jsp" charEncoding="UTF-8"/> --%>
<!-- header 시작  --><!-- header 시작 -->
<%@include file="../header.jsp" %>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- header 끝 --><!-- header 끝 -->
<script>
$(function(){
	$('.delete_btn').click(function (){
		var a = confirm('삭제하시겠습니까?');
		
		if(a != true){
			return false;
		}
	})
	
})

</script>


<div class="container">
  <h2>게시판</h2>
             
  <table class="table table-hover">
    <thead>
      <tr class="table-primary">
        <th>No.</th>
        <th>작성자</th>
        <th>제목</th>
        <th>조회수</th>
        <th>작성일</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
      
      <c:forEach var="item" items="${list}">
	      <tr>
	        <td>${item.bNum}</td>
	        <td>${item.userID}</td>
	        <td><a href="/board/detail?bNum=${item.bNum}">${item.bTitle}</a></td>
	        <td>${item.bReadCount}</td>
	        <td>${item.bWriteDate}</td>
	        <td><a href="/board/delete?bNum=${item.bNum}" class="delete_btn"> <i class="material-icons">delete</i></a></td>
	      </tr>
	      
      </c:forEach>
    </tbody>
  </table>
  
  <ul class="pagination justify-content-center">
	  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
	  <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
   
  	<button type="button" class="btn btn-success" onclick="location.href='/board/write?pageNum=${pageNum }'">작성</button>

</div>


<!-- footer 시작 --><!-- footer 시작 -->
<%@include file="../footer.jsp" %>
<!-- footer 끝 --><!-- footer 끝-->
<%-- <c:import url="footer.jsp" charEncoding="UTF-8"/> --%>