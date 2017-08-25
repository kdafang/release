package io.renren.service;

import io.renren.entity.ReleaseNewsEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-13 19:42:04
 */
public interface ReleaseNewsService {
	
	ReleaseNewsEntity queryObject(Integer id);
	
	List<ReleaseNewsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ReleaseNewsEntity releaseNews);
	
	void update(ReleaseNewsEntity releaseNews);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	int insertList(List<ReleaseNewsEntity> releaseNewsList);

	int deleteList(List<HashMap<String,Object>> deleteList);

	List<ReleaseNewsEntity> findListAll();

	List<ReleaseNewsEntity> webSiteTotal(String website);

	boolean selectRepeat(String newsurl);

	List<HashMap> findByTimeNow(String website,String flag);

	List<HashMap> webSiteNumber();

	List<HashMap> findByPastTime(String website,int num,String flag);

	List<HashMap> findBetweenTime(String time1,String time2,String website,String flag);

	List<HashMap> findByTimeWeek(String time,String website,String flag);

	List<HashMap> findByTimeMon(String time,String website,String flag);

	List<HashMap> findByTimeDay(String time,String website,String flag);

	List<HashMap> getWebsiteList();
	Boolean  existWebsite(String website);//判断站点是否存在
}
