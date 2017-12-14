package com.lihui.share.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonUtil{

    /**
     * 将json转化成map
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> convertJsonStrToMap(String jsonStr)
    {
        Map<String, Object> map = JSON.parseObject(jsonStr,new TypeReference<Map<String, Object>>(){});
        return map;
    }
    
//    1、//将map转换成jsonObject 
//    JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(itemMap));
//    将Map类型的itemInfo转换成json，再经JSONObject转换实现。
//
//    2、//将jsonObj转换成Map
//    Map<String, Object> itemMap = JSONObject.toJavaObject(itemJSONObj, Map.class);
//    //JOSN.parseObjet()方法同样可以转换
//    3、//将List转换成JSONArray
//    JSONArray ja = JSONArray.parseArray(JSON.toJSONString(itemList));
}
