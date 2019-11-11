<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardReply.jsp</title>
<script>
	function formSubmit(n) {
		if (n == 1)
			frm.action = "boardReplyOk.do";
		else
			frm.action = "boardView.do";

		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 보기</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="" method="post">
				<input type="hidden" id="id" name="id" value="${dto.id }"> <input
					type="hidden" id="group" name="group" value="${dto.group}">
				<input type="hidden" id="step" name="step" value="${dto.step}">
				<input type="hidden" id="indent" name="indent" value="${dto.indent}">
				<div>
					<table border="1">
						<tr align="center">
							<th width="70">작성자</th>
							<td width="70">${dto.name }</td>
							<!-- {boardView.java에 있는 dto  .   BoardDto에있는 값 }-->
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
				<div>
					<br>
					<table border="1">
						<tr align="center">
							<th width="70">답글</th>
							<td colspan="5"><textarea rows="10" cols="70" id="reply"
									name="reply"></textarea></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<button type="button" onclick="formSubmit(1)">저장</button>
					&nbsp;&nbsp;
					<button type="button" onclick="formSubmit(2)">취소</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>