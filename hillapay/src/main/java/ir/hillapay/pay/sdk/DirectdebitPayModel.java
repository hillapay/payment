package ir.hillapay.pay.sdk;


import android.os.Parcel;
import android.os.Parcelable;




public class DirectdebitPayModel implements Parcelable {


    private String transactionId;
    private String orderId;
    private String transactionAmount;
    private TerminalModel terminal;
    private BankModel bank;
    private boolean isSuccess;



    public DirectdebitPayModel(String transactionId, String orderId, String transactionAmount, TerminalModel terminal, BankModel bank, boolean isSuccess) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.transactionAmount = transactionAmount;
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

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
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
    public String toString() {
        return "DirectdebitPayModel{" +
                "transactionId='" + transactionId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", terminal=" + terminal +
                ", bank=" + bank +
                ", isSuccess=" + isSuccess +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.transactionId);
        dest.writeString(this.orderId);
        dest.writeString(this.transactionAmount);
        dest.writeParcelable(this.terminal, flags);
        dest.writeParcelable(this.bank, flags);
        dest.writeByte(this.isSuccess ? (byte) 1 : (byte) 0);
    }

    protected DirectdebitPayModel(Parcel in) {
        this.transactionId = in.readString();
        this.orderId = in.readString();
        this.transactionAmount = in.readString();
        this.terminal = in.readParcelable(TerminalModel.class.getClassLoader());
        this.bank = in.readParcelable(BankModel.class.getClassLoader());
        this.isSuccess = in.readByte() != 0;
    }

    public static final Creator<ir.hillapay.core.publicmodel.DirectdebitPayModel> CREATOR = new Creator<ir.hillapay.core.publicmodel.DirectdebitPayModel>() {
        @Override
        public ir.hillapay.core.publicmodel.DirectdebitPayModel createFromParcel(Parcel source) {
            return new ir.hillapay.core.publicmodel.DirectdebitPayModel(source);
        }

        @Override
        public ir.hillapay.core.publicmodel.DirectdebitPayModel[] newArray(int size) {
            return new ir.hillapay.core.publicmodel.DirectdebitPayModel[size];
        }
    };
}
