package com.model;

import java.util.Date;
import java.util.List;


public class Picture {
	
	private int id;
	
	private String picCollectionName;
	
	private String picCollectionDesc;
	
	private Date createTime;
	
	private int categoryId;
	
	private String defaulePic;
	
	private List<String> childrenPicUrl;
	
	
	/**************get set *******************/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicCollectionName() {
		return picCollectionName;
	}

	public void setPicCollectionName(String picCollectionName) {
		this.picCollectionName = picCollectionName;
	}

	public String getPicCollectionDesc() {
		return picCollectionDesc;
	}

	public void setPicCollectionDesc(String picCollectionDesc) {
		this.picCollectionDesc = picCollectionDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDefaulePic() {
		return defaulePic;
	}

	public void setDefaulePic(String defaulePic) {
		this.defaulePic = defaulePic;
	}

	public List<String> getChildrenPicUrl() {
		return childrenPicUrl;
	}

	public void setChildrenPicUrl(List<String> childrenPicUrl) {
		this.childrenPicUrl = childrenPicUrl;
	}

	
}
