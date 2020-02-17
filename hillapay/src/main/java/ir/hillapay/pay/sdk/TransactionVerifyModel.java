package ir.hillapay.pay.sdk;

import android.os.Parcel;
import android.os.Parcelable;



public class TransactionVerifyModel implements Parcelable {


    private String transactionId;
    private String orderId;
    private String card;
    private TerminalModel terminal;
    private BankModel bank;
    private boolean isSuccess;



    public TransactionVerifyModel(String transactionId, String orderId, String card, TerminalModel terminal, BankModel bank, boolean isSuccess) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.card = card;
        this.terminal = terminal;
        this.bank = bank;
        this.isSuccess = isSuccess;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public TerminalModel getTerminal() {
        return terminal;
    }

    public void setTerminal(TerminalModel terminal) {
        this.terminal = terminal;
    }

    public BankModel getBank() {
        return bank;
    }

    public void setBank(BankModel bank) {
        this.bank = bank;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.transactionId);
        dest.writeString(this.orderId);
        dest.writeString(this.card);
        dest.writeParcelable(this.terminal, flags);
        dest.writeParcelable(this.bank, flags);
        dest.writeByte(this.isSuccess ? (byte) 1 : (byte) 0);
    }

    protected TransactionVerifyModel(Parcel in) {
        this.transactionId = in.readString();
        this.orderId = in.readString();
        this.card = in.readString();
        this.terminal = in.readParcelable(TerminalModel.class.getClassLoader());
        this.bank = in.readParcelable(BankModel.class.getClassLoader());
        this.isSuccess = in.readByte() != 0;
    }

    public static final Creator<TransactionVerifyModel> CREATOR = new Creator<TransactionVerifyModel>() {
        @Override
        public TransactionVerifyModel createFromParcel(Parcel source) {
            return new TransactionVerifyModel(source);
        }

        @Override
        public TransactionVerifyModel[] newArray(int size) {
            return new TransactionVerifyModel[size];
        }
    };

    @Override
    public String toString() {
        return "TransactionVerifyModel{" +
                "transactionId='" + transactionId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", card='" + card + '\'' +
                ", terminal=" + terminal +
                ", bank=" + bank +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
