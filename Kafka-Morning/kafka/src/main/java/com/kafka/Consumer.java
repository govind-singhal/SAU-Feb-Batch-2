package com.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	@KafkaListener(topics = "TestTopic", groupId = "group_json",containerFactory = "kafkaListenerContainerFactory")
	public void consumeJson(Order order) {
		System.out.println("consumed message"+order);
	}
}
