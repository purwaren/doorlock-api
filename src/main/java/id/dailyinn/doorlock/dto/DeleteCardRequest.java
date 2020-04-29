package id.dailyinn.doorlock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteCardRequest {
    private String room;
}
