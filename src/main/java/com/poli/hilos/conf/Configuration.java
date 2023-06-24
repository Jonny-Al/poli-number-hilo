package com.poli.hilos.conf;

import com.poli.hilos.service.NumberIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);
    @Autowired
    NumberIndexService numberIndexService;

    @Scheduled (fixedRate = 60000)
    public void execute() {
        logger.info("Execute...");
        if (numberIndexService.executeInsert()) {
            numberIndexService.executeFirst();
            numberIndexService.executeLast();
        }
        logger.info("End ...");
    }
}
