package com.service.impl;

import java.util.List;
import java.util.Map;

import com.dao.ArticleDao;
import com.model.Article;
import com.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	
	
	@Override
	public List<Article> getAllArticleList(int pageNo, int pageSize) {
		return articleDao.getAllArticleList(pageNo, pageSize);
	}
	
	@Override
	public List<Article> getArticleById(Integer id) {
		return articleDao.getArticleById(id);
	}
	
	
	/********************get set ********************/
	
	public ArticleDao getArticleDao() {
		return articleDao;
	}
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void insertArticle(Map<String, Object> insertMap) {
		articleDao.insertArticle(insertMap);
		
	}

    @Override
    public void insertMusic(String name, int musicType) {
        articleDao.insertMusic(name,musicType);
    }

    @Override
    public int getMusicTotalCount(int musicType) {
        return 0;
    }

}
