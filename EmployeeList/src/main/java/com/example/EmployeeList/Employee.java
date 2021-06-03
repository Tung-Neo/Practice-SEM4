package com.example.EmployeeList;

public class Employee {
    private int ID;
    private String FullName;
    private String Birthday;
    private String Address;
    private String Position;
    private String Department;

    public Employee(String FullName, String Birthday, String Address, String Position, String Department) {
        this.FullName = FullName;
        this.Birthday = Birthday;
        this.Address = Address;
        this.Position = Position;
        this.Department = Department;
    }

    public Employee(int ID, String FullName, String Birthday, String Address, String Position, String Department) {
        this.ID = ID;
        this.FullName = FullName;
        this.Birthday = Birthday;
        this.Address = Address;
        this.Position = Position;
        this.Department = Department;
    }


    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

}
