package id.dailyinn.doorlock.dto.tesa;

import lombok.Data;

/**
 * Created by purwa on 5/14/17.
 */

@Data
public class GeneralResponse {
    private String info;
    private String rawMsg;
    private String rawMsgHex;
    private String rawMsgBase64;
}
