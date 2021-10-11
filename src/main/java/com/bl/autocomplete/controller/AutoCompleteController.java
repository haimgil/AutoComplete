package com.bl.autocomplete.controller;

import com.bl.autocomplete.services.domain.interfaces.IAutoCompleteAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bl/v0")
public class AutoCompleteController{

    private final static Logger logger = LoggerFactory.getLogger(AutoCompleteController.class);

    @Autowired
    private IAutoCompleteAppService autoCompleteService;

    @GetMapping("/autoComplete")
    @ResponseBody
    public ResponseEntity<?> autoComplete(@RequestParam String prefixName) {

        logger.info("Got autocomplete request with prefix {}", prefixName);
        List<String> result = autoCompleteService.autoComplete(prefixName);

        if (result == null)
            return ResponseEntity.badRequest().body("prefixName must contains either upper or lower case letters");
        return ResponseEntity.ok(result);
    }
}
