package ir.hillapay.pay.sdk;


public interface HillaPayActiveUserListener {

    void onResult(@HillaVasActiveType int active);

    void onFailed(String message, @HillaErrorType int errorType);

}
