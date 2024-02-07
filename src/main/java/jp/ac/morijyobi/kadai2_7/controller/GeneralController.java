package jp.ac.morijyobi.kadai2_7.controller;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import jp.ac.morijyobi.kadai2_7.security.LoginUserDetails;
import jp.ac.morijyobi.kadai2_7.service.TweetService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class GeneralController {
    private final TweetService tweetService;

    public GeneralController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal LoginUserDetails user,
                        @RequestParam(defaultValue = "") String keyword,
                        Model model){

        if(user != null){
            String name = user.getUsername();
            model.addAttribute("username", name);

        }

        List<Tweet> tweetList = tweetService.getTweetByKeyword(keyword);
        model.addAttribute("tweetList", tweetList);


        return "/layout";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "/login";
    }
}
