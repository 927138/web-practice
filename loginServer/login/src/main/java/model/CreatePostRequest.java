package model;

public class CreatePostRequest {
	private final String name;
	private final String title;
	private final String content;
	
	private CreatePostRequest(Builder builder) {
		this.name = builder.name;
		this.title = builder.title;
		this.content = builder.content;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private String name;
		private String title;
		private String content;
		
		public Builder name(String name) {this.name = name; return this;}
		public Builder title(String title) {this.title = title; return this;}
		public Builder content(String content) {this.content = content; return this;}
		
		public CreatePostRequest build() {
			return new CreatePostRequest(this);
		}
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	
}
