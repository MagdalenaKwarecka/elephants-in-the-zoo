package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args){

        String filename = "file.txt";
        SettingsInformation settingsInformation = new SettingsInformation(new File(filename));

        /*int quantity = settingsInformation.quantity();
        int[] weight = settingsInformation.weight();
        int[] currentSetting = settingsInformation.currentSetting();
        int[] targetSetting = settingsInformation.targetSetting();*/

        PetSitter petSitter = new PetSitter(settingsInformation);
        petSitter.work();

    }
}
