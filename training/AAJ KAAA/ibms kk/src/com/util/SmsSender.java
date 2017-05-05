package com.util;

import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.message.BasicNameValuePair;

public class SmsSender {
	// Find your Account Sid and Token at twilio.com/user/account
	private final String ACCOUNT_SID = "AC5663f57418945996609cc2e1bede4914";
	private final String AUTH_TOKEN = "c22c5c70450bd9ce507d4e1f3874b371";

	public void sendMessage(String to, String msg) throws TwilioRestException {
//
//		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

//		HttpHost proxy = new HttpHost("ngproxy.persistent.co.in", 8080);
//		client.getHttpClient().getParams()
//				.setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

//		Account account = client.getAccount();
//		MessageFactory messageFactory = account.getMessageFactory();
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		params.add(new BasicNameValuePair("To", to));
//		params.add(new BasicNameValuePair("From", "+19402027388"));
//		params.add(new BasicNameValuePair("Body", msg));
//		Message sms = messageFactory.create(params);
//		System.out.println(sms.getStatus());
	}

}