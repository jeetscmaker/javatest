package org.jk.entity;

import org.jk.util.Util;

public class Company {
    private String companyCode;
    private String account;
    private String city;
    private String country;
    private String creditRating;
    private String currency;
    private double amount;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Company [companyCode=" + companyCode + ", account=" + account + ", city=" + city + ", country="
                + country + ", creditRating=" + creditRating + ", currency=" + currency + ", amount=" + amount + "]";
    }

    public static Company setCompanyData(String[] arr) {
        Company company = new Company();
        company.setCompanyCode(arr[0]);
        company.setAccount(arr[1]);
        company.setCity(arr[2]);
        company.setCountry(arr[3]);
        company.setCurrency(arr[4]);
        company.setCreditRating(arr[5]);
        company.setAmount(Util.amountInEuro(Double.parseDouble(arr[6]), arr[4]));
        return company;
    }
}