package com.service;

import java.util.List;

import com.model.Category;
import com.model.Picture;

public interface BackendPicManagerService {

	
	/**
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Category> getCategoryList(Long parentId);

	/**
	 * 
	 * @param parentId
	 * @param addCategoryName
	 * @return
	 */
	public Long addCategory(Long parentId, String addCategoryName);


	/**
	 * 
	 * @param categoryId
	 */
	public void deleteCategory(Long categoryId);

	/**
	 * 
	 * @param categoryId
	 * @param name
	 */
	public void editCategory(Long categoryId, String name);


	/**
	 * 
	 * @param pictureCollectionName
	 * @param pictureCollectionDes
	 * @param categoryId
	 */
	public Long insertNewPic(String pictureCollectionName,
                             String pictureCollectionDes, Long categoryId);

	/**
	 * 
	 * @param id
	 * @param pic
	 */
	public void insertPicUrl(Long id, String pic);

	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<Picture> getPictureListByCategoryId(Long categoryId);

	/**
	 * 
	 * @param picCollectionId
	 * @return
	 */
	public List<String> getPictureListByPicCollectionId(Long picCollectionId);

	
	/**
	 * 
	 * @param picCollectionId
	 * @return
	 */
	public Picture getPictureByPicCollectionId(Long picCollectionId);
}
