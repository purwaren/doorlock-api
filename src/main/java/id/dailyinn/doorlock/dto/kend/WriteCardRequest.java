package id.dailyinn.doorlock.dto.kend;

import lombok.Data;

@Data
public class WriteCardRequest {
    String room;
    String checkin;
    String checkout;
    int flags;
}
