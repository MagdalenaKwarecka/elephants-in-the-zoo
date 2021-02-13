package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetSitter {

    int quantity;
    int[] weight;
    int[] currentSetting;
    int[] targetSetting;

    public PetSitter(int quantity, int[] weight, int[] currentSetting, int[] targetSetting) {
        this.quantity = quantity;
        this.weight = weight;
        this.currentSetting = currentSetting;
        this.targetSetting = targetSetting;
    }

    public void work() {

        int power = 0;

        for (int i = 0; i < quantity; i++) {

            if (currentSetting[i] != targetSetting[i]) {

                for (int j = 0; j < quantity; j++) {
                    List<Integer> elephants = new ArrayList<>();

                    if (currentSetting[i] == targetSetting[j] && currentSetting[j] == targetSetting[i]) {
                        int temp = currentSetting[i];
                        currentSetting[i] = currentSetting[j];
                        currentSetting[j] = temp;
                        power += weight[currentSetting[i] - 1] + weight[currentSetting[j] - 1];
                    } else if (currentSetting[i] == targetSetting[j] && currentSetting[j] != targetSetting[i]) {
                        int first = currentSetting[i];
                        elephants.add(currentSetting[i]);
                        int temp = i;
                        while (targetSetting[temp] != first) {
                            int newIndex = findIndex(currentSetting, targetSetting[temp]);
                            elephants.add(currentSetting[newIndex]);
                            temp = newIndex;
                        }
                        power += changeCyclePower(elephants, weight, currentSetting, targetSetting);
                        elephants.clear();
                    }
                }


            }

        }

        System.out.println(power);

    }

    public static int changeCyclePower(List<Integer> a, int[] weight, int[] x, int[] y) {
        int power = 0;
        Map<Integer, Integer> weigths = new HashMap<>();

        for (Integer integer : a) {
            weigths.put(integer, weight[integer - 1]);
        }

        int firstInCycle = weigths.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        int index = findIndex(x, firstInCycle);
        int newIndex;

        for(int i = 0; i < a.size()-1; i++) {
            int temp = x[index];
            power += weight[temp -1];
            newIndex = findIndex(x, y[index]);
            x[index] = y[index];
            power += weight[x[index] -1];
            x[newIndex] = temp;
            index = newIndex;
        }

        return power;
    }

    public static int findIndex (int[] list, int a) {
        int newIndex = 0;
        for(int i = 0; i < list.length; i++) {
            if (list[i] == a) {
                newIndex = i;
            }
        }
        return newIndex;
    }
}
