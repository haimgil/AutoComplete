package com.bl.autocomplete.config;

import com.bl.autocomplete.persistence.Boy;
import com.bl.autocomplete.persistence.Repository;
import com.bl.autocomplete.services.domain.impl.AutoCompleteAppService;
import com.bl.autocomplete.services.domain.impl.AutoCompleteDomainService;
import com.bl.autocomplete.services.domain.impl.ValidateInputService;
import com.bl.autocomplete.services.domain.interfaces.IAutoCompleteAppService;
import com.bl.autocomplete.services.domain.interfaces.IAutoCompleteDomainService;
import com.bl.autocomplete.services.domain.interfaces.IValidateInputService;
import com.bl.autocomplete.utils.AutoCompleteDS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.stream.Collectors;

@Configuration
public class AppConfig {

    private final static Logger logger = LoggerFactory.getLogger(AppConfig.class);
    @Bean
    public IAutoCompleteAppService autoCompleteService(){
        return new AutoCompleteAppService();
    }

    @Bean
    public IValidateInputService validateInputService(){
        return new ValidateInputService();
    }

    @Bean
    public IAutoCompleteDomainService autoCompleteDomainService(){
        return new AutoCompleteDomainService();
    }

    @Bean
    @DependsOn("dataReader")
    public AutoCompleteDS autoCompleteDS(Repository repository){
        AutoCompleteDS ds = new AutoCompleteDS();
        ds.insert(repository.findAll()
                .stream()
                .map(Boy::getName)
                .collect(Collectors.toList()));
        return ds;
    }
}
