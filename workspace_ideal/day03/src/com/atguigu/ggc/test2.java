package com.atguigu.ggc;

public class test2 {
    public static void main(String[] args) {

    }
    //将一个字符串进行翻转,将指定部分进行翻转,比如:"abcdefg"翻转为"abfedcg"
   //方式一:转换为char[]
     public String reverse(String str,int startIndex,int endIndex){
         if(str != null){
             char[] arr = str.toCharArray();
             for(int x = startIndex,y = endIndex; x < y; x++,y--){
                 char temp = arr[x];
                 arr[x] = arr[y];
                 arr[y] = temp;
             }
             return new String(arr);
         }
         return null;
     }
//     获取一个字符串在另一个字符串中出现的次数,比如:获取"ab"在"abkkcadkabfkabkskab"中出现的次数
//    public int getCount(String mainStr,String subStr){
//        int mianLength = mainStr.length();
//        int subLength = subStr.length();
//        int count = 0;
//        int index;
//        if(mainLength >= subLength){
//            while ( (index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
//            return count;
//        }else {
//            return 0;
//        }
//    }
    //获取两个字符串中最大相同子串,比如:str = "abcwerthelloyuiodef"; str2 = "cvhellobnm"

}
