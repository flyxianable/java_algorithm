package com.lyb.javalib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Shell {

    String regex = ".*\\$\\{.*\\}.*";
    Pattern p = Pattern.compile(regex);

    public void treateShellString() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        int num = 0;
        if (scanner.hasNext()) {
            String str = scanner.next().trim();
            if (!str.isEmpty()) {
                try {
                     num = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        for(int i=0; i< num; i++){
            if(scanner.hasNext()){
                String str = scanner.next().trim();
                if(str.isEmpty()){
                    break;
                }
                input.add(str);
            }
        }
        String[] arr = new String[input.size()];
        treateShellString(input.toArray(arr));
    }

    /**
     * Linux shell脚本中${xxx}代表变量xxx的值,给定一个字符串中存在一个或多个${xxx},需要将字符串中所有的${xxx}替换成实际值.
     * 4
     * xxx=lyf/${ttt}/test
     * ttt=www
     * yyy=seeyou
     * aa=/aaa/${xxx}/bbb/${yyy}/ccc
     * 说明：第一行4为输入总行数，其余为输入字符串，
     * 输出：
     * /aaa/lyf/www/test/bbb/seeyou/ccc
     * 说明：将最后一行等号右边的实际值输出
     *
     * @param input
     */
    public void treateShellString(String[] input) {
        if(input == null || input.length == 0){
            return;
        }
        try {

            String changeStr = "${xxx}";
            String finalKey = "";
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < input.length; i++) {
                String[] arrData = input[i].split("=");
                if (arrData != null && arrData.length == 2) {
                    map.put(arrData[0], arrData[1]);
                    System.out.println("原字符串 ： " + input[i]);
                } else {
                    System.out.println("数据不合规，抛弃！");
                }
            }
            String[] lastLine = input[input.length - 1].split("=");
            if (lastLine == null || lastLine.length != 2) {
                System.out.println("数据不合规，程序结束");
            } else {
                finalKey = lastLine[0];

            }


            //循环替换，直到所有的语句都没有匹配项（即都是干净串）
            while (isMatch(map)) {
                change(map);
            }

            testIter(map);

            String result = map.get(finalKey);
            System.out.println("输出结果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 先找出没有${xxx}的串，然后跟其他串进行循环匹配，并替换
     *
     * @param map
     */
    private void change(HashMap<String, String> map) {
        try {
            Iterator<String> iterator1 = map.keySet().iterator();
            while (iterator1.hasNext()) {
                String key1 = iterator1.next();
                String value1 = map.get(key1);
                String shellKey = "${" + key1 + "}";
                //不匹配的，则说明是已经替换完成的（起名叫做干净串），可以用于对其他串进行匹配替换
                if (!p.matcher(value1).matches()) {
                    System.out.println("shellKey = " + shellKey);
                    System.out.println("value1 = " + value1);
                    Iterator<String> iterator2 = map.keySet().iterator();
                    while (iterator2.hasNext()) {
                        String key2 = iterator2.next();
                        String value2 = map.get(key2);
                        System.out.println("替换前 value2 = " + value2);
                        //对字符串里包含shell关键字内容的进行替换
                        if (value2.contains(shellKey)) {
                            value2 = value2.replace(shellKey, value1);
                            System.out.println("替换后 value2 = " + value2);
                            map.put(key2, value2);
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 是否还有${xxx}的串
     *
     * @param map
     * @return
     */
    public boolean isMatch(HashMap<String, String> map) {
        //遍历，对除最后一句的输入进行替换
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key);
            if (p.matcher(value).matches()) {
                return true;
            }
        }
        return false;
    }

    public void testMatch() {
        String test = "lyf/${ttt}/test";
        boolean isMatch = p.matcher(test).matches();
        System.out.println("isMatch = " + isMatch);
    }

    public void testIter(HashMap<String, String> map) {
        Iterator<String> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            String key1 = iterator1.next();
            System.out.println("key1 =" + key1);
            System.out.println("value1 =" + map.get(key1));
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                System.out.println("key =" + key);
                System.out.println("value =" + map.get(key));
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key =" + key);
            System.out.println("value =" + map.get(key));
        }
    }

    public void testScanner(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String str = scanner.next().trim();
            System.out.println(str);
        }
    }

}
