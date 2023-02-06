package com.example.logging.coffee.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author z0rka 03.02.2023;
 * Order board to process {@link Order}
 */
@NoArgsConstructor
@Getter
@Slf4j
@Service
public class CoffeeOrderBoard {
    private final List<Order> orderList = new ArrayList<>();
    private final AtomicReference<Integer> integer = new AtomicReference<>(0);

    /**
     * Method to add new order
     *
     * @param customerName- name of the customer
     */
    public void add(String customerName) {
        log.info("Method of adding order started");

        if (customerName == null) {
            log.error("customerName is empty!");
            return;
        }

        Order order = new Order(customerName, integer.get());
        orderList.add(order);

        log.info("Placed order fro client" + customerName);

        integer.set(integer.get() + 1);

        log.info("Method of adding order ended");
    }

    /**
     * Method to deliver  order
     *
     * @param orderNumber- number of the order
     * @return {@link Order}
     */
    public Order deliver(int orderNumber) {
        log.info("Deliver method started");

        Order order = orderList.stream().filter(order1 -> order1.getNumber() == orderNumber).findFirst().orElse(null);

        if (order == null) {
            log.error("Order list is empty!Can`t process delivery method");
            return null;
        }

        orderList.remove(order);

        log.info("Delivered order to  client " + order.getCustomerName());

        log.info("Deliver method ended");
        return order;
    }

    /**
     * Method to deliver first order
     *
     * @return {@link Order}
     */
    public Order deliver() {
        log.info("Deliver method started");

        Order order = orderList.stream().findFirst().orElse(null);

        if (order == null) {
            log.error("Order list is empty!Can`t process delivery method");
            return null;
        }

        orderList.remove(order);

        log.info("Delivered order to  client " + order.getCustomerName());

        log.info("Deliver method ended");
        return order;
    }
}