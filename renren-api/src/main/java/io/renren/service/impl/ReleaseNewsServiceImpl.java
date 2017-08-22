package io.renren.service.impl;

import io.renren.dao.ReleaseNewsDao;
import io.renren.entity.ReleaseNewsEntity;
import io.renren.service.ReleaseNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("releaseNewsService")
public class ReleaseNewsServiceImpl implements ReleaseNewsService {
	@Autowired
	private ReleaseNewsDao releaseNewsDao;
	
	@Override
	public ReleaseNewsEntity queryObject(Integer id){
		return releaseNewsDao.queryObject(id);
	}
	
	@Override
	public List<ReleaseNewsEntity> queryList(Map<String, Object> map){
		return releaseNewsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return releaseNewsDao.queryTotal(map);
	}
	
	@Override
	public void save(ReleaseNewsEntity releaseNews){
		releaseNewsDao.save(releaseNews);
	}
	
	@Override
	public void update(ReleaseNewsEntity releaseNews){
		releaseNewsDao.update(releaseNews);
	}
	
	@Override
	public void delete(Integer id){
		releaseNewsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		releaseNewsDao.deleteBatch(ids);
	}

	@Transactional(readOnly = false)
	public int insertList(List<ReleaseNewsEntity> releaseNewsList){
		return releaseNewsDao.insertList(releaseNewsList);
	}

	public List<ReleaseNewsEntity> findListAll(){
		return releaseNewsDao.findListAll();
	}

	public List<ReleaseNewsEntity> webSiteTotal(String website){
		return releaseNewsDao.webSiteTotal(website);
	}

	@Override
	public List<HashMap> findByTimeNow(HashMap<String, Object> map) {
		return releaseNewsDao.findByTimeNow(map);
	}

	public List<HashMap> webSiteNumber(){
		return releaseNewsDao.webSiteNumber();
	}

	@Override
	public List<HashMap> findByPastTime(HashMap<String, Object> map) {
		return releaseNewsDao.findByPastTime(map);
	}

	@Override
	public List<HashMap> findBetweenTime(HashMap<String, Object> map) {

		return releaseNewsDao.findBetweenTime(map);
	}

	@Override
	public List<HashMap> findByTimeWeek(HashMap<String, Object> map) {
		return releaseNewsDao.findByTimeWeek(map);
	}
	@Override
	public List<HashMap> findByTimeMon(HashMap<String, Object> map) {
		return releaseNewsDao.findByTimeMon(map);
	}
	@Override
	public List<HashMap> findByTimeDay(HashMap<String, Object> map) {
		return releaseNewsDao.findByTimeDay(map);
	}

	@Override
	public boolean selectRepeat(String newsurl) {
		if (releaseNewsDao.selectRepeat(newsurl).size()==0){
			return true;
		}
		else{
			return false;
		}
	}
}
