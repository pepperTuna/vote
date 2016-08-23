package com.vote.domain;

public class PageMaker {
	private int page;
	private int pageWidth;
	private int perPageNum;
	private String writer;
	private int totalCount;
	private int startPage;
	private int endPage;
	private int pageListNo;
	private int totalEndPageNo;
	private int limitStart;
	private int limitEnd;

	public PageMaker(){
		this.page = 1;
		this.pageWidth = 10;
		this.perPageNum = 10;
		this.totalCount = 1;
		this.pageListNo = 1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageListNo() {
		return pageListNo;
	}

	public void setPageListNo(int pageListNo) {
		this.pageListNo = pageListNo;
	}

	public int getLimitStart() {
		return limitStart;
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	public int getLimitEnd() {
		return limitEnd;
	}

	public void setLimitEnd(int limitEnd) {
		this.limitEnd = limitEnd;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageWidth() {
		return pageWidth;
	}

	public void setPageWidth(int pageWidth) {
		this.pageWidth = pageWidth;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getTotalEndPageNo() {
		return totalEndPageNo;
	}

	public void setTotalEndPageNo(int totalEndPageNo) {
		this.totalEndPageNo = totalEndPageNo;
	}

	public void makePagingInfo(){
		calcVoteNoForLimit();
		calcPageList();   
	}

	private void calcVoteNoForLimit(){
		int page = this.getPage();
		int perPage = this.getPerPageNum();

		this.setLimitStart((page-1)*perPage + 1);
		this.setLimitEnd(page*perPage);
	}

	private void calcPageList(){
		int totalPageCount = this.getTotalCount() /this.getPerPageNum();
		int totalPageListNo = totalPageCount / this.getPageWidth();
		this.setTotalEndPageNo(totalPageCount);

		for (int i = 1; i <= totalPageListNo; i++) {
			int temp = (this.getPageWidth() * i) - this.getPage();
			temp = temp<0 ? (temp*-1) : temp;
			if(this.getPageWidth() > temp){
				this.setStartPage((this.getPageWidth() * (i-1)) + 1 );
				this.setEndPage(this.getPageWidth() * i);
				this.setPageListNo(i);
			}
		}
	}
}