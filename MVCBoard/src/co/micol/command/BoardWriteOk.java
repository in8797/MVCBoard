package co.micol.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardWriteOk implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글저장
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		dto.setName(request.getParameter("name")); // (name 값)
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setwDate(Date.valueOf(request.getParameter("date"))); // date가 String 타입이라서 date.valueof
		int n = dao.insert(dto); // dao에 dto값 담음
		String path = null;

		if (n != 0) { // 성공시
			path = "boardList.do"; // 목록보여줌
//			response.sendRedirect(path);
		} else { // 실패시
			path = "view/boardInsertFail.jsp"; // 실패 페이지
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//			dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
//		location.href는 요청 할때마다 만들어줌 , <jsp:forword>,request.sendRedirect는 ?
	}

}
