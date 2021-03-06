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
     * @param order  标识 默认升序，传入order=1时,降序
     * @return
     */

    @RequestMapping(value = "findByTimeNow")
    public AjaxResponse findByTime(String website,String flag,String order) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        DecideUitl decideUitl=new DecideUitl();
        List<HashMap> findByTime = releaseNewsService.findByTimeNow(website,flag,order);
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
     * @param order  标识 默认升序，传入order=1时,降序
     * @return
     */
    @RequestMapping(value = "findByPastTime")
    public AjaxResponse findByPastTime(String website,Integer num,String flag,String order) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        DecideUitl decideUitl=new DecideUitl();
        if(num==null||num<0){
            ajaxResponse.setCode(8);
            ajaxResponse.setMessage("输入天数为空或天数小于0！");
            return ajaxResponse;
        }
        List<HashMap> findByPastTime = releaseNewsService.findByPastTime(website,num,flag,order);
        JSONArray jsonArray = JsonUitl.getJson(findByPastTime);
        ajaxResponse.setData(jsonArray);
        if(website!=null){
            ajaxResponse= decideUitl.declideWebsite(ajaxResponse,website,releaseNewsService);
        }

        return ajaxResponse;
    }

    /**
     * 查询两个时间段之间的信息
     * @param time1 时间 格式为 yyyy-MM-dd
     * @param time2 时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag 标识 传入flag=1时，查询的结果为每天的总访问量
     * @param order  标识 默认升序，传入order=1时,降序
     * @return
     */
    @RequestMapping(value = "findBetweenTime")
    public AjaxResponse findBetweenTime(String time1,String time2,String website,String flag,String order) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        DecideUitl decideUitl=new DecideUitl();
        List<HashMap> findBetweenTime;
        if(time1==null ||time2==null){
            ajaxResponse.setCode(8);
            ajaxResponse.setMessage("输入日期为空！");
            return ajaxResponse;
        }
        if(time1.equals(time2)){
            ajaxResponse= findByTimeDay(time1,website,flag,order);
            return ajaxResponse;
        }
        if(decideUitl.declideTime(time1,time2)){
            findBetweenTime = releaseNewsService.findBetweenTime(time2,time1,website,flag,order);
        }
        else {
            findBetweenTime = releaseNewsService.findBetweenTime(time1, time2, website,flag,order);
        }
        JSONArray jsonArray = JsonUitl.getJson(findBetweenTime);
        ajaxResponse.setData(jsonArray);
        if(website!=null){
            ajaxResponse= decideUitl.declideWebsite(ajaxResponse,website,releaseNewsService);
        }
        return ajaxResponse;
    }

    /**
     * 查询给定时间所在周的信息
     * @param time  时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag  标识 传入flag=1时，查询的结果为每天的总访问量
     * @param order  标识 默认升序，传入order=1时,降序
     * @return
     */
    @RequestMapping(value = "findByTimeWeek")
    public AjaxResponse  findByTimeWeek(String time,String website,String flag,String order) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        DecideUitl decideUitl=new DecideUitl();
        if(time==null){
            ajaxResponse.setCode(8);
            ajaxResponse.setMessage("输入日期为空！");
            return ajaxResponse;
        }
        List<HashMap> findByTimeWeek = releaseNewsService.findByTimeWeek(time,website,flag,order);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeWeek);
        ajaxResponse.setData(jsonArray);
        if(website!=null){
            ajaxResponse= decideUitl.declideWebsite(ajaxResponse,website,releaseNewsService);
        }
        return ajaxResponse;

    }

    /**
     * 查询给定时间所在月的信息
     * @param time  时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag  标识 传入flag=1时，查询的结果为每天的总访问量
     * @param order  标识 默认升序，传入order=1时,降序
     * @return
     */
    @RequestMapping(value = "findByTimeMon")
    public AjaxResponse  findByTimeMon(String time,String website,String flag,String order) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        DecideUitl decideUitl=new DecideUitl();
        if(time==null){
            ajaxResponse.setCode(8);
            ajaxResponse.setMessage("输入日期为空！");
            return ajaxResponse;
        }
        List<HashMap> findByTimeMon = releaseNewsService.findByTimeMon(time,website,flag,order);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeMon);
        ajaxResponse.setData(jsonArray);
        if(website!=null){
            ajaxResponse= decideUitl.declideWebsite(ajaxResponse,website,releaseNewsService);
        }
        return ajaxResponse;
    }



    /**
     * 查询具体某一天的信息
     * @param time  时间 格式为 yyyy-MM-dd
     * @param website 站点名称
     * @param flag  标识 传入flag=1时，查询的结果为当天每小时的访问量
     * @param order  标识 默认升序，传入order=1时,降序
     * @return
     */
    @RequestMapping(value = "findByTimeDay")
    public AjaxResponse  findByTimeDay(String time,String website,String flag,String order) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        DecideUitl decideUitl=new DecideUitl();
        if(time==null){
            ajaxResponse.setCode(8);
            ajaxResponse.setMessage("输入日期为空！");
            return ajaxResponse;
        }
        List<HashMap> findByTimeDay = releaseNewsService.findByTimeDay(time,website,flag,order);
        JSONArray jsonArray = JsonUitl.getJson(findByTimeDay);
        ajaxResponse.setData(jsonArray);
        if(website!=null){
            ajaxResponse= decideUitl.declideWebsite(ajaxResponse,website,releaseNewsService);
        }
        return ajaxResponse;
    }

}
