package com.company;

import java.util.Random;

public class Enemy extends Entity {
    Enemy(int hp, int dmg, int stamina, int defence) {
        Random random = new Random();
        this.hp =random.nextInt(40) -20 + hp;
        this.dmg =random.nextInt(20) -10 + dmg;
        this.stamina =random.nextInt(20) -10 + stamina;
        this.defence =random.nextInt(30) -15 + defence;

        int bossevent = random.nextInt(100)+1;
        if (bossevent>89) {
            System.out.println("You found the boss");
            this.hp  *= 2;
            this.dmg *= 2;
            this.stamina *= 2;
            this.defence *= 2;
        }
    }
    public void getInf() {
        System.out.println(hp+ " "+ dmg+" "+ stamina+" "+ defence);
    }
    void makehit(Hero hero){
        System.out.println(hero.name+" get " + this.dmg +" damage and absorb "+ hero.gethit(this.dmg)+" damage from "+ this.name);
    }
}
