package ir.hillapay.pay.sdk;

public interface HillaPayIpgReportListener {

    void onResult(HillaIpgReportModel report);

    void onFailed(String message, @HillaErrorType int errorType);

}
