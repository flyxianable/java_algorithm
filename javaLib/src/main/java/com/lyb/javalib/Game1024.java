package com.lyb.javalib;

public class Game1024 {

    private int result;
    private int counter;
    int[] arrNumber = new int[10];
    int[] arrAmount = {2000,1,1,1,20,1,20,1,10,0};
//    int[] arrAmount = {1,1,1,1,20,1,20,1,10,0};
//    int[] arrAmount = {1,50,1,1,20,1,20,1,10,0};
//    int[] arrAmount = {0,0,0,0,0,0,0,0,0,6};
    private final int TARGET = 2048;


    public void count(){
        init();
        add();
    }

    private void init(){
        for(int i =0; i< 10; i++){
            arrNumber[i] = (int)Math.pow(2, i+1);
//            System.out.println("nums1024 =" + arrNumber[i]);
        }
    }

    /**
     * 递归
     */
    private void add(){
        System.out.println("add");
        try {
            for(int i=0; i< arrAmount.length; i++){
                System.out.println("for i = " + i);
                //双数的个数
                int doubleAmount = arrAmount[i] / 2;
                if(doubleAmount > 0){
                    System.out.println("for double = " + doubleAmount);
                    int tempResult =  arrNumber[i] * doubleAmount * 2;
                    if(tempResult > TARGET){
                        int newAmount = TARGET / arrNumber[i];
                        counter += newAmount;
                        result = newAmount * arrNumber[i];
                    }else{
                        result = doubleAmount * arrNumber[i];
                        arrAmount[i] -= doubleAmount * 2;
                    }
                    if(result == TARGET){
                        System.out.println("ok got it : the result is 2048");
                        System.out.println("计算次数 is : " + counter);
                        break;
                    }
                    if(i+1 < arrAmount.length) {
                        System.out.println("for i+1 = " + (i+1));
                        arrAmount[i + 1] += doubleAmount;
                        tempResult = arrAmount[i + 1] * arrNumber[i + 1];
                        System.out.println("tempResult " + tempResult);
                        if(tempResult > TARGET){
                            int newAmount = TARGET / arrNumber[i+1];
                            System.out.println("newAmount " + newAmount);
                            counter += newAmount;
                            result = newAmount * arrNumber[i + 1];
                        }else {
                            counter += doubleAmount;
                            result = arrAmount[i + 1] * arrNumber[i + 1];
                        }

                        System.out.println("result " + result);
                    }
                    if(result == TARGET){
                        System.out.println("ok got it : the result is 2048");
                        System.out.println("计算次数 is : " + counter);
                        break;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
