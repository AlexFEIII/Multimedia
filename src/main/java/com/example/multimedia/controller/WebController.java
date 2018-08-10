package com.example.multimedia.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @GetMapping("/html/index.html")
    public String index(){
        return "html/index";
    }

    @GetMapping("/")
    public String index2(){
        return "redirect:html/index.html";
    }

    @GetMapping("/html/article.html")
    public String article(){
        return "html/article";
    }

    @GetMapping("/html/articlePage.html")
    public String articlePage(){return "html/articlePage";}

    @GetMapping("/html/map.html")
    public String map(){
        return "html/map";
    }

    @GetMapping("/html/personalCenter.html")
    public String personalCenter(){
        try{
            User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "html/personalCenter";
        }catch (Exception e){
            return "redirect:index.html";
        }
    }

    @GetMapping("/html/RichEditor.html")
    public String richEditor(){
        return "html/RichEditor";
    }

    @GetMapping("/html/search.html")
    public String search(){
        return "html/search";
    }

    @GetMapping("/html/UI.html")
    public String ui(){
        try{
            User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "html/UI";
        }catch (Exception e){
            return "redirect:index.html";
        }
    }

    @GetMapping("/html/signIn.html")
    public String signIn(){
        return "html/signIn";
    }

    @GetMapping("/html/signUp.html")
    public String signUp(){
        return "html/signUp";
    }

    @GetMapping("/html/particles.html")
    public String particals(){
        return "html/particles";
    }
}
