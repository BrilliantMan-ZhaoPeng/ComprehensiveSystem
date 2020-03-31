package com.zp.pojo;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
public class PageUploadFile<T>{
        //当前的页面
 		public int nowPage;
 		//总的页数
 		public int totalPage;
 		//总的数据量
 		public int totalCount;
 		//存的数据
 		public List<T> datas;
		@Override
		public String toString() {
			return "PageUploadFile [nowPage=" + nowPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
					+ ", datas=" + datas + "]";
		}
		public PageUploadFile() {
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
		public List<T> getDatas() {
			return datas;
		}
		public void setDatas(List<T> datas) {
			this.datas = datas;
		}
}
