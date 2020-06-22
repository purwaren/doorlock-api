package id.dailyinn.doorlock.controllers;

import id.dailyinn.doorlock.dto.tesa.GeneralResponse;
import id.dailyinn.doorlock.dto.tesa.PreCheckInRequest;
import id.dailyinn.doorlock.dto.tesa.ReadCardRequest;
import id.dailyinn.doorlock.dto.tesa.ReadCardResponse;
import id.dailyinn.doorlock.service.TesaService;
import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TesaController {

    @Autowired
    TesaService tesaService;

    @PostMapping("/tesa/verify")
    public ReadCardResponse readCard(@RequestBody ReadCardRequest req) throws InterruptedException, IOException, DecoderException {
        return tesaService.readCard(req);
    }

    @PostMapping("/tesa/pre-checkin")
    public GeneralResponse preCheckIn(@RequestBody PreCheckInRequest req) throws IOException, InterruptedException {
        return tesaService.preCheckIn(req);
    }

    @PostMapping("/tesa/checkin")
    public GeneralResponse checkIn(@RequestBody PreCheckInRequest req) throws IOException, InterruptedException {
        return tesaService.preCheckIn(req);
    }
}
