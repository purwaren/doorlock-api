package id.dailyinn.doorlock.dto;

import lombok.Data;

@Data
public class WriteCardRequest extends CommonRequest {
    private String building;
    private String room;
    private String door;
    private String arrival;
    private String departure;
}