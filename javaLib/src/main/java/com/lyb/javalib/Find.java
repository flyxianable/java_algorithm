package com.lyb.javalib;

import java.util.ArrayList;

public class Find {
    //bacha
    //bbaaccedfg
    /**
     * 要求从第一次输入的字符串中找出第二行字符串中有的，按照ascii编码排序,
     * 最终输出没有重复字母的字符串。
     * @param src
     * @param des
     */
    public void findSame(String src,String des){
        ArrayList<Character> result = new ArrayList<>();
        for(int j=0; j< src.length(); j++){
            for(int k=0; k< des.length();  k++){
                char element = src.charAt(j);
                if(element == des.charAt(k)){
                    if(!result.contains(element)){
                        result.add(element);
                    }
                }
            }
        }
        for(int j=0;j<result.size(); j++){
            for(int k=j+1; k<result.size();k++){
                char elementJ = result.get(j);
                char elementK = result.get(k);
                if((int)elementJ > (int)elementK){
                    result.set(j, elementK);
                    result.set(k, elementJ);
                }
            }
        }
        String output = "";
        for(int i=0;i<result.size(); i++){
            output += result.get(i);
        }
        System.out.println("output =" + output);
    }

}
