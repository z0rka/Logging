package com.example.logging;

import com.example.logging.coffee.order.CoffeeOrderBoard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class LoggingApplication {

    @Autowired
    private CoffeeOrderBoard coffeeOrderBoard;

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        coffeeOrderBoard.add("Tolia");
        coffeeOrderBoard.add("Katya");
        coffeeOrderBoard.add("Kostya");

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(1);
        coffeeOrderBoard.deliver(2);

    }

}
