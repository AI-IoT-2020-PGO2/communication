package distributed.ai.communication;

import distributed.ai.communication.mqtt.Publisher;
import distributed.ai.communication.mqtt.Subscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunicationApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(CommunicationApplication.class, args);
        System.out.println("controller running");

        Publisher pub = new Publisher();
        pub.publish("rip");



    }

}

//http://localhost:8080/web/get/songs