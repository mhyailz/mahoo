package com.model;


public class Article {

	/**文章id **/
	private Long id;
	
	/**文章名字 **/
	private String articleName;
	
	/**文章正文**/
	private String articleContent;
	
	/**文章创建时间 **/
	private String articleCreateTime;
	
	/**文章评论id **/
	private Long articleCommentId;
	
	/**文章分类id **/
	private Integer articleSortId;
	
	/**加密id **/
	private String ids;

	/*******************get set ******************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleCreateTime() {
		return articleCreateTime;
	}

	public void setArticleCreateTime(String articleCreateTime) {
		this.articleCreateTime = articleCreateTime;
	}

	public Long getArticleCommentId() {
		return articleCommentId;
	}

	public void setArticleCommentId(Long articleCommentId) {
		this.articleCommentId = articleCommentId;
	}

	public Integer getArticleSortId() {
		return articleSortId;
	}

	public void setArticleSortId(Integer articleSortId) {
		this.articleSortId = articleSortId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
}
