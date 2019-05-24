package com.uhcl.amazonsellers.Utilities;

import java.util.*;
;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FrequencyMapper is a word count operation for a given String.
 */
public class FrequencyMapper {
    /**
     * Iterative count of the individual words present in a String
     * @param str
     * @return
     */
    public static Map<String,Integer> doWordCount(String str) {
        List<String> list = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());

        Map<String, Integer> wordCounter = list.stream()
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

        return wordCounter;
    }

    /**
     * Function that sorts on the basis of the individual word count.
     * @param unsortMap
     * @return
     */
    public static Map<String,Integer> doSorting(Map<String,Integer> unsortMap){
        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;

    }
}
