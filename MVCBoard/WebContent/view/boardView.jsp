<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function formSubmit(n) {
		if (n == 1)
			frm.action = "boardEdit.do";
		else if (n == 2)
			frm.action = "boardDelete.do";
		else if (n == 3)
			frm.action = "boardReply.do";
		else
			frm.action = "boardList.do";
		frm.submit();

	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 보기</h1>
		</div>
		<form id="frm" name="frm" action="" method="post">
			<c:forEach var="i" begin="1" end="${size-1 }">
				<c:if test="${i==0 }">
					<input type="hidden" id="id" name="id" value="${list[i].id }">
					<div>
						<table border="1">
							<tr align="center">
								<th width="70">작성자</th>
								<td width="70">${list[i].name }</td>
								<!-- {boardView.java에 있는 dto  .   BoardDto에있는 값 }-->
								<th width="70">작성일자</th>
								<td width="150">${list[i].wDate }</td>
								<th width="70">조회수</th>
								<td width="70">${list[i].hit }</td>
							</tr>
							<tr align="center">
								<th>제목</th>
								<td colspan="5">${list[i].title }</td>
							</tr>
							<tr align="center">
								<th>내용</th>
								<td colspan="5" height="100">${list[i].contents }</td>
							</tr>
						</table>
					</div>
				</c:if>



				<c:if test="${i!=0 }">
					<div>
						<table border="1">
							<tr>
								<th width="70">답글[${i }]</th>
								<td colspan="5" height="100">${list[i].contents }</td>
							</tr>
						</table>
					</div>
				</c:if>
			</c:forEach>
			<br>
			<div>
				<button type="button" onclick="formSubmit(1)">수정</button>
				&nbsp;&nbsp;
				<button type="button" onclick="formSubmit(2)">삭제</button>
				&nbsp;&nbsp;
				<button type="button" onclick="formSubmit(3)">댓글</button>
				&nbsp;&nbsp;
				<button type="button" onclick="formSubmit(4)">목록</button>
			</div>
		</form>
	</div>
</body>
</html>