package ir.hillapay.pay.sdk;



public interface HillaPaySdkListener  {

    void paymentResult(IpgCallbackModel var1, boolean var2);

    void verifyResult(TransactionVerifyModel var1, boolean var2);

    void directDebitResult(DirectdebitPayModel var1, boolean var2);

    void failed(String var1, int var2);
}
