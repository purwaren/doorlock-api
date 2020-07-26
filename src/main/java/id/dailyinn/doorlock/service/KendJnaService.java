package id.dailyinn.doorlock.service;

import id.dailyinn.doorlock.dto.kend.ReadCardResponse;
import id.dailyinn.doorlock.dto.kend.WriteCardRequest;
import id.dailyinn.doorlock.util.KendJnaWrapper;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KendJnaService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Setter
    KendJnaWrapper jnaWrapper;

    private int config(int lockType) {
        return jnaWrapper.TP_Configuration(lockType);
    }

    public ReadCardResponse readGuestCard() {
        StringBuilder card = new StringBuilder();
        StringBuilder room = new StringBuilder();
        StringBuilder checkin = new StringBuilder();
        StringBuilder checkout = new StringBuilder();
        int result = jnaWrapper.TP_ReadGuestCard(card, room, checkin, checkout);
        logger.info("result == {}", result);
        ReadCardResponse response = new ReadCardResponse();
        if (result > 0) {
            response.setCardNumber(card.toString());
            response.setRoom(room.toString());
            response.setCheckin(checkin.toString());
            response.setCheckout(checkout.toString());
        }
        return response;
    }

    public ReadCardResponse writeGuestCard(WriteCardRequest req) {
        StringBuilder card = new StringBuilder();
        int result = jnaWrapper.TP_MakeGuestCard(card,req.getRoom(), req.getCheckin(), req.getCheckout(), req.getFlags());
        ReadCardResponse response = new ReadCardResponse();
        if (result > 0) {
            response.setCardNumber(card.toString());
            response.setRoom(req.getRoom());
            response.setCheckin(req.getCheckin());
            response.setCheckout(req.getCheckout());
        }
        return response;
    }
}