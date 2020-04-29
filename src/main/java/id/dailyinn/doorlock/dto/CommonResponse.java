package id.dailyinn.doorlock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResponse {
    private int status;
    public CommonResponse() {
    }
}
