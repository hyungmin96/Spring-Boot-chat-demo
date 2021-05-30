package com.chatting.chat.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.chatting.chat.domains.ChatVo;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {
    
    private Map<String, ChatVo> chatRoomDTOMap;

    @PostConstruct
    private void init(){
        chatRoomDTOMap = new LinkedHashMap();
    }

    public List<ChatVo> findAllRooms(){
        List<ChatVo> result = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(result);

        return result;
    }

    public ChatVo findRoomById(String id){
        return chatRoomDTOMap.get(id);
    }

    public ChatVo createChatRoomDTO(String name){
        ChatVo room = ChatVo.create(name);
        chatRoomDTOMap.put(room.getRoomId(), room);

        return room;
    }

}
