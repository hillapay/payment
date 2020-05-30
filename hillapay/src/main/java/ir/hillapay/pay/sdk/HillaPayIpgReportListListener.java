package ir.hillapay.pay.sdk;

import java.util.List;

public interface HillaPayIpgReportListListener {

    void onResult(List<HillaIpgLastReportModel> report);

    void onFailed(String message, @HillaErrorType int errorType);

}
