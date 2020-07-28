package id.dailyinn.doorlock;

import id.dailyinn.doorlock.service.DowsJnaService;
import id.dailyinn.doorlock.service.KendJnaService;
import id.dailyinn.doorlock.service.TesaService;
import id.dailyinn.doorlock.util.DowsJnaWrapper;
import id.dailyinn.doorlock.util.KendJnaWrapper;
import id.dailyinn.doorlock.util.TesaConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class Startup {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DowsJnaService jnaService;

    @Autowired
    TesaService tesaService;

    @Autowired
    KendJnaService kendJnaService;

    @Value("${dows.active}")
    boolean isActiveDows;

    @Value("${tesa.active}")
    boolean isActiveTesa;

    @Value("${kend.active}")
    boolean isActiveKend;

    @Value("${tesa.server.address}")
    String tesaAddress;

    @Value("${tesa.server.port}")
    int tesaPort;

    @Value("${tesa.connect.timeout}")
    int tesaTimeout;

    TesaConnector tesaConnector;

    @PostConstruct
    public void initDows() {
        if (isActiveDows) {
            logger.info("Dows module is activated");
            logger.info("Try to connect");
            jnaService.setDows(DowsJnaWrapper.INSTANCE);
            jnaService.connect();
        }
    }

    @PostConstruct
    public void initTesa() throws IOException, InterruptedException {
        if (isActiveTesa) {
            logger.info("Tesa module is activated");
            tesaConnector = new TesaConnector(tesaAddress, tesaPort, tesaTimeout);
            tesaService.setConnector(tesaConnector);
            new Thread(tesaConnector).start();
            if (tesaConnector.isConnected()) {
                tesaConnector.sendEchoTest();
                tesaConnector.disconnect();
            } else {
                logger.info("TESA connector is not ready");
            }
        }
    }

    @PostConstruct
    public void initKend() {
        if (isActiveKend) {
            logger.info("Kend module is activated");
            kendJnaService.setJnaWrapper(KendJnaWrapper.INSTANCE);
            kendJnaService.setConfig(5);
        }
    }
}
