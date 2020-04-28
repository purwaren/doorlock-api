package id.dailyinn.doorlock;

import id.dailyinn.doorlock.util.DowsJnaWrapper;

import javax.annotation.PostConstruct;

public class Startup {

    private DowsJnaWrapper dows = DowsJnaWrapper.INSTANCE;

    @PostConstruct
    public void init() {
        dows.dv_connect(1);
    }
}
