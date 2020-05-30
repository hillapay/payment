package ir.hillapay.pay.sdk;


import android.os.Parcel;
import android.os.Parcelable;


public class HillaIpgLastReportModel implements Parcelable {
    private long amount;
    private String sku;
    private String orderId;
    private String transactionId;
    private String timestamp;

    public HillaIpgLastReportModel(long amount, String sku, String orderId, String transactionId, String timestamp) {
        this.amount = amount;
        this.sku = sku;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.timestamp = timestamp;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.amount);
        dest.writeString(this.sku);
        dest.writeString(this.orderId);
        dest.writeString(this.transactionId);
        dest.writeString(this.timestamp);
    }

    protected HillaIpgLastReportModel(Parcel in) {
        this.amount = in.readLong();
        this.sku = in.readString();
        this.orderId = in.readString();
        this.transactionId = in.readString();
        this.timestamp = in.readString();
    }

    public static final Creator<HillaIpgLastReportModel> CREATOR = new Creator<HillaIpgLastReportModel>() {
        @Override
        public HillaIpgLastReportModel createFromParcel(Parcel source) {
            return new HillaIpgLastReportModel(source);
        }

        @Override
        public HillaIpgLastReportModel[] newArray(int size) {
            return new HillaIpgLastReportModel[size];
        }
    };
}