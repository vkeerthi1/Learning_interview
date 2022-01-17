 
package com.ds.string;

import java.io.*;

class Employeee implements Serializable {

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

    public Departmente getDepartment() {
        return department;
    }

    public void setDepartment(Departmente department) {
        this.department = department;
    }

    public int empoyeeId;
    private String employeeName;
    private Departmente department;

    public Employeee(int id, String name, Departmente dept) {
        this.empoyeeId = id;
        this.employeeName = name;
        this.department = dept;
    }

}

class Departmente implements Serializable {
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

    public Departmente(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

public class TrialCloneWithSeralization{
    public static void main(String[] args) {
        try {
            Departmente dept = new Departmente(1, "Human Resource");
            Employeee original = new Employeee(1, "Admin", dept);

            //Lets create a clone of original object
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(bo);
            o.writeObject(original);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream i = new ObjectInputStream(bi);

            Employeee clonedDes = (Employeee) i.readObject();
            clonedDes.getDepartment().setName("TEST CLONE");
            System.out.println("--" + original.getDepartment().getName());
            System.out.println("--" + clonedDes.getDepartment().getName());

        } catch (Exception e) {
            System.out.println("--" + e);
        }


    }
}
