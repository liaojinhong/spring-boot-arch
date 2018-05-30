package com.me.demo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


/**
 * Json小工具
 * 
 * gson封装据类型转换
 * 
 * @author ljh
 *
 */
public class JsonUtil {

    private static Gson gson = null;

    static{
        gson  = new Gson();//todo yyyy-MM-dd HH:mm:ss
    }

    public static synchronized Gson newInstance(){
        if(gson == null){
            gson =  new Gson();
        }
        return gson;
    }

    /**
     * 将对象转换为json字符串
     * @param obj
     * @return
     */
    public static String toJson(Object obj){
        return gson.toJson(obj);
    }

    public static String toJsonFast(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 将json字符串转换为BEAN
     * @param json
     * @param clz
     * @return
     */
    public static <T> T toBean(String json,Class<T> clz){

        return gson.fromJson(json, clz);
    }

    /**
     * 将json字符串转换为MAP
     * @param json
     * @param clz
     * @return
     */
    public static <T> Map<String, T> toMap(String json, Class<T> clz){
        Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String,JsonObject>>(){}.getType());
        Map<String, T> result = new HashMap<String, T>();
        for(String key:map.keySet()){
            result.put(key,gson.fromJson(map.get(key),clz) );
        }
        return result;
    }

    /**
     * 将json字符串转换为MAP
     * @param json
     * @param clz
     * @return
     */
    public static Map<String, Object> toMap(String json){
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String,Object>>(){}.getType());
        return map;
    }

    /**
     * 将json字符串转换为LIST
     * @param json
     * @param clz
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> clz){
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        List<T> list  = new ArrayList<T>();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, clz));
        }
        return list;
    }

    /**
     * 将json字符串转换为LIST
     * @param json
     * @param clz
     * @return
     */
    public static <T> List<T> parseList(String json, Class<T> clz) {
        List<T> list = JSONObject.parseArray(json, clz);
        return list;
    }

}
