package ir.hillapay.pay.sdk;


import java.lang.annotation.Retention;

import ir.hillapay.core.types.HillaIntDef;

import static ir.hillapay.core.types.HillaVasActiveType.Expire;
import static ir.hillapay.core.types.HillaVasActiveType.Subscribe;
import static ir.hillapay.core.types.HillaVasActiveType.Unsubscribe;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@HillaIntDef({
        Subscribe,
        Unsubscribe,
        Expire


})
public @interface HillaVasActiveType {
    int Subscribe = 0;
    int Unsubscribe = 1;
    int Expire = 2;
}

