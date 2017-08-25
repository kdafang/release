package io.renren.utils;

import io.renren.service.ReleaseNewsService;

import java.util.List;

/**
 * 接口工具类
 */
public class BatchList{

    /**
     * 批量插入数据
     * @param releaseNewsList 删除数据list
     * @param batchCount   删除批量大小
     * @param releaseNewsService    信息数据service
     * @return
     */
    public static int  batchInsert(List releaseNewsList, int batchCount, ReleaseNewsService releaseNewsService){
        int startIndex = 0;
        while(startIndex < releaseNewsList.size()){
            int endIndex = 0;
            if(releaseNewsList.size() - batchCount < startIndex){
                endIndex = releaseNewsList.size();
            }else {
                endIndex = startIndex + batchCount;
            }
            releaseNewsService.insertList(releaseNewsList.subList(startIndex,endIndex));
            startIndex = endIndex;
        }
        return releaseNewsList.size();
    }

    /**
     * 批量删除数据
     * @param releaseNewsList  删除数据list
     * @param batchCount   删除批量大小
     * @param releaseNewsService    信息数据service
     * @return
     */
    public static int  batchDelete(List releaseNewsList, int batchCount, ReleaseNewsService releaseNewsService){
        int startIndex = 0,deleteCount = 0;
        while(startIndex < releaseNewsList.size()){
            int endIndex = 0;
            if(releaseNewsList.size() - batchCount < startIndex){
                endIndex = releaseNewsList.size();
            }else {
                endIndex = startIndex + batchCount;
            }
            deleteCount += releaseNewsService.deleteList(releaseNewsList.subList(startIndex,endIndex));
            startIndex = endIndex;
        }
        return deleteCount;
    }
}
