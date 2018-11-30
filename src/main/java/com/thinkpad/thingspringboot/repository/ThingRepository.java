package com.thinkpad.thingspringboot.repository;

import com.thinkpad.thingspringboot.model.Thing;

import java.util.List;

public interface ThingRepository extends Repository<Thing> {
    List<Thing> search(String word,String stt);
}
