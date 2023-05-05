package io.datajek.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {
    
    @RequestMapping("/showPlayerForm")
    public String showForm(){
        return "search-player-form";
    }

    @RequestMapping("/processPlayerForm")
    public String processPlayerForm() {
        return "player-detail";
    }

}
