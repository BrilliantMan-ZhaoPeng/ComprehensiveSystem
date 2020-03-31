package com.zp.pojo;
import java.util.List;
import com.zp.vo.CountryVo;
public class PageCountry {
	//当前的页面
	public int nowPage;
	//总的页数
	public int totalPage;
	//总的数据量
	public int totalCount;
	//存的数据
	public List<CountryVo> countrys;
	@Override
	public String toString() {
		return "PageCountry [nowPage=" + nowPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", countrys=" + countrys + "]";
	}
	public PageCountry() {
		super();
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<CountryVo> getCountrys() {
		return countrys;
	}
	public void setCountrys(List<CountryVo> countrys) {
		this.countrys = countrys;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//同时设置总的页数
	}
}
