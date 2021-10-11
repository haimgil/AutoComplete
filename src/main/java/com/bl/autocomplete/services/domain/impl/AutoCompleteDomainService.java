package com.bl.autocomplete.services.domain.impl;

import com.bl.autocomplete.services.domain.interfaces.IAutoCompleteDomainService;
import com.bl.autocomplete.utils.AutoCompleteDS;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteDomainService implements IAutoCompleteDomainService {

    @Autowired
    private AutoCompleteDS autoCompleteDS;

    @Override
    public List<String> prefixList(String prefix) {
        return new ArrayList<>(
                autoCompleteDS
                        .prefixMatches(prefix)
                        .values());
    }
}
