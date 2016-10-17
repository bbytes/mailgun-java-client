**Mailgun Java Client**
-------------
Rest api client for mailgun using spring rest template



Usage
-------------


 **Send mail :**



    MailgunClient client = MailgunClient.create("mailgun.apiKey");
    MailOperations mailOperations = client.mailOperations(domain);
    MailgunSendResponse response = mailOperations.sendHtmlMail("from.email",
				"<p>test mail from mailgun client</p>", "Hello message", "to.email");
    Assert.assertTrue(response.isOk());
    
    
    

 **Send Mail with attachment:**

    MailgunClient client = MailgunClient.create("mailgun.apiKey");
    MailOperations mailOperations = client.mailOperations(domain);
    MailMessage message = MailBuilder.create()
                                       .from("from.email")
                                       .to("to.email")
                                       .subject("Attachment Added").html("Check attachments")
                                       .addAttachments(attachment1, attachment2, attachment3)
                                       .build();
    MailgunSendResponse response = mailOperations.sendMail(message);
    Assert.assertTrue(response.isOk());
    
    
  **Route :**

	MailgunClient client = MailgunClient.create("mailgun.apiKey");
    RouteOperations routeOperations = client.roueOperations();
	MailgunRouteResponse response = routeOperations.createRoute(0, "simple route",
				"match_recipient('.*@gmail.com')", "forward('http://myhost.com/messages/')");
    Assert.isTrue(!response.getRoute().getId().isEmpty());
