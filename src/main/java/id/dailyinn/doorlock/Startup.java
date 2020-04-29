package id.dailyinn.doorlock;

import id.dailyinn.doorlock.service.DowsJnaService;
import id.dailyinn.doorlock.util.DowsJnaWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Startup {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DowsJnaService jnaService;

    @PostConstruct
    public void init() {
        logger.info("Test connect device");
        jnaService.connect();
    }
}
