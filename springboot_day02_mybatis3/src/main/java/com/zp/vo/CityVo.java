package com.zp.vo;
import java.util.Date;
import java.util.List;
import com.zp.pojo.City;
public class CityVo {
	    private City city;
	    private List<SimpleCountryVo> countrys;
		@Override
		public String toString() {
			return "CityVo [city=" + city + ", countrys=" + countrys + "]";
		}
		public CityVo() {
			super();
		}
		public City getCity() {
			return city;
		}
		public void setCity(City city) {
			this.city = city;
		}
		public List<SimpleCountryVo> getCountrys() {
			return countrys;
		}
		public void setCountrys(List<SimpleCountryVo> countrys) {
			this.countrys = countrys;
		}
}

