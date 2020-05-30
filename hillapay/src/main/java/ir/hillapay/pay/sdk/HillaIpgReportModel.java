package ir.hillapay.pay.sdk;


import android.os.Parcel;
import android.os.Parcelable;


public class HillaIpgReportModel implements Parcelable {
    private long countAmount;
    private String totalAmount;

    public HillaIpgReportModel(long countAmount, String totalAmount) {
        this.countAmount = countAmount;
        this.totalAmount = totalAmount;
    }

    public long getCountAmount() {
        return countAmount;
    }

    public void setCountAmount(long countAmount) {
        this.countAmount = countAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "ReportModel{" +"\n"+
                "countAmount='" + countAmount + '\'' +"\n"+
                ", totalAmount='" + totalAmount + '\'' +"\n"+
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.countAmount);
        dest.writeString(this.totalAmount);
    }

    protected HillaIpgReportModel(Parcel in) {
        this.countAmount = in.readLong();
        this.totalAmount = in.readString();
    }

    public static final Creator<HillaIpgReportModel> CREATOR = new Creator<HillaIpgReportModel>() {
        @Override
        public HillaIpgReportModel createFromParcel(Parcel source) {
            return new HillaIpgReportModel(source);
        }

        @Override
        public HillaIpgReportModel[] newArray(int size) {
            return new HillaIpgReportModel[size];
        }
    };
}