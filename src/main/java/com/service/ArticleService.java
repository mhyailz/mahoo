package com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.model.Article;

public interface ArticleService {

	/**
	 * 获取首页的前五条数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Article> getAllArticleList(int pageNo, int pageSize);

	/**
	 * 通过Id获取文章内容
	 * @param id
	 * @return
	 */
	public List<Article> getArticleById(Integer id);

	/**
	 * 
	 * @param insertMap
	 */
	public void insertArticle(Map<String, Object> insertMap);

    /**
     *
     * @param name
     * @param musicType
     */
    public void insertMusic(String name, int musicType);

    /**
     *
     * @param musicType
     * @return
     */
    public int getMusicTotalCount(int musicType);

    /**
     *
     * @param number
     * @return
     */
    public String getMusicNameByNumber(int number,int musicType);
}
