package com.vicitf.springmessage.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.vicitf.springmessage.pojo.HelloMessage;
import com.vicitf.springmessage.task.MessageTask;

@Controller
public class GreetingController {
    
    @Autowired
    private SimpMessagingTemplate temp;
    @Resource(name="redisTemplate")
    private RedisTemplate<String, String> templates;
    
    
    private Thread thread;
    private MessageTask task;
    
    @MessageMapping("/hello") // 确保如果一个消息是发送到"/hello"的, 那么greeting方法会被调用
    public void greeting(HelloMessage message) throws Exception {
        if (thread != null) {
            System.out.println("Alive? :" + thread.isAlive());
        }
        if ("start".equals(message.getName())) {
            if (!thread.isAlive()) {
                task = new MessageTask(temp, templates);
                task.setFlag(true);
                thread = new Thread(task);
                thread.start();
            }
        } else {
            task.setFlag(false);
        }
    }
}