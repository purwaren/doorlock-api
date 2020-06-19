package id.dailyinn.doorlock.service;

import id.dailyinn.doorlock.util.TesaConnector;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class TesaService {

    @Setter
    private TesaConnector connector;
}
