package ir.hillapay.pay.sdk;

public class VasConfig {

    private String userPhoneNumber;
    private boolean withOtp ;

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    private boolean withOtp() {
        return withOtp;
    }



    private VasConfig(Builder builder) {
        userPhoneNumber = builder.userPhoneNumber;
        withOtp = builder.withOtp;
    }


    public static class Builder {

        private String userPhoneNumber = null;
        private boolean withOtp = true;

        public Builder setUserPhoneNumber(String userPhoneNumber) {
            this.userPhoneNumber = userPhoneNumber;
            return this;
        }

        private Builder withOtp(boolean withOtp) {
            this.withOtp = withOtp;
            return this;
        }


        public VasConfig build() {
            return new VasConfig(this);
        }




    }




}

