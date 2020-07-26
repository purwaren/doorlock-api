package id.dailyinn.doorlock.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface KendJnaWrapper extends Library {
    KendJnaWrapper INSTANCE = (KendJnaWrapper) Native.load("LockSDK", KendJnaWrapper.class);

    int TP_Configuration (int lockType);
    int TP_MakeGuestCard (StringBuilder cardSnr, String room, String checkin, String checkout, int flags);
    int TP_ReadGuestCard (StringBuilder cardSnr, StringBuilder room, StringBuilder checkin, StringBuilder checkout);
    int TP_CancelCard (StringBuilder cardSnr);
    int TP_GetCardSnr (StringBuilder cardSnr);
}
