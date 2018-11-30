package com.thinkpad.thingspringboot.service.impl;

import com.thinkpad.thingspringboot.model.Thing;
import com.thinkpad.thingspringboot.repository.ThingRepository;
import com.thinkpad.thingspringboot.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ThingServiceImpl implements ThingService {
    @Autowired
    private ThingRepository thingRepository;

    @Override
    public List<Thing> findAll() {
        return thingRepository.findAll();
    }

    @Override
    public Thing findById(Integer id) {
        return thingRepository.findById(id);
    }

    @Override
    public void save(Thing t) {
        thingRepository.save(t);
    }

    @Override
    public void remove(Integer id) {
        thingRepository.remove(id);
    }

    @Override
    public List<Thing> search(String word,String stt) {
        return thingRepository.search(word,stt);
    }
}
