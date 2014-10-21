package com.action;    
  
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Category;
import com.service.BackendPicManagerService;
@Controller  
@RequestMapping("/backend")
public class BackendPicManagerAction {
    
	/**
	 * 首页展示的类目树
	 */
	private List<Category> categoryLists;
	
	@Autowired
	private BackendPicManagerService backendPicManagerService;
	
    @RequestMapping(value="index",method = RequestMethod.GET)
	public ModelAndView indexPage(){
		ModelAndView mv = new ModelAndView("backendImageManage/backendImageIndex");
		categoryLists = backendPicManagerService.getCategoryList(0L);
		mv.addObject("categoryLists", categoryLists);
    	
		return mv;
	}
    
    @RequestMapping(value="add", method = RequestMethod.GET)
	public @ResponseBody Category addCategory(
			@RequestParam(value = "addCategoryName", required = false) String addCategoryName,
			@RequestParam(value = "parentId", required = false) Long parentId) throws UnsupportedEncodingException {
    	
    	addCategoryName =new String(addCategoryName.getBytes("ISO-8859-1"),"UTF-8");
    	Long id = backendPicManagerService.addCategory(parentId,addCategoryName);
    	System.out.println(addCategoryName);
    	Category cateogry = new Category();
    	cateogry.setId(id);
    	cateogry.setName(addCategoryName);
    	cateogry.setParentCategoryId(parentId);
    	return cateogry;
    	
    }
    
    @RequestMapping(value="delete", method = RequestMethod.GET)
	public @ResponseBody Category deleteCategory(
			@RequestParam(value = "categoryId", required = false) Long categoryId) {
    	
    	backendPicManagerService.deleteCategory(categoryId);
    	Category cateogry = new Category();
    	return cateogry;
    	
    }
    
    @RequestMapping(value="edit", method = RequestMethod.GET)
	public @ResponseBody Category editCategory(
			@RequestParam(value = "categoryId", required = false) Long categoryId,
			@RequestParam(value = "name", required = false) String name) throws UnsupportedEncodingException {
    	
    	name =new String(name.getBytes("ISO-8859-1"),"UTF-8");
    	
    	backendPicManagerService.editCategory(categoryId,name);
    	
    	Category cateogry = new Category();
    	
    	return cateogry;
    	
    }
    
    @RequestMapping(value="childrenList", method = RequestMethod.GET)
	public @ResponseBody List<Category> getChildrenList(
			@RequestParam(value = "parentCategoryId", required = false) Long parentCategoryId) {
    	
    	List<Category> categorys = backendPicManagerService.getCategoryList(parentCategoryId);
    	
    	return categorys;
    	
    }
    
    @RequestMapping(value="updatePic",method = RequestMethod.GET)
	public ModelAndView updatePic(
			@RequestParam(value = "picturesName", required = false) String pictureCollectionName,
			@RequestParam(value = "pictureCollectionDes", required = false) String pictureCollectionDes,
			@RequestParam(value = "picUrls", required = false) String picUrls,
			@RequestParam(value = "categoryId", required = false) Long categoryId) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("backendImageManage/successUpload");
		
		
		pictureCollectionName =new String(pictureCollectionName.getBytes("ISO-8859-1"),"UTF-8");
		pictureCollectionDes =new String(pictureCollectionDes.getBytes("ISO-8859-1"),"UTF-8");
		picUrls =new String(picUrls.getBytes("ISO-8859-1"),"UTF-8");
		
		if(StringUtils.isNotEmpty(picUrls)){
			/** 图片链接url **/
			String[] pics = picUrls.split(",");
			
			// 先把pictureName,des,categoryId,保存起来
			Long id = backendPicManagerService.insertNewPic(pictureCollectionName,pictureCollectionDes,categoryId);
			
			for(String pic : pics){
				backendPicManagerService.insertPicUrl(id,StringUtils.trim(pic));
			}
		}
    	
		return mv;
	}
    
    
    
    /**************************get set ************************/

	public List<Category> getCategoryLists() {
		return categoryLists;
	}

	public void setCategoryLists(List<Category> categoryLists) {
		this.categoryLists = categoryLists;
	}

	public BackendPicManagerService getBackendPicManagerService() {
		return backendPicManagerService;
	}

	public void setBackendPicManagerService(
			BackendPicManagerService backendPicManagerService) {
		this.backendPicManagerService = backendPicManagerService;
	}
    
    
}  