package co.micol.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.dto.BoardDto;

public class BoardDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "micol";
	String password = "1234";

	public BoardDao() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 전체 목록 조회
	public ArrayList<BoardDto> select() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		BoardDto dto;
		String sql = "select * from mvc_board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDto();
				dto.setId(rs.getInt("bid"));
				dto.setName(rs.getString("bname"));
				dto.setTitle(rs.getString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
				dto.setGroup(rs.getInt("bgroup"));
				dto.setStep(rs.getInt("bstep"));
				dto.setIndent(rs.getInt("bindent"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}

	// 한건 조회
	public BoardDto select(int id) {
		BoardDto dto = new BoardDto();
		String sql = "select * from mvc_board where bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto.setId(rs.getInt("bid"));
				dto.setName(rs.getString("bname"));
				dto.setTitle(rs.getString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
				dto.setGroup(rs.getInt("bgroup"));
				dto.setStep(rs.getInt("bstep"));
				dto.setIndent(rs.getInt("bindent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return dto;
	}

	// 생성
	public int insert(BoardDto dto) {
		int n = 0;
		String sql = "insert into mvc_board(bid,bname,btitle,bcontent,bdate,bgroup,bstep,bindent) "
				+ "values(b_num.nextval,?,?,?,?,b_num.currval,0,0)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContents());
			psmt.setDate(4, dto.getwDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	// 업데이트(변경)
	public int update(BoardDto dto) {
		int n = 0;
		close();
		return n;
	}

	// 삭제
	public int delete(int id) {
		int n = 0;
		close();
		return n;
	}

	private void close() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
