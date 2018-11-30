package com.thinkpad.thingspringboot.service;

import com.thinkpad.thingspringboot.model.Thing;

import java.util.List;

public interface ThingService {
    List<Thing> findAll();

    Thing findById(Integer id);

    void save(Thing T);

    void remove(Integer id);

    List<Thing> search(String word,String stt);

}
