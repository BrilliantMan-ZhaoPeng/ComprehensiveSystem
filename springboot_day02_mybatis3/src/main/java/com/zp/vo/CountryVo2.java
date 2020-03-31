package com.zp.vo;
public class CountryVo2 {
	private String countryName;
	private String capitalName;

	@Override
	public String toString() {
		return "CountryVo2 [countryName=" + countryName + ", capitalName=" + capitalName + "]";
	}

	public CountryVo2() {
		super();
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapitalName() {
		return capitalName;
	}

	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

}
