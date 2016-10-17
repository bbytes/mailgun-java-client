package com.bbytes.mailgun.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.bbytes.mailgun.api.RouteOperations;
import com.bbytes.mailgun.model.MailgunRouteResponse;
import com.bbytes.mailgun.model.MailgunRouteListResponse;

public class RouteTemplate extends AbstractTemplate implements RouteOperations {

	public RouteTemplate(RestOperations restOperations) {
		super(restOperations);
	}

	@Override
	public MailgunRouteListResponse getAllRoutes(Integer limit, Integer skip) {
		MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
		paramMap.add("limit", limit.toString());
		paramMap.add("skip", skip.toString());
		return get("/routes", paramMap, MailgunRouteListResponse.class);
	}

	@Override
	public MailgunRouteResponse getRoute(String routeId) {
		return get("/routes/" + routeId, MailgunRouteResponse.class);
	}

	@Override
	public MailgunRouteResponse createRoute(Integer priority, String description, String expression, String... action) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("priority", priority.toString());
		paramMap.add("description", description);
		paramMap.add("expression", expression);
		for (int i = 0; i < action.length; i++) {
			paramMap.add("action", action[i]);
		}
		
		return post("/routes", paramMap, MailgunRouteResponse.class);
	}

	@Override
	public MailgunRouteResponse updateRoute(String routeId, Integer priority, String description, String expression, String action) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("priority", priority.toString());
		paramMap.add("description", description);
		paramMap.add("expression", expression);
		paramMap.add("action", action);
		return put("/routes", paramMap, MailgunRouteResponse.class);
	}

	@Override
	public void deleteRoute(String routeId) {
		delete("/routes/" + routeId);
	}

}
