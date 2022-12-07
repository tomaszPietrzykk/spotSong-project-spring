package com.example.demo.controller;

import com.example.demo.model.DTO.AlbumDto;
import com.example.demo.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/album")
@Controller
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @RequestMapping({"/list"})
    public String getAlbumPage(Model model) {

        List<AlbumDto> all = albumService.findAll();
        model.addAttribute("albums", all);
        return "album/list";
    }

    @RequestMapping("/details/{id}")
    public String getDetailsPage(Model model, @PathVariable String id) {
        AlbumDto album = albumService.findById(Long.valueOf(id));
        model.addAttribute("album", album);
        List<AlbumDto.SongDto> songs = album.getSongs();
        model.addAttribute("songs", songs);
        return "album/details";
    }

    @RequestMapping("/form")
    public String getFormPage() {
        return "album/form";
    }

    @RequestMapping("/form-edit/{id}")
    public String getEditPage(Model model, @PathVariable String id) {
        AlbumDto album = albumService.findById(Long.valueOf(id));
        model.addAttribute("album", album);
        return "album/form-edit";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        albumService.deleteById(Long.valueOf(id));
        return "redirect:/album/list";
    }


}
