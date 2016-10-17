package com.bbytes.mailgun.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.bbytes.mailgun.api.RouteOperations;
import com.bbytes.mailgun.model.MailgunDetailRouteResponse;
import com.bbytes.mailgun.model.MailgunRouteResponse;

public class RouteTemplate extends AbstractTemplate implements RouteOperations {

	public RouteTemplate(RestOperations restOperations) {
		super(restOperations);
	}

	@Override
	public MailgunRouteResponse getAllRoutes(Integer limit, Integer skip) {
		MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
		paramMap.add("limit", limit.toString());
		paramMap.add("skip", skip.toString());
		return get("/routes", paramMap, MailgunRouteResponse.class);
	}

	@Override
	public MailgunDetailRouteResponse getRoute(String routeId) {
		return get("/routes/" + routeId, MailgunDetailRouteResponse.class);
	}

	@Override
	public MailgunDetailRouteResponse createRoute(Integer priority, String description, String expression, String... action) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("priority", priority.toString());
		paramMap.add("description", description);
		paramMap.add("expression", expression);
		for (int i = 0; i < action.length; i++) {
			paramMap.add("action", action[i]);
		}
		
		return post("/routes", paramMap, MailgunDetailRouteResponse.class);
	}

	@Override
	public MailgunDetailRouteResponse updateRoute(String routeId, Integer priority, String description, String expression, String action) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("priority", priority.toString());
		paramMap.add("description", description);
		paramMap.add("expression", expression);
		paramMap.add("action", action);
		return put("/routes", paramMap, MailgunDetailRouteResponse.class);
	}

	@Override
	public void deleteRoute(String routeId) {
		delete("/routes/" + routeId);
	}

}
