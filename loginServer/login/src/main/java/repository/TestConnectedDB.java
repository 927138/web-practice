package repository;

import common.ConnectDB;
import jakarta.servlet.ServletContext;

public class TestConnectedDB extends ConnectDB {

	public TestConnectedDB(ServletContext application) {
		super(application);
	}
	
	public void insertTest() {
		try {
            // 쿼리문 템플릿 준비
            String query = "select count(*) from tt";
            
            // 쿼리문 준비
            
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            rs.next();

            // 쿼리문 실행
            System.out.println(rs.getInt(1));
        }
        catch (Exception e) {
            System.out.println("게시물 수정 중 예외 발생");
            e.printStackTrace();
        }
	}
	
}
