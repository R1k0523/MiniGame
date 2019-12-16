package com.company;

class Dwarf extends Enemy {
    private static final int shp = 100;
    private static final int sdmg = 25;
    private static final int sstamina = 100;
    private static final int sdefence = 100;
    String name = "Dwarf-warrior";
    Dwarf() {
        super (shp, sdmg, sstamina, sdefence);
    }
}
