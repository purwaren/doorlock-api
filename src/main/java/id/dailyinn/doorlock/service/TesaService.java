package id.dailyinn.doorlock.service;

import com.google.gson.Gson;
import id.dailyinn.doorlock.dto.tesa.*;
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
        connector.connect();
        if (connector.isConnected()) {
            byte[] resp = connector.sendCommand(req.buildCommand());
            connector.disconnect();
            return CommandUtil.decodeMessageReadCard(req, resp);
        }
        else return new ReadCardResponse();
    }

    public GeneralResponse preCheckIn(PreCheckInRequest req) throws IOException, InterruptedException {
        connector.connect();
        if (connector.isConnected()) {
            byte[] resp = connector.sendCommand(req.buildCommand());
            connector.disconnect();
            return CommandUtil.decodeMessagePreCheckIn(req, resp);
        }
        else return new GeneralResponse();
    }
}
