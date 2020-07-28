package id.dailyinn.doorlock.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface KendJnaWrapper extends Library {
    KendJnaWrapper INSTANCE = (KendJnaWrapper) Native.load("LockSDK", KendJnaWrapper.class);

    int TP_Configuration (int lockType);
    int TP_MakeGuestCard (StringBuffer cardSnr, String room, String checkin, String checkout, int flags);
    int TP_ReadGuestCard (StringBuffer cardSnr, StringBuffer room, StringBuffer checkin, StringBuffer checkout);
    int TP_CancelCard (StringBuffer cardSnr);
    int TP_GetCardSnr (StringBuffer cardSnr);
}
