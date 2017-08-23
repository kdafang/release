package io.renren.utils;

import io.renren.service.ReleaseNewsService;

import java.util.List;

public class BatchInsert {

    public static int  batchList(List releaseNewsList, int batchCount, ReleaseNewsService releaseNewsService){
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
}
