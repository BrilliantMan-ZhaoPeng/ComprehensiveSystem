package com.zp.pojo;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
public class City {
	   private Integer cityId;
	   @NotBlank(message = "cityName不能为空")
	   @Length(min = 1,max = 20,message = "cityName长度必须为1~20")
	   private String cityName;
	   @NotBlank(message = "localCityName不能为空")
	   @Length(min = 1,max = 20,message = "localCityName长度必须为1~20")
	   private String localCityName;
	   private Integer countryId;
	   @NotBlank(message = "描述不能为空")
	   @Length(min=1,max = 200,message = "district长度必须为1~200")
	   private String district;
	   private String population;
	   private Date dateModified;
	   private Date dateCreated;
	public City(Integer cityId, String cityName, String localCityName, Integer countryId, String district,
			String population, Date dateModified, Date dateCreated) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.localCityName = localCityName;
		this.countryId = countryId;
		this.district = district;
		this.population = population;
		this.dateModified = dateModified;
		this.dateCreated = dateCreated;
	}
	public City() {
		super();
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", localCityName=" + localCityName + ", countryId="
				+ countryId + ", district=" + district + ", population=" + population + ", dateModified=" + dateModified
				+ ", dateCreate=" + dateCreated + "]";
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLocalCityName() {
		return localCityName;
	}
	public void setLocalCityName(String localCityName) {
		this.localCityName = localCityName;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}