package ir.hillapay.pay.sdk;


public interface HillaPayPublishInfoListener {

    void onResult(PublishModel publishModel);

    void onFailed(String message, @HillaErrorType int errorType);

}
