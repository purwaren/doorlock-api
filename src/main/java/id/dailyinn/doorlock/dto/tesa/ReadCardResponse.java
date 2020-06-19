package id.dailyinn.doorlock.dto.tesa;

import lombok.Data;

/**
 * Created by purwa on 5/16/17.
 */

@Data
public class ReadCardResponse extends GeneralResponse {
    private String diagnostic;
    private String user;
    private String activationDate;
    private String activationTime;
    private String expiryDate;
    private String expiryTime;
    private String grant;
    private String keypad;
}
