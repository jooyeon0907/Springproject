<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.sql.*" %>  

<jsp:include   page="../inc/header.jsp" />
<!--					 -->
<!--  header.html  -->
 

	<div class="container  spring2_detail">
			<h3>QNA 상세보기</h3>
			<form action="<%=request.getContextPath()%>/board/list" method="get">
				    <input type="hidden"	name="bno"   value="${sboardDto.bno}"	readonly="readonly">				
    				<div class="form-group"  >
					  <span class="glyphicon glyphicon-plus">  조회수</span>
					  <div  class="form-control">${sboardDto.bhit}</div>
					</div>	 
					<div class="form-group"  >
					  <span class="glyphicon glyphicon-plus"><label for="bname">이름</label></span>
					  <input type="text" id="bname"  name="bname" value="${sboardDto.bname}"  readonly="readonly" class="form-control" /> 
					</div>				
					<div  class="form-group"   >
					  <span class="glyphicon glyphicon-plus"> <label for="btitle"> 제목</label></span>
					  <input type="text" id="btitle"  name="btitle" value="${sboardDto.btitle}"  readonly="readonly" class="form-control" /> 
					</div>	
					<div  class="form-group"   >
					  <span class="glyphicon glyphicon-plus"> <label for="bcontent"> 내용</label></span>
					  <textarea  rows="10" cols="60" name="bcontent"  id="bcontent" class="form-control"  readonly="readonly" >${sboardDto.bcontent}</textarea>
					</div>	
						<p><img src="<%=request.getContextPath()%>/upload/${sboardDto.bfile}" alt="${sboardDto.bfile}"></p>
					<div class="row  text-right"    >
						 <a href="<%=request.getContextPath()%>/board/board_modify?bno=${sboardDto.bno}"  class="btn" >수정</a> 
						 <a href="<%=request.getContextPath()%>/board/board_delete?bno=${sboardDto.bno}"  class="btn" >삭제</a> 
						 <a href="<%=request.getContextPath()%>/board/list"   class="btn">목록보기</a>  
					</div>	
		</form>
	</div>

<!--					 -->
<!--  Footer.html  -->
<!--					 -->
<jsp:include   page="../inc/footer.jsp" />
