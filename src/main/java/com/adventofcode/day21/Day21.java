package com.adventofcode.day21;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class Day21 {

    private static final int BOSS_HIT_POINTS = 109;
    private static final int BOSS_DAMAGE = 8;
    private static final int BOSS_ARMOR = 2;
    private static final int PLAYER_HIT_POINTS = 100;
    private final ItemShop itemShop = new ItemShop();

    public int calculateMinimalGoldToWin() {
        int minCost = Integer.MAX_VALUE;
        for (Weapon weapon : itemShop.getWeapons()) {
            for (Armor armor : itemShop.getArmors()) {
                for (List<Ring> ringCombo : generateRingsCombinations()) {
                    int totalCost = weapon.getCost()
                            + armor.getCost()
                            + ringCombo.stream().mapToInt(ItemFromShop::getCost).sum();
                    int totalDamage = weapon.getDamage()
                            + ringCombo.stream()
                            .mapToInt(Ring::getDamage)
                            .sum();
                    int totalArmor = armor.getDefense()
                            + ringCombo.stream().mapToInt(Ring::getDefense).sum();
                    if (simulateFight(totalDamage, totalArmor)) {
                        minCost = Math.min(minCost, totalCost);
                    }
                }
            }
        }
        return minCost;
    }

    // return true if player win
    private boolean simulateFight(int playerDamage, int playerDefense) {
        LivingEntity player = new LivingEntity(PLAYER_HIT_POINTS, playerDamage, playerDefense);
        LivingEntity boss = new LivingEntity(BOSS_HIT_POINTS, BOSS_DAMAGE, BOSS_ARMOR);
        while (true) {
            boss.takeDamage(
                    Math.max(1, player.getDamage() - boss.getDefense()));
            if (!boss.isAlive()) {
                return true;
            }
            player.takeDamage(
                    Math.max(1, boss.getDamage() - player.getDefense()));
            if (!player.isAlive()) {
                return false;
            }
        }
    }


    private List<List<Ring>> generateRingsCombinations() {
        List<List<Ring>> combinations = new ArrayList<>();
        // no rings
        combinations.add(List.of());
        // only one ring
        itemShop.getRings().stream()
                .map(List::of)
                .forEach(combinations::add);
        // two rings
        List<Ring> pairOfRings = new ArrayList<>(itemShop.getRings());
        range(0, pairOfRings.size()).forEach(
                i -> range(i + 1, pairOfRings.size()).forEach(
                        j -> combinations.add(
                                List.of(
                                        pairOfRings.get(i),
                                        pairOfRings.get(j)))
                )
        );
        return combinations;
    }

}
