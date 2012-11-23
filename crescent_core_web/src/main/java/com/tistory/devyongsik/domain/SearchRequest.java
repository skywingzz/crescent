package com.tistory.devyongsik.domain;

public class SearchRequest {

	@RequestParamName(name="col_name", defaultValue="sample")
	private String collectionName;
	
	@RequestParamName(name="keyword", defaultValue="")
	private String keyword;
	
	@RequestParamName(name="page_num", defaultValue="1")
	private String pageNum = "1";
	
	@RequestParamName(name="page_size", defaultValue="10")
	private String pageSize = "10";
	
	@RequestParamName(name="sort", defaultValue="")
	private String sort = "";
	
	@RequestParamName(name="search_field", defaultValue="")
	private String searchField = "";

	private String userIp = "";
	
	private String userId = "";
	
	private String pcId = "";
	
	
	
	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	@Override
	public String toString() {
		return "SearchRequest [collectionName=" + collectionName + ", keyword="
				+ keyword + ", pageNum=" + pageNum + ", pageSize="
				+ pageSize + ", sort=" + sort + ", searchField=" + searchField
				+ "]";
	}
	
	
}
