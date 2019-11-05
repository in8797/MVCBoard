<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 보기</h1>
		</div>
		<div>
			<table border="1">
				<tr align="center">
					<th width="70">작성자</th>
					<td width="70">${dto.name }</td> <!-- {boardView.java에 있는 dto  .   BoardDto에있는 값 }-->
					<th width="70">작성일자</th>
					<td width="150">${dto.wDate }</td>
					<th width="70">조회수</th>
					<td width="70">${dto.hit }</td>
				</tr>
				<tr align="center">
					<th>제목</th>
					<td colspan="5">${dto.title }</td>
				</tr>
				<tr align="center">
					<th>내용</th>
					<td colspan="5" height="100">${dto.contents }</td>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<button type="button" onclick="#">수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="#">삭제</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='boardList.do'">목록</button>
		</div>
	</div>
</body>
</html>