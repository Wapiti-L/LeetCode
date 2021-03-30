package simple;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Wapiti
 * @date 2020/3/19
 */
public class Solution {
    //罗马数字转整数
    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        for(int i = 0;i <= arr.length - 1;i ++){
            switch(arr[i]){
                case'I':
                    if(i <= arr.length - 2){
                        if(arr[i+1] == 'V' || arr[i+1] == 'X'){
                            result -= 1;
                            break;
                        }
                    }
                    result += 1;
                    break;

                case'V':
                    result += 5;
                    break;

                case'X':
                    if(i <= arr.length - 2){
                        if(arr[i+1] == 'L' || arr[i+1] == 'C'){
                            result -= 10;
                            break;
                        }
                    }
                    result += 10;
                    break;

                case'L':
                    result += 50;
                    break;

                case'C':
                    if(i <= arr.length - 2){
                        if(arr[i+1] == 'D' || arr[i+1] == 'M'){
                            result -= 100;
                            break;
                        }
                    }
                    result += 100;
                    break;

                case'D':
                    result += 500;
                    break;

                case'M':
                    result += 1000;
                    break;
                default :
                    System.out.println("未知错误");

            }
        }
        return result;

    }

    //最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
       String pre = "";

       if (strs.length == 0) {
           return "";
       }
       for (int i = 0; i < strs[0].length(); i ++){
           int j = 0;
           for(;j < strs.length && i < strs[j].length(); j ++ ){
               //System.out.println(strs[0].substring(0,i+1));
               if (!strs[0].substring(0, i+1).equals(strs[j].substring(0, i+1))){
                   break;
               }

               if (j == strs.length - 1){
                   pre = strs[0].substring(0,i+1);

               }
           }
       }

        return pre;
    }

    //有效括号
    public static Boolean isValid(String s){
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        if (arr.length / 2 == 1) {
            return false;
        }
        for (int i = 0; i < arr.length; i ++){
            if (arr[i].equals("{") || arr[i].equals("(") || arr[i].equals("[")){
                stack.push(arr[i]);
            }
            else if (stack.empty()){
                return false;
            }
            else {
                if (stack.peek().equals("{") && arr[i].equals("}") ||
                    stack.peek().equals("[") && arr[i].equals("]") ||
                    stack.peek().equals("(") && arr[i].equals(")") ) { stack.pop(); }
                else {
                    return false;
                }

            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }

    }

    //合并两个有序链表
    public static LinkedList mergeTwoLists(LinkedList l1, LinkedList l2){

        return null;


    }

    //位1的个数
    public static int hammingWeight(int n){
        int num = 0;
        for (int i = 0; i < 32; i ++ ){
            if((n & (1 << i)) != 0){
                num ++;
            }
        }

        return num;
    }

    //原地删除有序数组中的重复项
    public static int removeDuplicates(int[] nums)  {
        int i = 0, j = 1;
        while (j < nums.length){
            if(nums[i] == nums[j]){
                j ++;
            }else {
                nums[i+1] = nums[j];
                i ++;
                j ++;
            }
        }
        return i+1;
    }

    //原地移除元素
    public static int removeElement(int[] nums, int val){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j ++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }

    //实现strSTR()函数
    public static int strSTR(String haystack, String needle){
        int local = -1;
        local = haystack.indexOf(needle,0);
        return local;
    }

    //搜索插入位置
    public static int searchInsert(int[] nums, int target){
        int right = nums.length - 1;
        int left = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            if (target <= nums[mid]){

                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  left;
    }

    //最后一个单词的长度
    public static int lengthOfLastWord(String s){
        if (s == null){
            return 0;
        }
        int length = 0;
        String[] arr = s.split(" ");
        return length = (arr.length != 0) ? arr[arr.length - 1].length():0;
    }

    //加一
    public static int[] plusOne(int[] digits){
        int i = digits.length - 1;
        while (digits[i] + 1 == 10 && i != 0){
            digits[i] = 0;
            i --;

        }
        if (i == 0 && digits[i] == 9){
            digits = new int[digits.length + 1];
            digits[i] =1;
            digits[digits.length - 1] = 0;
            return digits;
        }
        digits[i] += 1;
        return digits;


    }


    public static void main(String[] args) {
        //String strs = "hello world";
        int[] digits ={1,2,3};
        System.out.println();
    }
}
