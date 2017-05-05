package com.hxqh.abb.common;

import java.util.List;

import org.springframework.data.domain.PageRequest;

public class Page {

	public int pageSize;

	public int pageNumber;

	public int totalCount = 0;
	
	public Page(PageRequest p, int totalCount) {
		this(p.getPageNumber(),p.getPageSize(),totalCount);
	}
	public Page() {
		 this.pageNumber=1;
		 this.pageSize = 1;
		 this.totalCount = 0;
	}
	

	
    public Page(int pageNumber2, int pageSize2, int totalCount2) {
		// TODO Auto-generated constructor stub
	}
    
    /**
     * 获取返回值的分页后的第一条数据
     */
    public int getfirstResultNumber(int pageNum , int pageSize){
    	int result = 0;
    	if(pageNum == 1){
    		return 0;
    	}
    	result = (pageNum - 1) * pageSize +1;
    	return result;
    }
    
    /**
     * 获取返回值的分页后的最后一条数据
     */
public int getlastResultNumber(int pageNum , int pageSize){
	int result = 0;
	if(pageNum == 1){
		return pageSize;
	}
	
	result = pageNum * pageSize;
	
	return result;
    }
    

	/**
     * 是否是首页（第一页），第一页页码为1
     *
     * @return 首页标识
     */
	public boolean isFirstPage() {
		return getThisPageNumber() == 1;
	}

    /**
     * 是否是最后一页
     *
     * @return 末页标识
     */
	public boolean isLastPage() {
		return getThisPageNumber() >= getLastPageNumber();
	}
    /**
     * 是否有下一页
     *
     * @return 下一页标识
     */
	public boolean isHasNextPage() {
		return getLastPageNumber() > getThisPageNumber();
	}
    /**
     * 是否有上一页
     *
     * @return 上一页标识
     */
	public boolean isHasPreviousPage() {
		return getThisPageNumber() > 1;
	}
    /**
     * 获取最后一页页码，也就是总页数
     *
     * @return 最后一页页码
     */
	public int getLastPageNumber() {
		return PageUtils.computeLastPageNumber(totalCount, pageSize);
	}
    /**
     * 总的数据条目数量，0表示没有数据
     *
     * @return 总数量
     */
	public int getTotalCount() {
		return totalCount;
	}
    /**
     * 获取当前页的首条数据的行编码
     *
     * @return 当前页的首条数据的行编码
     */
	public int getThisPageFirstElementNumber() {
		return (getThisPageNumber() - 1) * getPageSize() + 1;
	}
    /**
     * 获取当前页的末条数据的行编码
     *
     * @return 当前页的末条数据的行编码
     */
	public int getThisPageLastElementNumber() {
		int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
		return getTotalCount() < fullPage ? getTotalCount() : fullPage;
	}
    /**
     * 获取下一页编码
     *
     * @return 下一页编码
     */
	public int getNextPageNumber() {
		return getThisPageNumber() + 1;
	}
    /**
     * 获取上一页编码
     *
     * @return 上一页编码
     */
	public int getPreviousPageNumber() {
		return getThisPageNumber() - 1;
	}
    /**
     * 每一页显示的条目数
     *
     * @return 每一页显示的条目数
     */
	public int getPageSize() {
		return pageSize;
	}
    /**
     * 当前页的页码
     *
     * @return 当前页的页码
     */
	public int getThisPageNumber() {
		return pageNumber;
	}

    /**
     * 得到用于多页跳转的页码
     * @return
     */
	public List<Integer> getLinkPageNumbers() {
		return PageUtils.generateLinkPageNumbers(getThisPageNumber(), getLastPageNumber(),10);
	}
	

}