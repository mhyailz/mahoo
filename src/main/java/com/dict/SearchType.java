package com.dict;

/**
 * Created by Administrator on 2015/3/2.
 */
public enum SearchType {

    monthPara(0,"monthType"),  // 通过月份查询

    keyWords(1,"keyWordsType"), //通过查询输入框

    articleLabel(2,"articleLabel"); // 通过标签


    /**
     * 类型ID
     */
    private int typeId;

    /**
     * 类型value
     */
    private String typeValue;



    SearchType(int typeId,String typeValue) {
        this.typeId    = typeId;
        this.typeValue = typeValue;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
}
