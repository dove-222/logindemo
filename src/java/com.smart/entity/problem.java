package com.smart.entity;



import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.text.DecimalFormat;
import java.util.*;

public class problem {

  public static void main (String[] args){

    Scanner in = new Scanner(System.in);
    System.out.println(FirstNotRepeatingChar("google"));

  }
  static public int FirstNotRepeatingChar(String str) {
    if(str=="") return -1;
    else{
      LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    for (int i = 0; i < str.length();i++){
      if(map.containsKey(str.charAt(i))){
        int time1 = (int) map.get(str.charAt(i));
        time1++;
        map.put(str.charAt(i),time1);
      }
      map.put(str.charAt(i),1);
    }
    int i = 0;
    for(; i < str.length(); i++){
      char c = str.charAt(i);
      if(map.get(c)==1) return i;
    }
    }
    return -1;
  }

  static public int FirstNotRepeatingChar1(String str) {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    for(int i=0;i<str.length();i++){
      if(map.containsKey(str.charAt(i))){
        int time = map.get(str.charAt(i));
        map.put(str.charAt(i), ++time);
      }
      else {
        map.put(str.charAt(i), 1);
      }
    }
    int pos = -1;
    int i=0;
    for(;i<str.length();i++){
      char c = str.charAt(i);
      if (map.get(c) == 1) {
        return i;
      }
    }
    return pos;
  }


}
