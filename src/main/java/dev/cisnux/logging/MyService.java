package dev.cisnux.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {
    private static final Logger log = LoggerFactory.getLogger(MyService.class);
    private final MyRepository repository;

    public MyService(final MyRepository repository) {
        this.repository = repository;
    }

    public void save() {
        log.info("Service Save");
        this.repository.save();
    }

}
