package com.zp.controller;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.zp.pojo.PageUploadFile;
import com.zp.pojo.UploadFile;
import com.zp.service.UploadFileService;
import com.zp.vo.ResultVo;
@Controller
@RequestMapping("file")
@PropertySource("classpath:application.properties")
public class UploadFileController {
	@Autowired
	private UploadFileService uploadFileService;
	//跳转到文件下载页面
	@Value(value = "${files.savePath}")
	private String SAVE_PATH;////存文件的文件夹
	@GetMapping
	public ModelAndView toUploadFilePage(Model model,@RequestParam(value = "nowPage",defaultValue = "1")Integer nowPage,@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,@RequestParam(value = "async",defaultValue = "true")boolean async) {
        PageUploadFile<UploadFile> selAll = uploadFileService.selAll(nowPage, pageSize);
		model.addAttribute("pageData",selAll);
		return new ModelAndView(async==true?"body/file":"body/file::#maincontainerId");
	}
	
	
	//上传
	@PostMapping(value = "/upload",consumes = "multipart/form-data")
	@ResponseBody
	public ResultVo uploadFile(@RequestParam("file")MultipartFile[] file,@RequestParam("description")String description){
		return uploadFileService.uploadFile(file, description);
	}
	
	
	@Transactional//事务的处理
	@GetMapping("/download")
	public Object downloadFile(@RequestParam("fileName")String fileName,@RequestParam("fileId")Integer fileId,Model model){
	    try {
	    	Resource resource=new UrlResource(Paths.get(SAVE_PATH+File.separator+fileName).toUri());
			if(resource.exists()&&resource.isReadable()){
				uploadFileService.updateFileByfileId(fileId);/////修改数据库的下载次数
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_TYPE,"application/octet-stream")
						.header(HttpHeaders.CONTENT_DISPOSITION,String.format("attachment;filename=\"%s\"",fileName))
						.body(resource);
			}else {
				model.addAttribute("errorMsg","该文件不存在");
				return "error";
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg","服务器繁忙，请稍后重试！！！");
			return "error";
		}
	}
	
	
	
	
	/*
	
	@Transactional//事务的处理
	@GetMapping("/download")
	public Object downloadFile2(@RequestParam("fileName")String fileName,@RequestParam("fileId")Integer fileId,Model model,HttpServletResponse response){
		String filePath=SAVE_PATH+File.separator+fileName;
		File downloadFile=new File(filePath);
		if(downloadFile.exists()) {
			response.setContentType("application/octet-stream");
			response.setContentLength((int)downloadFile.length());
			response.setHeader(HttpHeaders.CONTENT_TYPE,String.format("attachment;filename=\"%s\"",fileName));
			byte[] buffer=new byte[1024];
			FileInputStream fis=null;
			BufferedInputStream bis=null;
			try {
				fis=new FileInputStream(downloadFile);
				bis=new BufferedInputStream(fis);
				OutputStream os = response.getOutputStream();
				int i=bis.read(buffer);
				while(i!=-1){
					os.write(buffer,0,i);
					i=bis.read(buffer);
				}
			} catch (Exception e) {
				
			}
	  }
		return null;
	}
	
	
	
	
	@RequestMapping("/download2")
	public void downloadFile2(HttpServletRequest request, 
			HttpServletResponse response, @RequestParam String fileName) {
		String filePath = "D:/upload" + File.separator + fileName;
		File downloadFile = new File(filePath);
		try {
			if (downloadFile.exists()) {
				response.setContentType("application/octet-stream");
				response.setContentLength((int)downloadFile.length());
				response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
						String.format("attachment; filename=\"%s\"", fileName));
				InputStream is = new FileInputStream(downloadFile);
				IOUtils.copy(is, response.getOutputStream());
				response.flushBuffer();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
