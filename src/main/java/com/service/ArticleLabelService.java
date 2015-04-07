package com.service;

import com.model.ArticleLabelModel;

import java.util.List;

/**
 * Created by Administrator on 2015/3/1.
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
