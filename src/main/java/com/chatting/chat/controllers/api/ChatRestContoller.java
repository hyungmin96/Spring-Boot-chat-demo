package com.chatting.chat.controllers.api;

import com.chatting.chat.domains.ChatVo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestContoller {
    @MessageMapping("/hello") // 설정한 prefix를 포함하면 /app/hello이다
    @SendTo("/topic/roomId")
    public ChatVo broadcastring(ChatVo message) throws Exception{
        System.out.println("message : " + message.getSendMessage());
        return message;
    }

    @MessageMapping("/out")
    @SendTo("/topic/out")
    public String outroom(String message) throws Exception{
        System.out.println("out message : " + message);
        return message;
    }

    @MessageMapping("/in")
    @SendTo("/topic/in")
    public String inroom(String message) throws Exception{
        System.out.println("out message : " + message);
        return message;
    }

}
