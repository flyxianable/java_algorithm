package com.lyb.javalib;

public class MyClass {

    public static void main(String[] args){

        System.out.println("hello rongyao");

//        sortData();
//
//        treateSnake();

//        treateShell();

//        treateDictSort();

//        treateFind();

//        treateWorkDay();

        treate1024();

    }

    public static void sortData(){
        //排序
        Sort sort = new Sort();
        sort.sortByInsert();
        sort.sortByBubble();
    }

    public static void treateSnake(){
        Snake snake = new Snake();
//        String input = "SxxsrR^AaSs";
        String input = "SxxsrR^AaSsOPQttppqqddssaaAAqTTWWWwwZZzz";
        snake.findSnakeNumber(input);
    }

    public static void treateShell(){
//        String[] input = {"xxx=lyf/${ttt}/test", "ttt=www", "yyy=seeyou", "aa=/aaa/${xxx}/bbb/${yyy}/ccc"};
        String[] input = {"yyy=seeyou${ttt}", "ttt=www${ddd}", "xxx=lyf/${ttt}/test" ,"ddd=goodby", "aa=/aaa/${xxx}/bbb/${yyy}/ccc${ttt}"};
//        String[] input = {"yyy=seeyouwwwgoodby", "ttt=wwwgoodby", "xxx=lyf/wwwgoodby/test" ,"ddd=goodby", "aa=/aaa/lyf/wwwgoodby/test/bbb/seeyouwwwgoodby/cccwwwgoodby"};

        Shell shell = new Shell();
//        shell.treateShellString();
        shell.testScanner();
    }

    public static void treateDictSort(){
        DictSort dictSort = new DictSort();
        String[] input = {"try", "want", "jack", "me", "fish", "ash", "jack", "dish", "beauty", "kiss"};
        dictSort.sort(input);
    }

    public static void treateFind(){
        Find find = new Find();
//        find.findSame("bacha", "bbaaccedfg");
        find.findSame("geaaehg", "ahsskdjfkiuig");
    }

    public static void treateWorkDay(){
        WorkDay workDay = new WorkDay();
//        workDay.treateFullWork("absent present late present present present " +
//                "present leaveearly late present present");

        workDay.treateFullWork("absent present present present present late " +
                "present leaveearly present present late");

    }

    public static void treate1024(){
        new Game1024().count();
    }



}