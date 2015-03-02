package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.dao.ArticleDao;
import com.model.Article;

public class ArticleDaoImpl implements ArticleDao {

    @Autowired
	private SqlMapClientTemplate  sqlMapClientTemplate;

	@Override
	public List<Article> getAllArticleList(Integer pageNo, Integer pageSize) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("start", (pageNo-1) * pageSize);
		map.put("end", pageSize);
		return sqlMapClientTemplate.queryForList("findArticleMessageWithPage", map);
	}

	@Override
	public List<Article> getArticleById(Integer id) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return sqlMapClientTemplate.queryForList("findArticleMessageWithId",map);
	}

	@Override
	public void insertArticle(Map<String, Object> insertMap) {
		sqlMapClientTemplate.insert("insertNewArticle",insertMap);
	}

    @Override
    public List<String> getArticleMonthList() {
        return sqlMapClientTemplate.queryForList("getArticleMonthList");
    }


    @Override
    public List<Article> findArticleWithPara(Map<String, Object> map) {
        return sqlMapClientTemplate.queryForList("findArticleWithPara", map);
    }

}
