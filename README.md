# Hillapay

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](http://hillavas.com/)

This library  best For payment libraries.

  - Two way for payment 
  - Not use dependencies
  - Small library

## How to use

#### 1. Add dependencies

##### Add it in your root build.gradle at the end of repositories:
```sh
 allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
```
##### Add the dependency
```sh
 dependencies {
 	        implementation 'com.github.mehrtarh:hillarest:v1.0.2'
 	}
```

#### 2. Add api key in build.gradle(app)
```sh
defaultConfig {
        manifestPlaceholders = [HILLA_API_KEY: "Your key"]
}
```

#### 3. Add internet permission to manifest
```sh
<uses-permission android:name="android.permission.INTERNET" />
```
#### 4. Register SDK

```sh
HillaPaySdk.register(this, uid);
```
or

```sh
HillaPaySdk.register(this, uid,showFirsLevel);
```
>**showFirsLevel:** This field is enabled by default. When disabled, Mehran will not be displayed

#### 5. Request payment
```sh
HillapaySdk. payment(activityContext, amount, phone, orderId, description, uid, additionalData,sku, phoneByUser)
```
>**orderid:** The unique id that must be changed each time the payment request is made and must use the same orderId throughout the payment process.

>**uid:**  A unique id that must be unique for all payments.

>**sku:** This is a product code used to control payments.

>**uid:** You can get the phone number from the user to make this field true By activating this field a pre-paid step is added which takes the phone number from the user.

#### 6. Implementation result activity for get result payment
```sh
 @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        HillaPaySdk.getPaymentResult(requestCode, resultCode, data, new HillaPaySdkListener() {

            @Override
            public void paymentResult(IpgCallbackModel ipgModel, boolean isSuccess) {
                if (ipgModel != null && isSuccess)
                   HillaPaySdk. verify(MainActivity.this, uid, ipgModel);
            }

            @Override
            public void verifyResult(TransactionVerifyModel verifyModel, boolean isSuccess) {


            }

            @Override
            public void directDebitResult(DirectdebitPayModel payModel, boolean isSuccess) {

            }

            @Override
            public void failed(String message, @HillaErrorType int errorType) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }

```

>**paymentResult callback:** This callback Returns an IpgCallbackModel type that contains payment information.

>**verifyResult callback:**  This callback returns a TransactionVerifyModel type that responds to verify. With this callback you can get payment results and payment information.

>**directDebitResult callback:** This callback returns a DirectdebitPayModel type that responds to directdebit.

>**failed callback:** If the payment request goes to Error, this callback will be called

#### 7.Verify for payment

```sh
HillapaySdk. verify(activityContext, uid, ipgModel)

```

>**ipgModel:** Payment must be verified when using EPG, Get ipgModel from paymentResult Callback

###More option in sdk


#### 1. Open tracker

```sh
HillaPaySdk.openTrack(activityContext, uid);
```
> when open app call this method

#### 2. Close tracker

```sh
HillaPaySdk.closeTrack(activityContext, uid);
```
> when close app call this method

#### 3. Costume tracker

```sh
HillaPaySdk.track(activityContext, uid,action, description);
```
#### 4. Change sdk them

```sh
Open the AndroidManifest and paste the code below
```

```sh
        <meta-data
            android:name="ir.hillapay.core.BACKGROUND_MAIN"
            android:resource="@drawable/background_main" />
```

> **BACKGROUND_MAIN** Is the color of all backgrounds so you can use photos in the drawable folder and you can use colors in the color folder.

```sh
        <meta-data
            android:name="ir.hillapay.core.BACKGROUND_MAIN2"
            android:resource="@drawable/background_main2" />
```

> **BACKGROUND_MAIN2**  Is the color of all backgrounds so you can use photos in the drawable folder and you can use colors in the color folder.

```sh
        <meta-data
            android:name="ir.hillapay.core.LINE_COLOR"
            android:resource="@color/colorAccent" />
```
> **LINE_COLOR**  Is about the color of lines that you can use in the drawable folder, as well as the colors in the color folder.

```sh
        <meta-data
            android:name="ir.hillapay.core.POPUP_COLOR"
            android:resource="@color/colorAccent4" />
```
> **POPUP_COLOR**  It is about the color of dialogs that you can use in the drawable folder and the colors in the color folder.

```sh
        <meta-data
            android:name="ir.hillapay.core.TEXT_COLOR"
            android:resource="@color/colorAccent3" />
        <meta-data
            android:name="ir.hillapay.core.TEXT_COLOR"
            android:resource="@color/colorAccent3" />
        <meta-data
            android:name="ir.hillapay.core.CURVED_BUTTON_SIZE"
            android:value="100" />
```
> **CURVED_BUTTON_SIZE** You can change the solvent around the buttons with this option

```sh
       <meta-data
            android:name="ir.hillapay.core.FONT"
            android:value="fonts/hillafont.otf" />
```
> **CURVED_BUTTON_SIZE** This option allows you to change the font of the sdk you need to put your custom font in the fonts folder and name it in the settings

##### download persion pdf document

[https://github.com/hillapay/HillaPaySample/blob/master/hillapay.pdf](https://github.com/hillapay/HillaPaySample/blob/master/hillapay.pdf)