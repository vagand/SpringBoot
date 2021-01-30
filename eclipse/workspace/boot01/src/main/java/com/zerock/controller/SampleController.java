package com.zerock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerock.domain.SampleVO;

@RestController
public class SampleController {
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello World";
	}
	
	@GetMapping("/sample")
	public SampleVO makeSample()
	{
		SampleVO vo = new SampleVO();
		vo.setVal1("v1");
		vo.setVal1("v2");
		vo.setVal1("v3");
		
		System.out.println(vo);
		return vo;
	}
}
