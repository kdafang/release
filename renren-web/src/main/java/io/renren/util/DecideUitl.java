package io.renren.util;

import io.renren.service.ReleaseNewsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kdafang on 2017/8/25.
 */
public class DecideUitl {
    public AjaxResponse declideWebsite(AjaxResponse ajaxResponse, String website, ReleaseNewsService releaseNewsService) {
        if (website != null) {
            if (!releaseNewsService.existWebsite(website)) {
                ajaxResponse.setCode(4);
                ajaxResponse.setMessage("站点名称输入错误！");
            }

        }
        return ajaxResponse;
    }
    public Boolean declideTime(String time1,String time2){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = (Date) sdf.parseObject(time1);
            Date date2 = (Date) sdf.parseObject(time2);
            if(date1.getTime()<date2.getTime()){
                return false;
            }
            else{
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;

    }

    }
