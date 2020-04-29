package id.dailyinn.doorlock.controllers;

import id.dailyinn.doorlock.dto.CardCheckResponse;
import id.dailyinn.doorlock.dto.CommonResponse;
import id.dailyinn.doorlock.service.DowsJnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DowsController {

    @Autowired
    DowsJnaService dows;

    @PostMapping("/dows/connect")
    public CommonResponse connect() {
        return dows.connect();
    }

    @PostMapping("/dows/disconnect")
    public CommonResponse disconnect() {
        return dows.disconnect();
    }

    @PostMapping("/dows/cardCheck")
    public CardCheckResponse cardCheck() {
        return dows.cardCheck();
    }
}
