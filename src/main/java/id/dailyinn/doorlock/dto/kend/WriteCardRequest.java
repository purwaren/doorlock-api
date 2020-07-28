package id.dailyinn.doorlock.dto.kend;

import lombok.Data;

@Data
public class WriteCardRequest {
    //Room format: 001.001.00101 => room number: 101
    String room;
    String checkin;
    String checkout;
    int flags;
}
