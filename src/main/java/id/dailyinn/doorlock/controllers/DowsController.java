package id.dailyinn.doorlock.controllers;

import id.dailyinn.doorlock.service.DowsJnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DowsController {

    @Autowired
    DowsJnaService dows;

    @PostMapping("/dows/connect")
    public int connect() {
        return dows.connect();
    }
}
