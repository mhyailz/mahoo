package com.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/3/3.
 */
public class SearchParaMap{

    private static final int pageSize = 10;

    private Map paraMap;

    public SearchParaMap(){
        Map map = new HashMap<String,Object>();
        map.put("pageNo",0);
        map.put("PageSize",pageSize);
        this.paraMap = map;
    }

    public SearchParaMap( Map paraMap){
        this.paraMap = paraMap;
    }

    public Map getParaMap() {
        return paraMap;
    }

}
