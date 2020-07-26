package id.dailyinn.doorlock.dto.kend;

import lombok.Data;

@Data
public class ReadCardResponse {
    String cardNumber;
    String room;
    String checkin;
    String checkout;
}
