package ybigta.us.dto;

public class UserDashboardResponse {
    private String name;
    private Boolean sex;
    private String phoneNumber;
    private String email;

    private String featureValue1;
    private String featureValue2;
    private String featureValue3;
    private String featureValue4;
    private String featureValue5;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }


    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public String getFeatureValue1() {
        return featureValue1;
    }

    public void setFeatureValue1(String featureValue1) {
        this.featureValue1 = featureValue1;
    }

    public String getFeatureValue2() {
        return featureValue2;
    }

    public void setFeatureValue2(String featureValue2) {
        this.featureValue2 = featureValue2;
    }

    public String getFeatureValue3() {
        return featureValue3;
    }

    public void setFeatureValue3(String featureValue3) {
        this.featureValue3 = featureValue3;
    }

    public String getFeatureValue4() {
        return featureValue4;
    }

    public void setFeatureValue4(String featureValue4) {
        this.featureValue4 = featureValue4;
    }

    public String getFeatureValue5() {
        return featureValue5;
    }

    public void setFeatureValue5(String featureValue5) {
        this.featureValue5 = featureValue5;
    }
}
