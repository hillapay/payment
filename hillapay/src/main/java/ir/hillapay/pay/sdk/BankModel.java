package ir.hillapay.pay.sdk;

import android.os.Parcel;
import android.os.Parcelable;


public class BankModel implements Parcelable {


    private String id;
    private String withdrawalType;
    private String title;
    private String image;

    public BankModel(String id, String withdrawalType, String title, String image) {
        this.id = id;
        this.withdrawalType = withdrawalType;
        this.title = title;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.withdrawalType);
        dest.writeString(this.title);
        dest.writeString(this.image);
    }

    protected BankModel(Parcel in) {
        this.id = in.readString();
        this.withdrawalType = in.readString();
        this.title = in.readString();
        this.image = in.readString();
    }

    public static final Creator<ir.hillapay.core.publicmodel.BankModel> CREATOR = new Creator<ir.hillapay.core.publicmodel.BankModel>() {
        @Override
        public ir.hillapay.core.publicmodel.BankModel createFromParcel(Parcel source) {
            return new ir.hillapay.core.publicmodel.BankModel(source);
        }

        @Override
        public ir.hillapay.core.publicmodel.BankModel[] newArray(int size) {
            return new ir.hillapay.core.publicmodel.BankModel[size];
        }
    };

    @Override
    public String toString() {
        return "BankModel{" +
                "id='" + id + '\'' +
                ", withdrawalType='" + withdrawalType + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}