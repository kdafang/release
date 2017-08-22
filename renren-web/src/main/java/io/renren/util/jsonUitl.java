package io.renren.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kdafang on 2017/8/9.
 */
public class jsonUitl {
    public JSONArray getJson(List<HashMap> name){
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<name.size();i++){
            JSONObject jsonObject = new JSONObject();
            for(Object key: name.get(i).keySet()){
                jsonObject.put(key,name.get(i).get(key));
            }
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }
}
