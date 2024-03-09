package dev.cisnux.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyController {
    private final static Logger log = LoggerFactory.getLogger(MyController.class);
    private final MyService service;

    public MyController(final MyService service) {
        this.service = service;
    }

    public void save() {
        log.info("Controller Save");
        this.service.save();
    }
}
