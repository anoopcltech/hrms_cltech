package com.cltech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.model.ExeperienceModel;
import com.cltech.service.ExperienceService;

@RestController
@RequestMapping("/cltech")
public class ExperienceController {
	
	ExperienceService experienceService;

	public ExperienceService getExperienceService() {
		return experienceService;
	}
	@Autowired(required=true)
	public void setExperienceService(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@GetMapping("/experience")
	public List<ExeperienceModel> getExperience() {
		//experienceService.getAllExperience();
		return experienceService.getAllExperience();
	}
	@PostMapping("/saveexperience")
	public String saveExperience (@RequestBody ExeperienceModel  e ) { 
		
		return    experienceService.saveExperience(e);
	}
	
	
}
