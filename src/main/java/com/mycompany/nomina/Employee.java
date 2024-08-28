package com.mycompany.nomina;

public class Employee {    
    
    public double CalcAfp(){
        return Math.round(((this.salary * (2.87 / 100) * 100.0) / 100.0));
    }
    
    public double CalcArs(){
        return Math.round(((this.salary * (3.04 / 100) * 100.0) / 100.0));
    }
    
    public double CalcIsr(){
        if((this.salary > 35000) && (this.salary <= 50000)){
            return Math.round(((this.salary * (5.0 / 100) * 100.0) / 100.0));
        }else if(this.salary > 50000){
            return Math.round(((this.salary * (10.0 / 100) * 100.0) / 100.0));
        }
        return 0;
    }
    
    public double CalcSueldoNeto(){
        return this.salary - (CalcAfp() + CalcArs() + CalcIsr());
    }
    
    public double GetSalary(){
        return this.salary;
    }
    
    public long GetID(){
        return this.ID;
    }
    
    public String GetMaritalStatus(){
        return this.marital_status;
    }
    
    public String GetName(){
        return this.name;
    }
    
    public String GetLastname(){
        return this.lastname;
    }
    
    public void ChangeMaritalStatus(String marital_status){
        this.marital_status = marital_status;
    }
    
    public void ChangeName(String name){
        this.name = name;
    }
    
    public void ChangeLastname(String lastname){
        this.lastname = lastname;
    }
    
    public void ChangeSalary(double salary){
        this.salary = salary; 
    }
    
    public void ChangeCedula(String cedula){
        this.cedula = cedula;
    }
    
    public String GetCedula(){
        return this.cedula;
    }
    
    public Employee(int ID,String name,String lastname,String cedula,double salary, String marital_status, String status){
        this.ID = ID;
        this.salary = salary;
        this.active = status;
        this.marital_status = marital_status;
        this.name = name;
        this.lastname = lastname;
        this.cedula = cedula;
    }
    
    public void ChangeStatus(String active){
        this.active = active;
    }
    
    public String GetStatus(){
        return this.active;
    }
    
    private String name;
    private String lastname;
    private String cedula;
    private int ID; // unchangeble
    private double salary;
    private String active;
    private String marital_status;    
}
