package com.bl.autocomplete.services.domain.impl;

import com.bl.autocomplete.services.domain.interfaces.IValidateInputService;

public class ValidateInputService implements IValidateInputService {

    @Override
    public boolean validInput(String prefix) {
        for (char c : prefix.toCharArray()){
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }
}
