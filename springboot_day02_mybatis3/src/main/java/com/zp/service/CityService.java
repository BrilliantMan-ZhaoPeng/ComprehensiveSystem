package com.zp.service;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pojo.City;
import com.zp.pojo.PageCity;
import com.zp.repository.CityMapper;
import com.zp.repository.CountryMapper;
import com.zp.vo.CityVo;
import com.zp.vo.CountryVo2;
import com.zp.vo.ResultVo;
import com.zp.vo.SimpleCountryVo;
@Service
public class CityService {
	@Autowired
    private CityMapper cityMapper;
	@Autowired
	private CountryMapper countryMapper;
	//分页业务类的实现
	public PageCity getPageData(Integer nowPage,Integer pageSize,Integer countryId,String keyword,String sort) {
		keyword="%"+keyword+"%";
		PageCity pageCity=new PageCity();
		pageCity.setNowPage(nowPage);//设置当前的页数
		int totalCount = cityMapper.selCountByCountryId(countryId,keyword);
		pageCity.setTotalCount(totalCount);//设置总的数据量
		pageCity.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1);//设置总的页数
		List<City> cities = cityMapper.selCityByCountryId(countryId, (nowPage-1)*pageSize, pageSize,keyword,sort);
		pageCity.setCities(cities);//设置城市信息
		pageCity.setCountry(countryMapper.selectByPrimaryKey(countryId));
		return pageCity;
	}
	
	//根据id删除城市
	public boolean delCityById(Integer cityId) {
		try {
			cityMapper.deleteByPrimaryKey(cityId);
			return true;		
		} catch (Exception e) {
			return false;
		}
	}
	
	//修改需求
	public CityVo selCityVo(Integer cityId) {
		CityVo cityVo=new CityVo();
		List<SimpleCountryVo> countrys = countryMapper.selectSimpleCountryVo();
		cityVo.setCountrys(countrys);
		if(cityId==null) {
            cityVo.setCity(new City(null,null,null,null,null,null,null,new Date()));                			
		}else {
			City selectByPrimaryKey = cityMapper.selectByPrimaryKey(cityId);
			cityVo.setCity(selectByPrimaryKey);
		}
		return cityVo;
	}
	
	
	public ResultVo addEdit(City city) {
		city.setDateModified(new Date());
			if(null==city.getCityId()) {//执行增加
               city.setDateCreated(new Date());				
               cityMapper.insertSelective(city);
               return new ResultVo(true,"增加或修改成功！！！");
			}else {//执行修改
			   cityMapper.updateByPrimaryKeySelective(city);
			   return new ResultVo(true,"增加或修改成功！！！");
			}
    }
	
	
	public CountryVo2 getCountryVo2(Integer countryId) {
		CountryVo2 selCountryNameAndCapitalNameByCountryId = countryMapper.selCountryNameAndCapitalNameByCountryId(countryId);
		return selCountryNameAndCapitalNameByCountryId;
	}
}

