package common;

import java.util.Map;

public interface Controller {
	
	default String get(Map<String, String> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("get method support controller");
	}
	default String post(Map<String, String> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("post method support controller");
	}
	default String put(Map<String, String> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("put method support controller");
	}
	default String delete(Map<String, String> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("delete method support controller");
	}
	
}
