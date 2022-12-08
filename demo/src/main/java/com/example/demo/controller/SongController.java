package com.example.demo.controller;

import com.example.demo.model.DTO.SongDto;
import com.example.demo.model.DTO.SongRequest;
import com.example.demo.service.SongService;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/song")
@Controller
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @RequestMapping("/list")
    public String getSongPage(Model model){
        model.addAttribute("songs", songService.findAll());
        return "song/list";
    }

    @RequestMapping("/details/{id}")
    public String getDetailsPage(Model model, @PathVariable String id){
        SongDto song = songService.findById(Long.valueOf(id));
        model.addAttribute("song", song);
        return "song/details";
    }

    @RequestMapping("/form")
    public String getFormPage(){
        return "song/form";
    }

    @RequestMapping("/form-edit/{id}")
    public String getEditPage(Model model, @PathVariable String id){
        SongDto song = songService.findById(Long.valueOf(id));
        model.addAttribute("song", song);
        return "song/form-edit";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        songService.deleteById(Long.valueOf(id));
        return "redirect:/song/list";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute SongRequest songRequest) {
        songService.update(id, songRequest);
        return "redirect:/song/list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute SongRequest songRequest){
        songService.save(songRequest);
        return "redirect:/song/list";
    }

}
