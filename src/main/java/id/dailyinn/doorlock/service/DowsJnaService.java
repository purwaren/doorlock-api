package id.dailyinn.doorlock.service;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import id.dailyinn.doorlock.dto.*;
import id.dailyinn.doorlock.util.DowsJnaWrapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class DowsJnaService {

    @Setter
    private DowsJnaWrapper dows;

    @Value("${dows.card.auth}")
    private String authCode;

    public CommonResponse connect() {
        int status = 1;
        try {
            status = dows.dv_connect(1);
        } catch (Exception e) {
            status = -1;
            e.printStackTrace();
        }
        return new CommonResponse(status);
    }

    public CommonResponse disconnect() {
        int status = 1;
        try {
            status = dows.dv_disconnect();
        } catch (Exception e) {
            status = -1;
            e.printStackTrace();
        }
        return new CommonResponse(status);
    }

    public CardCheckResponse cardCheck() {
        connect();
        int cardType = 0;
        try {
            cardType = dows.dv_check_card();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CardCheckResponse(cardType);
    }

    public CardCheckResponse verifyCard() {
        Memory cardType = new Memory(Native.LONG_SIZE);
        connect();
        int status = 1;
        try {
            status = dows.dv_verify_card(cardType);
        } catch (Exception e) {
            status = -1;
            e.printStackTrace();
        }
        disconnect();
        CardCheckResponse resp =  new CardCheckResponse(cardType.getInt(0));
        Memory.disposeAll();
        return resp;
    }

    public CommonRequest getAuthCode() {
        Memory authCode = new Memory(6);
        int status = 1;

        connect();
        try {
            status = dows.dv_get_auth_code(authCode);
        } catch(Exception e) {
            status = -1;
        }
        disconnect();
        CommonRequest resp = new CommonRequest(authCode.getString(0, "UTF-8"));
        this.authCode = resp.getAuth();
        Memory.disposeAll();
        return resp;
    }

    public ReadCardResponse getCardNumber() {
        Memory cardNo = new Memory(6);
        connect();
        int status = 1;
        try {
            status = dows.dv_get_card_number(cardNo);
        } catch (Exception e) {
            status = -1;
            e.printStackTrace();
        }
        disconnect();
        ReadCardResponse resp = new ReadCardResponse();
        resp.setCardNo(cardNo.getString(0, "UTF-8"));
        resp.setStatus(status);
        Memory.disposeAll();
        return resp;
    }

    public ReadCardResponse readCard() {
        Memory auth = new Memory(authCode.length());
        if (authCode.length() > 0) {
            auth.write(0, authCode.getBytes(), 0, authCode.length());
        }
        Memory cardNo = new Memory(6);
        Memory building = new Memory(2);
        Memory room = new Memory(4);
        Memory door = new Memory(2);
        Memory arrival = new Memory(19);
        Memory departure = new Memory(19);
        int status = 1;
        connect();
        try {
            status = dows.dv_read_card(auth, cardNo, building, room, door, arrival, departure);
        } catch (Exception e) {
            status = -1;
            e.printStackTrace();
        } 
        disconnect();
        ReadCardResponse resp = new ReadCardResponse();
        resp.setStatus(status);
        resp.setCardNo(cardNo.getString(0, "UTF-8"));
        resp.setBuilding(building.getString(0, "UTF-8"));
        resp.setRoom(room.getString(0, "UTF-8"));
        resp.setDoor(door.getString(0, "UTF-8"));
        resp.setArrival(arrival.getString(0, "UTF-8"));
        resp.setDeparture(departure.getString(0, "UTF-8"));
        Memory.disposeAll();
        return resp;
    }

    public CommonResponse writeCard(WriteCardRequest req) {
        Memory auth = authCode.length() > 0 ? new Memory(authCode.length()) : new Memory(1);
        if (authCode.length() > 0) {
            auth.write(0, authCode.getBytes(), 0, authCode.length());
        }

        Memory building = new Memory(req.getBuilding().length());
        building.write(0, req.getBuilding().getBytes(), 0, req.getBuilding().length());

        Memory room = new Memory(req.getRoom().length());
        room.write(0, req.getRoom().getBytes(), 0, req.getRoom().length());

        Memory door = new Memory(req.getDoor().length());
        door.write(0, req.getDoor().getBytes(), 0, req.getDoor().length());

        Memory arrival = new Memory(req.getArrival().length());
        arrival.write(0, req.getArrival().getBytes(), 0, req.getArrival().length());

        Memory departure = new Memory(req.getDeparture().length());
        departure.write(0, req.getDeparture().getBytes(), 0, req.getDeparture().length());
        int status = 1;
        connect();
        try {
            status = dows.dv_write_card(auth, building, room, door, arrival, departure);
        } catch (Exception e) {
            status = -1;
            e.printStackTrace();
        }
        disconnect();
        Memory.disposeAll();
        return new CommonResponse(status);
    }

    public CommonResponse deleteCard(String roomNo) {
        Memory room = new Memory(roomNo.length());
        room.write(0, roomNo.getBytes(), 0, roomNo.length());
        int status = 1;
        connect();
        try {
            status = dows.dv_delete_card(room);
        } catch (Exception e) {
            status = -1;
            e.printStackTrace();
        }
        disconnect();
        Memory.disposeAll();
        return new CommonResponse(status);
    }
}
