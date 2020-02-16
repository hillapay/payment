package ir.hillapay.pay.sdk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface HillaErrorType {
    int Unknown = 0;
    int Timeout = 1;
    int ServerDown = 2;
    int NoInternetConnection = 3;
    int Network = 4;
    int ParseJson = 5;
    int NotFound = 6;
    int InvalidParams = 7;
    int Response = 8;
    int CanceledByUser = 9;
    int NullObjects = 10;
}
