package com.bl.autocomplete.services.domain.impl;

import com.bl.autocomplete.services.domain.interfaces.IAutoCompleteAppService;
import com.bl.autocomplete.services.domain.interfaces.IAutoCompleteDomainService;
import com.bl.autocomplete.services.domain.interfaces.IValidateInputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutoCompleteAppService implements IAutoCompleteAppService {

    private final static Logger logger = LoggerFactory.getLogger(AutoCompleteAppService.class);

    @Autowired
    private IValidateInputService validateInputService;
    @Autowired
    private IAutoCompleteDomainService autoCompleteDomainService;

    @Override
    public List<String> autoComplete(String prefix) {
        if (! validateInputService.validInput(prefix))
            return null;
        return autoCompleteDomainService.prefixList(prefix);
    }
}
