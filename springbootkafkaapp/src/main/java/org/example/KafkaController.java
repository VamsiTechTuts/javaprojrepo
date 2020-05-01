package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

   /* @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }*/
    @PostMapping(value = "/readDataFromWebUi")
    public void readDataFromWebUi(@RequestBody Order order) {
       // this.producer.sendMessage(message);
        this.producer.sendMessage(order.toString());
    }
}