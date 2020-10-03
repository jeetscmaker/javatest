package org.jk.entity;

public class CC {
    String country;
    String creditRating;

    public static class Builder {
        String country;
        String creditRating;

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withCreditRating(String creditRating) {
            this.creditRating = creditRating;
            return this;
        }

        public CC build() {
            CC cc = new CC();
            cc.country = this.country;
            cc.creditRating = this.creditRating;
            return cc;
        }
    }
}
