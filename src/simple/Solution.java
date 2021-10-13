package simple;

import javax.crypto.MacSpi;
import java.util.*;

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

    //二进制求和
    public static String addBinary(String a, String b){
        /*return Integer.toBinaryString(
                Integer.parseInt(a,2) + Integer.parseInt(b,2)
        );*/
        String newBinary = new String();
        int l = (a.length() > b.length()) ? a.length():b.length();
        int isCarry = 0;
        for (int i = 0; i < l; i ++){
            isCarry += i < a.length() ? a.charAt(a.length() - 1 - i) - '0': 0;
//            System.out.println(a.charAt(a.length() - 1 - i));
            isCarry += i < b.length() ? b.charAt(b.length() - 1 - i) - '0': 0;
//            System.out.println(b.charAt(b.length() - 1 - i));
//            System.out.println(isCarry + "carry");
            newBinary = newBinary + (char)((isCarry % 2) + '0');
            isCarry = isCarry / 2;
        }
        if (isCarry > 0){
            newBinary += '1';
        }
        newBinary = new StringBuffer(newBinary).reverse().toString();
        return newBinary;
    }

    //实现sqrt()函数(二分法)
    public static int mySqrt(int x){
        int right = (x / 2) + 1;
        int left = 0;
        while (left < right){
            int mid = (left + right) / 2 + 1;
            if (Math.pow(mid,2) > x){
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        return left;

    }

    //相同的树（递归）
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null || q == null){
            return false;
        }
        else if(p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return judge(root,root);
}
        public  boolean  judge(TreeNode  l,TreeNode  r){
                if(l  ==  null  &&  r  ==  null){
                        return  true;
                }
                if(l  ==  null  ||  r  ==  null){
                        return  false;
                }
                        return  (l.val  ==  r.val)  &&  judge(l.left,r.right)  &&  judge(r.left,l.right);
                
        }

    //合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n){
        for (int i = 0; i < n; i ++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //二叉树的最大深度(Queue)
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        //定义队列，层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            depth ++;
        }
        return depth;
    }


    //有序数组构造二叉树(递归)
    public TreeNode sortedArrayToBST(int[] nums){
        return dfs(nums,0,nums.length - 1);
    }
    private TreeNode dfs(int[] nums,int left,int right){
        if (left > right){
            return null;
        }
        int mid = (left + right) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid - 1);
        root.right = dfs(nums,mid + 1, right);
        return root;
    }


    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    //树高
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    //二叉树的最小深度
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }


    //路经总和
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return (root.val - targetSum) == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val );
    }

    //环形链表
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(p != q){
            if(q == null || q.next == null ){
                return false;
            }
            p = p.next;
            q = q.next.next;

        }
        return true;
    }

    //相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();

        ListNode p = headA;
        //遍历A链表，存入哈希表
        while (p != null){
            hashSet.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null){
            if (hashSet.contains(p)){
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //两数之和-有序数组
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target){
            int temp = numbers[i] + numbers[j];
            if (temp > target){
                j --;
            }else {
                i ++;
            }
        }
        return  new int[] {i,j};
    }

    //多数元素（Boyer-Moore 投票算法）
    public int majorityElement(int[] nums){
        int count = 0;
        Integer candidate = null;
        for (int num : nums){
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    //Excel表列序号
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i ++){
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }


    //二叉树中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    
    //Excel表列名称
    public String convertToTitle(int columnNumber){
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            columnNumber --;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = null, temp = null;
        int carry = 0; //进位
        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;//取值 为空则用0代替
            int sum = n1 + n2 + carry;
            if(res == null){
                res = temp = new ListNode(sum % 10);    //结果链表为空则从头赋值，
            }else{
                temp.next = new ListNode(sum % 10);     //结果不空，temp滑动
                temp = temp.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //如果还存在进位，需在末尾加上
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 1;

        System.out.println( mySqrt(x));
        System.out.println(Math.sqrt(x));
    }
}
