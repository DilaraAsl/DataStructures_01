package cydeo.com.groupTasks;

import java.util.*;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s="(((()))";
        System.out.println(getLongestValidParentheses(s));
    }


    public static int getLongestValidParentheses(String s) {
        int left=0;
        int right=0;
        int max=0;

        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
            {
                max=Math.max(max,left*2);
            }else if(right>left)  // ()) when right is greater than left there is no possiblity of  closing the right
            {
                left=0;
                right=0;
            }
        }

        left=0;
        right=0;

        for(int i=s.length()-1;i>=0;i--)
        {
            if (s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
            {
                max=Math.max(max,left*2);
            }else if(left>right) //(() when left we are traversing from right to left if left is greater there is no possiblity of closing the left
            {
                left=0;
                right=0;
            }
        }

        return max;

    }
//    public static int getLongestValidParenthesesNo(String s){
//        if(s.isEmpty()||s==null) return 0;
//        if(s.length()==1) return 0;
//        char[] arr=s.toCharArray();
//        int length=arr.length;
//        boolean valid=false;
//
//        Stack<Character> stack=new Stack<>();
//        int count=0;
//        int right=0;
//        List<Integer> list=new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//
//           if(stack.isEmpty()&& arr[i]==')') { valid=false; continue; } //invalid
//            if(right==0&&arr[i]==')') {valid=false;}
//           if(stack.isEmpty()&&arr[i]=='('){ stack.push(arr[i]); right++;}
//
//           else if(!stack.isEmpty()&& arr[i]=='('&& stack.peek()=='(') {stack.push(arr[i]);right++;}
//           else if(!stack.isEmpty()&& arr[i]==')' && stack.peek()=='('){
//               stack.pop();
//              count+=2;
//              right--;
//              valid=true;
//           }
//
//
//           if(valid==false&&right==0&&count!=0){list.add(count); count=0;}
//
//
//        }
//
//if(count!=0&&right==0) list.add(count);
//if (list.isEmpty()) return 0;
//
//
//       return Collections.max(list);
//
//
//
//
//
//    }

    public static int getLongestValidParenthesesReverse(String s){
        if(s.isEmpty()||s==null) return 0;
        if(s.length()==1) return 0;
        char[] arr=s.toCharArray();
        int length=arr.length;
        boolean valid=false;

        Stack<Character> stack=new Stack<>();
        int count=0;
        int right=0;
        List<Integer> list=new ArrayList<>();
        for (int i = arr.length-1; i>=0; i--) {

            if(stack.isEmpty()&& arr[i]=='(') { valid=false; continue; } //invalid
            if(right==0&&arr[i]==')') {valid=false;}
            if(stack.isEmpty()&&arr[i]=='('){ stack.push(arr[i]); right++;}

            else if(!stack.isEmpty()&& arr[i]=='('&& stack.peek()=='(') {stack.push(arr[i]);right++;}
            else if(!stack.isEmpty()&& arr[i]==')' && stack.peek()=='('){
                stack.pop();
                count+=2;
                right--;
                valid=true;
            }


            if(valid==false&&right==0&&count!=0){list.add(count); count=0;}


        }

        if(count!=0&&right==0) list.add(count);
        if (list.isEmpty()) return 0;


        return Collections.max(list);





    }
}
