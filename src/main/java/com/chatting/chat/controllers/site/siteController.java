package com.chatting.chat.controllers.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class siteController {
    
    // @Autowired
    // private ChatService chatService;

    // @Autowired
    // private ProjectSerivce projectService;

    // @GetMapping("/project/{nickname}/{title}/chatting") // 첫 화면 매핑
    // public String index(Model model, @PathVariable String nickname, @PathVariable String title){
    //     //nickname과 projectTitle로 projectId 찾기
    //     Long projectId = projectService.getProjectId(nickname, title);
    // }

    @GetMapping("/")
    public String Home(){
        return "index";
    }

}
