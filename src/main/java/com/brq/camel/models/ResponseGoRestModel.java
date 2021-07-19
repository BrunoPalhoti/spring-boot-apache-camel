package com.brq.camel.models;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ResponseGoRestModel {
	private GoRestMetaModel meta;
	private ArrayList<GoRestDataModel> data;
	
	
}
