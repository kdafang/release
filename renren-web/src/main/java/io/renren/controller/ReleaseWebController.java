package io.renren.controller;

import io.renren.service.ReleaseNewsService;
import io.renren.util.AjaxResponse;
import io.renren.util.DecideUitl;
import io.renren.util.JsonUitl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 查询当天的信息
     * @param website 站点名称
     * @param flag     标识 flag=1时 查询的结果为当天24小时每小时的总访问量
     * @return
     */

    @RequestMapping(value = "findByTimeNow")
    public AjaxResponse findByTime(String website,String flag) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        DecideUitl decideUitl=new DecideUitl();
        List<HashMap> findByTime = releaseNewsService.findByTimeNow(website,flag);
        JSONArray jsonArray = JsonUitl.getJson(findByTime);
        if(jsonArray.size()==0){
            ajaxResponse.setMessage("当天暂无数据！");
        }
        if(website!=null){
            ajaxResponse= decideUitl.declideWebsite(ajaxResponse,website,releaseNewsService);
        }

        ajaxResponse.setData(jsonArray);
        return ajaxResponse;
      }





    /**
     * 查询当天到num天内的信息，如num=10是过去10天中的所有信息
     * @param website 站点名称
     * @param num      天数 （非空）
     * @param flag  标识 传入flag=1时，查询的结果为每天的总访问量
     * @return
     */
    @RequestMapping(value = "findByPastTime")
    public AjaxResponse findByPastTime(String website,int num,String flag) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        List<HashMap> findByPastTime = releaseNewsService.findByPastTime(website,num,flag);
        JSONArray jsonArray = JsonUitl.getJson(findByPastTime);
        ajaxResponse.setData(jsonArray);
        return ajaxResponse;
    }

    /**
     * 查询两个时间段之间的信息
     * @param time1 时间 格式为 yyyy-MM-dd
     * @param time2 时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag 标识 传入flag=1时，查询的结果为每天的总访问量
     * @return
     */
    @RequestMapping(value = "findBetweenTime")
    public AjaxResponse findBetweenTime(String time1,String time2,String website,String flag) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        List<HashMap> findBetweenTime = releaseNewsService.findBetweenTime(time1,time2,website,flag);
        JSONArray jsonArray = JsonUitl.getJson(findBetweenTime);
        ajaxResponse.setData(jsonArray);
        return ajaxResponse;
    }

    /**
     * 查询给定时间所在周的信息
     * @param time  时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag  标识 传入flag=1时，查询的结果为每天的总访问量
     * @return
     */
    @RequestMapping(value = "findByTimeWeek")
    public AjaxResponse  findByTimeWeek(String time,String website,String flag) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        List<HashMap> findByTimeWeek = releaseNewsService.findByTimeWeek(time,website,flag);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeWeek);
        ajaxResponse.setData(jsonArray);
        return ajaxResponse;

    }

    /**
     * 查询给定时间所在月的信息
     * @param time  时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag  标识 传入flag=1时，查询的结果为每天的总访问量
     * @return
     */
    @RequestMapping(value = "findByTimeMon")
    public AjaxResponse  findByTimeMon(String time,String website,String flag) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        List<HashMap> findByTimeMon = releaseNewsService.findByTimeMon(time,website,flag);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeMon);
        ajaxResponse.setData(jsonArray);
        return ajaxResponse;
    }

    /**
     * 查询具体某一天的信息
     * @param time  时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag  标识 传入flag=1时，查询的结果为当天每小时的访问量
     * @return
     */
    @RequestMapping(value = "findByTimeDay")
    public AjaxResponse  findByTimeDay(String time,String website,String flag) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        List<HashMap> findByTimeDay = releaseNewsService.findByTimeDay(time,website,flag);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeDay);
        ajaxResponse.setData(jsonArray);
        return ajaxResponse;
    }

}
