package com.example.tu_dien_anh_viet.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository {
    private static final Map<String,String> englishToVietnamese=new HashMap<>();
    private static final Map<String,String> vietnameseToEnglish=new HashMap<>();
    static {
        englishToVietnamese.put("dog", "con chó");
        englishToVietnamese.put("cat", "con mèo");
        englishToVietnamese.put("pig", "con lợn");
        vietnameseToEnglish.put("con trâu", "buffalo");
        vietnameseToEnglish.put("con chuột", "rat");
        vietnameseToEnglish.put("con bò", "cow");
    }

    public String translate(String word, String direction) {
        if (word == null || direction == null) return null;
        word = word.toLowerCase();

        if (direction.equals("englishToVn")) {
            return englishToVietnamese.get(word);
        } else if (direction.equals("vnToEnglish")) {
            return vietnameseToEnglish.get(word);
        }
        return null;
    }
}
