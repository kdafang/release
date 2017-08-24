package io.renren.controller;

import io.renren.service.ReleaseNewsService;
import io.renren.util.JsonUitl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 李博 on 2017-05-17.
 */
@RestController
@RequestMapping(value = "/f/release/web")
public class ReleaseWebController {

    @Autowired
    private ReleaseNewsService releaseNewsService;

    @RequestMapping(value = "total")
    public JSONArray newsTotal(){
        List<HashMap> websiteNumber = releaseNewsService.webSiteNumber();
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<websiteNumber.size();i++){
            JSONObject jsonObject = new JSONObject();
            for(Object key: websiteNumber.get(i).keySet()){
                jsonObject.put(key,websiteNumber.get(i).get(key));
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @RequestMapping(value = "findByTimeNow")
    public JSONArray findByTime(String website,String flag) {
        HashMap<String, Object> map=new HashMap<String,Object>();
        map.put("websiteName",website);
        map.put("flag",flag);
        List<HashMap> findByTime = releaseNewsService.findByTimeNow(map);
        JSONArray jsonArray = JsonUitl.getJson(findByTime);
        return jsonArray;
    }

    @RequestMapping(value = "findByPastTime")
    public JSONArray  findByPastTime(String website,int num,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("websiteName",website);
        map.put("num",num);
        map.put("flag",flag);

        List<HashMap> findByPastTime = releaseNewsService.findByPastTime(map);
        JSONArray jsonArray = JsonUitl.getJson(findByPastTime);
        return jsonArray;
    }

    @RequestMapping(value = "findBetweenTime")
    public JSONArray  findBetweenTime(String time1,String time2,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time1",time1);
        map.put("time2",time2);
        map.put("flag",flag);
        List<HashMap> findBetweenTime = releaseNewsService.findBetweenTime(map);
        JSONArray jsonArray = JsonUitl.getJson(findBetweenTime);
        return jsonArray;
    }

    @RequestMapping(value = "findByTimeWeek")
    public JSONArray  findByTimeWeek(String time,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
        List<HashMap> findByTimeWeek = releaseNewsService.findByTimeWeek(map);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeWeek);
        return jsonArray;

    }

    @RequestMapping(value = "findByTimeMon")
    public JSONArray  findByTimeMon(String time,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
        List<HashMap> findByTimeMon = releaseNewsService.findByTimeMon(map);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeMon);
        return jsonArray;
    }

    @RequestMapping(value = "findByTimeDay")
    public JSONArray  findByTimeDay(String time,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
        List<HashMap> findByTimeDay = releaseNewsService.findByTimeDay(map);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeDay);
        return jsonArray;
    }

}
