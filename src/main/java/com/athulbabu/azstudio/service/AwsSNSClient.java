package com.athulbabu.azstudio.service;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class AwsSNSClient {
	public static final String AWS_ACCESS_KEY_ID="aws.accessKeyId";
	public static final String AWS_SECRET_KEY="aws.secretKey";
	
	static {
		System.setProperty(AWS_ACCESS_KEY_ID, "AKIAIY2ZAVP6BBSGLC5Q");
		System.setProperty(AWS_SECRET_KEY, "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");
	}
	
	public void sendsms(String message,String phonenumber) {
		AmazonSNS snsClient = AmazonSNSClient.builder().withRegion(Regions.US_EAST_1).build();
		Map<String,MessageAttributeValue> smsAttributes=new HashMap<>();
		smsAttributes.put("AWS.SNS.SMS.SenderID",new MessageAttributeValue().withStringValue("TrendIt")
				.withDataType("String"));
		smsAttributes.put("AWS.SNS.SMS.SMSType",new MessageAttributeValue().withStringValue("Transactional")
				.withDataType("String"));
		PublishResult result= snsClient.publish(new PublishRequest()
				.withMessage(message)
				.withPhoneNumber(phonenumber)
				.withMessageAttributes(smsAttributes));
		System.out.println("Success"+result.getMessageId());
	}
}
