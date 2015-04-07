package com.service;

import com.model.ArticleModel;

import java.util.List;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */
public interface ArticleService {

	/**
	 * 通过Id获取文章内容
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
    public  List<ArticleModel> findArticleWithPara(Map<String, Object> map);
}
