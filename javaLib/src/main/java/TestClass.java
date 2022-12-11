import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        count2048();
    }

    private static int count2048() {
        int result = 0;
        int minCount = 0;
        //数字数量
        ArrayList<Integer> listInput = input();
        //数字
        int[] nums = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        int[] arraySmall = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arraySmall[i] = 2048 / nums[i];
        }
        for (int i = listInput.size() - 1; i > 0; i--) {
            if (listInput.get(i).intValue() == arraySmall[i]) {
                minCount = arraySmall[i];
            }
        }
        return minCount;
    }

    /**
     * 输入
     *
     * @return
     */
    private static ArrayList<Integer> input() {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.isEmpty() || input.length() < 10) {
                continue;
            }
            System.out.println(input);
            String[] array = input.split(" ");
            for(int i=0; i< array.length; i++){
                try {
                    int num = Integer.parseInt(array[i]);
                    list.add(num);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

        }
        return list;
    }


}
