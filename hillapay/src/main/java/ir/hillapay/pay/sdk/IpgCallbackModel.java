package ir.hillapay.pay.sdk;


import android.os.Parcel;
import android.os.Parcelable;

public class IpgCallbackModel implements Parcelable {


    private String transactionId;
    private String orderId;
    private int statusCode;
    private String statusDescription;
    private String packageName;
    private String returnAmount;
    private String returnRrn;
    private boolean isSuccess;

    public IpgCallbackModel(String transactionId, String orderId, int statusCode, String statusDescription, String packageName, String returnAmount, String returnRrn, boolean isSuccess) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.packageName = packageName;
        this.returnAmount = returnAmount;
        this.returnRrn = returnRrn;
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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(String returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnRrn() {
        return returnRrn;
    }

    public void setReturnRrn(String returnRrn) {
        this.returnRrn = returnRrn;
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
        dest.writeInt(this.statusCode);
        dest.writeString(this.statusDescription);
        dest.writeString(this.packageName);
        dest.writeString(this.returnAmount);
        dest.writeString(this.returnRrn);
        dest.writeByte(this.isSuccess ? (byte) 1 : (byte) 0);
    }

    protected IpgCallbackModel(Parcel in) {
        this.transactionId = in.readString();
        this.orderId = in.readString();
        this.statusCode = in.readInt();
        this.statusDescription = in.readString();
        this.packageName = in.readString();
        this.returnAmount = in.readString();
        this.returnRrn = in.readString();
        this.isSuccess = in.readByte() != 0;
    }

    public static final Creator<ir.hillapay.core.publicmodel.IpgCallbackModel> CREATOR = new Creator<ir.hillapay.core.publicmodel.IpgCallbackModel>() {
        @Override
        public ir.hillapay.core.publicmodel.IpgCallbackModel createFromParcel(Parcel source) {
            return new ir.hillapay.core.publicmodel.IpgCallbackModel(source);
        }

        @Override
        public ir.hillapay.core.publicmodel.IpgCallbackModel[] newArray(int size) {
            return new ir.hillapay.core.publicmodel.IpgCallbackModel[size];
        }
    };

    @Override
    public String toString() {
        return "IpgCallbackModel{" +
                "transactionId='" + transactionId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", statusCode=" + statusCode +
                ", statusDescription='" + statusDescription + '\'' +
                ", packageName='" + packageName + '\'' +
                ", returnAmount='" + returnAmount + '\'' +
                ", returnRrn='" + returnRrn + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
