package jp.ac.morijyobi.kadai2_7.controller;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tag;
import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import jp.ac.morijyobi.kadai2_7.bean.form.TweetForm;
import jp.ac.morijyobi.kadai2_7.service.TagService;
import jp.ac.morijyobi.kadai2_7.service.TweetService;
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
    public String sarasuBook(Model model) {

        TweetForm tweetForm = new TweetForm();
        model.addAttribute("tweetForm", tweetForm);

        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tagList", tagList);

        return "tweet/home-tweet";
    }

    @PostMapping("/home")
    public String tweetExe(@Validated TweetForm tweetForm,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model){
        if (bindingResult.hasErrors()){

            List<Tag> tagList = tagService.getAllTags();
            model.addAttribute("tagList", tagList);

            return "tweet/home-tweet";
        }

        tweetService.tweetSentence(tweetForm);
        redirectAttributes.addFlashAttribute("message", "つぶやきました");

        return "redirect:/tweet/home";
    }

    @GetMapping("/list")
    public String tweetList(@RequestParam(defaultValue = "") String keyword,
                            Model model){
        List<Tweet> tweetList = tweetService.getTweetByKeyword(keyword);
        model.addAttribute("tweetList", tweetList);

        return "tweet/tweet-list";
    }
}
