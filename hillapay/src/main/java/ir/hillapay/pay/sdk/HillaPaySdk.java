package ir.hillapay.pay.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import ir.hillapay.core.publicmodel.CoreDirectdebitPayModel;
import ir.hillapay.core.publicmodel.CoreHillaVasReportModel;
import ir.hillapay.core.publicmodel.CoreIpgCallbackModel;
import ir.hillapay.core.publicmodel.CoreTransactionVerifyModel;
import ir.hillapay.core.sdk.CoreHillaPayActiveUserListener;
import ir.hillapay.core.sdk.CoreHillaPaySdk;
import ir.hillapay.core.sdk.CoreHillaPaySdkListener;
import ir.hillapay.core.sdk.CoreHillaPayVasReportListener;
import ir.hillapay.core.sdk.CorePaymentConfig;
import ir.hillapay.core.sdk.CoreVasConfig;


public class HillaPaySdk {


    public static void init(Context context, String uid) {
        CoreHillaPaySdk.coreRegister(context, uid);
    }

    public static void init(Context context, String uid, HillaPaymentConfig config) {

        if (config != null) {
            VasConfig vasConfig = config.getVasConfig();
            String registerPhoneNumber = "";
            if (vasConfig != null) {
                if (vasConfig.getUserPhoneNumber() != null)
                    registerPhoneNumber = vasConfig.getUserPhoneNumber();
            }
            CorePaymentConfig paymentConfig = new CorePaymentConfig.Builder()
                    .showFirstLevel(config.showFirsLevel())
                    .setDirectdebitDailyWithdrawCount(config.getDirectdebitDailyWithdrawCount())
                    .setDirectdebitMonthlyWithdrawCount(config.getDirectdebitMonthlyWithdrawCount())
                    .addVasConfig(
                            new CoreVasConfig.Builder()
                                    .setUserPhoneNumber(registerPhoneNumber)
                                    .build()
                    )
                    .build();

            CoreHillaPaySdk.coreRegister(context, uid, paymentConfig);
        } else
            CoreHillaPaySdk.coreRegister(context, uid);
    }

    public static void openTrack(Activity context, String uid) {
        CoreHillaPaySdk.coreOpenTrack(context, uid);
    }

    public static void closeTrack(Activity context, String uid) {
        CoreHillaPaySdk.coreCloseTrack(context, uid);
    }

    public static void tracker(Activity context, String uid, String action, String description) {
        CoreHillaPaySdk.coreTracker(context, uid, action, description);
    }

    /**
     * @param context
     * @param amount
     * @param phone
     * @param orderId        is unique
     * @param description
     * @param uid            is unique
     * @param additionalData
     * @param sku            is product code
     * @param phoneByUser    is enable get user phone
     */
    public static void payment(Activity context, String amount, String phone, String orderId,
                               String description, String uid, String additionalData, String sku,
                               boolean phoneByUser) {
        CoreHillaPaySdk.corePayment(context, amount, phone, orderId,
                description, uid, additionalData, sku, phoneByUser);

    }

    public static void verify(Activity context, String uid, IpgCallbackModel ipgCallbackModel) {
        CoreIpgCallbackModel ipgModel = new CoreIpgCallbackModel(
                ipgCallbackModel.getTransactionId(),
                ipgCallbackModel.getOrderId(),
                ipgCallbackModel.getStatusCode(),
                ipgCallbackModel.getStatusDescription(),
                ipgCallbackModel.getPackageName(),
                ipgCallbackModel.getReturnAmount(),
                ipgCallbackModel.getReturnRrn(),
                ipgCallbackModel.isSuccess());
        CoreHillaPaySdk.coreVerify(context, uid, ipgModel);
    }

    public static void getSdkResult(int requestCode, int resultCode, Intent data, final HillaPaySdkListener sdkListener) {
        CoreHillaPaySdk.coreGetPaymentResult(requestCode, resultCode, data, new CoreHillaPaySdkListener() {
            @Override
            public void paymentResult(CoreIpgCallbackModel ipgModel, boolean isSuccess) {
                IpgCallbackModel ipgCallbackModel = new IpgCallbackModel(
                        ipgModel.getTransactionId(),
                        ipgModel.getOrderId(),
                        ipgModel.getStatusCode(),
                        ipgModel.getStatusDescription(),
                        ipgModel.getPackageName(),
                        ipgModel.getReturnAmount(),
                        ipgModel.getReturnRrn(),
                        ipgModel.isSuccess());
                sdkListener.paymentResult(ipgCallbackModel, isSuccess);
            }

            @Override
            public void verifyResult(CoreTransactionVerifyModel verifyModel, boolean isSuccess) {

                BankModel bankModel = new BankModel(
                        verifyModel.getBank().getId(),
                        verifyModel.getBank().getWithdrawalType(),
                        verifyModel.getBank().getTitle(),
                        verifyModel.getBank().getImage());

                TerminalModel terminalModel = new TerminalModel(
                        verifyModel.getTerminal().getId(),
                        verifyModel.getTerminal().getTitle());

                TransactionVerifyModel transactionVerifyModel = new TransactionVerifyModel(
                        verifyModel.getTransactionId(),
                        verifyModel.getOrderId(),
                        verifyModel.getCard(),
                        terminalModel,
                        bankModel,
                        verifyModel.isSuccess());
                sdkListener.verifyResult(transactionVerifyModel, isSuccess);
            }

            @Override
            public void directDebitResult(CoreDirectdebitPayModel payModel, boolean isSuccess) {
                BankModel bankModel = new BankModel(
                        payModel.getBank().getId(),
                        payModel.getBank().getWithdrawalType(),
                        payModel.getBank().getTitle(),
                        payModel.getBank().getImage());

                TerminalModel terminalModel = new TerminalModel(
                        payModel.getTerminal().getId(),
                        payModel.getTerminal().getTitle());

                DirectdebitPayModel directdebitPayModel = new DirectdebitPayModel(
                        payModel.getTransactionId(),
                        payModel.getOrderId(),
                        payModel.getTransactionAmount(),
                        terminalModel,
                        bankModel,
                        payModel.isSuccess()
                );

                sdkListener.directDebitResult(directdebitPayModel, isSuccess);
            }

            @Override
            public void directDebitVasResult(boolean isSuccess) {
                sdkListener.directDebitVasResult(isSuccess);
            }

            @Override
            public void phoneRegister(boolean isSuccess, String phone) {
                sdkListener.otpResult(isSuccess, phone);
            }

            @Override
            public void unsubscribeUser(boolean b) {
                sdkListener.unsubscribeUserResult(b);
            }

            @Override
            public void failed(String message, @HillaErrorType int errorType) {
                sdkListener.failed(message, errorType);
            }
        });
    }

    public static class VAS {

        public static void checkActiveUser(Activity context, String uid, final HillaPayActiveUserListener listener) {

            CoreHillaPaySdk.CoreVAS.coreCheckActiveUser(context, uid, new CoreHillaPayActiveUserListener() {
                @Override
                public void onResult(int i) {
                    listener.onResult(i);
                }

                @Override
                public void onFailed(String s, int i) {
                    listener.onFailed(s, i);
                }
            });
        }

        public static void unsubscribeUser(Activity context, String uid) {
            CoreHillaPaySdk.CoreVAS.coreUnsubscribeUser(context, uid);
        }

        public static void createPayman(Activity context, String uid) {
            CoreHillaPaySdk.CoreVAS.coreCreatePayman(context, uid);
        }

        public static void getReport(Activity context, String uid, final HillaPayVasReportListener listener) {
            CoreHillaPaySdk.CoreVAS.coreGetReport(context, uid, new CoreHillaPayVasReportListener() {
                @Override
                public void onResult(CoreHillaVasReportModel hillaVasReportModel) {
                    HillaVasReportModel reportModel = new HillaVasReportModel(
                            hillaVasReportModel.countAmount,
                            hillaVasReportModel.totalAmount);
                    listener.onResult(reportModel);
                }

                @Override
                public void onFailed(String s, int i) {

                }
            });
        }
    }

    public static class OTP {
        public static void phoneRegister(Activity context, String uid) {
            CoreHillaPaySdk.CoreOTP.coreRegister(context, uid);
        }
    }


}
