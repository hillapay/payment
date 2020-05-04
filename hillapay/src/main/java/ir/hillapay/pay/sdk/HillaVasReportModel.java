package ir.hillapay.pay.sdk;


import android.os.Parcel;
import android.os.Parcelable;


public class HillaVasReportModel implements Parcelable {
    private long countAmount;
    private String totalAmount;

    public HillaVasReportModel(long countAmount, String totalAmount) {
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

    protected HillaVasReportModel(Parcel in) {
        this.countAmount = in.readLong();
        this.totalAmount = in.readString();
    }

    public static final Creator<HillaVasReportModel> CREATOR = new Creator<HillaVasReportModel>() {
        @Override
        public HillaVasReportModel createFromParcel(Parcel source) {
            return new HillaVasReportModel(source);
        }

        @Override
        public HillaVasReportModel[] newArray(int size) {
            return new HillaVasReportModel[size];
        }
    };
}