package com.service.impl;

import com.dao.ArticleLabelDao;
import com.model.ArticleLabelModel;
import com.service.ArticleLabelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2015/3/1.
 */
public class ArticleLabelServiceImpl implements ArticleLabelService {


    @Autowired
    private ArticleLabelDao articleLabelDao;

    @Override
    public List<ArticleLabelModel> getAllLabels() {
        return articleLabelDao.getAllLabels();
    }

    @Override
    public List<ArticleLabelModel> getLabelsById(List<Integer> ids) {
        //TODO
        return null;
    }

}
