package com.dao.impl;

import com.dao.ArticleLabelDao;
import com.model.ArticleLabelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * Created by Administrator on 2015/3/1.
 */
public class ArticleLabelDaoImpl implements ArticleLabelDao{

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public List<ArticleLabelModel> getAllLabels() {
        return sqlMapClientTemplate.queryForList("getAllLabels");
    }

}
