package controller;


import java.util.Map;

public interface Controller {
	
	default String get(Map<String, Object> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("Controller does not support methods Get");
	}
	default String post(Map<String, Object> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("Controller does not support methods Post");
	}
	default String put(Map<String, Object> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("Controller does not support methods Put");
	}
	default String delete(Map<String, Object> reqParam, Map<String, Object> respParam) {
		throw new UnsupportedOperationException("Controller does not support methods Delete");
	}
	
}
