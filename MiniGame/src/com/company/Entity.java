package com.company;

abstract class Entity {
    boolean alive = true;
    int hp;
    int dmg;
    int stamina;
    int defence;
    String name = "";
    void getInf() {
        System.out.println(name+" hp: "+hp+"\n"+name+" damage: "+dmg+"\n"+name+" stamina: "+stamina+"\n"+name+" defence: "+defence);
    }
}

