package id.dailyinn.doorlock.service;

import id.dailyinn.doorlock.dto.tesa.ReadCardRequest;
import id.dailyinn.doorlock.dto.tesa.ReadCardResponse;
import id.dailyinn.doorlock.util.CommandUtil;
import id.dailyinn.doorlock.util.TesaConnector;
import lombok.Setter;
import org.apache.commons.codec.DecoderException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TesaService {

    @Setter
    private TesaConnector connector;

    public ReadCardResponse readCard(ReadCardRequest req) throws IOException, InterruptedException, DecoderException {
        byte[] resp = connector.sendCommand(req.buildCommand());
        return CommandUtil.decodeMessageReadCard(req, resp);
    }
}
