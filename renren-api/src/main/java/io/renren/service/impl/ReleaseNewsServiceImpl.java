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
import java.util.Objects;


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

	@Override
	@Transactional(readOnly = false)
	public int deleteList(List<HashMap<String, Object>> deleteList) {
		return releaseNewsDao.deleteList(deleteList);
	}

	public List<ReleaseNewsEntity> findListAll(){
		return releaseNewsDao.findListAll();
	}

	public List<ReleaseNewsEntity> webSiteTotal(String website){
		return releaseNewsDao.webSiteTotal(website);
	}

	@Override
	public List<HashMap> findByTimeNow(String website,String flag,String order) {
        HashMap<String, Object> map=new HashMap<String,Object>();
		map.put("websiteName",website);
		map.put("flag",flag);
		if("1".equals(order)){
			map.put("order","asc");
		}else
		{
			map.put("order","desc");
		}
		return releaseNewsDao.findByTimeNow(map);
	}

	public List<HashMap> webSiteNumber(){
		return releaseNewsDao.webSiteNumber();
	}

	@Override
	public List<HashMap> findByPastTime(String website,int num,String flag,String order) {
        HashMap<String, Object> map=new HashMap<String,Object>();
	    map.put("websiteName",website);
        map.put("num",num);
        map.put("flag",flag);
		if("1".equals(order)){
			map.put("order","asc");
		}else
		{
			map.put("order","desc");
		}
	    return releaseNewsDao.findByPastTime(map);
	}

	@Override
	public List<HashMap> findBetweenTime(String time1,String time2,String website,String flag,String order) {
        HashMap<String, Object> map=new HashMap<String,Object>();
        map.put("websiteName",website);
		map.put("time1",time1);
		map.put("time2",time2);
		map.put("flag",flag);
		if("1".equals(order)){
			map.put("order","asc");
		}else
		{
			map.put("order","desc");
		}
		return releaseNewsDao.findBetweenTime(map);
	}

	@Override
	public List<HashMap> findByTimeWeek(String time,String website,String flag,String order) {
        HashMap<String, Object> map=new HashMap<String,Object>();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
		if("1".equals(order)){
			map.put("order","asc");
		}else
		{
			map.put("order","desc");
		}
		return releaseNewsDao.findByTimeWeek(map);
	}
	@Override
	public List<HashMap> findByTimeMon(String time,String website,String flag,String order) {
        HashMap<String, Object> map=new HashMap<String,Object>();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
		if("1".equals(order)){
			map.put("order","asc");
		}else
		{
			map.put("order","desc");
		}
		return releaseNewsDao.findByTimeMon(map);
	}
	@Override
	public List<HashMap> findByTimeDay(String time,String website,String flag,String order) {
        HashMap<String, Object> map=new HashMap<String,Object>();
        map.put("websiteName",website);
        map.put("time",time);
        map.put("flag",flag);
		if("1".equals(order)){
			map.put("order","asc");
		}else
		{
			map.put("order","desc");
		}
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

	@Override
	public List<HashMap> getWebsiteList() {
		return releaseNewsDao.getWebsiteList();
	}

	@Override
	public Boolean existWebsite(String website) {
        List<HashMap> websites=getWebsiteList();
        HashMap<String, Object> map1=new HashMap<String,Object>();
        map1.put("website",website);
		return websites.contains(map1);
	}
}
