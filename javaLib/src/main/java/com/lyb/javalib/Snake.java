package com.lyb.javalib;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    List<Character> arrSmallSnake = new ArrayList<>();
    List<Character> arrBigSnake = new ArrayList<>();


    /**
     * 1.蛇形字符串由连续字符对组成，其特点如下：
     * 1.1 字符对定义：字符对由同一字母的大写和小写组成（前大后小）。如：Aa，Dd；
     * 1.2 蛇形字符串中包含的字符对，必须是连续字母，并按照字母顺序排序。如：AaBbCc或OoPpQqRrSs；
     * 2.从输入中寻找字符组成蛇形字符串（字符顺序不限），符合规则：
     * 2.1 每次寻找必须是最长的蛇形字符串；
     * 2.2 使用过的字符不能重复使用；
     */

    public String findSnakeNumber(String input) {
        String snakeString = "";
        try {
            int a = (int) 'a';
            int z = (int) 'z';
            int A = (int) 'A';
            int Z = (int) 'Z';

            //大小写字母之间的Ascii码差值
            int space = Math.abs(a - A);

            //把大小写字母分别拆出来
            List<Character> small = new ArrayList<>();
            List<Character> big = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                int ascii = (int) input.charAt(i);
                if (ascii >= a && ascii <= z) {
                    small.add(input.charAt(i));
                }
                if (ascii >= A && ascii <= Z) {
                    big.add(input.charAt(i));
                }
            }
            //大小写字母分别排序
            sort(small);
            sort(big);

            print(small);
            print(big);

            //通过递归把连续的大小写字母分别加入各自的数组
            treateSnack(arrSmallSnake, small, 0);
            print(arrSmallSnake);
            treateSnack(arrBigSnake, big, 0);
            print(arrBigSnake);

            //将两个大写和小写连续字母数组中的字母进行查找匹配，并进行拼接：大写在前，小写在后
            for (int j = 0; j < arrSmallSnake.size(); j++) {
                for (int k = 0; k < arrBigSnake.size(); k++) {
                    char smallChar = arrSmallSnake.get(j);
                    char bigChar = arrBigSnake.get(k);
                    if((int)smallChar - (int)bigChar == space){
                        snakeString += bigChar + "" + smallChar;
                    }
                }
            }
            System.out.println("snakeString = " + snakeString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return snakeString;
    }

    /**
     * 字母排序
     * @param listChars
     * @return
     */
    public List<Character> sort(List<Character> listChars) {
        try {
            for (int j = 0; j < listChars.size(); j++) {
                for (int k = j + 1; k < listChars.size(); k++) {
                    int asciiJ = (int) listChars.get(j);
                    int asciik = (int) listChars.get(k);
                    if (asciiJ > asciik) {
                        char temp = listChars.get(j);
                        listChars.set(j, listChars.get(k));
                        listChars.set(k, temp);
                    }
                }
            }
            return listChars;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChars;
    }


    /**
     * 递归方法
     * 去掉不连续的字母
     *  startIdx从0开始
     * @param arrSnake
     * @param arrInputChars
     * @param startIdx
     */
    private void treateSnack(List<Character> arrSnake, List<Character> arrInputChars, int startIdx) {
        if (startIdx >= arrInputChars.size()-1) {
            return;
        }
        int e0 = (int) arrInputChars.get(startIdx);
        int e1 = (int) arrInputChars.get(startIdx + 1);
        if (e1 - e0 == 1) {
            addSnack(arrSnake, arrInputChars.get(startIdx));
            addSnack(arrSnake, arrInputChars.get(startIdx + 1));
        }
        treateSnack(arrSnake, arrInputChars, startIdx + 1);
    }

    /**
     * 排重添加元素
     * @param arrSnake
     * @param element
     */
    private void addSnack(List<Character> arrSnake, char element) {
        if (arrSnake == null) {
            arrSnake = new ArrayList<>();
        }
        if (!arrSnake.contains(element)) {
            arrSnake.add(element);
        }

    }

    private String getString(List<Character> listChars) {
        String output = "";
        for (int j = 0; j < listChars.size(); j++) {
            output += listChars.get(j);
        }
        return output;
    }


    private void print(List<Character> listChars) {
        System.out.println(getString(listChars));
    }

}
