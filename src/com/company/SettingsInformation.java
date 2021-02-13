package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SettingsInformation {

    public File file;

    SettingsInformation(File file) {
        this.file = file;
    }

    public String[] infor() {
        String[] data = new String[4];
        Scanner sc = null;

        try {
            sc = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = 0;
            while(sc.hasNextLine()){
            String str = sc.nextLine();
            data[i] = str;
            i++;
            }
            return data;
    }

    public int[] newArray(String[] array, int index, int length) {
        int[] ar = new int[length];
        for(int n = 0; n < length; n++) {
            ar[n] = Integer.parseInt(array[index].split(" ")[n]);
        }
        return ar;
    }

    public int quantity() {
        return newArray(infor(), 0, 1)[0];

    }

    public int[] weight() {
        return newArray(infor(), 1, quantity());
    }


    public int[] currentSetting() {
        return newArray(infor(), 2, quantity());
    }

    public int[] targetSetting() {
        return newArray(infor(), 3, quantity());
    }

}
