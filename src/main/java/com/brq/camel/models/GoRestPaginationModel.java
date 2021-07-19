package com.brq.camel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoRestPaginationModel {
	private int total;
	private int pages;
	private int page;
	private int limit;
	private GoRestLinkModel links;
}
