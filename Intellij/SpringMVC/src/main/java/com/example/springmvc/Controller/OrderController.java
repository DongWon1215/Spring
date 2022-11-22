package com.example.springmvc.Controller;

import domain.OrderCommand;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/order/order")
public class OrderController {

    @GetMapping
    public String getOrderForm()
    {


        return "order/orderForm";
    }

    @PostMapping
    public void order(OrderCommand od)
    {
        log.info(od);
    }
}
