package com.company;

class Orc extends Enemy {
    private static final int shp = 100;
    private static final int sdmg = 18;
    private static final int sstamina = 100;
    private static final int sdefence = 20;
    String name = "Orc-Warrior";
    Orc() {
        super (shp, sdmg, sstamina, sdefence);
    }

}
