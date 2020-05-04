package ir.hillapay.pay.sdk;


import java.lang.annotation.Retention;

import ir.hillapay.core.types.CoreHillaIntDef;

import static ir.hillapay.core.types.CoreHillaVasActiveType.Expire;
import static ir.hillapay.core.types.CoreHillaVasActiveType.Subscribe;
import static ir.hillapay.core.types.CoreHillaVasActiveType.Unsubscribe;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@CoreHillaIntDef({
        Subscribe,
        Unsubscribe,
        Expire


})
public @interface HillaVasActiveType {
    int Subscribe = 0;
    int Unsubscribe = 1;
    int Expire = 2;
}

