package id.dailyinn.doorlock.service;

import id.dailyinn.doorlock.util.DowsJnaWrapper;
import org.springframework.stereotype.Service;

@Service
public class DowsJnaService {

    private DowsJnaWrapper dows = DowsJnaWrapper.INSTANCE;

    public int connect() {
        return dows.dv_connect(1);
    }
}
