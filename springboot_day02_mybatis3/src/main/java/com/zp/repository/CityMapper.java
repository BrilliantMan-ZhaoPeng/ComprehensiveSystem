package com.zp.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.zp.pojo.City;
@Repository
@Mapper
public interface CityMapper {
    int deleteByPrimaryKey(Integer fileId);
    int insert(City record);
    int insertSelective(City record);
    City selectByPrimaryKey(Integer fileId);
    int updateByPrimaryKeySelective(City record);
    int updateByPrimaryKey(City record);
	int selCountByCountryId(Integer countryId, String keyword);
	List<City> selCityByCountryId(Integer countryId,Integer startIndex, Integer pageSize, String keyword, String sort);
}