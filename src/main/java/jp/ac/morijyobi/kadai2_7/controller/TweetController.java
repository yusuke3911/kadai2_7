package jp.ac.morijyobi.kadai2_7.controller;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tag;
import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import jp.ac.morijyobi.kadai2_7.bean.form.TweetForm;
import jp.ac.morijyobi.kadai2_7.security.LoginUserDetails;
import jp.ac.morijyobi.kadai2_7.service.TagService;
import jp.ac.morijyobi.kadai2_7.service.TweetService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    private final TagService tagService;
    private final TweetService tweetService;

    public TweetController(TagService tagService, TweetService tweetService) {
        this.tagService = tagService;
        this.tweetService = tweetService;
    }

    @GetMapping("/home")
    public String sarasuBook(@AuthenticationPrincipal LoginUserDetails user,
                             Model model) {
        String name = user.getUsername();
        model.addAttribute("username", name);


        TweetForm tweetForm = new TweetForm();
        model.addAttribute("tweetForm", tweetForm);

        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tagList", tagList);

        return "tweet/home-tweet";
    }

    @PostMapping("/home")
    public String tweetExe(@Validated TweetForm tweetForm,
                           @AuthenticationPrincipal LoginUserDetails user,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model){

        String name = user.getUsername();
        model.addAttribute("username", name);

        if (bindingResult.hasErrors()){

            List<Tag> tagList = tagService.getAllTags();
            model.addAttribute("tagList", tagList);

            return "tweet/home-tweet";
        }

        tweetService.tweetSentence(tweetForm, user);
        redirectAttributes.addFlashAttribute("message", "つぶやきました");

        return "redirect:/";
    }

//    @GetMapping("/list")
//    public String tweetList(@RequestParam(defaultValue = "") String keyword,
//                            Model model){
//        List<Tweet> tweetList = tweetService.getTweetByKeyword(keyword);
//        model.addAttribute("tweetList", tweetList);
//
//        return "layout";
//    }
}
