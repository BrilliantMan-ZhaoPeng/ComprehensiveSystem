package com.zp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pojo.Country;
import com.zp.pojo.PageCountry;
import com.zp.repository.CountryMapper;
import com.zp.vo.CountryVo;
@Service
public class CountryService {
	@Autowired
    private CountryMapper countryMapper;
	public Country getCountryById(Integer countryId) {
		return countryMapper.selectByPrimaryKey(countryId);
	}
	
	public PageCountry getPageData(Integer nowPage,Integer pageSize) {
		PageCountry pageCountry=new PageCountry();
		pageCountry.setNowPage(nowPage);//设置当前的页数
		int totalCount = countryMapper.selCount();
		pageCountry.setTotalCount(totalCount);//设置总的数据量
		pageCountry.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1);//设置总的页数
		List<CountryVo> selectAll = countryMapper.selectAll((nowPage-1)*pageSize, pageSize);
		pageCountry.setCountrys(selectAll);
		return pageCountry;
	}
}
