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
     * constructor of moviegoer object
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
	 * get moviegoer email
     * @return moviegoer email
     */
    public String getEmail(){ return this.email; };

    /**
	 * get moviegoer age
     * @return moviegoer age
     */
    public int getAge(){return this.age; }

    /**
	 * get moviegoer name
     * @return moviegoer name
     */
    public String getName() {return this.name;}

    /**
	 * get moviegoer mobile phone
     * @return moviegoer mobile phone
     */
    public int getMobile() {return this.mobileNumber;}

    /**
	 * get moviegoer reward point
     * @return moviegoer reward point
     */
    public float getRewardPoint(){return this.rewardPoint;}

    /**
     * change moviegoer reward point to a specific float
     * @param rewardPointInput
     */
    public void setRewardPoint(float rewardPointInput){this.rewardPoint = rewardPointInput;}

}