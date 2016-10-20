package com.bbytes.mailgun.api;

import com.bbytes.mailgun.model.AccessLevel;
import com.bbytes.mailgun.model.MailingListMemberResponse;
import com.bbytes.mailgun.model.MailingListPageResponse;
import com.bbytes.mailgun.model.MailingListResponse;

public interface MailingListOperations {


	MailingListPageResponse getAllList(Integer limit);

	MailingListPageResponse getList(String listAddress);
	
	/**
	 * subscribed	yes to lists subsribed, no for unsubscribed. list all if not setlimit	
	 * Maximum number of records to return (optional: 100 by default)
	 * @param listAddress
	 * @return
	 */
	MailingListPageResponse getMemberList(String listAddress,  boolean subscribed , Integer limit);
	
	MailingListMemberResponse getMember(String listAddress, String memberAddress);
	
	/**
	 * address	Valid email address specification, e.g. Alice <alice@example.com> or just alice@example.com
	 * name	Optional member name 
	 * vars	JSON-encoded dictionary string with arbitrary parameters, e.g. {"gender":"female","age":27}
	 * subscribed	yes to add as subscribed (default), no as unsubscribed
	 * upsert yes to update member if present, no to raise error in case of a duplicate member (default)
	 * @param address
	 * @return
	 */
	MailingListMemberResponse addMember(String listAddress,String memberAddress, String vars, boolean subscribed, boolean upsert);
	
	MailingListMemberResponse addMembers(String listAddress,String memberAddressJson, boolean upsert);
	
	MailingListMemberResponse updateMember(String listAddress,String memberAddress, String vars, boolean subscribed, boolean upsert);

	/**
	 * address	A valid email address for the mailing list, e.g. developers@mailgun.net, or Developers <devs@mg.net>
	 * name	Mailing list name, e.g. Developers (optional)
	 * description	A description (optional)
	 * access_level	List access level, one of: readonly (default), members, everyone
	 */
	MailingListResponse createList(String listAddress, String name, String description, AccessLevel accessLevel);
	
	MailingListResponse createList(String listAddress, String name, String accessLevel);

	/**
	 * address	New mailing list address, e.g. devs@mg.net (optional)
	 * name	New name, e.g. My newsletter (optional)
	 * access_level	List access level, one of: readonly (default), members, everyone
	 */
	MailingListResponse updateList(String listAddress, String name, String description, String accessLevel);
	
	/**
	 * address	New mailing list address, e.g. devs@mg.net (optional)
	 * name	New name, e.g. My newsletter (optional)
	 * access_level	List access level, one of: readonly (default), members, everyone
	 */
	MailingListResponse updateList(String listAddress, String name, String accessLevel);

	void deleteList(String listAddress);
	
	void deleteMember(String listAddress , String memberAddress);
	
}
