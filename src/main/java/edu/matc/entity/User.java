package edu.matc.entity;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private String birthDate;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param birthDate the birthDate
     */
    public User(String firstName, String lastName, String userid, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.birthDate = birthDate;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int calculateAge(){
        int birthYear = Integer.parseInt(birthDate.substring(0,4));
        int birthDay = Integer.parseInt(birthDate.substring(5,7));
        int birthMonth = Integer.parseInt(birthDate.substring(8,10));

        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        java.util.Date date = new java.util.Date();
        int yearNow = Integer.parseInt(dateFormat.format(date));

        dateFormat = new SimpleDateFormat("MM");
        date = new java.util.Date();
        int monthNow = Integer.parseInt(dateFormat.format(date));

        dateFormat = new SimpleDateFormat("DD");
        date = new java.util.Date();
        int dayNow = Integer.parseInt(dateFormat.format(date));

        int age = yearNow - birthYear;

        if(monthNow < birthMonth){
            age = age - 1;
        }

        if(monthNow == birthMonth && dayNow < birthDay){
            age = age - 1;
        }

        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }


}