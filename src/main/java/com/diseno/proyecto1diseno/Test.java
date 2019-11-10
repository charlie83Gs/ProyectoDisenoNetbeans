/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno;

import com.diseno.proyecto1diseno.HibernateORM.HibernateUtil;
import com.diseno.proyecto1diseno.HibernateORM.PersistanceData;
import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Public;
import com.diseno.proyecto1diseno.model.Schedule;
import com.diseno.proyecto1diseno.model.Service;
import com.diseno.proyecto1diseno.model.ServiceBuilder;
import com.diseno.proyecto1diseno.model.Study;
import controller.Payload;
import controller.command.AddCommand;
import java.util.Date;

/**
 *
 * @author Charlie
 */
public class Test {
    
    
    public static void fullTest(){
        
        testClientCrud();
        testEmployeeCrud();
        testAddCommands();
    }
    
    public static void testEmployeeCrud(){
        HibernateUtil.getSessionFactory().getCurrentSession();
        Employee emp = new Employee("CharlieEmp","63387898","carlos@gmail.com", "1234");
        Employee emp2 = new Employee("BryanEmp","22222222","malabaryan@gmail.com", "1234");
        Employee emp3 = new Employee("EvelioEmp","33333333","evelio@gmail.com", "1234");
        Employee emp4 = new Employee("KennethEmp","44444444","kennetg@gmail.com", "4321");
        
        PersistanceData.<Employee>insert(emp);
        PersistanceData.<Employee>insert(emp2);
        PersistanceData.<Employee>insert(emp3);
        PersistanceData.<Employee>insert(emp4);
        
        System.out.println("employee --> valid " + (PersistanceData.validateLoginEmp("CharlieEmp", "1234") != null));
        System.out.println("employee --> valid " + (PersistanceData.validateLoginEmp("KennethEmp", "4321") != null));
        System.out.println("employee --> invalid " + (PersistanceData.validateLoginEmp("CharlieEmp", "1334") != null));
        System.out.println("employee --> invalid " + (PersistanceData.validateLoginEmp("KennethEmp", "43210") != null)); 
        
    }
    
    public static void testClientCrud(){
        Client cli = new Client("CharlieCli","63387898","carlos@gmail.com", "1234");
        Client cli2 = new Client("BryanCli","22222222","malabaryan@gmail.com", "1234");
        Client cli3 = new Client("EvelioCli","33333333","evelio@gmail.com", "1234");
        Client cli4 = new Client("KennethCli","44444444","kennetg@gmail.com", "4321");
        
        PersistanceData.<Client>insert(cli);
        PersistanceData.<Client>insert(cli2);
        PersistanceData.<Client>insert(cli3);
        PersistanceData.<Client>insert(cli4);
        
        System.out.println("client --> valid " + (PersistanceData.validateLoginCli("CharlieCli", "1234") != null));
        System.out.println("client --> valid " + (PersistanceData.validateLoginCli("KennethCli", "4321") != null));
        System.out.println("client --> invalid " + (PersistanceData.validateLoginCli("CharlieCli", "1334") != null));
        System.out.println("client --> invalid " + (PersistanceData.validateLoginCli("KennethCli", "43210") != null)); 
        
        //HibernateUtil.getSessionFactory();
    }
    
    public static void testAddCommands(){
        
        Employee emp = new Employee("CharlieEmpCm","63387898","carlos@gmail.com", "1234");
        Payload empPayload = new Payload();
        empPayload.addContent("object", emp);
        
        Client cli = new Client("CharlieCliCm","63387898","carlos@gmail.com", "1234");
        Payload cliPayload = new Payload();
        cliPayload.addContent("object", cli);
        
        Public pub = new Public("public1");
        Schedule sch = new Schedule(new Date(), new Date());
        sch.setMonday(true);
        sch.setThursday(true);
        
        //first add parts to db the retrive the m by id 
        //to build bigger object
        ServiceBuilder servBuilder = new ServiceBuilder();
        servBuilder.addSchedule(sch);
        servBuilder.setPublic(pub);
        Payload servPayload = new Payload();
        servPayload.addContent("object", servBuilder.getResult());
        
        Study study = new Study("Educacion Geriatrica", 100,80);
        Payload stdPayload = new Payload();
        stdPayload.addContent("object", study);
        
        AddCommand<Employee> addEmpCommand= new AddCommand<>(empPayload);
        AddCommand<Client> addClientCommand = new AddCommand<>(cliPayload);
        AddCommand<Service> addSrvCommand = new AddCommand<>(servPayload);
        AddCommand<Study> addStdCommand = new AddCommand<>(stdPayload);
        
        addEmpCommand.execute();
        addClientCommand.execute();
        //addSrvCommand.execute();
        addStdCommand.execute();
        
     }
}
