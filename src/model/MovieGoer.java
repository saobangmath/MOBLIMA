package model;

/**
 * represent movie goer class
 * @author Phung Minh Khanh
 */
public class MovieGoer extends Email{
    private String email;
    private int age;
    private String name;
    private int mobileNumber;
    private float rewardPoint;

    /**
     * constructor
     * @param emailInput
     * @param ageInput
     * @param nameInput
     * @param mobileInput
     * @param rewardPointInput
     */
    public MovieGoer(String emailInput, int ageInput, String nameInput, int mobileInput, float rewardPointInput){
        email = emailInput;
        age = ageInput;
        name = nameInput;
        mobileNumber = mobileInput;
        rewardPoint = rewardPointInput;
    }

    /**
     * @return goer email
     */
    public String getEmail(){ return this.email; };

    /**
     * @return goer age
     */
    public int getAge(){return this.age; }

    /**
     * @return goer name
     */
    public String getName() {return this.name;}

    /**
     * @return goer mobile phone
     */
    public int getMobile() {return this.mobileNumber;}

    /**
     * @return goer reward point
     */
    public float getRewardPoint(){return this.rewardPoint;}

    /**
     * set goer reward point to a specific float
     * @param rewardPointInput
     */
    public void setRewardPoint(float rewardPointInput){this.rewardPoint = rewardPointInput;}

}