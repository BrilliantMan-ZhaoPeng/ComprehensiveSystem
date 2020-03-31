package com.zp.vo;
import java.util.Date;
public class CountryVo {
     private Integer countryId;
     private String countryName;
     private String capitalCityName;
     private Date dateModified;
     private String continent;
     private String region;
     private Integer population;
	@Override
	public String toString() {
		return "CountryVo [countryId=" + countryId + ", countryName=" + countryName + ", capitalCityName="
				+ capitalCityName + ", dateModified=" + dateModified + ", continent=" + continent + ", region=" + region
				+ ", population=" + population + "]";
	}
	public CountryVo() {
		super();
	}
	public String getCapitalCityName() {
		return capitalCityName;
	}

	public void setCapitalCityName(String capitalCityName) {
		this.capitalCityName = capitalCityName;
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
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
}
