package ir.hillapay.pay.sdk;




public class HillaPaymentConfig {

    private int directdebitMonthlyWithdrawCount;
    private int directdebitDailyWithdrawCount;
    private boolean addPhoneByUser;
    private boolean showFirsLevel;

    public int getDirectdebitMonthlyWithdrawCount() {
        return directdebitMonthlyWithdrawCount;
    }

    public int getDirectdebitDailyWithdrawCount() {
        return directdebitDailyWithdrawCount;
    }

    public boolean addPhoneByUser() {
        return addPhoneByUser;
    }

    public boolean showFirsLevel() {
        return showFirsLevel;
    }

    private HillaPaymentConfig(Builder builder) {

        addPhoneByUser = builder.addPhoneByUser;
        directdebitMonthlyWithdrawCount = builder.directdebitMonthlyWithdrawCount;
        directdebitDailyWithdrawCount = builder.directdebitDailyWithdrawCount;
        showFirsLevel = builder.showFirsLevel;

    }


    public static class Builder {

        private int directdebitMonthlyWithdrawCount = 30;
        private int directdebitDailyWithdrawCount = 1;
        private boolean addPhoneByUser = false;
        private boolean showFirsLevel = true;

        public Builder setDirectdebitMonthlyWithdrawCount(int monthlyCount) {
            this.directdebitMonthlyWithdrawCount = monthlyCount;
            return this;
        }

        public Builder setDirectdebitDailyWithdrawCount(int dailyCount) {
            this.directdebitDailyWithdrawCount = dailyCount;
            return this;
        }

        private Builder addPhoneByUser(boolean phoneByUser) {
            this.addPhoneByUser = phoneByUser;
            return this;
        }

        public Builder showFirstLevel(boolean showFirsLevel) {
            this.showFirsLevel = showFirsLevel;
            return this;
        }

        public HillaPaymentConfig build() {
            return new HillaPaymentConfig(this);
        }

    }

}

