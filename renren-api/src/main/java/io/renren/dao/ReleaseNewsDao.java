package io.renren.dao;

import io.renren.entity.ReleaseNewsEntity;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-13 19:42:04
 */
public interface ReleaseNewsDao extends BaseDao<ReleaseNewsEntity> {
    /**
     * 批量插入数据
     */
    int insertList(List<ReleaseNewsEntity> releaseNewsList);

    int deleteList(List<HashMap<String,Object>> deleteList);
    /**
     * 查询所有数据
     * @return
     */
    List<ReleaseNewsEntity> findListAll();

    /**
     * 按照站点名称查询数据
     * @return
     */
    List<ReleaseNewsEntity> webSiteTotal(String website);

    /**
     * 查找站点及信息量
     * @return
     */
    List<HashMap> webSiteNumber();
    /**
     * 按照发布时间统计当天数据
     *
     */
    List<HashMap> findByTimeNow(HashMap<String, Object> map);
    /**
     * 统计从今天到n天前的数据
     */
    List<HashMap> findByPastTime(HashMap<String, Object> map);
    /**
     * 统计两个时间段之间的数据
     */
    List<HashMap> findBetweenTime(HashMap<String, Object> map);
    /**
     * 统计给定时间所在周的数据
     */
    List<HashMap> findByTimeWeek(HashMap<String, Object> map);
    /**
     * 统计给定时间所在月的数据
     */
    List<HashMap> findByTimeMon(HashMap<String, Object> map);
    /**
     * 统计某一天的数据
     */
    List<HashMap> findByTimeDay(HashMap<String, Object> map);

    /**
     * 过滤已存在的数据
     * @param newsurl
     * @return
     */
    List<ReleaseNewsEntity> selectRepeat(String newsurl);

    /**
     * 获取站点名称列表
     * @return
     */
    List<HashMap> getWebsiteList();


}
