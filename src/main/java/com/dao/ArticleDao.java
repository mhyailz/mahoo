package com.dao;

import com.model.ArticleModel;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author mahongyao 2014.09.03
 *
 */

public interface ArticleDao {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<ArticleModel> getArticleById(Integer id);

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
    public List<ArticleModel> findArticleWithPara(Map<String, Object> map);

}
