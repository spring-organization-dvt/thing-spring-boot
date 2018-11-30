package com.thinkpad.thingspringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "things")
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String magicScript;
    private String manaNeed;

    public Thing(){}

    public Thing(String name, String magicScript, String manaNeed) {
        this.name = name;
        this.magicScript = magicScript;
        this.manaNeed = manaNeed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMagicScript() {
        return magicScript;
    }

    public void setMagicScript(String magicScript) {
        this.magicScript = magicScript;
    }

    public String getManaNeed() {
        return manaNeed;
    }

    public void setManaNeed(String manaNeed) {
        this.manaNeed = manaNeed;
    }
}
