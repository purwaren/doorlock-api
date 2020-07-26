package id.dailyinn.doorlock.controllers;

import id.dailyinn.doorlock.dto.kend.ReadCardResponse;
import id.dailyinn.doorlock.dto.kend.WriteCardRequest;
import id.dailyinn.doorlock.service.KendJnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KendController {

    @Autowired
    private KendJnaService kendJnaService;

    @GetMapping("/kend/card")
    public ReadCardResponse readGuestCard() {
        return kendJnaService.readGuestCard();
    }

    @PostMapping("/kend/card")
    public ReadCardResponse writeCardRequest(@RequestBody WriteCardRequest request) {
        return kendJnaService.writeGuestCard(request);
    }
}
