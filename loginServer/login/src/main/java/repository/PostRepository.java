package repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DTO.PostDTO;
import utils.MysqlConfigration;

public class PostRepository{
	
	private final MysqlConfigration jdbc;

	public PostRepository(MysqlConfigration jdbc) {
		this.jdbc = jdbc;
	}
	
	public List<PostDTO> selectListPage(){
		List<PostDTO> pageList = new ArrayList<>();
		
		String query = "SELECT * FROM posts ORDER BY idx DESC";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(query);
			jdbc.rs = jdbc.pstmt.executeQuery();
						
			while (jdbc.rs.next()) {
				PostDTO post = PostDTO.builder()
					    .idx(jdbc.rs.getInt(1))
					    .name(jdbc.rs.getString(2))
					    .title(jdbc.rs.getString(3))
					    .content(jdbc.rs.getString(4))
					    .postdate(jdbc.rs.getTimestamp(5).toLocalDateTime()) // LocalDateTime 변환
					    .visitcount(jdbc.rs.getInt(6))
					    .build();
				pageList.add(post);
			}
		} catch (Exception e) {
			System.out.println("PostsRepository.selectListPage() sql exception");
			e.printStackTrace();
		}
		return pageList;
	}
	
	public int writeBoard(PostDTO dto) {
		int result = 0;
		
		String query = ""
				+ "insert into posts(name, title, content) "
				+ "values(?, ?, ?)";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(query);
			jdbc.pstmt.setString(1, dto.getName());
			jdbc.pstmt.setString(2, dto.getTitle());
			jdbc.pstmt.setString(3, dto.getContent());
			
			result = jdbc.pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("PostsRepository.writeBoard() method sql exception");
			e.printStackTrace();
		}
		
		return result;
	}
}
