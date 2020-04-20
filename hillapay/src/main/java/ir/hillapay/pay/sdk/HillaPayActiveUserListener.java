package ir.hillapay.pay.sdk;

import ir.hillapay.core.types.HillaErrorType;

public interface HillaPayActiveUserListener {

    void onResult(@HillaVasActiveType int active);

    void onFailed(String message, @HillaErrorType int errorType);

}
