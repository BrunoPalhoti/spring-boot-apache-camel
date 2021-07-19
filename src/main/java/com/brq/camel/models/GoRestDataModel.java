package com.brq.camel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoRestDataModel {

	private int 	id;
	private String 	name;
	private String 	email;
	private String  gender;
	private String 	status;
	
}
