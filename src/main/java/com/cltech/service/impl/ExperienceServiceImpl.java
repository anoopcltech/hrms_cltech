package com.cltech.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cltech.model.ExeperienceModel;
import com.cltech.model.ResponseBean;
import com.cltech.model.Status;
import com.cltech.repository.ExperienceModelRepository;
import com.cltech.service.ExperienceService;
import com.cltech.service.PropertyService;

@Service
public class ExperienceServiceImpl implements ExperienceService{

	@Autowired
	@Qualifier("propertyServiceImpl")
	protected PropertyService propertyService;

	private static Logger LOGGER = LogManager.getLogger(ExperienceServiceImpl.class);
	@Autowired
	ExperienceModelRepository experienceModelRepository;
	@Override
	public List<ExeperienceModel> getAllExperience() {
		// TODO Auto-generated method stub
		return experienceModelRepository.findAll();
	}

	@Override
	public String saveExperience(ExeperienceModel experience_model) {
		// TODO Auto-generated method stub
		try {
			//propertyService.getAppProperty(GlobalConstant.ALLOWED_DECIMAL_POINTS);
			if (experience_model == null) {
				return ResponseBean.builder(Status.FAIL, "Data Is Null", experience_model);
			}
			
			ExeperienceModel employeeBean = experienceModelRepository.save(experience_model);
			
			return ResponseBean.builder(Status.SUCCESS, "Record Added Succesfully", experience_model);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);	
			return ResponseBean.builder(Status.FAIL, "Something Went Wrong", experience_model);
		}
		
		
	}

}
