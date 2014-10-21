package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.dao.BackendPicManagerDao;
import com.model.Category;
import com.model.Picture;

public class BackendPicManagerDaoImpl implements BackendPicManagerDao {

	private SqlMapClientTemplate  sqlMapClientTemplate = null;
	
	@Override
	public List<Category> getCategoryList(Long parentId) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("parentId", parentId);
		
		return sqlMapClientTemplate.queryForList("getCategoryListByParentId",map);
		
	}

	@Override
	public Long addCategory(Long parentId, String addCategoryName) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("parentId", parentId);
		map.put("addCategoryName", addCategoryName);
		
		return (Long) sqlMapClientTemplate.insert("addCategory",map);
	}
	
	/****************get set*******************/
	
	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",categoryId);
		sqlMapClientTemplate.update("deleteCategory",map);
		
	}

	@Override
	public void editCategory(Long categoryId, String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",categoryId);
		map.put("name",name);
		sqlMapClientTemplate.update("editCategory",map);
		
	}

	@Override
	public Long insertNewPic(String pictureCollectionName,
			String pictureCollectionDes, Long categoryId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pictureCollectionName", pictureCollectionName);
		map.put("pictureCollectionDes", pictureCollectionDes);
		map.put("categoryId", categoryId);
		return (Long) sqlMapClientTemplate.insert("insertNewPic",map);
		
	}

	@Override
	public void insertPicUrl(Long id, String pic) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pictureCollectionId", id);
		map.put("picUrl", pic);
		sqlMapClientTemplate.insert("insertPicUrl",map);
	}

	@Override
	public List<Picture> getPictureListByCategoryId(Long categoryId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("categoryId", categoryId);
		return sqlMapClientTemplate.queryForList("getPictureListByCategoryId",map);
	}

	@Override
	public List<String> getPictureListByPicCollectionId(Long picCollectionId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("picCollectionId", picCollectionId);
		return sqlMapClientTemplate.queryForList("getPictureListByPicCollectionId",map);
	}

	@Override
	public Picture getPictureByPicCollectionId(Long picCollectionId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("picCollectionId", picCollectionId);
		return (Picture) sqlMapClientTemplate.queryForObject("getPictureByPicCollectionId",map);
	}
	


	

}
