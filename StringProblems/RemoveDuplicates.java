package StringProblems;

import java.util.Arrays;

public class RemoveDuplicates {
    static void re_move_duplicates(int[] arr){
//        without using Collections
//        two pointer approach. This is a unsorted array
        int p1 =0;
        for(int p2=0; p2<arr.length; p2++){
            if(arr[p2] != arr[p1]){
                p1++;
                arr[p1] = arr[p2];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, p1)));

    }
    static boolean palindrom_tow_pointer(String s){
        int p1 =0;
        int p2 =s.length()-1;
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
    static String moveZerosToEnd(String s){
        char[] chars = s.toCharArray();
        int write =0;
        for(int read = 0; read < s.length(); read++){
            if(chars[read] != '0'){ //1020304
                chars[write++] = chars[read];
            }
        }
        while(write < chars.length){
            chars[write++] = '0';
        }
        return new String(chars);
    }
    static String moveVowels_to_end(String s){
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        StringBuilder vowels = new StringBuilder();
        int write = 0;
        for(char c: chars){
            if("aeiouAEIOU".indexOf(c) != -1){
                vowels.append(c);
            }else {
                result[write++] = c;
            }
        }
        for (int i = 0; i < vowels.length(); i++){
            result[write++] = vowels.charAt(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        RemoveDuplicates.re_move_duplicates(new int[]{1,1,2,3,3,4,3});
        RemoveDuplicates.moveZerosToEnd("1020304");
        System.out.println("aeiouAEIOU".indexOf('a'));
    }
}
