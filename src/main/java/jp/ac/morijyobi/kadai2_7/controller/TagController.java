package jp.ac.morijyobi.kadai2_7.controller;

import jp.ac.morijyobi.kadai2_7.bean.form.TagForm;
import jp.ac.morijyobi.kadai2_7.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping("/register")
    public String register(Model model){
        TagForm tagForm = new TagForm();
        model.addAttribute("tagForm", tagForm);

        return "tag/register-tag";
    }

    @PostMapping("/register")
    public String registerExe(@Validated TagForm tagForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model){
        if (bindingResult.hasErrors()){
            return "tag/register-tag";
        }

        tagService.registerTag(tagForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました。");

        return "redirect:/tag/register";
    }
}
