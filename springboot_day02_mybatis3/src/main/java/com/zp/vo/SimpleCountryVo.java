package com.zp.vo;

public class SimpleCountryVo {
	
	    private Integer countryId;
	    
	    private String countryName;
	    
		@Override
		public String toString() {
			return "SimpleCountryVo [countryId=" + countryId + ", countryName=" + countryName + "]";
		}
		public SimpleCountryVo() {
			super();
		}
		public Integer getCountryId() {
			return countryId;
		}
		public void setCountryId(Integer countryId) {
			this.countryId = countryId;
		}
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
}
