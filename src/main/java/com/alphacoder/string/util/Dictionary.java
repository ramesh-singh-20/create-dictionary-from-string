package com.alphacoder.string.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {

    public static void createDictionary(List<String> inputStringList){
        Map<String, String> dicMap= new TreeMap<>();

        for(int i=0; i<inputStringList.size(); i++){
            String currentLine= inputStringList.get(i).toLowerCase();
            currentLine= currentLine.substring(0, currentLine.length()-1);
            String [] tempArr= currentLine.split(" ");
            int line= i+1;
            for(String s1: tempArr) {
                s1= s1.toLowerCase();
                if(s1.contains(",")){
                    s1=s1.substring(0, s1.length()-1);
                }
                if (!dicMap.containsKey(s1)) {
                    int count = 1;
                    String value = String.valueOf(count) + ":" + String.valueOf(line);
                    dicMap.put(s1, value);
                } else {
                    String value = dicMap.get(s1);
                    int count = Integer.valueOf(value.split(":")[0]);
                    count = count + 1;
                    String lineTemp = value.split(":")[1];
                    lineTemp = lineTemp + "," + line;
                    value = count + ":" + lineTemp;
                    dicMap.put(s1, value);
                }
            }
        }
        for(Map.Entry<String, String> entry: dicMap.entrySet()){
            System.out.println(entry.getKey() + ":" + "{"+ entry.getValue()+"}");
        }
    }

    public static void main(String[] args) {
        String [] inputArr= new String[4];
        inputArr[0]= "Question, what kind of bear is best?";
        inputArr[1]= "That's a ridiculous question!";
        inputArr[2]= "False.";
        inputArr[3]= "Black bear.";

        createDictionary(Arrays.asList(inputArr));
    }
}
