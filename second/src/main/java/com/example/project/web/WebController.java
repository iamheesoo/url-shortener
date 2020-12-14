package com.example.project.web;

import com.example.project.domain.UrlResponseDto;
import com.example.project.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/result")
    public String send(@RequestParam("url")String url, Model model){
        UrlResponseDto result=urlService.urlToShort(url);
        if(result==null){
            model.addAttribute("msg", "invalid url");
        }
        else{
            if(url.startsWith("http://localhost:8080/")){
                model.addAttribute("originUrl", result.getOrigin());
                model.addAttribute("changedUrl", result.getOrigin());
            }
            else{
                model.addAttribute("originUrl", result.getOrigin());
                model.addAttribute("changedUrl", result.getShorten());
            }

        }

        return "index";
    }

    @RequestMapping("/history")
    public String sendHistory(Model model){
        return "index";
    }
}
