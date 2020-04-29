package id.dailyinn.doorlock.dto;

import lombok.Data;

@Data
public class ReadCardResponse extends CommonResponse {
    private String cardNo;
    private String building;
    private String room;
    private String door;
    private String arrival;
    private String departure;

    public ReadCardResponse() {

    }
}
