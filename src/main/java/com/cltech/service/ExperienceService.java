package com.cltech.service;

import java.util.List;

import com.cltech.model.ExeperienceModel;

public interface ExperienceService {
	
	List<ExeperienceModel> getAllExperience();
	String saveExperience(ExeperienceModel experience_model);
	

}
