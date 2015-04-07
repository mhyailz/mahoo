package com.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * Welcome you !
 * author : mahongyao
 * time   : 2015/4/7 - 11:27
 */

public class SearchParaMap{

    private static final int pageSize = 10;

    private Map paraMap;

    public SearchParaMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageNo",0);
        map.put("PageSize",pageSize);
        this.paraMap = map;
    }

    public Map getParaMap() {
        return paraMap;
    }

}
