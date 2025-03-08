package common;

import java.util.Map;

public interface Controller {
	
	default String get(Map<String, String> getParam, Map<String, Object> setParam) {
		throw new UnsupportedOperationException("get method support controller");
	}
	default String post(Map<String, String> getParam, Map<String, Object> setParam) {
		throw new UnsupportedOperationException("post method support controller");
	}
	default String put(Map<String, String> getParam, Map<String, Object> setParam) {
		throw new UnsupportedOperationException("put method support controller");
	}
	default String delete(Map<String, String> getParam, Map<String, Object> setParam) {
		throw new UnsupportedOperationException("delete method support controller");
	}
	
}
