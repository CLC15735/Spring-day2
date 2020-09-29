package com.qa.demo.utils;

import org.springframework.beans.BeanUtils;

import lombok.NoArgsConstructor;

@NoArgsConstructor 
//Generates an empty constructor
public class DemoBeanUtils {
	
	public static void mergeObject(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}

}
