/*4.1: Display Good Morning <uname>, Good Afternoon <uname> or Good Evening <uname>
based on the current time of the day.*/
//!!! Resource @tutorials duniya

package com.tutorialsduniya;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;

public class pro4 extends SimpleTagSupport 
{
    String name1;
	public void setName1(String name1)
	{
        this.name1 = name1;
    }

	int hr, min, sec;

	public void doTag() throws JspException, IOException 
    {
		JspWriter out = getJspContext().getOut();
        out.print("Time : ");
        hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        min = Calendar.getInstance().get(Calendar.MINUTE);
        sec = Calendar.getInstance().get(Calendar.SECOND);
        out.print(hr+"hr-");
        out.print(min+"min-");
        out.print(sec+"sec<br>");
	
		if(hr>=5 && hr<= 11 )
        {
            out.println(name1+"Good Morning ");
        }
        else if(hr>=12 && hr<= 4)
        {
            out.println(name1+"Good Afternoon ");
        }
        else
        {
            out.println(name1+" Good Evening ");
        }
    }
}