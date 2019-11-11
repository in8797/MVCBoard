<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardlist.jsp</title>
<script>
function transData(n) {
	frm.id.value=n;
	frm.submit();
}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 목록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="boardView.do" method="post">
				<input type="hidden" name="id" value="${dto.id}">
				<table border="1">
					<tr align="center">
						<th width="50">순번</th>
						<th width="70">작성자</th>
						<th width="100">제목</th>
						<th width="200">작성일자</th>
						<th width="70">조회수</th>
					</tr>
					<c:forEach var="dto" items="${list }">
						<!-- dto라는 이름으로 list를 읽음  request의 변수값-->
						<tr align="center"
							onmouseover="this.style.backgroundColor='#ffff99'"
							onmouseout="this.style.backgroundColor=''"
							onclick="transData(${dto.id })">
							<td>${dto.id }</td>
							<td>${dto.name }</td>
							<td>${dto.title }</td>
							<td>${dto.wDate }</td>
							<td>${dto.hit }</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<div>
			<br>
			<button type="button" onclick="location.href='boardWrite.do'">글쓰기</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='index.do'">홈으로</button>
		</div>
	</div>
</body>
</html>