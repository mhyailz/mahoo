package com.service.impl;

import java.util.List;
import java.util.Map;

import com.dao.ArticleDao;
import com.model.Article;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.soap.Addressing;

public class ArticleServiceImpl implements ArticleService {

    @Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getAllArticleList(int pageNo, int pageSize) {
		return articleDao.getAllArticleList(pageNo, pageSize);
	}
	
	@Override
	public List<Article> getArticleById(Integer id) {
		return articleDao.getArticleById(id);
	}


	@Override
	public void insertArticle(Map<String, Object> insertMap) {
		articleDao.insertArticle(insertMap);
		
	}

    @Override
    public List<String> getArticleMonthList() {
        return articleDao.getArticleMonthList();
    }

    @Override
    public List<Article> findArticleWithPara(Map<String, Object> map) {
        return articleDao.findArticleWithPara(map);
    }

}
