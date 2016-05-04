package com.luo.rabbit.test.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	public static void main(String[] argv) throws java.io.IOException {
		ConnectionFactory conn = new ConnectionFactory();
		conn.setHost("127.0.0.1");
		Connection connn = conn.newConnection();
		Channel chan = connn.createChannel();
		chan.queueDeclare("queue", false, false, false, null);
		chan.basicPublish("", "queue", null, "hello Rabbit".getBytes());
		chan.close();
		connn.close();
	}
}