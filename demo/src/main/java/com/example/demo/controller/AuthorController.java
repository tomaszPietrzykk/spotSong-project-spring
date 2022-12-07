package com.example.demo.controller;

import com.example.demo.model.DTO.AuthorDto;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/author")
@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @RequestMapping("/list")
    public String getAuthorPage(Model model){
        model.addAttribute("authors",authorService.findAll()) ;
        return "author/list";
    }

    @RequestMapping("/details/{id}")
    public String getDetailsPage(Model model,@PathVariable String id){
        AuthorDto author = authorService.findById(Long.valueOf(id));
        model.addAttribute("author", author);
        return "author/details";
    }

    @RequestMapping("/form")
    public String getFormPage(){
        return "author/form";
    }

    @RequestMapping("/form-edit")
    public String getEditPage(){
        return "author/form-edit";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        authorService.deleteById(Long.valueOf(id));
        return "redirect:/song/list";
    }

}
