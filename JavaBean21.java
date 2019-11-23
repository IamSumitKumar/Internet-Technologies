/*2.1: Implement Employee JavaBean using Serializability Interface.*/
//!!! Resource @tutorials duniya

public class EmployeeBean
{
    String name;
    int id;
    String dept;
    EmployeeBean(){}
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public String getDept()
    {
    return dept;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDept(String dept)
    {
        this.dept=dept;
    }
    public void setId(int id)
    {
        this.id=id;
    }
}
