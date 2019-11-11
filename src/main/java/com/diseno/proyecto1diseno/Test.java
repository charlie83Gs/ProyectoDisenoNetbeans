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
import com.diseno.proyecto1diseno.model.Role;
import com.diseno.proyecto1diseno.model.Schedule;
import com.diseno.proyecto1diseno.model.Service;
import com.diseno.proyecto1diseno.model.ServiceBuilder;
import com.diseno.proyecto1diseno.model.Study;
import com.diseno.proyecto1diseno.model.Task;
import controller.Payload;
import controller.command.AddCommand;
import controller.command.DeleteCommand;
import controller.command.FindCommand;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlie
 */
public class Test {
    
    
    public static void fullTest(){
        
        testClientCrud();
        testEmployeeCrud();
        testAddCommands();
        testDeleteCommand();
        testAddService();
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
        
        try {
            /*Task taskAdmin = new Task("Admin", "take care of the bussines");
            Task taskAccounting = new Task("Accounting", "");
            Task taskGovernance = new Task("Governance","");
            
            Task[] tasks = {taskAdmin, taskAccounting, taskGovernance};
                    
            //add admin
            Payload addAdminPayload = new Payload();
            Payload addAccountingPayload = new Payload();
            Payload addGovernancePayload = new Payload();
            
            addAdminPayload.addContent("object", taskAdmin);
            addAccountingPayload.addContent("object", taskAccounting);
            addGovernancePayload.addContent("object", taskAccounting);
            
            AddCommand<Task> addAdminTask = new AddCommand<>(addAdminPayload);
            AddCommand<Task> addAccountingTask = new AddCommand<>(addAccountingPayload);
            AddCommand<Task> addGovernanceTask = new AddCommand<>(addGovernancePayload);
            
            addAccountingTask.execute();
            addAdminTask.execute();
            addGovernanceTask.execute();
            
            Role roleAdmin = new Role("Adimin",200, tasks);
            Payload addRolePayload = new Payload();
            addRolePayload.addContent("object", roleAdmin);
            
            AddCommand<Role> addRole = new AddCommand<>(addRolePayload);
            
            addRole.execute();
            */

            Employee emp = new Employee("CharlieEmpCm","63387898","carlos@gmail.com", "1234");
            //emp.addRole(roleAdmin);
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
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //asumes add command is working
    public static void testDeleteCommand(){
        try {
            Employee emp = new Employee("DeleteEmp","63387898","carlos@gmail.com", "1234");
            
            //data required to create employee
            Payload empPayload = new Payload();
            empPayload.addContent("object", emp);
            
            //data required to find employee
            Payload findPayload = new Payload();
            findPayload.addContent("param", "name");
            findPayload.addContent("value", "DeleteEmp");
            findPayload.addContent("class", Employee.class);
            
            
            
            AddCommand<Employee> addEmpCommand= new AddCommand<>(empPayload);
            addEmpCommand.execute();
            
            FindCommand<Employee> findEmpcommand = new FindCommand<>(findPayload);
            Employee empResult = findEmpcommand.execute();
            
            //data required to delete employee
            Payload deletePayload = new Payload();
            deletePayload.addContent("id", empResult.getId());
            deletePayload.addContent("class", Employee.class);
            
            DeleteCommand<Employee> deleteCommand = new DeleteCommand<>(deletePayload);
            deleteCommand.execute();
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void testAddService(){
        try {
            Public childrenPublic = new Public("children");
            Public babyPublic = new Public("baby");
            Public elderPublic = new Public("elder");
            Payload pAddChildren = new Payload();
            Payload pAddBaby = new Payload();
            Payload pAddElder = new Payload();
            pAddChildren.addContent("object", childrenPublic);
            pAddBaby.addContent("object", babyPublic);
            pAddElder.addContent("object", elderPublic);
            
            AddCommand<Public> addChildrenCommand= new AddCommand<>(pAddChildren);
            AddCommand<Public> addBabyCommand= new AddCommand<>(pAddBaby);
            AddCommand<Public> addElderCommand= new AddCommand<>(pAddElder);
            
            addChildrenCommand.execute();
            addBabyCommand.execute();
            addElderCommand.execute();
            
            
            Schedule schedule = new Schedule(new Date(), new Date());
            schedule.setMonday(true);
            schedule.setFriday(true);
            Payload addSchedulePayload = new Payload();
            addSchedulePayload.addContent("object", schedule);
            
            AddCommand<Schedule> addScheduleCommand = new AddCommand<>(addSchedulePayload);
            addScheduleCommand.execute();
           
            
            
            ServiceBuilder builder = new ServiceBuilder();
            builder.setPublic(childrenPublic);
            builder.addSchedule(schedule);
            builder.setName("Children Service v1");
            
            Payload addSservicePayload = new Payload();
            addSservicePayload.addContent("object",builder.getResult());
            
            
            AddCommand<Service> addService = new AddCommand<>(addSservicePayload);
            addService.execute();
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
