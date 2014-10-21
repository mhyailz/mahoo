package com.service.impl;

import java.util.List;

import com.dao.BackendPicManagerDao;
import com.model.Category;
import com.model.Picture;
import com.service.BackendPicManagerService;

public class BackendPicManagerServiceImpl implements BackendPicManagerService {
	
	private BackendPicManagerDao backendPicManagerDao;

	@Override
	public List<Category> getCategoryList(Long parentId) {
		return backendPicManagerDao.getCategoryList(parentId);
	}

	
	
	/***************get set ********************/
	
	
	public BackendPicManagerDao getBackendPicManagerDao() {
		return backendPicManagerDao;
	}

	public void setBackendPicManagerDao(BackendPicManagerDao backendPicManagerDao) {
		this.backendPicManagerDao = backendPicManagerDao;
	}



	@Override
	public Long addCategory(Long parentId, String addCategoryName) {
		return backendPicManagerDao.addCategory(parentId,addCategoryName);
	}



	@Override
	public void deleteCategory(Long categoryId) {
		backendPicManagerDao.deleteCategory(categoryId);
	}



	@Override
	public void editCategory(Long categoryId, String name) {
		backendPicManagerDao.editCategory(categoryId,name);
		
	}



	@Override
	public Long insertNewPic(String pictureCollectionName,
			String pictureCollectionDes, Long categoryId) {
		return backendPicManagerDao.insertNewPic(pictureCollectionName,pictureCollectionDes,categoryId);
	}



	@Override
	public void insertPicUrl(Long id, String pic) {
		backendPicManagerDao.insertPicUrl(id,pic);
	}



	@Override
	public List<Picture> getPictureListByCategoryId(Long categoryId) {
		return backendPicManagerDao.getPictureListByCategoryId(categoryId);
	}



	@Override
	public List<String> getPictureListByPicCollectionId(Long picCollectionId) {
		return backendPicManagerDao.getPictureListByPicCollectionId(picCollectionId);
	}



	@Override
	public Picture getPictureByPicCollectionId(Long picCollectionId) {
		return backendPicManagerDao.getPictureByPicCollectionId(picCollectionId);
	}

}
