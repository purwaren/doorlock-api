package id.dailyinn.doorlock.service;

import id.dailyinn.doorlock.dto.kend.ReadCardResponse;
import id.dailyinn.doorlock.dto.kend.WriteCardRequest;
import id.dailyinn.doorlock.util.KendJnaWrapper;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class KendJnaService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Setter
    KendJnaWrapper jnaWrapper;

    private int config(int lockType) {
        return jnaWrapper.TP_Configuration(lockType);
    }

    public ReadCardResponse readGuestCard() {
        char[] card = new char[20];
        char[] room = new char[20];
        char[] checkin = new char[30];
        char[] checkout = new char[30];
        int result = jnaWrapper.TP_ReadGuestCard(card, room, checkin, checkout);
        logger.info("result == {}", result);
        ReadCardResponse response = new ReadCardResponse();
        if (result > 0) {
            response.setCardNumber(String.valueOf(card));
            response.setRoom(String.valueOf(room));
            response.setCheckin(String.valueOf(checkin));
            response.setCheckout(String.valueOf(checkout));
        }
        return response;
    }

    public ReadCardResponse writeGuestCard(WriteCardRequest req) {
        char[] card = new char[20];
        int result = jnaWrapper.TP_MakeGuestCard(card,req.getRoom(), req.getCheckin(), req.getCheckout(), req.getFlags());
        ReadCardResponse response = new ReadCardResponse();
        if (result > 0) {
            response.setCardNumber(String.valueOf(card));
            response.setRoom(req.getRoom());
            response.setCheckin(req.getCheckin());
            response.setCheckout(req.getCheckout());
        }
        return response;
    }

    public void cancelCard(String card) {
        char[] cardSnr = card.toCharArray();
        int result = jnaWrapper.TP_CancelCard(cardSnr);
        if (result > 0) {
            logger.info("card cancelled");
        }
    }

    public void setConfig(int lockType) {
        int result = jnaWrapper.TP_Configuration(lockType);
        if (result > 0) {
            logger.info("configured encoder");
        }
    }
}