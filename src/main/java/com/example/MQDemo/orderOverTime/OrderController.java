package com.example.MQDemo.orderOverTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private SenderForOrder sender;
    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String nihao1() {
        sender.send();
        return "已经下单，请在三秒内完成支付，负责订单将自动关闭";
    }
}
