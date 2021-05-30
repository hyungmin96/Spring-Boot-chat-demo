package com.chatting.chat.controllers.site;

import com.chatting.chat.domains.ChatVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class siteController {
    
    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/chat/enter")
    public void enter(ChatVo message){
        System.out.println("입장");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatVo message){
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @GetMapping("/")
    public String Home(){
        return "index";
    }

}
