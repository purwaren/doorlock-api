package id.dailyinn.doorlock.controllers;

import id.dailyinn.doorlock.dto.*;
import id.dailyinn.doorlock.service.DowsJnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DowsController {

    @Autowired
    DowsJnaService dows;

    @GetMapping("/dows/connect")
    public CommonResponse connect() {
        return dows.connect();
    }

    @GetMapping("/dows/disconnect")
    public CommonResponse disconnect() {
        return dows.disconnect();
    }

    @GetMapping("/dows/card/check")
    public CardCheckResponse cardCheck() {
        return dows.cardCheck();
    }

    @GetMapping("/dows/card/verify")
    public CardCheckResponse verifyCard() {
        return dows.verifyCard();
    }

    @GetMapping("/dows/auth")
    public CommonRequest getAuthorization() {
        return dows.getAuthCode();
    }

    @GetMapping("/dows/card/number")
    public ReadCardResponse getCardNumber() {
        return dows.getCardNumber();
    }

    @GetMapping("/dows/card")
    public ReadCardResponse readCard() {
        return dows.readCard();
    }

    @PostMapping("/dows/card")
    public CommonResponse writeCard(@RequestBody WriteCardRequest req) {
        return dows.writeCard(req);
    }

    @DeleteMapping("/dows/card/{room}")
    public CommonResponse deleteCard(@PathVariable String room) {
        return dows.deleteCard(room);
    }

    @PostMapping("/dows/checkin")
    public ReadCardResponse checkin(@RequestBody WriteCardRequest req) {
        CommonResponse resp = dows.writeCard(req);
        return dows.readCard();
    }

    @GetMapping("/dows/verify")
    public ReadCardResponse verify() {
        return dows.readCard();
    }

    @DeleteMapping("/dows/card/{room}")
    public ReadCardResponse erase(@PathVariable String room) {
        CommonResponse resp = dows.deleteCard(room);
        return dows.readCard();
    }
}
