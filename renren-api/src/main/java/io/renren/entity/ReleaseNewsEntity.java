package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-15 17:04:09
 */
public class ReleaseNewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//网站标识
	private String website;
	//发布时间
	private String releaseTime;
	//修改时间
	private String modifiedTime;
	//新闻标题
	private String newsTitle;
	//新闻链接
	private String newsUrl;
	//编辑
	private String editor;
	//来源
	private String source;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：网站标识
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * 获取：网站标识
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * 设置：发布时间
	 */
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * 获取：发布时间
	 */
	public String getReleaseTime() {
		return releaseTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	/**
	 * 获取：修改时间
	 */
	public String getModifiedTime() {
		return modifiedTime;
	}
	/**
	 * 设置：新闻标题
	 */
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	/**
	 * 获取：新闻标题
	 */
	public String getNewsTitle() {
		return newsTitle;
	}
	/**
	 * 设置：新闻链接
	 */
	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}
	/**
	 * 获取：新闻链接
	 */
	public String getNewsUrl() {
		return newsUrl;
	}
	/**
	 * 设置：编辑
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	/**
	 * 获取：编辑
	 */
	public String getEditor() {
		return editor;
	}
	/**
	 * 设置：来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：来源
	 */
	public String getSource() {
		return source;
	}
}
