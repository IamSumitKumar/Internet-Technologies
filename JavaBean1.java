/*1: Implement Student JavaBean using Serializability Interface.*/
//!!! Resource @tutorials duniya

package com.tutorialsduniya;
public class Student
{
    public static void main (String args[])
    {
        StudentBean s=new StudentBean();
        s.setName("Abhishek");
        s.setRoll(1027);
        s.setCourse("CS");
        System.out.println(s.getName());
        System.out.println(s.getRoll());
        System.out.println(s.getCourse());
    }
}