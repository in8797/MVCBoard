package co.micol.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.command.BoardDelete;
import co.micol.command.BoardEdit;
import co.micol.command.BoardEditOk;
import co.micol.command.BoardList;
import co.micol.command.BoardReply;
import co.micol.command.BoardView;
import co.micol.command.BoardWrite;
import co.micol.command.BoardWriteOk;
import co.micol.command.Command;
import co.micol.command.MainCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HashMap<String, Command> list = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Command>();
		list.put("/index.do", new MainCommand());// url에서 index.do로 오면 MainCOmmand를 실행 / command만들고 controller추가?
		list.put("/boardList.do", new BoardList()); // 글 목록
		list.put("/boardEdit.do", new BoardEdit()); // 글변경
		list.put("/boardWrite.do", new BoardWrite()); // 글쓰기
		list.put("/boardWriteOk.do", new BoardWriteOk()); // 글저장
		list.put("/boardView.do", new BoardView()); // 게시글 보기
		list.put("/boardEditOk.do", new BoardEditOk()); // 글 수정 저장
		list.put("/boardDelete.do", new BoardDelete()); // 글 삭제
		list.put("/boardReply.do", new BoardReply()); // 댓글 작성
//		list.put("/boardReplyOk.do", new BoardReplyOk());
		// K V
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		String context = request.getContextPath();
		String path = url.substring(context.length()); // context의 길이 ex)MVCBoard 8이면 9번째부터(다음부터)
		Command subcommand = list.get(path);
		subcommand.excute(request, response);
	}

}
