package com.action;    
  
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Category;
import com.model.Picture;
import com.service.BackendPicManagerService;
@Controller  
@RequestMapping("/pic")
public class PicIndex {
	
	/** 服务 **/
	@Autowired
	private BackendPicManagerService backendPicManagerService;
	
	
	private List<Category> categoryList;
	
	private List<Picture> pictureList;
	
    @RequestMapping(value="index", method = RequestMethod.GET)
	public ModelAndView indexPage(
			@RequestParam(value = "ids", required = false) Long ids ,
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
    	
    	ModelAndView mv = new ModelAndView("backendImageManage/picIndex");
    	//类目树
		mv.addObject("categoryLists", getCategoryTree());
		
		pictureList = new ArrayList<Picture>();
		
		List<Picture> tempPictureList = null;
		
		if(ids == null){
			ids =  0L;
		}
		if(pageNo == null){
			pageNo = 1;
		}
		
		int totalCount = 0;
		
		if(ids != null){
			tempPictureList = backendPicManagerService.getPictureListByCategoryId(ids);
			List<Category> childrenCategoryList = backendPicManagerService.getCategoryList(ids);
			for(Category childrenCategory : childrenCategoryList){
				List<Category> secondChildrenCategoryList = backendPicManagerService.getCategoryList(childrenCategory.getId());
				for(Category secondChildrenCategory : secondChildrenCategoryList){
					tempPictureList.addAll(backendPicManagerService.getPictureListByCategoryId(secondChildrenCategory.getId()));
				}
				tempPictureList.addAll(backendPicManagerService.getPictureListByCategoryId(childrenCategory.getId()));
			}
			if(tempPictureList != null){
				totalCount = (tempPictureList.size() - 1) / 20 ;
				if(tempPictureList.size() > 20){
					int maxSize = tempPictureList.size() > pageNo * 20 ? 20 :  tempPictureList.size() - (pageNo-1) * 20;
					for(int i =0 ; i< maxSize ;i++){
						pictureList.add(tempPictureList.get((pageNo - 1) * 20  + i));
					}
				}else{
					pictureList.addAll(tempPictureList);
					totalCount = 0;
				}
			}
//		}else{
//			for(Category category : getCategoryTree()){
//				tempPictureList = backendPicManagerService.getPictureListByCategoryId(category.getId());
//				List<Category> childrenCategoryList = backendPicManagerService.getCategoryList(category.getId());
//				for(Category childrenCategory : childrenCategoryList){
//					List<Category> secondChildrenCategoryList = backendPicManagerService.getCategoryList(childrenCategory.getId());
//					for(Category secondChildrenCategory : secondChildrenCategoryList){
//						tempPictureList.addAll(backendPicManagerService.getPictureListByCategoryId(secondChildrenCategory.getId()));
//					}
//					tempPictureList.addAll(backendPicManagerService.getPictureListByCategoryId(childrenCategory.getId()));
//				}
//				if(tempPictureList != null){
//					totalCount = (tempPictureList.size()-1) / 20 ;
//					if(tempPictureList.size() > 20){
//						int maxSize = tempPictureList.size() > pageNo * 20 ? 20 :  tempPictureList.size() - (pageNo-1) * 20;
//						for(int i =0 ; i< maxSize ;i++){
//							pictureList.add(tempPictureList.get((pageNo - 1) * 20  + i));
//						}
//					}else{
//						pictureList.addAll(tempPictureList);
//						totalCount = 0;
//					}
//				}
//			}
//			ids = 0L;
		}
		mv.addObject("pictureList", pictureList);
		mv.addObject("selectCateogryId",ids);
		mv.addObject("totalCount",totalCount);
		mv.addObject("pageNo",pageNo);
		return mv;
	}
    
    @RequestMapping(value="item", method = RequestMethod.GET)
    public ModelAndView categoryList(
			@RequestParam(value = "ids", required = false) Long picCollectionId) {
    	
		ModelAndView mv = new ModelAndView("backendImageManage/picItem");
		Picture pic = backendPicManagerService.getPictureByPicCollectionId(picCollectionId);
		List<String> urls = backendPicManagerService.getPictureListByPicCollectionId(picCollectionId);
		pic.setChildrenPicUrl(urls);
		mv.addObject("pic", pic);
		return mv;
	}
    
    
    public List<Category> getCategoryTree(){
    	categoryList = backendPicManagerService.getCategoryList(0L);
    	for(Category category : categoryList){
			Long categoryId = category.getId();
			List<Category> secondCategorys = backendPicManagerService.getCategoryList(categoryId);
			category.setSecondCategoryList(secondCategorys);
		}
    	return categoryList;
    }
    
    /**************************get set ************************/

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	
}  