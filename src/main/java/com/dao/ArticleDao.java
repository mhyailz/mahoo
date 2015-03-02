package com.dao;

import java.util.List;
import java.util.Map;

import com.model.Article;

/**
 * 
 * @author mahongyao 2014.09.03
 *
 */

public interface ArticleDao {
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Article> getAllArticleList(Integer pageNo, Integer pageSize);

	/**
	 * 
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
    public List<Article> findArticleWithPara(Map<String, Object> map);

}
