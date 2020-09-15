<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include   page="../inc/header.jsp" />
<!--					 -->
<!--  header.html  -->

<%-- 
	#todo1. 빈칸검사
	#todo2. 빈칸검사 완료시 board_insert.jsp로 파일 넘기기 
--%>

	<div class="container">
			<h3>QNA 등록</h3>
			<form action="<%=request.getContextPath()%>/board/board_write" method="post" enctype="multipart/form-data">
				<div class="form-group">
				  <label for="bname"  >이름</label>
				  <input type="text"   name="bname"   id="bname"   class="form-control" > 
				</div>	
				<div class="form-group">
				  <label for="bpass"  >비밀번호</label>
				  <input type="password"   name="bpass"   id="bpasss"   class="form-control" > 
				</div>																			
				<div class="form-group">
				  <label for="btitle"  >제목</label>
				  <input type="text"   name="btitle"   id="btitle"   class="form-control" > 
				</div>					
				<div class="form-group">
				  <label for="bcontent"  >내용</label>
				  <textarea name="bcontent"  cols="60"  rows="10"   class="form-control" ></textarea>
				</div>	
			 	<div class="form-group">
					<label for="file">파일업로드</label>
					<input type="file" name="file" id="file" class="form-control"/>
				</div> 
				<div class="form-group  text-right">
						 <input type="submit"   value="입력"  class="btn"    >  
						 <input type="reset"   onclick="history.go(-1);"    value="취소"  class="btn"    >  
						 <a href="<%=request.getContextPath()%>/board/list"   class="btn"   >목록보기</a>
				</div>	
				
			</form>
</div>
<!--					 -->
<!--  Footer.html  -->
<!--					 -->
<jsp:include   page="../inc/footer.jsp" />
