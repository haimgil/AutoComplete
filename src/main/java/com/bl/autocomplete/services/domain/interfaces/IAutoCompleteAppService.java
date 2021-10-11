package com.bl.autocomplete.services.domain.interfaces;

import java.util.List;

public interface IAutoCompleteAppService {
    List<String> autoComplete(String prefix);
}
