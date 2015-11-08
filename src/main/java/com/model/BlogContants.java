package com.model;

import java.io.Serializable;

/**
 * Welcome to mahoo
 * author : mahongyao
 * time   : 2015/4/22 - 16:12
 */
public class BlogContants implements Serializable {

    /** 密钥 **/
    public static final String secretKey = "abcdefghijklmnop";

    /** 404URL **/
    public static final String pageNotFoundUrl = "article/pageNotFound";

    /** PC主页URL **/
    public static final String homePageUrl = "article/articleHomePage";

    /** PC详情URL **/
    public static final String itemPageUrl = "article/articleItemPage";

    /** H5详情URL **/
    public static final String mobileItemPageUrl = "article/h5/articleMobileItemPage";

    /** H5主页URL **/
    public static final String mobileHomePageUrl = "article/h5/articleMobileHomePage";


}
