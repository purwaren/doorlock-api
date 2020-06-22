package id.dailyinn.doorlock.controllers;

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

    @PostMapping("/tesa/card/verify")
    public ReadCardResponse readCard(@RequestBody ReadCardRequest req) throws InterruptedException, IOException, DecoderException {
        return tesaService.readCard(req);
    }
}
