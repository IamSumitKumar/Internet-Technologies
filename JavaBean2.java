/*2: Implement Employee JavaBean using Serializability Interface.*/
//!!! Resource @tutorials duniya

package com.tutorialsduniya;
public class Employee
{
    public static void main (String args[])
    {
        EmployeeBean s=new EmployeeBean();
        s.setName("ankurkeshav");
        s.setId(7);
        s.setDept("CS");
        System.out.println(s.getName());
        System.out.println(s.getId());
        System.out.println(s.getDept());
    }
}