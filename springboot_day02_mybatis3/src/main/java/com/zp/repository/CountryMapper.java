package com.zp.repository;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.zp.pojo.Country;
import com.zp.vo.CountryVo;
import com.zp.vo.CountryVo2;
import com.zp.vo.SimpleCountryVo;
@Repository
@Mapper
public interface CountryMapper {
    int deleteByPrimaryKey(Integer countryId);
    int insert(Country record);
    int insertSelective(Country record);
    Country selectByPrimaryKey(Integer countryId);
    int updateByPrimaryKeySelective(Country record);
    int updateByPrimaryKey(Country record);
    //分页查询所有的数据
    List<CountryVo> selectAll(@PathParam("startIndex")Integer startIndex,@PathParam("pageSize")Integer pageSize);   
    //查询总的数据
    int selCount();
    //查询所有的简单的国家对象信息
    @Select("select country_id,country_name from m_country")
    List<SimpleCountryVo> selectSimpleCountryVo();
    //根据国家Id查询信息
    CountryVo2 selCountryNameAndCapitalNameByCountryId(Integer countryId);
}