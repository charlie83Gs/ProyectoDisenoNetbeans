/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno;

import com.diseno.proyecto1diseno.HibernateORM.HibernateUtil;
import com.diseno.proyecto1diseno.HibernateORM.PersistanceData;

import com.diseno.proyecto1diseno.model.Calification;

import com.diseno.proyecto1diseno.model.AttentionCenter;

import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.Public;
import com.diseno.proyecto1diseno.model.Role;
import com.diseno.proyecto1diseno.model.Schedule;
import com.diseno.proyecto1diseno.model.Service;
import com.diseno.proyecto1diseno.model.ServiceBuilder;
import com.diseno.proyecto1diseno.model.ServiceContract;
import com.diseno.proyecto1diseno.model.Study;
import com.diseno.proyecto1diseno.model.Task;
import controller.LocalSession;
import controller.Payload;
import controller.command.AddCommand;
import controller.command.DeleteCommand;
import controller.command.FindCommand;
import java.io.IOException;
import java.util.ArrayList;

import java.time.Instant;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        testRoles();
        teststudys();
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
            Task taskAdmin = new Task("Admin", "take care of the bussines");
            Task taskAccounting = new Task("Accounting", "");
            Task taskGovernance = new Task("Governance","");
            
            ArrayList<Task> tasks = new ArrayList<>();
            tasks.add(taskAdmin);
            tasks.add(taskAccounting);
            tasks.add(taskGovernance);
            
            
            //add admin
            Payload addAdminPayload = new Payload();
            Payload addAccountingPayload = new Payload();
            Payload addGovernancePayload = new Payload();
            
            addAdminPayload.addContent("object", taskAdmin);
            addAccountingPayload.addContent("object", taskAccounting);
            addGovernancePayload.addContent("object", taskGovernance);
            
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
            

            Employee emp = new Employee("CharlieEmpCm","63387898","carlos@gmail.com", "1234");
            emp.addRole(roleAdmin);
            Payload empPayload = new Payload();
            empPayload.addContent("object", emp);
            
            LocalSession.getInstance().addData("employee", emp);
            
            Client cli = new Client("CharlieCliCm","63387898","carlos@gmail.com", "1234");
            Payload cliPayload = new Payload();
            cliPayload.addContent("object", cli);
            
            //Public pub = new Public("public1", 260, 200);
            
            
            Schedule sch = new Schedule(new Date(), new Date());
            sch.setMonday(true);
            sch.setThursday(true);
            
            //first add parts to db the retrive the m by id
            //to build bigger object
            ServiceBuilder servBuilder = new ServiceBuilder();
            servBuilder.addSchedule(sch);
            //servBuilder.setPublic(pub);
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
            Public childrenPublic = new Public("children",250,200);
            Public babyPublic = new Public("baby",270,160);
            Public elderPublic = new Public("elder",220,130);
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
            Service service = builder.getResult();
            addSservicePayload.addContent("object",service);
            
            
            AddCommand<Service> addService = new AddCommand<>(addSservicePayload);
            addService.execute();
            
            //-*//*/************************/
            
            Employee emp = new Employee("CharlieEmpSrv","63387898","carlos@gmail.com", "1234");
            PersistanceData.<Employee>insert(emp);

            AttentionCenter attcent = new AttentionCenter();
            Payload pAddAttentionCenter = new Payload();
            pAddAttentionCenter.addContent("object", attcent);
            AddCommand<AttentionCenter> addAttentionCenter = new AddCommand<>(pAddAttentionCenter);
            addAttentionCenter.execute();
            
            ServiceContract cont1 = new ServiceContract(service,emp,null,new Date(),new Date(),attcent,4500 );
            Payload pAddServiceContract = new Payload();
            pAddServiceContract.addContent("object", cont1);
            
            AddCommand<ServiceContract> addServiceContract = new AddCommand<>(pAddServiceContract);
            addServiceContract.execute();
            
            //public ServiceContract(Service service, Employee employee, Date dateStart, Date dateEnd) {
            //PersistanceData.<ServiceContract>insert(cont1);
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void testRoles(){
        try {
            Task taskAdmin = new Task("Take care", "Supply basic needs");
            Task taskAccounting = new Task("Prepare food", "cook food for client");
            Task taskGovernance = new Task("Shower","shower the client");
            
            ArrayList<Task> tasks = new ArrayList<>();
            tasks.add(taskAdmin);
            tasks.add(taskAccounting);
            tasks.add(taskGovernance);
            
            
            //add admin
            Payload addAdminPayload = new Payload();
            Payload addAccountingPayload = new Payload();
            Payload addGovernancePayload = new Payload();
            
            addAdminPayload.addContent("object", taskAdmin);
            addAccountingPayload.addContent("object", taskAccounting);
            addGovernancePayload.addContent("object", taskGovernance);
            
            AddCommand<Task> addAdminTask = new AddCommand<>(addAdminPayload);
            AddCommand<Task> addAccountingTask = new AddCommand<>(addAccountingPayload);
            AddCommand<Task> addGovernanceTask = new AddCommand<>(addGovernancePayload);
            
            addAccountingTask.execute();
            addAdminTask.execute();
            addGovernanceTask.execute();
            
            Role roleAdmin = new Role("Cuidador",150, tasks);
            Payload addRolePayload = new Payload();
            addRolePayload.addContent("object", roleAdmin);
            
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void teststudys(){
        try {
            Study eldercare = new Study("Elder care", 300, 120);
            Study childrencare = new Study("Children care", 200, 80);
            Study babycare = new Study("Baby care", 280, 95);
            
            Payload elderPayload = new Payload();
            Payload childrenPayload = new Payload();
            Payload babyPayload = new Payload();
            
            elderPayload.addContent("object", eldercare);
            childrenPayload.addContent("object", childrencare);
            babyPayload.addContent("object", babycare);
            
            AddCommand<Study> addElder = new AddCommand<>(elderPayload);
            AddCommand<Study> addChildren = new AddCommand<>(childrenPayload);
            AddCommand<Study> addBaby = new AddCommand<>(babyPayload);
            
            addElder.execute();
            addChildren.execute();
            addBaby.execute();
            
            //califications
            Calification calf1 = new Calification(3,"decent work");
            Calification calf2 = new Calification(4,"good work");
            Calification calf3 = new Calification(5,"excelent work");
            Payload calf1Payload = new Payload();
            Payload calf2Payload = new Payload();
            Payload calf3Payload = new Payload();
            calf1Payload.addContent("object", calf1);
            calf2Payload.addContent("object", calf2);
            calf3Payload.addContent("object", calf3);
            AddCommand<Calification> calf1Command = new AddCommand<>(calf1Payload);
            AddCommand<Calification> calf2Command = new AddCommand<>(calf2Payload);
            AddCommand<Calification> calf3Command = new AddCommand<>(calf3Payload);
            calf1Command.execute();
            calf2Command.execute();
            calf3Command.execute();
            
            
            Employee empElder = new Employee("ElderEmp","63387898","carlos@gmail.com", "1234");
            Employee empchildren = new Employee("ChildrenEmp","63387898","carlos@gmail.com", "1234");
            Employee empBaby = new Employee("BabyEmp","63387898","carlos@gmail.com", "1234");
            
            empElder.addStudy(eldercare);
            empchildren.addStudy(childrencare);
            empBaby.addStudy(babycare);
            empElder.addStudy(babycare);
            
            empElder.addCalification(calf3);
            empElder.addCalification(calf2);
            empBaby.addCalification(calf1);
            
            Payload empPayload = new Payload();
            empPayload.addContent("object", empElder);
            Payload emp2Payload = new Payload();
            emp2Payload.addContent("object", empchildren);
            Payload emp3Payload = new Payload();
            emp3Payload.addContent("object", empBaby);
            
            AddCommand<Employee> addEmpCommand= new AddCommand<>(empPayload);
            AddCommand<Employee> addEmp2Command= new AddCommand<>(emp2Payload);
            AddCommand<Employee> addEmp3Command= new AddCommand<>(emp3Payload);
            
            addEmpCommand.execute();
            addEmp2Command.execute();
            //addEmp3Command.execute();
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    

}
