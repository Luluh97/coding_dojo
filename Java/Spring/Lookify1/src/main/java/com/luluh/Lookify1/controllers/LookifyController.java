package com.luluh.Lookify1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.luluh.Lookify1.models.Lookify;
import com.luluh.Lookify1.services.LookifyService;

@Controller
public class LookifyController {
    private final LookifyService lookifyService;
    
    public LookifyController(LookifyService lookifyService) {
        this.lookifyService = lookifyService;
    }
    
    @RequestMapping("/")
    public String index() {
     
        return "/index.jsp";
    }
    
    @RequestMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute("artist1") Lookify artist1) {
    	List<Lookify> l = lookifyService.all();
        model.addAttribute("songs", l);
        return "/dashboard.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("songs") Lookify song) {
        return "/new_song.jsp";
    }
    
    @RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("songs") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/new.jsp";
        } else {
            lookifyService.createLookify(song);
            return "redirec:/dashboard";
        }
    }
    
    @RequestMapping(value="/songs/remove/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	lookifyService.deleteSong(id);
        return "redirect:/dashboard";
    }
    
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id,  @ModelAttribute("song") Lookify song,Model model) {
        Lookify song1 = lookifyService.findLookify(id);
        model.addAttribute("song", song1);
        return "/show_song.jsp";
    }
    
    @RequestMapping("/search/{artist}")
    public String show(@PathVariable("artist1") String artist, @PathVariable("id") Long id, @ModelAttribute("artist1") Lookify artist1,Model model) {
        List<Lookify> artt = lookifyService.findLookifyArtist(artist,id);
        model.addAttribute("art", artt);

        
        return "/show_search.jsp";
    }
    
    @RequestMapping("/search/topTen")
    public String topTen(Model model) {
    	List<Lookify> t = lookifyService.topTen();
        model.addAttribute("top", t);
      
        return "/topTen.jsp";
    }
}
