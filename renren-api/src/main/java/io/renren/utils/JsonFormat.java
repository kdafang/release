package io.renren.utils;

import io.renren.entity.ReleaseNewsEntity;

import java.util.List;

public class JsonFormat {

    /**
     * 判断提交数据关键字段是否为空或null
     * @param releaseNewsList  提交数据
     * @return
     */
    public static boolean insertJson(List<ReleaseNewsEntity> releaseNewsList){
        ReleaseNewsEntity releaseNewsEntity = releaseNewsList.get(0);
        if(releaseNewsEntity.getWebsite().equals("")||releaseNewsEntity.getWebsite()==null)
            return false;
        if(releaseNewsEntity.getReleaseTime().equals("")||releaseNewsEntity.getReleaseTime()==null)
            return false;
        if(releaseNewsEntity.getNewsUrl().equals("")||releaseNewsEntity.getNewsUrl()==null)
            return false;
        if(releaseNewsEntity.getNewsTitle().equals("")||releaseNewsEntity.getNewsTitle()==null)
            return false;
        return true;

    }
}
