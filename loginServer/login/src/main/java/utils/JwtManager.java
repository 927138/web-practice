package utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtManager {

	private final String securityKey = "testToken";
	private final Long expiredTime = 1000 * 60L;  // 3 min
	
	public String generateJwtToken() {
		Date now = new Date();
		
		return Jwts.builder()
				.setHeader(createHeader())
				.setClaims(createClaims())
				.setExpiration(new Date(now.getTime() + expiredTime))
				.signWith(SignatureAlgorithm.HS256, securityKey)
				.compact();
	}
	
	private Map<String, Object> createHeader(){
		Map<String, Object> header = new HashMap<>();
		header.put("typ", "JWT");
		header.put("alg", "HS256"); // 해시 256 사용하여 암호화
		header.put("regDate", System.currentTimeMillis());
		return header;
	}
	
	 private Map<String, Object> createClaims() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("test", "success");
		return claims;
	 }
	 
	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
	}
	
	public String getTestValueToGetTest(String token){
		return getClaims(token).get("test", String.class);
	}
	
			
}
