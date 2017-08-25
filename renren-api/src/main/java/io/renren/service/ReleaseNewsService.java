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

	List<HashMap> findByTimeNow(HashMap<String, Object> map);

	List<HashMap> webSiteNumber();

	List<HashMap> findByPastTime(HashMap<String, Object> map);

	List<HashMap> findBetweenTime(HashMap<String, Object> map);

	List<HashMap> findByTimeWeek(HashMap<String, Object> map);

	List<HashMap> findByTimeMon(HashMap<String, Object> map);

	List<HashMap> findByTimeDay(HashMap<String, Object> map);

	List<HashMap> getWebsiteList();
}
