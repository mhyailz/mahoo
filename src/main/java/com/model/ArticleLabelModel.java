package com.model;

import java.io.Serializable;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */
public class ArticleLabelModel implements Serializable {

    /**
     * id
     */
    private int id;

    /**
     * name
     */
    private String labelName;



    /*********get set **********/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
