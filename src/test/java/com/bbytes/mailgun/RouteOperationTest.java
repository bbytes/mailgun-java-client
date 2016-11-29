package com.bbytes.mailgun;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

import com.bbytes.mailgun.api.RouteOperations;
import com.bbytes.mailgun.api.impl.MailgunClientException;
import com.bbytes.mailgun.client.MailgunClient;
import com.bbytes.mailgun.model.MailgunRouteResponse;
import com.bbytes.mailgun.model.MailgunRouteListResponse;

public class RouteOperationTest extends MailgunJavaClientApplicationTests {

	@Autowired
	Environment environment;

	MailgunClient client;

	String domain;

	@Before
	public void setup() {
		client = MailgunClient.create(environment.getProperty("mailgun.api.key"));
		domain = environment.getProperty("mailgun.domain");
	}

	@Test
	public void getAllRoutes() {
		RouteOperations routeOperations = client.roueOperations();
		MailgunRouteListResponse response = routeOperations.getAllRoutes(3, 0);
		Assert.isTrue(response.getTotalCount() > 0);
	}

	@Test
	public void getRoute() {
		RouteOperations routeOperations = client.roueOperations();
		MailgunRouteListResponse response = routeOperations.getAllRoutes(3, 0);
		MailgunRouteResponse mailgunRouteResponse = routeOperations
				.getRoute(response.getRoutes().get(0).getId());
		Assert.isTrue(!mailgunRouteResponse.getRoute().getId().isEmpty());

	}

	@Test
	public void createRoute() throws MailgunClientException {
		RouteOperations routeOperations = client.roueOperations();
		String domain = "recruiz.com";
		String fromDomain = "'.*@" + domain + "'";
		String filter = "match_recipient(" + fromDomain + ")";
		MailgunRouteResponse response = routeOperations.createRoute(0, "simple route",
				filter, "forward('http://myhost.com/messages/')");
		Assert.isTrue(!response.getRoute().getId().isEmpty());
	}

	@Test
	public void deleteRoute() throws MailgunClientException {
		RouteOperations routeOperations = client.roueOperations();
		MailgunRouteListResponse response = routeOperations.getAllRoutes(3, 0);
		MailgunRouteResponse mailgunRouteResponse = routeOperations
				.getRoute(response.getRoutes().get(0).getId());
		routeOperations.deleteRoute(mailgunRouteResponse.getRoute().getId());
	}
	


}
