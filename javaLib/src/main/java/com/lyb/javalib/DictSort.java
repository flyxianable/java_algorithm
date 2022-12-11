package com.lyb.javalib;

public class DictSort {

    public void sort(String[] input){
        for(int j=0; j< input.length; j++){
            for(int k=j+1; k<input.length; k++){
                char charJ = input[j].charAt(0);
                char charK = input[k].charAt(0);
                if(charJ > charK){
                    String temp = input[j];
                    input[j] = input[k];
                    input[k] = temp;
                }
            }
        }

        System.out.println(getString(input));
    }

    private String getString(String[] input){
        String output = "";
        for(int i=0; i< input.length; i++){
            output += input[i] + "\n";
        }
        return output;
    }


}
