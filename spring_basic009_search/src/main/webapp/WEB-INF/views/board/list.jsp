<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ page session="false"%> 

<jsp:include   page="../inc/header.jsp" />
<!-- Main content -->

<script>
	if( "${insert}" == "ok"){ alert("글쓰기에 성공했습니다.");}
	if( "${update}" == "ok"){ alert("글수정에 성공했습니다.");}
	if( "${delete}" == "ok"){ alert("글삭제에 성공했습니다.");}
</script>


<section class="container"  style="margin-top:10%">
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>BNO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th>HIT</th>
			</tr>
		</thead>
		<tbody>
		<%-- <p><a href="${pageContext.request.contextPath}/board/board_detail?bno=3">test</a></p>
		<p><a href="${pageContext.request.contextPath}/board/board_detail?bno=5">test4</a></p> --%>
 		 <c:forEach items="${list}" var="sboardDto"  varStatus="status" >
			<tr>	
			 	<td>${list.size()-status.index}</td>
			 	<td><a href="${pageContext.request.contextPath}/board/board_detail?bno=${sboardDto.bno}">${sboardDto.btitle}</a></td>
			 	<td>${sboardDto.bname}</td>
			 	<td>${sboardDto.bdate}</td>
			 	<td><span class="badge bg-red">${sboardDto.bhit}</span></td>
			 </tr>
		</c:forEach>  
		</tbody>				
	</table>
	<p class="text-right"><a href='<%=request.getContextPath()%>/board/board_write' class="btn btn-default"> 글쓰기</a></p>
	
	
	<h3 class="panel-heading" style="font-size:90%" >SEARCH</h3>
	<div>
		<input type="search" id="search" name="search" placeholder="검색어를 입력해주세요." class="form-control"/>
		<script>
			$(function(){
				$("#search").on("keyup", function(){
					$("#result tbody").html( ); // $("#search").val()
					if( $("#search").val() =="" ) { $("#search").focus();} 
					else{
						$.ajax({
							url:"${pageContext.request.contextPath}/boardajax/searchBoard",
							type:"get", dataType:"json",
							data:{"search":$("#search").val()},
							success:function( data ){
								console.log(data);
								$("#result tbody").empty();
								$.each( data, function( index, item ){
									console.log('ddddd: ' + item.bno);
									 var tr = $("<tr>");
									 var td1 = $("<td>").html(item.bno);
									 var td2 = $("<td>").html("<a href='${pageContext.request.contextPath}/board/board_detail?bno="+item.bno+"'>"+item.btitle+"</a>");
									 var td3 = $("<td>").html(item.bname);
									 var td4 = $("<td>").html(item.bdate);
									 var td5 = $("<td>").html(item.bhit);
									 tr.append(td1).append(td2).append(td3).append(td4).append(td5);
									 $("#result tbody").append(tr);
								});
							},
							error:function(xhr, textStatus, errorThrown){}
							
						}); //end ajax
						
					}//else 
				});
			});
		
		</script>
	
	</div>
	<table class="table table-striped table-hover" id="result">
		<thead>
			<tr>
				<th>BNO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th>HIT</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	
	
	
	
</section>


<jsp:include   page="../inc/footer.jsp" />
