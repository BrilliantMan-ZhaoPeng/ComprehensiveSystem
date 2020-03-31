package com.zp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zp.pojo.PageCountry;
import com.zp.service.CountryService;
@Controller
@RequestMapping("country")
public class CountryConrtroller {
	@Autowired
	private CountryService countryService;
	@GetMapping
	@ResponseBody
	public ModelAndView toCountryPage(@RequestParam(value = "nowPage",defaultValue = "1")Integer nowPage,@RequestParam(value = "pageSize",defaultValue = "2")Integer pageSize,@RequestParam(value = "async",defaultValue = "true")boolean async,Model model) {
		   if(nowPage==null||pageSize==null){
	           nowPage=0;
	           pageSize=2;
			}
			PageCountry pageData = countryService.getPageData(nowPage, pageSize);
			model.addAttribute("pageData",pageData);
			return new ModelAndView(async==true?"body/country":"body/country::#containerId");
	}
}
