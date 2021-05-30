package com.chatting.chat.controllers.site;

import com.chatting.chat.repositories.ChatRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/chat")
@Log4j2
public class RoomController {
    
    @Autowired
    private ChatRoomRepository repository;

    @GetMapping("/rooms")
    public ModelAndView rooms(){
        
        log.info("All Chat Rooms");

        ModelAndView mv = new ModelAndView("chat/rooms");

        mv.addObject("list", repository.findAllRooms());

        return mv;

    }

    @PostMapping("/room")
    public String create(@RequestParam String name, RedirectAttributes rttr){
        
        log.info("Create Chat Room : " + name);
        rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
        return "redirect:/chat/rooms";

    }
    
    @GetMapping("/room")
    public void getRoom(String roomId, Model model){
        
        log.info("Get Chat Room : " + roomId);
        model.addAttribute("room", repository.findRoomById(roomId));

    }

}
