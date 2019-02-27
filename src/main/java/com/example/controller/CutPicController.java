package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ResultDTO;
import com.example.service.CutPicService;

@RestController
@RequestMapping(value = "/first")
public class CutPicController {

	@GetMapping(value = "/test") // @RequestParam(name="fileLocation",required =
									// true)String fileLocation
	public ResultDTO hello() throws Exception {
		return CutPicService.getResultDTO();
	}
}
