package com.javatpoint.beans;

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Boolean isDeleted;
    private String subject;
    
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getGender() {
    	return gender;
    }
    public void setGender(String gender) {
    	this.gender = gender;
    }
    public String getSubject () {
    	return subject;
    }
    public void setSubject (String subject) {
    	this.subject = subject;
    }
    public Boolean getIsDeleted() {
    	return isDeleted;
    }
    public void setIsDeleted (Boolean isDeleted) {
    	this.isDeleted = isDeleted;
    }
    
    
}
