package com.qa.demo.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Converting Java into JSON

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GuitaristDTO {
	
//	D-
//	T-
//	O-
	
	private long id;
	private String name;
	private int noOfString;
	private String type;

}
