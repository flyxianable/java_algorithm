package com.lyb.javalib;

public class Sort {

    /**
     * 插入排序
     * 算法复杂度：o(n*(n/2))
     */
    public void sortByInsert(){
//        String input = "15 2 4 8 7 9 3";
        String input = "15 13 11 9 7 5 3";
        String split = " ";
        int count = 0;
        String[] array = input.split(split);
        for(int j=0; j< array.length; j++){
            for(int k=j+1; k< array.length; k++){
                int numJ = Integer.parseInt(array[j]);
                int numK = Integer.parseInt(array[k]);
                System.out.println("numJ = " + "J =" + j + "; " + numJ);
                System.out.println("numK = " + "k =" + k + "; " + numK);
                count ++;
                if(numJ > numK){
                    String temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                    System.out.println("change");
                    outputResult(array, split);

                }
            }
        }
        outputResult(array, split);
        System.out.println("count = " + count);

    }

    /**
     * 冒泡排序
     * 算法复杂度：o(n^2))
     */
    public void sortByBubble(){
//        String input = "15 2 4 8 7 9 3";
        String input = "15 13 11 9 7 5 3";
        String split = " ";
        int count = 0;
        String[] array = input.split(split);
        for(int j=0; j< array.length; j++){
            for(int k=0; k< array.length; k++){
                int numJ = Integer.parseInt(array[j]);
                int numK = Integer.parseInt(array[k]);
                System.out.println("numJ = " + "J =" + j + "; " + numJ);
                System.out.println("numK = " + "k =" + k + "; " + numK);
                count ++;
                if(numJ > numK){
                    String temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                    System.out.println("change");
                    outputResult(array, split);

                }
            }
        }
        outputResult(array, split);
        System.out.println("count = " + count);

    }

    private static void outputResult(String[] array, String split){
        String output = "";
        for(int i=0; i< array.length; i++){
            output += array[i] + split;
        }
        output = output.substring(0, output.length() - 1);
        System.out.println(output);
    }
}
