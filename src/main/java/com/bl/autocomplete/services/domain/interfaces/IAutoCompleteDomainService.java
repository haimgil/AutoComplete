package com.bl.autocomplete.services.domain.interfaces;

import java.util.List;

public interface IAutoCompleteDomainService {
    List<String> prefixList(String prefix);
}
