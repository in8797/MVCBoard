<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardEdit.jsp</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 수정</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="boardEditOk.do" method="post">
				<input type="hidden" id="id" name="id" value="${dto.id}">
				<table border="1">
					<tr align="center">
						<th width="70">작성자</th>
						<td width="70">${dto.name }</td>
						<!-- {boardEdit.java에 있는 dto  .   BoardDto에있는 값 }-->
						<th width="70">작성일자</th>
						<td width="150">${dto.wDate }</td>
						<th width="70">조회수</th>
						<td width="70">${dto.hit }</td>
					</tr>
					<tr align="center">
						<th>제목</th>
						<td colspan="5"><input type="text" id="title" name="title"
							value="${dto.title }" size="70"></td>
					</tr>
					<tr align="center">
						<th>내용</th>
						<td colspan="5" height="100"><textarea id="contents"
								name="contents" rows="10" cols="70">${dto.contents }</textarea></td>
					</tr>
				</table>
				<br> <input type="submit" value="저장">&nbsp;&nbsp; <input
					type="reset" value="취소">&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardList.do'">목록</button>
			</form>
		</div>
	</div>
</body>
</html>