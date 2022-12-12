package com.lyb.javalib;

import java.util.HashMap;

/**
 * 一公司使用字符串来记录考勤，首行输入的数字代表接下来需要判断的员工数，后面每一行代表一个员工的出勤记录，每行不超过10000个字符，每个单词代表每天的出勤情况，
 * 。
 * <p>
 * 获得全勤奖的规则是：缺勤不超过1次，没有连续的迟到/早退，
 * 任意连续7天内出现缺勤/迟到/早退的次数不超过3次。
 */
public class WorkDay {

    int continuous = 0;
    int countDay = 0;

    String[] arrWork;
    HashMap<String, Integer> map;

    /**
     * 判断全勤
     */
    public boolean treateFullWork(String workData) {

        treateInput(workData);
        //present代表正常出勤，absent代表缺席，late代表迟到，leaveearly代表早退，单词之间用空格隔开
        // 获得全勤奖的规则是：缺勤不超过1次，没有连续的迟到/早退，
        //  任意连续7天内出现缺勤/迟到/早退的次数不超过3次。

        int absent = map.get("absent");
        if (absent > 1) {
            return false;
        }
        if(!isOKForContinusLateleaveearly(workData)){
            return false;
        }

        //连续判断
        for(int i=0; i< arrWork.length; i++){
            if(!isOKFor7WorkDay(arrWork, i)){
                return false;
            }
        }

        return true;

    }

    public void treateInput(String workData) {

        arrWork = workData.split(" ");

        map = new HashMap();

        for (int i = 0; i < arrWork.length; i++) {
            String key = arrWork[i];

            if (map.containsKey(key)) {

                map.put(arrWork[i], map.get(key) + 1);

            } else {

                map.put(arrWork[i], 1);
            }
        }
    }

    /**
     * 递归
     * 任意连续7天内出现缺勤/迟到/早退的次数不超过3次
     *
     * @param arrWork
     * @param index
     */
    private boolean isOKFor7WorkDay(String[] arrWork, int index) {
        String hit = "absent late leaveearly";
        if (index >= arrWork.length) {
            return true;
        }
        String key = arrWork[index];
        if (hit.contains(key)) {
            continuous++;
            countDay ++;
        }
        if(countDay <= 7 && continuous > 3){
            return false;
        }
        if(countDay < 7) {
            isOKFor7WorkDay(arrWork, index + 1);
        }
        return true;
    }

    /**
     * 没有连续的迟到/早退
     * @return
     */
    private boolean isOKForContinusLateleaveearly(String workData){
        String[] hit = {"late leaveearly", "leaveearly late", "late late", "leaveearly leaveearly"};
        for(int i=0; i< hit.length; i++){
            if(workData.contains(hit[i])){
                return false;
            }
        }
        return true;
    }

}
