package com.chatting.chat.domains;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ChatVo {

    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatVo create(String name){
        ChatVo room = new ChatVo();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }

}
