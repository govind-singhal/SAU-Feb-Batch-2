package com.kafka;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	@Autowired
	private KafkaTemplate<String, Order> temp;
	private static final String TOPIC="TestTopic";
	public String sendMessage(int id, int qty, String type) {
		temp.send(TOPIC,new Order(id,qty,type,new Date().toString()));
		return "Published successfully";
	}
	

}
