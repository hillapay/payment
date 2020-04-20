package ir.hillapay.pay.sdk;

import ir.hillapay.core.types.HillaErrorType;

public interface HillaPayUnSubscribeUserListener {

    void onResult(boolean unSubscribe);

    void onFailed(String message, @HillaErrorType int errorType);

}
