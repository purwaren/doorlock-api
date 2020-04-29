package id.dailyinn.doorlock.service;

import id.dailyinn.doorlock.dto.CardCheckResponse;
import id.dailyinn.doorlock.dto.CommonResponse;
import id.dailyinn.doorlock.util.DowsJnaWrapper;
import org.springframework.stereotype.Service;


@Service
public class DowsJnaService {

    private final DowsJnaWrapper dows = DowsJnaWrapper.INSTANCE;

    public CommonResponse connect() {
        int status = dows.dv_connect(1);
        return new CommonResponse(status);
    }

    public CommonResponse disconnect() {
        int status = dows.dv_disconnect();
        return new CommonResponse(status);
    }

    public CardCheckResponse cardCheck() {
        int cardType = dows.dv_check_card();
        return new CardCheckResponse(cardType);
    }
}
