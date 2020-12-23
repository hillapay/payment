package ir.hillapay.pay.sdk;

import java.util.List;



public interface HillaPayStorageListener {

    interface FailedListener {
        void onFailed(String message, @HillaErrorType int errorType);
    }

    interface InsertListener extends FailedListener {
        void onResult(boolean successInsert, String storageId);
    }

    interface UpdateListener extends FailedListener {

        void onResult(boolean successUpdate, String storageId);
    }

    interface DestroyListener extends FailedListener {
        void onResult(boolean successDestroy);
    }

    interface ItemsListener extends FailedListener {
        void onResult(List<StorageModel> storageModels);
    }

    interface ItemListener extends FailedListener {
        void onResult(StorageModel storageModel);
    }


}
