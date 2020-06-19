package id.dailyinn.doorlock.dto.tesa;

import lombok.Data;

/**
 * @author purwa
 */

@Data
public class GeneralRequest {
    private String pcId = "";
    private String cmd;
    private String technology = "P";
    private String cardOperation = "EF";
    private String encoder = "1";

    public boolean validateParent() {
        if(cmd.length() > 0 && technology.length() > 0 && cardOperation.length() > 0 && encoder.length() > 0)
            return true;
        else return false;
    }
}
