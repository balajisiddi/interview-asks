package StringProblems;

import java.util.*;

public class KDistinct_Substring {

    static List<Integer> removeDuplicates(int[] nums){
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            if(!seen.contains(num)){
                seen.add(num);
                result.add(num);
            }
        }
        return result;
    }

    public static String largest_unique_substring(String s){
        int maxLen =0;
        int left =0;
        int startIndex =0;
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        for(int right =0; right<s.length(); right++){
            char currentChar = s.charAt(right);
            if(lastSeenIndex.containsKey(currentChar)){
                left = Math.max(left, lastSeenIndex.get(currentChar)+1);
            }
            lastSeenIndex.put(currentChar, right);
            if(right - left +1 > maxLen){
                maxLen = right - left +1;
                startIndex = left;
            }
        }
        return  s.substring(startIndex, startIndex+maxLen);
    }
    static String larg_subString(String s){
        int maxLen = 0;
        int left = 0;
        int startIndex = 0;
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(lastSeenIndex.containsKey((currentChar))){
                left = Math.max(left, lastSeenIndex.get(currentChar) + 1);
            }
            lastSeenIndex.put(currentChar, right);
            if(right - left + 1 >maxLen){
                maxLen = right - left +1;
                startIndex = left;
            }
        }
        return  s.substring(startIndex, startIndex + maxLen);
    }
    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left =0;
        for(int right =0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(lastSeen.containsKey(currentChar)){
                left = Math.max(left, lastSeen.get(currentChar)+1);
            }
            lastSeen.put(currentChar, right);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
    //    getting the substring instead of the len of the longest unique substring
    public static String longest_unique_substring(String s){
        int maxLen = 0;
        int left =0;
        int startIndex =0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        for(int right =0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(lastSeen.containsKey(currentChar)){
                left = Math.max(left, lastSeen.get(currentChar)+1);
            }
            lastSeen.put(currentChar, right);
            if(right - left +1 > maxLen){
                maxLen = right - left + 1;
                startIndex =left;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
    public static String largest_unique_subString(String s){
        int maxLen =0;
        int left =0;
        int start =0;
        Map<Character, Integer> seen = new HashMap<>();
        for(int right =0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(seen.containsKey(currentChar)){
                left = Math.max(left, seen.get(currentChar));
            }
            seen.put(currentChar, right);
            if(right - left + 1 > maxLen){
                maxLen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxLen);
    }
    public static String get_larget_unique_substring(String s){
        int maxLen =0;
        int left =0;
        int startIndex =0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int right = 0; right < s.length(); right++){
            char currrentChar = s.charAt(right);
            if(lastSeen.containsKey(currrentChar)){
                left = Math.max(left, lastSeen.get(currrentChar) + 1);
            }
            lastSeen.put(currrentChar, right);
            if(right - left + 1 > maxLen){
                maxLen = right - left +1;
                startIndex =left;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
    static void k_distinct_char_unique_substring(String s, int k){
        int n = s.length();
        List<String> subStrings = new ArrayList<>();
        Map<Character, Integer> char_frequencies = new HashMap<>();
        int p1 = 0;
        for(int p2 = 0; p2 < n; p2++){
            char rChar = s.charAt(p2);
            char_frequencies.put(rChar, char_frequencies.getOrDefault(rChar, 0) + 1);
            while(char_frequencies.size() > k){
                char lChar = s.charAt(p1);
                char_frequencies.put(lChar, char_frequencies.get(lChar) - 1);
                if(char_frequencies.get(lChar) == 0){
                    char_frequencies.remove(lChar);
                }
                p1++;
            }
            if(char_frequencies.size() == k){
                String distinct = s.substring(p1, p2 + 1);
                subStrings.add(distinct);
                System.out.println("K Distinct SubString found:: "+distinct);
            }
        }
        System.out.println(subStrings);
    }

    public static void main(String[] args) {
        KDistinct_Substring.k_distinct_char_unique_substring("adeceeeee", 2);
    }



}
