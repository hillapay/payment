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

    public static final Parcelable.Creator<TerminalModel> CREATOR = new Parcelable.Creator<TerminalModel>() {
        @Override
        public TerminalModel createFromParcel(Parcel source) {
            return new TerminalModel(source);
        }

        @Override
        public TerminalModel[] newArray(int size) {
            return new TerminalModel[size];
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