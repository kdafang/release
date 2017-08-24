package io.renren.api;

import io.renren.annotation.IgnoreAuth;
import io.renren.entity.DeleteEntity;
import io.renren.entity.ReleaseNewsEntity;
import io.renren.service.ReleaseNewsService;
import io.renren.utils.BatchInsert;
import io.renren.utils.JsonFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 李博 on 2017-06-13.
 */

@Controller
@RequestMapping("/api")
public class ApiReleaseReportMessage {

    @Autowired
    private ReleaseNewsService releaseNewsService;

    @IgnoreAuth
    @RequestMapping(value = "insertMessage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getMessage(@RequestBody String message){
        JSONArray jsonArray = JSONArray.fromObject(message);
        List<ReleaseNewsEntity> releaseNewsList = (List) JSONArray.toCollection(jsonArray,ReleaseNewsEntity.class);
//        查找数据库是否已存在数据
//        for (int i=releaseNewsList.size()-1;i>=0;i--){
//            if(!releaseNewsService.selectRepeat(releaseNewsList.get(i).getNewsUrl())){
//                releaseNewsList.remove(i);
//            }
//            System.out.println(releaseNewsList);
//        }
        JSONObject jsonObject = new JSONObject();
        if(releaseNewsList.size()>0){
            int newsSize=0;
            try{
//                newsSize = releaseNewsService.insertList(releaseNewsList);
                newsSize = BatchInsert.batchList(releaseNewsList,50,releaseNewsService);
            }catch (DataAccessException e){
                jsonObject.put("code",400);
                jsonObject.put("message","数据提交异常，请通知管理员");
//                jsonObject.put("error",e.getMessage());
                return jsonObject;
            }
            jsonObject.put("code",201);
            jsonObject.put("message","数据提交成功");
            jsonObject.put("size",newsSize);
            return jsonObject;
        }
        else{
            jsonObject.put("code",400);
            jsonObject.put("message","数据格式不正确");
            return jsonObject;
        }
    }


    @IgnoreAuth
    @RequestMapping(value = "deleteMessage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delMessage(@RequestBody String message){
        JSONArray jsonArray = JSONArray.fromObject(message);
        List<HashMap<String,Object>> deleteList = JSONArray.toList(jsonArray,new DeleteEntity(),new JsonConfig());

        System.out.println(message);
        JSONObject jsonObject=new JSONObject();
        return jsonObject;
    }
}
