package distributed.ai.communication.mqtt;//Thomas Verschoor


//imports
import org.eclipse.paho.client.mqttv3.*;

import java.io.IOException;

public class Subscriber {

    public void subscribe() throws Exception {


        //set up client

        MqttClient client = new MqttClient("tcp://broker.mqttdashboard.com", "testClient");
        System.out.println("client set up");

        //new callback
        MqttCallback callback = new MqttCallback() {


            //messageArrived
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(message);
            }


            //deliveryComplete
            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
            }

            //connectionLost
            @Override
            public void connectionLost(Throwable cause) {
                cause.printStackTrace();
            }
        };


        //System.out.println("callback");
        client.connect();

        //subscribe to topic
        client.subscribe("MQTT Examples");

        client.setCallback(callback);

        //get message
        try{
            int mess;
            mess = System.in.read();
            System.out.println("read: "+ mess);
        }catch (IOException e){
            System.out.println("error");
        }


        client.disconnect();

        client.close();
    }
}

