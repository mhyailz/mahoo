package com.service;

import com.model.ArticleLabelModel;

import java.util.List;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */
public interface ArticleLabelService {

    /**
     * 获取所有的标签
     * @return
     */
    public List<ArticleLabelModel> getAllLabels();


    /**
     * 通过标签ID,查询标签名
     * @param ids
     * @return
     */
    public List<ArticleLabelModel> getLabelsById(List<Integer> ids);
}
