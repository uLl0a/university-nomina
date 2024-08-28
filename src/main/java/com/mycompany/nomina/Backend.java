package com.mycompany.nomina;
import java.sql.*;
import java.util.*;

public class Backend {
    private static int GenerateID(){
        int x =  new Random().nextInt(900000) + 100000;
        
        if(employee.containsKey(x)){
            GenerateID();
        }
        
        return x;
    }
    
    public static void AddEmployee(Connection conn,String name,String lastname,String cedula, float salary, String marital_status, String status) throws SQLException{
        int id = GenerateID();
        employee.put(id, new Employee(id,name, lastname,cedula, salary, marital_status,status));
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Employees VALUES (?,?,?,?,?,?,?)");
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, lastname);
        pstmt.setString(4, cedula);
        pstmt.setFloat(5, salary);
        pstmt.setString(6, marital_status);
        pstmt.setString(7, status);
        pstmt.executeUpdate();
    }

    public static void EditEmployee(Connection conn, int ID,String name, String lastname,String cedula,float salary, String marital_status, String status) throws SQLException{
        employee.get(ID).ChangeName(name);
        employee.get(ID).ChangeLastname(lastname);
        employee.get(ID).ChangeSalary(salary);
        employee.get(ID).ChangeMaritalStatus(marital_status);
        employee.get(ID).ChangeCedula(cedula);
        employee.get(ID).ChangeStatus(status);
        PreparedStatement pstmt = conn.prepareStatement("UPDATE Employees SET name=?, lastname=?,cedula=?,salary=?,marital_status=?,status=? WHERE ID = ?");
        pstmt.setString(1, name);
        pstmt.setString(2, lastname);
        pstmt.setString(3, cedula);
        pstmt.setFloat(4, salary);
        pstmt.setString(5, marital_status);
        pstmt.setString(6, status);
        pstmt.setInt(7, ID);
        pstmt.executeUpdate();
    }
    
    public static Employee GetEmployee(int ID){
        return employee.get(ID);
    }
    
    public static Hashtable GetEmployeeList(){
        return employee;
    }
    
    public static Backend GetInstance() {
        if (instance == null) {
            instance = new Backend();
        }
        return instance;
    }
    
    private Backend() {

    }

    public static void GetDatabaseInfo(Connection conn) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");
        while(rs.next()){
            employee.put(rs.getInt("ID"), 
                    new Employee(rs.getInt("ID"),
                        rs.getString("name"), 
                            rs.getString("lastname"),
                            rs.getString("cedula"), 
                            rs.getFloat("salary"),
                            rs.getString("marital_status"),
                            rs.getString("status")));
        }
        rs.close();
    }
    
    private static Backend instance = null;
    private static Hashtable<Integer,Employee> employee = new Hashtable<Integer,Employee>();
}
