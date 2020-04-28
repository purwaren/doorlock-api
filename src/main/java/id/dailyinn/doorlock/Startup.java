package id.dailyinn.doorlock;

import id.dailyinn.doorlock.util.DowsJnaWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class Startup {

    @Autowired
    private DowsJnaWrapper dows;

    @PostConstruct
    public void init() {
        dows.dv_connect(1);
    }
}
