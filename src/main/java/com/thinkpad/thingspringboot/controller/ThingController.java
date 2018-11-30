package com.thinkpad.thingspringboot.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.thinkpad.thingspringboot.model.Thing;
import com.thinkpad.thingspringboot.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ThingController {

    @Autowired
    private ThingService thingService;

//    @GetMapping
//    public ModelAndView home() {
//        return new ModelAndView("/index");
//    }

    @GetMapping("/")
    public ModelAndView listThing() {
        List<Thing> things = thingService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("things", things);
        return modelAndView;
    }

    @GetMapping("/create-thing")
    public ModelAndView showCreateThing() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("thing", new Thing());
        return modelAndView;
    }

    @PostMapping("/create-thing")
    public ModelAndView createThing(@ModelAttribute("thing") Thing thing) {
        thingService.save(thing);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("thing", new Thing());
        modelAndView.addObject("message", "New thing created successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-thing/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Thing thing = thingService.findById(id);
        if (thing != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("thing", thing);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-thing")
    public ModelAndView updateThing(@ModelAttribute("thing") Thing thing) {
        thingService.save(thing);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("thing", thing);
        modelAndView.addObject("message", "Thing updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-thing/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Thing thing = thingService.findById(id);
        if (thing != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("thing", thing);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-thing")
    public ModelAndView deleteThing(@ModelAttribute("thing") Thing thing) {
        thingService.remove(thing.getId());
        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("newthing", new Thing());

        List<Thing> things = thingService.findAll();
        modelAndView.addObject("things", things);
        modelAndView.addObject("message", "Thing deleted successfully!");
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("word") String word, @RequestParam("stt") String stt) {
        List<Thing> things = thingService.search(word, stt);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("things", things);
        return modelAndView;
    }

}
