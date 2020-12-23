package ir.hillapay.pay.sdk;

import android.os.Parcel;
import android.os.Parcelable;


public class StorageModel implements Parcelable {


    private String packageName;
    private String packageVersion;
    private String cid;
    private String storageId;
    private String expire;
    private String timestamp;
    private String domain;
    private String value;
    private String name;

    public StorageModel(String packageName, String packageVersion, String cid, String storageId, String expire, String timestamp, String domain, String value, String name) {
        this.packageName = packageName;
        this.packageVersion = packageVersion;
        this.cid = cid;
        this.storageId = storageId;
        this.expire = expire;
        this.timestamp = timestamp;
        this.domain = domain;
        this.value = value;
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageVersion() {
        return packageVersion;
    }

    public void setPackageVersion(String packageVersion) {
        this.packageVersion = packageVersion;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.packageName);
        dest.writeString(this.packageVersion);
        dest.writeString(this.cid);
        dest.writeString(this.storageId);
        dest.writeString(this.expire);
        dest.writeString(this.timestamp);
        dest.writeString(this.domain);
        dest.writeString(this.value);
        dest.writeString(this.name);
    }

    protected StorageModel(Parcel in) {
        this.packageName = in.readString();
        this.packageVersion = in.readString();
        this.cid = in.readString();
        this.storageId = in.readString();
        this.expire = in.readString();
        this.timestamp = in.readString();
        this.domain = in.readString();
        this.value = in.readString();
        this.name = in.readString();
    }

    public static final Creator<StorageModel> CREATOR = new Creator<StorageModel>() {
        @Override
        public StorageModel createFromParcel(Parcel source) {
            return new StorageModel(source);
        }

        @Override
        public StorageModel[] newArray(int size) {
            return new StorageModel[size];
        }
    };


    @Override
    public String toString() {
        return "StorageModel{" +
                "packageName='" + packageName + '\'' +
                ", packageVersion='" + packageVersion + '\'' +
                ", cid='" + cid + '\'' +
                ", storageId='" + storageId + '\'' +
                ", expire='" + expire + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", domain='" + domain + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
