package com.example.MQDemo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private Sender sender;
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String nihao1() {
        sender.send1();
        return "已经为您排队，成功后将以短信通知您.........(简单队列)";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String nihao2() {
        sender.send2();
        return "已经为您排队，成功后将以短信通知您.........(工作队列)";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String nihao3() {
        sender.send3();
        return "已经为您排队，成功后将以短信和邮件通知您.........(fanout交换机)";
    }


    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    public String nihao4() {
        sender.send4("info");
        System.out.println("================切换路由============");
        sender.send4("error");
        return "已经为您排队，成功后将以短信和邮件通知您.........(direct交换机)";
    }



    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    public String nihao5() {
        sender.send5("goods.update");
        sender.send5("goods.add");
        return "已经为您排队，成功后将以短信和邮件通知您.........(topic交换机)";
    }
































}
