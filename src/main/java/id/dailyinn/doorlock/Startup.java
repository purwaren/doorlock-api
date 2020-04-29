package id.dailyinn.doorlock;

import id.dailyinn.doorlock.util.DowsJnaWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class Startup {

    Logger logger = LoggerFactory.getLogger(getClass());
    private DowsJnaWrapper dows = DowsJnaWrapper.INSTANCE;

    @PostConstruct
    public void init() {
        logger.info("Test connect device");
        dows.dv_connect(1);
    }
}
