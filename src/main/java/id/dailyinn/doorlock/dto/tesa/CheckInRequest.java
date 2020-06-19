package id.dailyinn.doorlock.dto.tesa;

import lombok.Data;

/**
 * Created by purwa on 5/14/17.
 */

@Data
public class CheckInRequest extends PreCheckInRequest {
    private String fullName = "daily inn guest";
    public CheckInRequest(){
    }
}
