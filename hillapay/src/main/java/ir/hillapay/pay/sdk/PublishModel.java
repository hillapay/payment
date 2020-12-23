package ir.hillapay.pay.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import ir.hillapay.core.publicmodel.CorePublishDeviceModel;

public class PublishModel implements Parcelable {

    private PublishDeviceModel a;
    private PublishDeviceModel i;

    public PublishModel(PublishDeviceModel a, PublishDeviceModel i) {
        this.a = a;
        this.i = i;
    }

    public PublishDeviceModel getA() {
        return a;
    }

    public void setA(PublishDeviceModel a) {
        this.a = a;
    }

    public PublishDeviceModel getI() {
        return i;
    }

    public void setI(PublishDeviceModel i) {
        this.i = i;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.a, flags);
        dest.writeParcelable(this.i, flags);
    }

    protected PublishModel(Parcel in) {
        this.a = in.readParcelable(PublishDeviceModel.class.getClassLoader());
        this.i = in.readParcelable(PublishDeviceModel.class.getClassLoader());
    }

    public static final Creator<PublishModel> CREATOR = new Creator<PublishModel>() {
        @Override
        public PublishModel createFromParcel(Parcel source) {
            return new PublishModel(source);
        }

        @Override
        public PublishModel[] newArray(int size) {
            return new PublishModel[size];
        }
    };

    @Override
    public String toString() {
        return "PublishModel{" +
                "a=" + a +
                ", i=" + i +
                '}';
    }
}
