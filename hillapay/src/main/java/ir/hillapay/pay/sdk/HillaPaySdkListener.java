package ir.hillapay.pay.sdk;



public abstract class HillaPaySdkListener {

    public void paymentResult(IpgCallbackModel ipgModel, boolean isSuccess) {
    }

    public void verifyResult(TransactionVerifyModel verifyModel, boolean isSuccess) {
    }

    public void directDebitResult(DirectdebitPayModel payModel, boolean isSuccess) {
    }

    public void directDebitVasResult(boolean isSuccess) {
    }

    public abstract void failed(String message, int type);

    public void otpResult(boolean isSuccess, String phone) {

    }

}
