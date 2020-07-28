package id.dailyinn.doorlock.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface KendJnaWrapper extends Library {
    KendJnaWrapper INSTANCE = (KendJnaWrapper) Native.load("LockSDK", KendJnaWrapper.class);

    int TP_Configuration (int lockType);
    int TP_MakeGuestCard (char[] cardSnr, String room, String checkin, String checkout, int flags);
    int TP_ReadGuestCard (char[] cardSnr, char[] room, char[] checkin, char[] checkout);
    int TP_CancelCard (char[] cardSnr);
    int TP_GetCardSnr (char[] cardSnr);
}
