package ir.hillapay.pay.sdk;

import android.os.Parcel;
import android.os.Parcelable;


public class PublishDeviceModel implements Parcelable {
    private String hp;
    private String ha;
    private String lg;
    private String description;
    private boolean status;


    public PublishDeviceModel(String hp, String ha, String lg, String description, boolean status) {
        this.hp = hp;
        this.ha = ha;
        this.lg = lg;
        this.description = description;
        this.status = status;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getHa() {
        return ha;
    }

    public void setHa(String ha) {
        this.ha = ha;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.hp);
        dest.writeString(this.ha);
        dest.writeString(this.lg);
        dest.writeString(this.description);
        dest.writeByte(this.status ? (byte) 1 : (byte) 0);
    }

    protected PublishDeviceModel(Parcel in) {
        this.hp = in.readString();
        this.ha = in.readString();
        this.lg = in.readString();
        this.description = in.readString();
        this.status = in.readByte() != 0;
    }

    public static final Creator<PublishDeviceModel> CREATOR = new Creator<PublishDeviceModel>() {
        @Override
        public PublishDeviceModel createFromParcel(Parcel source) {
            return new PublishDeviceModel(source);
        }

        @Override
        public PublishDeviceModel[] newArray(int size) {
            return new PublishDeviceModel[size];
        }
    };

    @Override
    public String toString() {
        return "PublishDeviceModel{" +
                "hp='" + hp + '\'' +
                ", ha='" + ha + '\'' +
                ", lg='" + lg + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
