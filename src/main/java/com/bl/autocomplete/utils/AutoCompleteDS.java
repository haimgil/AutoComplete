package com.bl.autocomplete.utils;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AutoCompleteDS {

    private final static Logger logger = LoggerFactory.getLogger(AutoCompleteDS.class);

    private final Trie<String,String> namesTrie;

    public AutoCompleteDS(){
        namesTrie = new PatriciaTrie<>();
    }

    public void insert(String name){
        logger.debug("Insert {} to trie", name);
        namesTrie.put(name.toLowerCase(),name);
    }

    public void insert(List<String> names){
        for (String name : names){
            insert(name);
        }
    }

    public Map<String,String> prefixMatches(String prefix){
        return namesTrie.prefixMap(prefix.toLowerCase());
    }
}
