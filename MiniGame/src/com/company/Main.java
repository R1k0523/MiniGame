package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to game");
        Hero hero = new Hero();
        HeroActivities act = new HeroActivities();
        hero.getInf();
        while (hero.alive) {
            act.findaction(hero);
        }


        }
    }
