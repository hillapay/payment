# HillaPay

[![Hilla WebSite](https://img.shields.io/badge/WebSite-HillaVas-red.svg)](http://hillavas.com/)  
 
[![](https://jitpack.io/v/hillapay/payment.svg)](https://jitpack.io/#hillapay/payment)

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
            implementation 'com.github.hillapay:payment:v1.4.4'
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
#### 4. Initialize SDK

```sh
HillaPaySdk.init(this, uid);
```
or

```sh
VasConfig vasConfig =new VasConfig.Builder()
                .setUserPhoneNumber("user phone number")
                .build();

        HillaPaymentConfig config = new HillaPaymentConfig.Builder()
                .setDirectdebitDailyWithdrawCount(3)
                .setDirectdebitMonthlyWithdrawCount(30)
                .addVasConfig(vasConfig)
                .showFirstLevel(true)
                .build();

HillaPaySdk.init(this, uid,config);
```
>**showFirsLevel:** Status of this field is "enabled" by default. In the case of "disabled", then select the payment method activity will not be displayed.

>**DirectdebitDailyWithdrawCount:** This field is the number of harvests per day, which is 1 by default.

>**DirectdebitMonthlyWithdrawCount:** This field is the number of harvests per month, which is 3 by default

>**VasConfig:** By making some adjustments to this filed, you can sue the M-VAS feature.

#####  VasConfig
>**UserPhoneNumber:** When you want to use M-VAS services, it is required to do an OTP or enter your mobile phone number. By using this filed, you may only enter the phone number, and there is no need to do the OTP process.



#### 5. Request payment
```sh
HillapaySdk. payment(activityContext, amount, phone, orderId, description, uid, additionalData,sku, phoneByUser)
```
>**orderid:** It is a unique id that must be changed each time the payment request is made and must use the same orderId throughout the payment process.

>**uid:**  It is a unique id that must be kept unique for all the payments.

>**sku:** It is a product code used to control payments.

>**uid:** You can get the phone number from the user to make this field TRUE by activating this field, a pre-paid step is added, which takes the phone number from the user.

#### 6. Implementation result activity to get result sdk
```java
public class Activity
{
 @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        HillaPaySdk.getSdkResult(requestCode, resultCode, data, new HillaPaySdkListener() {

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

            @Override
            public void directDebitVasResult(boolean isSuccess) {
                // TODO: use result  
            }

            @Override
            public void otpResult(boolean isSuccess, String phone) {
                // TODO: use results  
            }

			@Override
            public void unsubscribeUserResult(boolean isSuccess) {
                // TODO: use results
            }

            });

    }
}
```

>**paymentResult callback:** This callback Returns an IpgCallbackModel type that contains payment information.

>**verifyResult callback:**  This callback returns a TransactionVerifyModel type that responds to verify. With this callback, you can get payment results and payment information.

>**directDebitResult callback:** This callback returns a DirectdebitPayModel type that responds to directdebit.

>**failed callback:** This method will call when the payment request faces error.

>**directDebitVasResult callback:** This method called when you had created an M-VAS contract.

>**otpResult callback:** This method called when you had used OTP as a login.

>**unsubscribeUserResult callback:**  This method called when you had used OTP as a unsubscribe user. 

#### 7.Verify the payment

```sh
HillapaySdk. verify(activityContext, uid, ipgModel)
```

>**ipgModel:** Payment must be verified when using IPG, Get ipgModel from paymentResult callback

#### OTP
You can use the OTP login instead of having a server login yourself to be able to use this feature, and you must call the following method.
```sh
HillaPaySdk.OTP.phoneRegister(activityContext,uid);
```
The answer to this method returned in OnActivityResult, which is in the otpResult method.

#### M-VAS (Mobile Value Added Services)
To use the M-VAS capabilities, you must first log in with OTP (or added user phone number by VasConfig in init SDK) and then follow the steps below.

#### 1. otpRegister
Ignore this step If you have added a user's phone number with VasConfig.
```sh
 HillaPaySdk.OTP.phoneRegister(activityContext, uid);
```
#### 2. CheckActiveUser
```sh
 HillaPaySdk.VAS.checkActiveUser(activityContext, uid, 
       new HillaPayActiveUserListener() {
                @Override
                public void onResult(@HillaVasActiveType int active) {
                 // Compare active with HillaVasActiveType then implement 
				 // your favorite code
                }

                @Override
                public void onFailed(String message, int errorType) {
                    Toast.makeText(MainActivity.this,  message, Toast.LENGTH_SHORT).show();
                }
            });
```

This method checks whether the M-VAS user is active or not, and returns the result, which is as follows.


##### HillaVasActiveType

>**HillaVasActiveType.Expire:** The user's contract has expired.

>**HillaVasActiveType.Unsubscribe:** The user has no contract.

>**HillaVasActiveType.Subscribe:** The user has a contract.


 #### 3. Create Payman
If the user did not have a contract or the contract expired, use the following method. (n.b., Paymen means "Contract").
```sh
HillaPaySdk.VAS.createPayman(activityContext, uid);
```
The answer to this method is returned in OnActivityResult, which is in the directDebitVasResult method.

#### 4. Unsubscribe User
You may cancel the contract of the user by using the following method.
```sh
HillaPaySdk.VAS.unsubscribeUser(MainActivity.this, uid);
```

#### 4. IPG Report
###### 1. Total Report
You may get the total report of user payments with this method.

```sh
HillaPaySdk.VAS.getIpgReport(MainActivity.this, uid, new HillaPayIpgReportListener() {
                @Override
                public void onResult(HillaIpgReportModel report) {
                    Toast.makeText(MainActivity.this,
                            "count: " + report.getCountAmount() +
                                    "\n total Amount: " + report.getTotalAmount()
                            , Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailed(String message, int errorType) {
                    Toast.makeText(MainActivity.this, "report:" + message, Toast.LENGTH_SHORT).show();
                }
            });
```
###### 2. Last List Report

You may get The last five reports of user payments with this method.
```sh
 HillaPaySdk.getIpgReportLastList(MainActivity.this, uid, new HillaPayIpgReportListListener() {
                @Override
                public void onResult(List<HillaIpgLastReportModel> report) {
                    Toast.makeText(MainActivity.this,
                            "count: " + report.size()
                            , Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailed(String message, int errorType) {
                    Toast.makeText(MainActivity.this, "report:" + message, Toast.LENGTH_SHORT).show();
                }
            });
```

#### Storage
You can use server storage space. This feature is like SharedPreferences with the difference that it is online.
You can use this service below:

###### 1.Insert item

You can add an item to storage. 

```sh
 HillaPaySdk.Storage.insertItem(MainActivity.this, uid, "sampleKey", "sampleValue", "mobile", "optionalDomainName", "expire", new HillaPayStorageListener.InsertListener() {
                @Override
                public void onResult(boolean successInsert, String storageId) {
                    
                }

                @Override
                public void onFailed(String message, int errorType) {

                }
            });
```
>optionalDomainName: Choose a name for the domain.
>expire: When the expiration date, the storage item will be cleared.

###### 2.Update Item
You can update the item in storage. 

```sh
 HillaPaySdk.Storage.updateItem(MainActivity.this, uid, "storageId", "sampleKey", "sampleValue", "mobile", "optionalDomainName", "1000",
                    new HillaPayStorageListener.UpdateListener() {
                        @Override
                        public void onResult(boolean successUpdate, String storageId) {
                            
                        }

                        @Override
                        public void onFailed(String message, int errorType) {

                        }
                    });
```
>storageId: This is storage id; get this id from insert service or get storage service


###### 3.Delete item
You can delete an item in storage. 

```sh
HillaPaySdk.Storage.destroyItemStorage(MainActivity.this, uid, "storageId", new HillaPayStorageListener.DestroyListener() {
                @Override
                public void onResult(boolean successDestroy) {

                }

                @Override
                public void onFailed(String message, int errorType) {

                }
            });
```

###### 4.Get one storage item
you can get one item with a key.

```sh
HillaPaySdk.Storage.getItemStorage(MainActivity, uid, "sampleKey", new HillaPayStorageListener.ItemListener() {
                @Override
                public void onResult(StorageModel storageModel) {

                }

                @Override
                public void onFailed(String message, int errorType) {

                }
            });
```

###### 5.Get all storage items
you can get all items in your storage.

```sh
HillaPaySdk.Storage.getAllItemsStorage(MainActivity.this, uid, new HillaPayStorageListener.ItemsListener() {
                @Override
                public void onResult(List<StorageModel> storageModels) {
                    
                }

                @Override
                public void onFailed(String message, int errorType) {

                }
            });
```

### More option in SDK


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
#### 4. Publish Service
This service is a tool to manage your application in different instances. For example, you can use this service to control whether your app is free or not, or even its language.


```sh
 HillaPaySdk.getPublishInfo(MainActivity.this, uid, new HillaPayPublishInfoListener() {
                @Override
                public void onResult(PublishModel publishModel) {
                    PublishDeviceModel publishAndroidModel = publishModel.getA();
                    String hasActive = publishAndroidModel.getHa();
                    String hasPayment = publishAndroidModel.getHp();
                    String language = publishAndroidModel.getLg();
                    String description = publishAndroidModel.getDescription();


                }

                @Override
                public void onFailed(String message, int errorType) {

                }
            });
```
>**getA():** get android publish info
>**publishAndroidModel.getHa():** get publish active status 
>**publishAndroidModel.getHp():** get active payment status 
>**publishAndroidModel.getLg():** get publish language
>**publishAndroidModel.getDescription():** get publish description


#### 4. Change sdk them

```sh
Open the AndroidManifest and paste the below code:
```

```xml
        <meta-data
            android:name="ir.hillapay.core.BACKGROUND_MAIN"
            android:resource="@drawable/background_main" />
```
> **BACKGROUND_MAIN** It is the color of all backgrounds, you can also use a photo in the background and load it from the "drawable" folder, and you can set color values in the "colors.xml" in "values" folder.

```xml
        <meta-data
            android:name="ir.hillapay.core.BACKGROUND_MAIN2"
            android:resource="@drawable/background_main2" />
```
> **BACKGROUND_MAIN2**  It is the color of all backgrounds, you can also use a photo in the background and load it from the "drawable" folder, and you can set color values in the "colors.xml" in "values" folder. It is visible on the BACKGROUND_MAIN.

```xml
        <meta-data
            android:name="ir.hillapay.core.LINE_COLOR"
            android:resource="@color/colorAccent" />
```            
> **LINE_COLOR**  It is the color of lines that you can set it in the "drawable" folder, and you can set color values in the "colors.xml" in the "values" folder. 

```xml
        <meta-data
            android:name="ir.hillapay.core.POPUP_COLOR"
            android:resource="@color/colorAccent4" />
```            
> **POPUP_COLOR**  It is the color of dialogue boxes that you can set it in the "drawable" folder, and you can set color values in the "colors.xml" in the "values" folder. 

```xml
        <meta-data
            android:name="ir.hillapay.core.TEXT_COLOR"
            android:resource="@color/colorAccent3" />
```    
> **TEXT_COLOR** You can change the color text with this option. 

```xml
        <meta-data
            android:name="ir.hillapay.core.CURVED_BUTTON_SIZE"
            android:value="100" />
```          
> **CURVED_BUTTON_SIZE** You can change the curve amount around the buttons with this option.        



```xml
      <meta-data
            android:name="ir.hillapay.core.REGISTER_PHONE_LABEL"
            android:value="@string/phone_label" />
```            
> **REGISTER_PHONE_LABEL** You can change the title of the OTP phone number.

```xml
      <meta-data
            android:name="ir.hillapay.core.REGISTER_CODE_LABEL"
            android:value="@string/phone_label" />
```            
> **REGISTER_PHONE_LABEL**  You can change the title of the OTP code number.

```xml
      <meta-data
            android:name="ir.hillapay.core.BACKGROUND_PHONE_NUMBER"
            android:value="@color/colorAccent5" />
```            
> **BACKGROUND_PHONE_NUMBER**   It is the color of all backgrounds, you can also use a photo in the background and load it from the "drawable" folder, and you can set color values in the "colors.xml" in "values" folder. It is visible on the BACKGROUND_PHONE_NUMBER in OTP.

```xml
       <meta-data
            android:name="ir.hillapay.core.FONT"
            android:value="fonts/hillafont.otf" />
```            
> **FONT** This option allows you to change the font of the SDK. Put your custom font in the "fonts" folder and name it in the settings.

##### Download the Persian version in PDF

[https://github.com/hillapay/HillaPaySample/blob/master/hillapay.pdf](https://github.com/hillapay/HillaPaySample/blob/master/hillapay.pdf)


[hilla]: http://hillavas.com/ "Hillavas"