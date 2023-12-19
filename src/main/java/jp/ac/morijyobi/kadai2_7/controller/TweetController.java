package jp.ac.morijyobi.kadai2_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tweet")
public class TweetController {
    @GetMapping("/sarasu")
    public String sarasuBook(Model model){
        return "tweet/sarasu_tweet";
    }
}
