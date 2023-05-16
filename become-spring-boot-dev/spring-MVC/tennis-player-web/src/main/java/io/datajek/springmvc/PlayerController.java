package io.datajek.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.datajek.Player;
import io.datajek.PlayerService;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService service;

    @RequestMapping("/showPlayerForm")
    public String showForm() {
        return "search-player-form";
    }

    @RequestMapping("/processPlayerForm")
    public String processForm(@RequestParam String name, Model model) {
        System.out.println(name);
        Player player = service.getPlayerByName(name);
        String playerNameToShow = name.toUpperCase();
        model.addAttribute("name", playerNameToShow);
        model.addAttribute("country", player.getNationality());
        model.addAttribute("dob", player.getBirthDate());
        model.addAttribute("titles", player.getTitles());
        return "player-detail";
    }

}
