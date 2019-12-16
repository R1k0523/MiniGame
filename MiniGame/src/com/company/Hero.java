package com.company;

import java.util.Random;

class Hero extends Entity{
    static int maxhp =120;
    static int maxdmg =25;
    static int maxstamina =100;
    static int maxdefence =50;
    String name = "Player";
    int money = 30;
    Random random = new Random();
    Hero () {
        this.hp = 120;
        this.dmg = 25;
        this.stamina = 100;
        this.defence = 50;

    }
    void makehit(Orc orc){
        int temp = random.nextInt(12)-6;
        System.out.println(name+" deals "+(dmg+temp) +" damage"+ orc.name);
        orc.hp -= (dmg+temp);
        if (orc.hp<=0) {
            orc.alive = false;
        }
        stamina-=30;
    }
    void makehit(Elf elf){
        int temp = random.nextInt(12)-6;
        System.out.println(name+" deals "+(dmg+temp) +" damage to "+ elf.name);
        elf.hp -= (dmg+temp);
        if (elf.hp<=0) {
            elf.alive = false;
        }
        stamina-=30;
    }
    void makehit(Dwarf dwarf){
        int temp = random.nextInt(12)-6;
        System.out.println(name+" deals "+(dmg+temp) +" damage to dwarf");
        dwarf.hp -= (dmg+temp);
            if (dwarf.hp<=0) {
                dwarf.alive = false;
            }
        stamina-=30;
    }
    void makelighthit(Orc orc){
        System.out.println(name+" deals "+dmg +" damage"+ orc.name);
        orc.hp -= dmg;
        if (orc.hp<=0) {
            orc.alive = false;
        }
        stamina-=15;
    }
    void makelighthit(Elf elf){
        System.out.println(name+" deals "+dmg +" damage to "+ elf.name);
        elf.hp -= dmg;
        if (elf.hp<=0) {
            elf.alive = false;
        }
        stamina-=15;
    }
    void makelighthit(Dwarf dwarf){
        System.out.println(name+" deals "+dmg +" damage to dwarf");
        dwarf.hp -= dmg;
        if (dwarf.hp<=0) {
            dwarf.alive = false;
        }
        stamina-=15;
    }
    void makeheavyhit(Orc orc){
        int temp = random.nextInt(22)-11;
        System.out.println(name+" deals "+(dmg+temp) +" damage"+ orc.name);
        if (temp>0)
            System.out.println("Great hit!");
        orc.hp -= (dmg+temp);
        if (orc.hp<=0) {
            orc.alive = false;
        }
        stamina-=45;
    }
    void makeheavyhit(Elf elf){
        int temp = random.nextInt(22)-11;
        if (temp>0)
            System.out.println("Great hit!");
        System.out.println(name+" deals "+(dmg+temp) +" damage to "+ elf.name);
        elf.hp -= (dmg+temp);
        if (elf.hp<=0) {
            elf.alive = false;
        }
        stamina-=45;
    }
    void makeheavyhit(Dwarf dwarf){
        int temp = random.nextInt(22)-11;
        if (temp>0)
        System.out.println("Great hit!");
        System.out.println(name+" deals " + (dmg+temp) +" damage to "+dwarf.name);
        dwarf.hp -= (dmg+temp);
        if (dwarf.hp<=0) {
            dwarf.alive = false;
            exp();
        }
        stamina-=45;
    }
    int gethit(int dmg){
        int range = random.nextInt(dmg/5);
        hp = hp - dmg + range ;
        if (hp<=0) {
            alive = false;
        }
        return range;
    }
    void exp() {
        System.out.println("You got some experience.");
        maxdmg++;
        maxhp++;
        maxdefence++;
        maxstamina++;
        }
    void lvlup() {
        System.out.println("You got lots of experience.");
        maxdmg+=10;
        maxhp+=10;
        maxdefence+=10;
        maxstamina+=10;
    }


}
