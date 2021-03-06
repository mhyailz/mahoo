package com.dict;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */
public enum SearchTypeEnum {

  monthPara(0, "monthType"),  // 通过月份查询

  keyWords(1, "keyWordsType"), //通过查询输入框

  articleLabel(2, "articleLabel"); // 通过标签


  /**
   * 类型ID
   */
  private int typeId;

  /**
   * 类型value
   */
  private String typeValue;


  SearchTypeEnum(int typeId, String typeValue) {
    this.typeId = typeId;
    this.typeValue = typeValue;
  }

  public int getTypeId() {
    return typeId;
  }

  public String getTypeValue() {
    return typeValue;
  }

}
