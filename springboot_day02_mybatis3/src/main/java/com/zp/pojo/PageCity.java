package com.zp.pojo;
import java.util.List;
public class PageCity {
	    //当前的页面
		public int nowPage;
		//总的页数
		public int totalPage;
		//总的数据量
		public int totalCount;
		//存的数据
		public List<City> cities;
		
		//存的城市信息
        public Country country;
        
		@Override
		public String toString() {
			return "PageCity [nowPage=" + nowPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
					+ ", cities=" + cities + ", country=" + country + "]";
		}
		public PageCity() {
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
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		public List<City> getCities() {
			return cities;
		}
		public void setCities(List<City> cities) {
			this.cities = cities;
		}
		public Country getCountry() {
			return country;
		}
		public void setCountry(Country country) {
			this.country = country;
		}
}
