package com.mycompany.nomina;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
    
    Employee instance = null;
    public EmployeeTest() {
            instance = new Employee(123456,"Prueba", "Prueba", "023012021",25000,"Casado","ACTIVO");
    }
    
    @Test
    public void testCalcAfp() {
        System.out.println("CalcAfp");
        double expResult = 718.0;
        double result = instance.CalcAfp();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCalcArs() {
        System.out.println("CalcArs");
        double expResult = 760.0;
        double result = instance.CalcArs();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCalcIsr() {
        System.out.println("CalcIsr");
        double expResult = 0.0;
        double result = instance.CalcIsr();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCalcSueldoNeto() {
        System.out.println("CalcSueldoNeto");
        double expResult = 23522.0;
        double result = instance.CalcSueldoNeto();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetSalary() {
        System.out.println("GetSalary");
        double expResult = 25000.0;
        double result = instance.GetSalary();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetID() {
        System.out.println("GetID");
        long expResult = 123456;
        long result = instance.GetID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaritalStatus() {
        System.out.println("GetMaritalStatus");
        String expResult = "Casado";
        String result = instance.GetMaritalStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName() {
        System.out.println("GetName");
        String expResult = "Prueba";
        String result = instance.GetName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLastname() {
        System.out.println("GetLastname");
        String expResult = "Prueba";
        String result = instance.GetLastname();
        assertEquals(expResult, result);
    }

    @Test
    public void testChangeMaritalStatus() {
        System.out.println("ChangeMaritalStatus");
        String marital_status = "Soltero";
        instance.ChangeMaritalStatus(marital_status);
        String expResult = "Soltero";
        String result = instance.GetMaritalStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testChangeName() {
        System.out.println("ChangeName");
        String name = "";
        instance.ChangeName(name);
        String expResult = "";
        String result = instance.GetName();
        assertEquals(expResult, result);
    }

    @Test
    public void testChangeLastname() {
        System.out.println("ChangeLastname");
        String lastname = "";
        instance.ChangeLastname(lastname);
        String expResult = "";
        String result = instance.GetLastname();
        assertEquals(expResult, result);
    }

    @Test
    public void testChangeSalary() {
        System.out.println("ChangeSalary");
        double salary = 0.0;
        instance.ChangeSalary(salary);
        double expResult = 0.0;
        double result = instance.GetSalary();
        assertEquals(expResult, result, 0.0);
        
        double expAFP = 0.0;
        double reAFP = instance.CalcAfp();
        assertEquals(expAFP, reAFP, 0.0);
        
        double expARS = 0.0;
        double reARS = instance.CalcArs();
        assertEquals(reARS, expARS, 0.0);
        
        double expISR = 0.0;
        double reISR = instance.CalcIsr();
        assertEquals(expISR, reISR, 0.0);
        
        double expSueldoNeto = 0.0;
        double reSueldoNeto = instance.CalcSueldoNeto();
        assertEquals(reSueldoNeto, expSueldoNeto, 0.0);
        
        instance.ChangeSalary(50000);
        
        expAFP = 1435.0;
        reAFP = instance.CalcAfp();
        assertEquals(expAFP, reAFP, 0.0);
        
        expARS = 1520.0;
        reARS = instance.CalcArs();
        assertEquals(reARS, expARS, 0.0);
        
        expISR = 2500.0;
        reISR = instance.CalcIsr();
        assertEquals(expISR, reISR, 0.0);
        
        expSueldoNeto = 44545.0;
        reSueldoNeto = instance.CalcSueldoNeto();
        assertEquals(reSueldoNeto, expSueldoNeto, 0.0);
    }

    @Test
    public void testGetCedula() {
        System.out.println("GetCedula");
        String expResult = "023012021";
        String result = instance.GetCedula();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeCedula() {
        System.out.println("ChangeCedula");
        String cedula = "123456789";
        instance.ChangeCedula(cedula);
        String expResult = "123456789";
        String result = instance.GetCedula();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStatus() {
        System.out.println("GetStatus");
        String expResult = "ACTIVO";
        String result = instance.GetStatus();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeStatus() {
        System.out.println("ChangeStatus");
        String active = "INACTIVO";
        instance.ChangeStatus(active);
        String expResult = "INACTIVO";
        String result = instance.GetStatus();
        assertEquals(expResult, result);
    }
    
}
