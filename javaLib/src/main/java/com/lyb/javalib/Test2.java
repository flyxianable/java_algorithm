package com.lyb.javalib;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args){
        treate();
    }

    private static void treate(){
        int roomNum = 0;
        int manNum = 0;
        ArrayList<String> array = input();
        roomNum = Integer.parseInt(array.get(0));
        manNum = array.get(1).length();
        if(roomNum >= manNum){
            System.out.println("所有出差人员都成功入住");
        }else{
            int rest = manNum - roomNum;
            System.out.println(rest + " 个出差人员无法入住");
        }
    }


    private static ArrayList<String> input() {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.isEmpty()) {
                break;
            }
            list.add(input);
//            System.out.println(input);

        }
        return list;
    }

}
