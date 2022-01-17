package com.ds.string;

class Employee implements Cloneable {

    public int getEmpoyeeId() {
        return empoyeeId;
    }

    public void setEmpoyeeId(int empoyeeId) {
        this.empoyeeId = empoyeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int empoyeeId;
    private String employeeName;
    private Department department;

    public Employee(int id, String name, Department dept) {
        this.empoyeeId = id;
        this.employeeName = name;
        this.department = dept;
    }
    //shallow copy
   /* @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.setDepartment((Department) cloned.getDepartment().clone());
        return cloned;
    }
}

class Department implements Cloneable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Defined clone method in Department class for Deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TrialWithClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Department dept = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", dept);

        //Lets create a clone of original object
        Employee cloned = (Employee) original.clone();

        //Let verify using employee id, if cloning actually workded
        System.out.println(cloned.getEmpoyeeId());

        //Verify JDK's rules

        //Must be true and objects must have different memory addresses
        System.out.println(original != cloned);

        //As we are returning same class; so it should be true
        System.out.println(original.getClass() == cloned.getClass());

        //Default equals method checks for references so it should be false. If we want to make it true,
        //then we need to override equals method in Employee class.
        System.out.println(original.equals(cloned));

        /*Output:
        1
        true
        true
        false*/


        cloned.getDepartment().setName("Finance");

        System.out.println(original.getDepartment().getName());
        System.out.println(cloned.getDepartment().getName());

        //So deep cloning requires satisfaction of following rules –

        //No need to separately copy primitives.
        //All the member classes in original class should support cloning and in clone method of original class in context should call super.clone() on all member classes.
        //If any member class does not support cloning then in clone method, one must create a new instance of that member class and copy all its attributes one by one to new member class object. This new member class object will be set in cloned object.
    }
}
