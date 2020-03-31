package com.zp.repository;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.zp.pojo.UploadFile;
@Mapper
@Repository
public interface UploadFileMapper {
    int deleteByPrimaryKey(Integer fileId);
    int insert(UploadFile record);
    int insertSelective(UploadFile record);
    UploadFile selectByPrimaryKey(Integer fileId);
    int updateByPrimaryKey(UploadFile record);
    //查询所有的文件信息
    List<UploadFile> selAll(@PathParam("startIndx")Integer startIndex,@PathParam("pageSize")Integer pageSize);
    //根据名字查询文件
    List<UploadFile> selFileByName(String fileName);
    //查询总的数据量
    Integer selFileCount();
    //修改值
    int updateByPrimaryKeySelective(UploadFile record);
}