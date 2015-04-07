package com.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/3/1.
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
