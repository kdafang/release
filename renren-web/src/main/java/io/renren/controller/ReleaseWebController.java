package io.renren.controller;

import io.renren.service.ReleaseNewsService;
import io.renren.util.jsonUitl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 李博 on 2017-05-17.
 */
@Controller
@RequestMapping(value = "/f/release/web")
public class ReleaseWebController {

    @Autowired
    private ReleaseNewsService releaseNewsService;


    @RequestMapping(value = "total",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray newsTotal(HttpServletRequest request, HttpServletResponse response){
        List<HashMap> websiteNumber = releaseNewsService.webSiteNumber();
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<websiteNumber.size();i++){
            JSONObject jsonObject = new JSONObject();
            for(Object key: websiteNumber.get(i).keySet()){
                jsonObject.put(key,websiteNumber.get(i).get(key));
            }
            jsonArray.add(jsonObject);
            // System.out.println(jsonObject);
        }
        return jsonArray;
    }
    @RequestMapping(value = "findByTimeNow",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray findByTime(HttpServletRequest request, HttpServletResponse response,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String,Object>();
        map.put("websiteName",website);
        map.put("flag",flag);
        List<HashMap> findByTime = releaseNewsService.findByTimeNow(map);
        JSONArray jsonArray = new JSONArray();
        jsonUitl jsonUitl=new jsonUitl();
        jsonArray=jsonUitl.getJson(findByTime);
        return jsonArray;
    }

    @RequestMapping(value = "findByPastTime",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray  findByPastTime(HttpServletRequest request, HttpServletResponse response,String website,int num,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("websiteName",website);
        map.put("num",num);
        map.put("flag",flag);

        List<HashMap> findByPastTime = releaseNewsService.findByPastTime(map);
        JSONArray jsonArray = new JSONArray();
        jsonUitl jsonUitl=new jsonUitl();
        jsonArray=jsonUitl.getJson(findByPastTime);
        return jsonArray;
    }
    @RequestMapping(value = "findBetweenTime",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray  findBetweenTime(HttpServletRequest request, HttpServletResponse response,String time1,String time2,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time1",time1);
        map.put("time2",time2);
        map.put("flag",flag);
        List<HashMap> findBetweenTime = releaseNewsService.findBetweenTime(map);
        JSONArray jsonArray = new JSONArray();
        jsonUitl jsonUitl=new jsonUitl();
        jsonArray=jsonUitl.getJson(findBetweenTime);
        return jsonArray;
    }
    @RequestMapping(value = "findByTimeWeek",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray  findByTimeWeek(HttpServletRequest request, HttpServletResponse response,String time,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
        List<HashMap> findByTimeWeek = releaseNewsService.findByTimeWeek(map);
        JSONArray jsonArray = new JSONArray();
        jsonUitl jsonUitl=new jsonUitl();
        jsonArray=jsonUitl.getJson(findByTimeWeek);
        return jsonArray;

    }
    @RequestMapping(value = "findByTimeMon",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray  findByTimeMon(HttpServletRequest request, HttpServletResponse response,String time,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
        List<HashMap> findByTimeMon = releaseNewsService.findByTimeMon(map);
        JSONArray jsonArray = new JSONArray();
        jsonUitl jsonUitl=new jsonUitl();
        jsonArray=jsonUitl.getJson(findByTimeMon);
        return jsonArray;
    }
    @RequestMapping(value = "findByTimeDay",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray  findByTimeDay(HttpServletRequest request, HttpServletResponse response,String time,String website,String flag) {
        HashMap<String, Object> map=new HashMap<String, Object> ();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
        List<HashMap> findByTimeDay = releaseNewsService.findByTimeDay(map);
        JSONArray jsonArray = new JSONArray();
        jsonUitl jsonUitl=new jsonUitl();
        jsonArray=jsonUitl.getJson(findByTimeDay);
        return jsonArray;
    }

}
