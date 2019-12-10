package com.cidenet.hulkstore.users;

import java.io.Serializable;

/**
 * This class represents the user model.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-19
 */
public final class UsersDto implements Serializable
{
    /** 
     * This attribute maps to the column userId in the users table.
     */
    protected int userId;

    /** 
     * This attribute maps to the column userName in the users table.
     */
    protected String userName;

    /** 
     * This attribute maps to the column userPass in the users table.
     */
    protected String userPass;

    /** 
     * This attribute maps to the column identification in the users table.
     */
    protected String identification;

    /** 
     * This attribute maps to the column realName in the users table.
     */
    protected String realName;

    /** 
     * This attribute maps to the column surname in the users table.
     */
    protected String surname;

    /** 
     * This attribute maps to the column userProfile in the users table.
     */
    protected short userProfile;

    /** 
     * This attribute maps to the column state in the users table.
     */
    protected short state;

    /**
     * Empty Constructor.     * 
     */
    public UsersDto() {}
    
    /**
     * Constructor.
     * 
     * @param userId
     * @param userName
     * @param identification
     * @param realName
     * @param surname
     * @param userProfile
     * @param state 
     */    
    public UsersDto(int userId, String userName, String identification, String realName, String surname, short userProfile, short state)
    {
        this.userId = userId;
        this.userName = userName;
        this.identification = identification;
        this.realName = realName;
        this.surname = surname;
        this.userProfile = userProfile;
        this.state = state;
    }

    /**
     * Gets the value of userId.
     * 
     * @return int
     */
    public int getUserId() { return userId; }

    /**
     * Sets the value of userId.
     * 
     * @param userId
     */
    public void setUserId(int userId) { this.userId = userId; }

    /**
     * Gets the value of userName.
     * 
     * @return String
     */
    public String getUserName() { return userName; }

    /**
     * Sets the value of userName.
     * 
     * @param userName
     */
    public void setUserName(String userName) { this.userName = userName; }

    /**
     * Gets the value of userPass.
     * 
     * @return String
     */
    public String getUserPass() { return userPass; }

    /**
     * Sets the value of userPass.
     * 
     * @param userPass
     */
    public void setUserPass(String userPass) { this.userPass = userPass; }

    /**
     * Gets the value of identification.
     * 
     * @return String
     */
    public String getIdentification() { return identification; }

    /**
     * Sets the value of identification.
     * 
     * @param identification
     */
    public void setIdentification(String identification) { this.identification = identification; }

    /**
     * Gets the value of realName.
     * 
     * @return String
     */
    public String getRealName() { return realName; }

    /**
     * Sets the value of realName.
     * 
     * @param realName
     */
    public void setRealName(String realName) { this.realName = realName; }

    /**
     * Gets the value of surname.
     * 
     * @return String
     */
    public String getSurname() { return surname; }

    /**
     * Sets the value of surname.
     * 
     * @param surname
     */
    public void setSurname(String surname) { this.surname = surname; }

    /**
     * Gets the value of userProfile.
     * 
     * @return short
     */
    public short getUserProfile() { return userProfile; }

    /**
     * Sets the value of userProfile.
     * 
     * @param userProfile
     */
    public void setUserProfile(short userProfile) { this.userProfile = userProfile; }

    /**
     * Gets the value of state.
     * 
     * @return short
     */
    public short getState() { return state; }

    /**
     * Sets the value of state.
     * 
     * @param state
     */
    public void setState(short state) { this.state = state; }

    /**
     * Method 'createPk'
     * 
     * @return UsersPk
     */
    public UsersPk createPk() { return new UsersPk(userId); }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder response = new StringBuilder();
        response.append("com.cidenet.hulkstore.dto.Users: ");
        response.append("userId=").append(userId);
        response.append(", userName=").append(userName);
        response.append(", userPass=").append(userPass);
        response.append(", identification=").append(identification);
        response.append(", realName=").append(realName);
        response.append(", surname=").append(surname);
        response.append(", userProfile=").append(userProfile);
        response.append(", state=").append(state);
        return response.toString();
    }
}