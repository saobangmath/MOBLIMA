package model;

public class MovieGoer extends Email{
    private String email;
    private int age;
    private String name;
    private int mobileNumber;
    private float rewardPoint;

    public MovieGoer(String emailInput, int ageInput, String nameInput, int mobileInput, float rewardPointInput){
        email = emailInput;
        age = ageInput;
        name = nameInput;
        mobileNumber = mobileInput; 
        rewardPoint = rewardPointInput;
    }

    public String getEmail(){ return this.email; };

    public int getAge(){return this.age; }

    public String getName() {return this.name;}

    public int getMobile() {return this.mobileNumber;}

    public float getRewardPoint(){return this.rewardPoint;}

    public void setRewardPoint(float rewardPointInput){this.rewardPoint = rewardPointInput;}

}