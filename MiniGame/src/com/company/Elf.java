package com.company;

class Elf extends Enemy {
    private static final int shp = 70;
    private static final int sdmg = 15;
    private static final int sstamina = 120;
    private static final int sdefence = 10;
    String name = "Elf-archer";
    Elf() {
        super (shp, sdmg, sstamina, sdefence);
    }
}
