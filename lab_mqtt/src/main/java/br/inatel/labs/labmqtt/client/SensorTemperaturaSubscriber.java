package br.inatel.labs.labmqtt.client;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class SensorTemperaturaSubscriber {

	public static void main(String[] args) throws MqttException {
		//1.cria o subscriber
		String subscriberId = UUID.randomUUID().toString();
		IMqttClient subscriber = new MqttClient( MyConstants.URI_BROKER, subscriberId);

		//2.conecta
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		subscriber.connect(options);

		//3.recebe a mensagem
		subscriber.subscribe(MyConstants.TOPIC_1, (topic, msg) -> {
			byte[] payload = msg.getPayload();
			System.out.println( "Payload recebido: " + payload );
			System.out.println( "Topico recebido: " + topic );
		});

		//4.desconecta
		subscriber.disconnect();

	}
	
}
