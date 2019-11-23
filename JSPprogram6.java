/*6.2: Create your custom library which contains two tags: <hello>, <choco>.
Usage of the tags:
<hello name=”Ajay”>: Output should be Hello Ajay. It contains a mandatory attribute ‘name’ which can accept Dynamic value.
<choco texture=”Chewy”>: Output should be FiveStar, BarOne.
<choco texture=”Crunchy”>: Output should be Munch. KitKat.
That means the mandatory attribute must accept a value, and based on the attributes value, it should give output. You must use a bean ChocoBean for this purpose.*/
//!!! Resource @tutorials duniya

package com.tutorialsduniya;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;

public class Program6 extends SimpleTagSupport
{
    String name;
    public void setName(String name)
    {
        this.name=name;
    }
    public void doTag() throws IOException
    {
        JspWriter out = getJspContext().getOut();
        out.println("Hello "+ name);
    }
}
