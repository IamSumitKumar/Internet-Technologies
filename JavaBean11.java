/*1.1: Implement Student JavaBean using Serializability Interface.*/
//!!! Resource @tutorials duniya

package com.tutorialsduniya;
public class StudentBean implements java.io.Serializable
{
    String name;
    int roll;
    String course;
    StudentBean(){}
    public String getName()
    {
        return name;
    }
    public int getRoll()
    {
        return roll;
    }
    public String getCourse()
    {
	    return course;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setCourse(String course)
    {
        this.course=course;
    }
    public void setRoll(int roll)
    {
        this.roll=roll;
    }
}
