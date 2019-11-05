<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardForm.jsp</title>
<script>
	function formCheck() {
		if (frm.name.value == "") {
			alert("작성자를 입력하세요.");
			frm.name.focus();
			return false;
		}
		if (frm.title.value == "") {
			alert("제목을 입력하세요.");
			frm.title.focus();
			return false;
		}
		if (frm.contents.value == "") {
			alert("내용을 입력하세요.")
			frm.contents.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 작성</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="boardWriteOk.do" method="post"
				onsubmit="return formCheck()">
				<!--★버튼 type이 submit가 있는경우★-->
				<div>
					<table border="1">
						<tr>
							<th align="center" width="70">작성자</th>
							<td><input type="text" id="name" name="name" size="25"></td>
							<th align="center">작성일자</th>
							<td><input type="date" id="date" name="date" size="25"></td>
						</tr>
						<tr>
							<th align="center">제목</th>
							<td colspan="3"><input type="text" id="title" name="title"
								size="70"></td>
						</tr>
						<tr>
							<th align="center">내용</th>
							<td colspan="3"><textarea name="contents" rows="10"
									cols="70"></textarea></td>
						</tr>
					</table>
				</div>
				<div>
					<button type="submit">등록</button>
					&nbsp;&nbsp;
					<button type="reset">취소</button>
					&nbsp;&nbsp;
					<button type="button" onclick="location.href='boardList.do'">목록보기</button>
				</div>
			</form>
		</div>
		<script>
			document.getElementById('date').value = new Date().toISOString()
					.substring(0, 10);
		</script>
	</div>
</body>
</html>