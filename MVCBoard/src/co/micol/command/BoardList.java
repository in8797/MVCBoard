package co.micol.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardList implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao(); //BoardDao 에있는걸땡김
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		list = dao.select();
		
		request.setAttribute("list", list); //(변수명,변수에 담는 값) / 요청객체에 값을 실어놓는다.
		String path = "view/boardList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

}
