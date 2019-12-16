package com.company;

import java.util.Scanner;
class HeroActivities extends Hero{
    void findaction(Hero hero) {
        System.out.println("You want to go to: \n"+ "1 - city\n"+"2 - somewhere in search of adventure \n3 - check stats");
        Scanner scan = new Scanner(System.in);
        int actiontype = scan.nextInt();
        switch (actiontype) {
            case 1:
                System.out.println("You want to : \n1 - heal yourself for 100 coins\n2 - go to trainer to get some exp for 200 coins");
                int actionc = scan.nextInt();
                /*CITYACTIONS*/
                switch (actionc) {
                    case 1:
                        if (hero.money>=100) {
                        hero.money -= 100;
                        regen(hero); } else System.out.println("You have no enough money");
                        break;
                    case 2:
                        if (hero.money>=200) {
                        hero.money -= 200;
                            hero.lvlup();  } else System.out.println("You have no enough money");
                        break;
                }
                break;
            case 2:
                /*ADVENTUREACTIONS*/
                int actionm = random.nextInt(40);
                System.out.println(actionm);
                if (actionm>3)
                    enemyfound(hero);
                    else
                        switch (actionm) {
                            case 0:
                                System.out.println("You found magical stream, drank from it and saw, that your wounds had healed");
                                regen(hero);
                                break;
                            case 1:
                                System.out.println("Someone stole your money");
                                hero.money /= 2;
                                break;
                            case 2:
                                System.out.println("You found strange wizard. He said: \nI can improve your skills for 50 coins.\n1 - I give him 50 coins\n2 - I will pass him ");
                                int actionwizard = scan.nextInt();
                                if ((actionwizard==1)&&(hero.money>=50)) {
                                        switch (random.nextInt(2)) {
                                            case 0:
                                                System.out.println("He stole your money and dissolved in air");
                                                hero.money -= 50;
                                                break;
                                            case 1:
                                                System.out.println("You felt, that you became stronger");
                                                hero.money -= 50;
                                                hero.exp();
                                                break;
                                        }

                                } else System.out.println("You just went out");
                                break;
                            case 3:
                                System.out.println("You saw the chest.");
                                switch (random.nextInt(3)) {
                                    case 0:
                                        int temp = random.nextInt(100);
                                        hero.money += temp;
                                        System.out.println("You found"+ temp + " coins");
                                        break;
                                    case 1:
                                        System.out.println("You found the healing potion");
                                        regen(hero);
                                        break;
                                    case 2:
                                        System.out.println("There is nothing here");
                                        break;
                                }
                                break;
                        }
                    break;
            case 3:
                System.out.println("Your have "+money+" coins");
                hero.getInf();
                }
        }
    private void regen(Hero hero) {
        hero.money -=100;
        hero.hp = maxhp;
        hero.defence = maxdefence;
        hero.stamina = maxstamina;
        hero.dmg = maxdmg;
        System.out.println("You are well rested and ready for battle");
    }
    private void enemyfound(Hero hero) {
        int enemy = random.nextInt(3);
        switch (enemy) {
            case 0:
                Dwarf dwarf = new Dwarf();
                System.out.println ("U met "+dwarf.name);
                dwarf.getInf();
                battle(dwarf, hero);
                break;
            case 1:
                Elf elf = new Elf();
                System.out.println ("U met "+elf.name);
                elf.getInf();
                battle(elf, hero);
                break;
            case 2:
                Orc orc = new Orc();
                System.out.println ("U met "+orc.name);
                orc.getInf();
                battle(orc, hero);
                break;
        }
    }
    private void battleaction(Elf elf, Hero hero) {
        System.out.println("You wanna make: \n"+ "1 - lighthit\n"+ "2 - hit\n"+ "3 - heavyhit");
        Scanner scan = new Scanner(System.in);
        int actiontype = scan.nextInt();
        switch (actiontype) {
            case 1:
                    hero.makelighthit(elf);
                break;
            case 2:
                    hero.makehit(elf);
                break;
            case 3:
                    hero.makeheavyhit(elf);
                break;
            default:
                break;
        }
    }
    private void battleaction(Orc orc, Hero hero) {
        System.out.println("You wanna make: \n"+ "1 - lighthit\n"+ "2 - hit\n"+ "3 - heavyhit");
        Scanner scan = new Scanner(System.in);
        int actiontype = scan.nextInt();
        switch (actiontype) {
            case 1:
                hero.makelighthit(orc);
                break;
            case 2:
                hero.makehit(orc);
                break;
            case 3:
                hero.makeheavyhit(orc);
                break;
            default:
                break;
        }
    }
    private void battleaction(Dwarf dwarf, Hero hero) {
        System.out.println("You wanna make: \n"+ "1 - lighthit\n"+ "2 - hit\n"+ "3 - heavyhit");
        Scanner scan = new Scanner(System.in);
        int actiontype = scan.nextInt();
        switch (actiontype) {
            case 1:
                hero.makelighthit(dwarf);
                break;
            case 2:
                hero.makehit(dwarf);
                break;
            case 3:
                hero.makeheavyhit(dwarf);
                break;
            default:
                break;
        }
    }
    private void battle(Elf elf, Hero hero) {
        int bysurprice = random.nextInt(3);
        switch (bysurprice) {
            case 0:
                System.out.println("You begin the battle");
                battleaction(elf, hero);
                break;
            case 1:
                System.out.println(elf.name+" begin the battle");
                elf.makehit(hero);
                break;
        }
        while ((elf.alive)&&(hero.alive)) {
            if (hero.stamina>0) {
                battleaction(elf, hero);
            } else hero.stamina+=80;
            if (elf.stamina>0) {
                elf.makehit(hero);
                elf.stamina-=25;
            }
            else elf.stamina+=60;
            hero.getInf();
            elf.getInf();
        }
        System.out.println("You won the battle");
        hero.exp();
        hero.getInf();
        hero.money+=elf.dmg + random.nextInt(30);
    }
    private void battle(Orc orc, Hero hero) {
        int bysurprice = random.nextInt(2);
        switch (bysurprice) {
            case 0:
                System.out.println("You begin the battle");
                battleaction(orc, hero);
                break;
            case 1:
                System.out.println(orc.name+" begin the battle");
                orc.makehit(hero);
                break;
        }
        while ((orc.alive)&&(hero.alive)) {
            if (hero.stamina>0) {
                battleaction(orc, hero);
            } else hero.stamina+=80;
            if (orc.stamina>0) {
                orc.makehit(hero);
                orc.stamina-=25;
            }
            else orc.stamina+=60;
            hero.getInf();
            orc.getInf();
        }
        System.out.println("You won the battle");
        hero.exp();
        hero.getInf();
        hero.money+=orc.dmg + random.nextInt(30);
    }
    private void battle(Dwarf dwarf, Hero hero) {
        int bysurprise = random.nextInt(2);
        switch (bysurprise) {
            case 0:
                System.out.println("You begin the battle");
                battleaction(dwarf, hero);
                break;
            case 1:
                System.out.println(dwarf.name+" begin the battle");
                dwarf.makehit(hero);
                break;
        }
        while ((dwarf.alive)&&(hero.alive)) {
            if (hero.stamina>0) {
                battleaction(dwarf, hero);
            } else hero.stamina+=80;
            if (dwarf.stamina>0) {
                dwarf.makehit(hero);
                dwarf.stamina-=30;
            }
            else dwarf.stamina+=60;
            hero.getInf();
            dwarf.getInf();
        }
        if (!dwarf.alive) {
            System.out.println("You won the battle");
            hero.exp();
            hero.getInf();
            hero.money += dwarf.dmg + random.nextInt(30);
        } else System.out.println("YOU ARE DEAD");
    }
}
