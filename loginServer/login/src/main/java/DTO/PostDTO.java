package DTO;

import java.time.LocalDateTime;
import java.util.Date;

public class PostDTO {
	private int idx;
	private String name;
	private String title;
	private String content;
	private LocalDateTime postDate;
	private int visitCount;
	
	private PostDTO(Builder builder) {
		this.idx = builder.idx;
		this.name = builder.name;
		this.title = builder.title;
		this.content = builder.content;
		this.postDate = builder.postDate;
		this.visitCount = builder.visitCount;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	public static class Builder {
		private int idx;
		private String name;
		private String title;
		private String content;
		private LocalDateTime postDate;
		private int visitCount;
		
		public Builder idx(int idx) { this.idx = idx; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder content(String content) { this.content = content; return this; }
        public Builder postdate(LocalDateTime postDate) { this.postDate = postDate; return this; }
        public Builder visitcount(int visitCount) { this.visitCount = visitCount; return this; }
        
        public PostDTO build() {
        	return new PostDTO(this);
        }
	}
	
	public int getIdx() {
		return idx;
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
	public LocalDateTime getPostdate() {
		return postDate;
	}
	public int getVisitcount() {
		return visitCount;
	}
	
	
	
}
