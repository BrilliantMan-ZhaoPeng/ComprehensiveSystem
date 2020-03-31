package com.zp.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zp.pojo.City;
import com.zp.pojo.PageCity;
import com.zp.service.CityService;
import com.zp.vo.CityVo;
import com.zp.vo.ResultVo;
@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CityService cityService;
	@RequestMapping(value = "/{countryId}",method = RequestMethod.GET)
	@ResponseBody
    public ModelAndView toCity(@PathVariable("countryId")Integer countryId,@RequestParam(value = "nowPage",defaultValue = "1")Integer nowPage,@RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
    		@RequestParam(value = "keyword",defaultValue = "")String keyword,@RequestParam(value = "sort",defaultValue = "DESC")String sort,@RequestParam(value = "async",defaultValue = "true")boolean async,
    		Model model){
        PageCity pageData = cityService.getPageData(nowPage, pageSize, countryId,keyword,sort);		
		model.addAttribute("pageData",pageData);
		model.addAttribute("countryData",cityService.getCountryVo2(countryId));
    	return new ModelAndView(async==true?"body/city":"body/city::#containerId");
    }

	
	
	@ResponseBody
	@DeleteMapping("/{cityId}")
	public boolean delCity(@PathVariable("cityId")Integer cityId) {
		return cityService.delCityById(cityId);
	}
	
	//跳转到编辑页面
	@RequestMapping("/edit")
	public ModelAndView toEditView(Model model,@RequestParam("cityId")Integer cityId) {
		CityVo selCityVo = cityService.selCityVo(cityId);
		model.addAttribute("cityVo",selCityVo);
		return new ModelAndView("body/cityedit","modelData",model);
	}
	
	
	//跳转到编辑页面
	@RequestMapping("/add")
	public ModelAndView toaddView(Model model) {
		CityVo selCityVo = cityService.selCityVo(null);
		model.addAttribute("cityVo",selCityVo);
		return new ModelAndView("body/cityedit","modelData",model);
	}
	
	//控制增加或修改,,,,,,实现city的表单校验
	@ResponseBody
	@RequestMapping(value = "/add",produces = "application/json;charset=utf-8")
	public ResultVo  addEdit(@Valid @ModelAttribute City city) {
   	/*	if(bindingResult.hasErrors()) {
			//获取所有字段参数不匹配的参数集合
			 List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			 return new ResultVo(false,fieldErrors.get(0).getDefaultMessage());
		}
		*/
		return cityService.addEdit(city);
	}
}
