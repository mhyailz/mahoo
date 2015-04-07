package com.dao;

import com.model.ArticleLabelModel;

import java.util.List;

/**
 * Created by Administrator on 2015/3/1.
 */
public interface ArticleLabelDao {


    /**
     *
     * @return
     */
    public List<ArticleLabelModel> getAllLabels();
}
