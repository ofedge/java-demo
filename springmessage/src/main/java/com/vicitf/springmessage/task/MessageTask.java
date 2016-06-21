package com.vicitf.springmessage.task;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.vicitf.springmessage.pojo.Greeting;

public class MessageTask implements Runnable {
    
    private static final String KEY = "test";
    
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private SimpMessagingTemplate template;
    private RedisTemplate<String, String> templates;
    
    public MessageTask(SimpMessagingTemplate template, RedisTemplate<String, String> templates) {
        this.template = template;
        this.templates = templates;
    }
    
    @Override
    public void run() {
        System.out.println(":::::::message start:::::::");
        while(flag){
            try {
                Thread.sleep(100);
                String message = templates.boundListOps(KEY).leftPop(); // 写个dao比较好吧
                if (message != null)
                    template.convertAndSend("/topic/greetings", new Greeting(message));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
