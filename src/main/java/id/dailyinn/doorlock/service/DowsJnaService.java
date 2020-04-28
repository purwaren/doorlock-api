package id.dailyinn.doorlock.service;

import id.dailyinn.doorlock.util.DowsJnaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DowsJnaService {
    @Autowired
    private DowsJnaWrapper dows;

    public int connect() {
        return dows.dv_connect(1);
    }
}
