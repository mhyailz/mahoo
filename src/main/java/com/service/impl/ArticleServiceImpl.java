package com.service.impl;

import com.dao.ArticleDao;
import com.model.ArticleModel;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

public class ArticleServiceImpl implements ArticleService {

    @Autowired
	private ArticleDao articleDao;

	public List<ArticleModel> getArticleById(Integer id) {
		return articleDao.getArticleById(id);
	}


	public void insertArticle(Map<String, Object> insertMap) {
		articleDao.insertArticle(insertMap);
		
	}

    public List<String> getArticleMonthList() {
        return articleDao.getArticleMonthList();
    }

    public List<ArticleModel> findArticleWithPara(Map<String, Object> map) {
        return articleDao.findArticleWithPara(map);
    }

}
