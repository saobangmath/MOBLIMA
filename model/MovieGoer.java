package model;

public class MovieGoer extends Email{
    private String email;
    private int age;
    private String name;
    private int mobileNumber;

    public MovieGoer(String emailInput, int ageInput, String nameInput, int mobileInput){
        email = emailInput;
        age = ageInput;
        name = nameInput;
        mobileNumber = mobileInput; 
    }

    public String getEmail(){ return this.email; };

    public int getAge(){return this.age; }

    public String getName() {return this.name;}

    public int getMobile() {return this.mobileNumber;}


}