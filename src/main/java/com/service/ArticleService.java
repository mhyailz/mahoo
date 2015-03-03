package com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.model.Article;

public interface ArticleService {

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
     * @return
     */
    public List<String> getArticleMonthList();

    /**
     *
     * @param map
     * @return
     */
    public  List<Article> findArticleWithPara(Map<String, Object> map);
}
