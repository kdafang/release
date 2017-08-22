package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.ReleaseNewsEntity;
import io.renren.service.ReleaseNewsService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-13 19:42:04
 */
@RestController
@RequestMapping("releasenews")
public class ReleaseNewsController {
	@Autowired
	private ReleaseNewsService releaseNewsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("releasenews:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ReleaseNewsEntity> releaseNewsList = releaseNewsService.queryList(query);
		int total = releaseNewsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(releaseNewsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("releasenews:info")
	public R info(@PathVariable("id") Integer id){
		ReleaseNewsEntity releaseNews = releaseNewsService.queryObject(id);
		
		return R.ok().put("releaseNews", releaseNews);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("releasenews:save")
	public R save(@RequestBody ReleaseNewsEntity releaseNews){
		releaseNewsService.save(releaseNews);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("releasenews:update")
	public R update(@RequestBody ReleaseNewsEntity releaseNews){
		releaseNewsService.update(releaseNews);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("releasenews:delete")
	public R delete(@RequestBody Integer[] ids){
		releaseNewsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
