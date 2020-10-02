package distributed.ai.communication.mqtt;
// https://www.eclipse.org/paho/index.php?page=clients/java/index.php

// import mqtt (.jar)

//Thomas Verschoor

//imports
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Publisher extends Thread{

    public void publish(String text){


        System.out.println("MQTT publish");

        //Sending some messages

        //choose topic
        String topic        = "MQTT Examples";

        //choose content
        String content      = text;

        //select qos
        int qos             = 2;

        //select broker
        String broker       = "tcp://broker.mqttdashboard.com";

        //set clientID
        String clientId     = "JavaSample";

        //clear MemoryPersistence
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            //create new Client
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");

            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");

            sampleClient.disconnect();
            System.out.println("Disconnected");
            //System.exit(0);

        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }

    }

}