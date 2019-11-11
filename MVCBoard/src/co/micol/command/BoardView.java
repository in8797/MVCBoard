package co.micol.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardView implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		BoardDao dao = new BoardDao();
		int id = Integer.parseInt(request.getParameter("id"));
		list = dao.select(id);
		int size = list.size();
		
		request.setAttribute("list", list);
		request.setAttribute("size", size);
		String path="view/boardView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
		
	}

}
