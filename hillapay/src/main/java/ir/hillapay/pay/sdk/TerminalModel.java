package ir.hillapay.pay.sdk;


import android.os.Parcel;
import android.os.Parcelable;


public class TerminalModel implements Parcelable {
    private String title;
    private String id;



    public TerminalModel(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.id);
    }

    protected TerminalModel(Parcel in) {
        this.title = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<ir.hillapay.core.publicmodel.TerminalModel> CREATOR = new Parcelable.Creator<ir.hillapay.core.publicmodel.TerminalModel>() {
        @Override
        public ir.hillapay.core.publicmodel.TerminalModel createFromParcel(Parcel source) {
            return new ir.hillapay.core.publicmodel.TerminalModel(source);
        }

        @Override
        public ir.hillapay.core.publicmodel.TerminalModel[] newArray(int size) {
            return new ir.hillapay.core.publicmodel.TerminalModel[size];
        }
    };

    @Override
    public String toString() {
        return "TerminalModel{" +"\n"+
                "title='" + title + '\'' +"\n"+
                ", id='" + id + '\'' +"\n"+
                '}';
    }
}