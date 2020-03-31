package com.zp.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.postprocessor.IPostProcessor;

import com.zp.pojo.PageUploadFile;
import com.zp.pojo.UploadFile;
import com.zp.repository.UploadFileMapper;
import com.zp.vo.ResultVo;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForImplementation;
@Service
@PropertySource("classpath:application.properties")
public class UploadFileService {
	@Value(value = "${files.savePath}")
	private String SAVE_PATH;////存文件的文件夹
	@Autowired
    private UploadFileMapper uploadFileMapper;
	
 	public PageUploadFile<UploadFile> selAll(Integer nowPage,Integer pageSize){
        PageUploadFile<UploadFile> page=new PageUploadFile<UploadFile>();
        page.setNowPage(nowPage);
        Integer totalCount = uploadFileMapper.selFileCount();
        page.setTotalCount(totalCount);
        page.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
        List<UploadFile> selAll = uploadFileMapper.selAll((nowPage-1)*pageSize, pageSize);
        page.setDatas(selAll);
 		return page;
	}
	
	public ResultVo uploadFile(MultipartFile[] file,String description) {
		int fail=0;
	 	for(MultipartFile multipartFile : file) {
	 		if(multipartFile.isEmpty()){
	 			fail++;
	 			continue;
	 		}
			String fileName=multipartFile.getOriginalFilename();
			String destFileName=SAVE_PATH+File.separator+fileName;//保存文件的地址
			File destFile=new File(destFileName);
			List<UploadFile> selFileByName = uploadFileMapper.selFileByName(fileName);
			try {
				if(null==selFileByName||selFileByName.size()==0){
					UploadFile fileData=new UploadFile();
					fileData.setCreateTime(new Date());
					fileData.setFileDescription(description);
					fileData.setFileName(fileName);
					fileData.setFileSize((multipartFile.getSize()/1024.00)+"");
					fileData.setFileUrl(destFileName);
					fileData.setUploadCount(0);
					////法一
					multipartFile.transferTo(destFile);//写入到磁盘中
					
					//////////法2
//					InputStream is = multipartFile.getInputStream();
//					FileOutputStream os=new FileOutputStream(destFile);
//					byte[]flush=new byte[1024];
//					int len=is.read(flush);
//					while(-1!=len){
//						os.write(flush,0,len);
//						len=is.read(flush);
//					}
//					os.flush();
					
					
					
					
					
					// 使用工具类Files来上传文件  法3
					//byte[] bytes = multipartFile.getBytes();
					//Path path = Paths.get(destFileName);
					//Files.write(path, bytes);
					uploadFileMapper.insertSelective(fileData);//写入到数据库中
				}else {
					return new ResultVo(false,"已存在名为"+fileName+"的文件,请选择其它文件上传！！！");
				}
			} catch (Exception e) {
				return new ResultVo(false,"上传失败，请稍后重试！！！");
			}
		}
	 	if(fail<file.length){
	 		return new ResultVo(true,"文件上传成功"+(file.length-fail)+"个,失败"+fail+"个");
	 	}else if(fail==file.length){
	 		return new ResultVo(false,"文件上传失败,文件不能为空！！！");
	 	}
		return null;
	}
	
	
	public int updateFileByfileId(Integer fileId) {
		UploadFile file=new UploadFile();
		file.setFileId(fileId);
		file.setUploadCount(0);
	     int updateByPrimaryKeySelective = uploadFileMapper.updateByPrimaryKeySelective(file);	  
	     return updateByPrimaryKeySelective;
	}
}
