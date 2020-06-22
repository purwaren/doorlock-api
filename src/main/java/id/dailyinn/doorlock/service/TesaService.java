package id.dailyinn.doorlock.service;

import com.google.gson.Gson;
import id.dailyinn.doorlock.dto.tesa.GeneralResponse;
import id.dailyinn.doorlock.dto.tesa.PreCheckInRequest;
import id.dailyinn.doorlock.dto.tesa.ReadCardRequest;
import id.dailyinn.doorlock.dto.tesa.ReadCardResponse;
import id.dailyinn.doorlock.util.CommandUtil;
import id.dailyinn.doorlock.util.TesaConnector;
import lombok.Setter;
import org.apache.commons.codec.DecoderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TesaService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Setter
    private TesaConnector connector;

    public ReadCardResponse readCard(ReadCardRequest req) throws IOException, InterruptedException, DecoderException {
        byte[] resp = connector.sendCommand(req.buildCommand());
        return CommandUtil.decodeMessageReadCard(req, resp);
    }

    public GeneralResponse preCheckIn(PreCheckInRequest req) throws IOException, InterruptedException {
        logger.info("request == {}", new Gson().toJson(req));
        byte[] resp = connector.sendCommand(req.buildCommand());
        return CommandUtil.decodeMessagePreCheckIn(req, resp);
    }
}
