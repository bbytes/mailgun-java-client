package com.bbytes.mailgun.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.bbytes.mailgun.api.impl.AbstractTemplate;
import com.bbytes.mailgun.model.AccessLevel;
import com.bbytes.mailgun.model.MailingListMemberResponse;
import com.bbytes.mailgun.model.MailingListPageResponse;
import com.bbytes.mailgun.model.MailingListResponse;

public class MailingListTemplate extends AbstractTemplate implements MailingListOperations {

	public MailingListTemplate(RestOperations restOperations) {
		super(restOperations);
	}

	@Override
	public MailingListPageResponse getAllList(Integer limit) {
		MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
		paramMap.add("limit", limit.toString());
		return get("/lists/pages", paramMap, MailingListPageResponse.class);
	}

	@Override
	public MailingListPageResponse getList(String listAddress) {
		return get("/lists/" + listAddress, MailingListPageResponse.class);
	}

	@Override
	public MailingListPageResponse getMemberList(String listAddress, boolean subscribed, Integer limit) {
		MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
		paramMap.add("limit", limit.toString());
		paramMap.add("subscribed", getYesNo(subscribed));
		return get("/lists/" + listAddress + "/members/pages", paramMap, MailingListPageResponse.class);
	}

	@Override
	public MailingListMemberResponse getMember(String listAddress, String memberAddress) {
		return get("/lists/" + listAddress + "/members/"+memberAddress, MailingListMemberResponse.class);
	}

	@Override
	public MailingListMemberResponse addMember(String listAddress, String memberAddress, String vars,
			boolean subscribed, boolean upsert) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("address",memberAddress);
		paramMap.add("vars", vars);
		paramMap.add("upsert", getYesNo(upsert));
		paramMap.add("subscribed", getYesNo(subscribed));
		return post("/lists/"+listAddress+"/members", paramMap, MailingListMemberResponse.class);
	}

	@Override
	public MailingListMemberResponse addMembers(String listAddress, String memberAddressJson, boolean upsert) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("members",memberAddressJson);
		paramMap.add("upsert", getYesNo(upsert));
		return post("/lists/"+listAddress+"/members.json", paramMap, MailingListMemberResponse.class);
	}

	@Override
	public MailingListMemberResponse updateMember(String listAddress, String memberAddress, String vars,
			boolean subscribed, boolean upsert) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("vars", vars);
		paramMap.add("upsert", getYesNo(upsert));
		paramMap.add("subscribed", getYesNo(subscribed));
		put("/lists/"+listAddress+"/members/"+memberAddress, paramMap, MailingListMemberResponse.class);
		return null;
	}

	@Override
	public MailingListResponse createList(String listAddress, String name, String description, AccessLevel accessLevel) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("address", listAddress);
		paramMap.add("name", name);
		paramMap.add("description", description);
		paramMap.add("access_level", accessLevel.toString());
		return post("/lists", paramMap,MailingListResponse.class);
	}

	@Override
	public MailingListResponse createList(String listAddress, String name, String accessLevel) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("address", listAddress);
		paramMap.add("name", name);
		paramMap.add("access_level", accessLevel.toString());
		return post("/lists", paramMap,MailingListResponse.class);
	}

	@Override
	public MailingListResponse updateList(String listAddress, String name, String description, String accessLevel) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("address", listAddress);
		paramMap.add("name", name);
		paramMap.add("description", description);
		paramMap.add("access_level", accessLevel.toString());
		return put("/lists/"+listAddress, paramMap,MailingListResponse.class);
	}

	@Override
	public MailingListResponse updateList(String listAddress, String name, String accessLevel) {
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
		paramMap.add("address", listAddress);
		paramMap.add("name", name);
		paramMap.add("access_level", accessLevel.toString());
		return put("/lists/"+listAddress, paramMap,MailingListResponse.class);
	}

	@Override
	public void deleteList(String listAddress) {
		delete("/lists/"+listAddress);
	}

	@Override
	public void deleteMember(String listAddress, String memberAddress) {
		delete("/lists/"+listAddress+"/members/"+memberAddress);
	}

	private String getYesNo(boolean input) {
		if (input)
			return "yes";
		else
			return "no";
	}
}
