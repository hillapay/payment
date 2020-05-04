package ir.hillapay.pay.sdk;

public interface HillaPayVasReportListener {

    void onResult(HillaVasReportModel report);

    void onFailed(String message, @HillaErrorType int errorType);

}
