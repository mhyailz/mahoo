package com.dao;

import com.model.ArticleLabelModel;

import java.util.List;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */
public interface ArticleLabelDao {


    /**
     *
     * @return
     */
    public List<ArticleLabelModel> getAllLabels();
}
