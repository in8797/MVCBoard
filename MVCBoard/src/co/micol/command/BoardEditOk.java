package co.micol.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardEditOk implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update 호출
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		
		int n = dao.update(dto);
		String path;
		if(n != 0 )
			path = "boardView.do";
		else
			path = "view/boardInsertFail.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
