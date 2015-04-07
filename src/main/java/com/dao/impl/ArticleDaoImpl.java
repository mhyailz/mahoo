package com.dao.impl;

import com.dao.ArticleDao;
import com.model.ArticleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

public class ArticleDaoImpl implements ArticleDao {

    @Autowired
	private SqlMapClientTemplate  sqlMapClientTemplate;


	@Override
	public List<ArticleModel> getArticleById(Integer id) {
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
    public List<ArticleModel> findArticleWithPara(Map<String, Object> map) {
        return sqlMapClientTemplate.queryForList("findArticleWithPara", map);
    }

}
