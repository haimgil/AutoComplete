package com.bl.autocomplete.utils;

import com.bl.autocomplete.persistence.Boy;
import com.bl.autocomplete.persistence.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class DataReader {

    private final static Logger logger = LoggerFactory.getLogger(DataReader.class);

    @Value("${path.to.file}")
    private String PATH_TO_TXT_FILE;

    @Autowired
    Repository repository;

    @PostConstruct
    public void readFile() {
        logger.info("Import names from: " + PATH_TO_TXT_FILE);
        read();
    }

    private void read() {
        int entriesCount = 0;
        try {
            var file = new File(PATH_TO_TXT_FILE);    //creates a new file instance
            var fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            String name;
            while ((name = br.readLine()) != null) {
                populateName(name);
                entriesCount++;
            }
            fr.close();
            br.close();//closes the stream and release the resources
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Finish reading {} entries from {}.", entriesCount, PATH_TO_TXT_FILE);
    }

    private void populateName(String name) {
        Boy b = repository.save(new Boy(name));
        logger.debug("{} saved to H2 Boys table", b.getName());
    }
}
