# Hillapay

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](http://hillavas.com/)

HillaPay Payment SDK is an effective and convenient way to implement a payment system to android apps and games. The SDK is working pretty fine with the Shetab Banking Network and all related cards. This payment SDK is Android-market-independent so that you may take benefit from it for a wide variety of use.

Some of the features of this payment SDK are as follows;
- There are two methods for making payments,
- it does not rely on dependencies,
- it is pretty small in size, and
- there is no other library in it.

Let's have a look at it.


## How to use

#### 1. Add dependencies

##### Add it to your root build.gradle at the end of repositories:
```groovy
 allprojects {
     repositories {
       
       maven { url 'https://jitpack.io' }
     }
   }
```
##### Add the dependency
```groovy
 dependencies {
           implementation 'com.github.mehrtarh:hillarest:1.0.2'
   }
```
#### 2. Add API key in build.gradle(app)
```groovy
defaultConfig {
        manifestPlaceholders = [HILLA_API_KEY: "Your key"]
}
```
#### 3. Add internet permission to manifest
```xml
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
>showFirsLevel: Status of this field is "enabled" by default. In the case of "disabled", then select the payment method activity will not be displayed.

#### 5. Request payment
```sh
HillapaySdk. payment(activityContext, amount, phone, orderId, description, uid, additionalData,sku, phoneByUser)
```
>orderid: It is a unique id that must be changed each time the payment request is made and must use the same orderId throughout the payment process.

>uid:  It is a unique id that must be kept unique for all the payments.

>sku: It is a product code used to control payments.

>uid: You can get the phone number from the user to make this field TRUE by activating this field, a pre-paid step is added, which takes the phone number from the user.

#### 6. Implementation result activity to get result payment
```java
public class Activity
{
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
}
```

>paymentResult callback: This callback Returns an IpgCallbackModel type that contains payment information.

>verifyResult callback:  This callback returns a TransactionVerifyModel type that responds to verify. With this callback, you can get payment results and payment information.

>directDebitResult callback: This callback returns a DirectdebitPayModel type that responds to directdebit.

>failed callback: This method will call when the payment request faces error.

#### 7.Verify the payment

```sh
HillapaySdk. verify(activityContext, uid, ipgModel)
```

>ipgModel: Payment must be verified when using IPG, Get ipgModel from paymentResult callback

###More option in SDK


#### 1. Open tracker

```sh
HillaPaySdk.openTrack(activityContext, uid);
```
> This method will call when the app opens.

#### 2. Close tracker

```sh
HillaPaySdk.closeTrack(activityContext, uid);
```
> This method will call when the app closes.

#### 3. Costume tracker

```sh
HillaPaySdk.track(activityContext, uid,action, description);
```
#### 4. Change sdk them

```sh
Open the AndroidManifest and paste the below code:
```

```xml
        <meta-data
            android:name="ir.hillapay.core.BACKGROUND_MAIN"
            android:resource="@drawable/background_main" />
```
> BACKGROUND_MAIN It is the color of all backgrounds, you can also use a photo in the background and load it from the "drawable" folder, and you can set color values in the "colors.xml" in "values" folder.

```xml
        <meta-data
            android:name="ir.hillapay.core.BACKGROUND_MAIN2"
            android:resource="@drawable/background_main2" />
```
> BACKGROUND_MAIN2  It is the color of all backgrounds, you can also use a photo in the background and load it from the "drawable" folder, and you can set color values in the "colors.xml" in "values" folder. It is visible on the BACKGROUND_MAIN.

```xml
        <meta-data
            android:name="ir.hillapay.core.LINE_COLOR"
            android:resource="@color/colorAccent" />
```            
> LINE_COLOR  It is the color of lines that you can set it in the "drawable" folder, and you can set color values in the "colors.xml" in the "values" folder. 

```xml
        <meta-data
            android:name="ir.hillapay.core.POPUP_COLOR"
            android:resource="@color/colorAccent4" />
```            
> POPUP_COLOR  It is the color of dialogue boxes that you can set it in the "drawable" folder, and you can set color values in the "colors.xml" in the "values" folder. 

```xml
        <meta-data
            android:name="ir.hillapay.core.TEXT_COLOR"
            android:resource="@color/colorAccent3" />
```    
```xml
       <meta-data
            android:name="ir.hillapay.core.TEXT_COLOR"
            android:resource="@color/colorAccent3" />
```  
```xml
        <meta-data
            android:name="ir.hillapay.core.CURVED_BUTTON_SIZE"
            android:value="100" />
```          

        
> FONT This option allows you to change the font of the SDK. Put your custom font in the "fonts" folder and name it in the settings.

```xml
       <meta-data
            android:name="ir.hillapay.core.FONT"
            android:value="fonts/hillafont.otf" />
```            
> CURVED_BUTTON_SIZE You can change the curve amount around the buttons with this option.

##### Download the Persian version in PDF

[https://github.com/hillapay/HillaPaySample/blob/master/hillapay.pdf](https://github.com/hillapay/HillaPaySample/blob/master/hillapay.pdf)
