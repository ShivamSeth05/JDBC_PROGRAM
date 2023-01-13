# JDBC_PROGRAM
<hr>

##  1.Demo program<br>

##  2.Book Details(JDBC)<br>
Create table with name Customer50 <br>
(custId , custName, custCity, CustMailid, custNo)<br>
Primary Key(custId)

##  3.Book Details 50(JDBC)<br>
Create table with name Customer50 <br>
(custId , custName, custCity, CustMailid, custNo)<br>
Primary Key(custId)
Construct JDBC application to perform the following operations on
BookDetails50 based on user choice:

 1.AddBookDetails<br>
 2.ViewAllBookDetails<br>
 3.ViewBookByCode<br>
 4.UpdateBookDetails(price/qty)<br>
 5.DeleteBookByCode
 
 ##  4.Employee50(id,name,desg,bsal,totSal)(JDBC)<br>
 Construct JDBC Application to perform the following operations<br>
 1.AddEmployee<br>
 2.ViewAllEmployees<br>
 3.ViewEmployeeById<br>
 4.UpdateEmployee(bSal)<br>
 5.DeleteEmployee<br>
totSal = bSal+HRA+DA;<br>
HRA = 93% of bSal<br>
DA = 61% of bSal

##  5.Student50(rollNo,name,branch,totmarks,per,grade)

DB Table : Student50(rollNo,name,branch,totmarks,per,grade)

SQL> create table Student50(<br>
  2  rollNo number(15),<br>
  3  name varchar2(20),<br>
  4  branch varchar(20),<br>
  5  totmarks number(3),<br>
  6  per number(3,2),<br>
  7  grade varchar2(20));<br>

Construct JDBC Application to perform the following operations:<br>
1.AddStudent<br>
2.ViewAllStudents<br>
3.ViewStudentByRollNo<br>
4.UpdateStudent(totMarks)<br>
5.DeleteStudent<br>

totMarks = s1+...+s6<br>
per=<br>
grade=

##  6. (dbconProcedureIN_OUT) Constructing and executing Procedure:
### -> DBConnProcedure_IN(class)
#### step-1 : create the following DB tables
BankCustomer50(accno,custid,custname,balance,acctype)
CustomerAddress50(accno,hno,snane,city,state,pincode)
CustomerContact50(accno,mailid,phoneno)

create table BankCustomer50(accno number(15),custid number(10),
custname varchar2(15),balance number(10,2),acctype varchar2(15),
primary key(accno));

create table CustomerAddress50(accno number(15),hno varchar2(15),
sname varchar2(15),city varchar2(15),state varchar2(15),
pincode number(10),primary key(accno));

create table CustomerContact50(accno number(15),mailid varchar2(25),

phoneno number(15),primary key(accno));

#### step-2 : Construct Procedure to insert data to Database tables

create or replace procedure Register50
(ano number,cid number,cname varchar2,bal number,actype varchar2,
hn varchar2,sn varchar2,cty varchar2,st varchar2,pcode number,
mid varchar2,pno number) is
begin
insert into BankCustomer50 values(ano,cid,cname,bal,actype);
insert into CustomerAddress50 values(ano,hn,sn,cty,st,pcode);
insert into CustomerContact50 values(ano,mid,pno);
end;
/

#### step-3 : Contruct JDBC application to execute Procedure with IN parameters

### -> DBConnProcedure_IN(Class)

#### step-1 : Construct OUT-Parameter Procedures to display deatils
 of Customer based on accNo
 
 create or replace procedure Retrieve50
(ano number,cid OUT number,cname OUT varchar2,bal OUT number,
actype OUT varchar2,hn OUT varchar2,sn OUT varchar2,
cty OUT varchar2,st OUT varchar2,pcode OUT number,
mid OUT varchar2,pno OUT number) is
begin
 select custid,custname,balance,acctype into cid,cname,bal,actype
 from BankCustomer50 where accno=ano;
 select hno,sname,city,state,pincode into hn,sn,cty,st,pcode
 from CustomerAddress50 where accno=ano;
 select mailid,phoneno into mid,pno
 from CustomerContact50 where accno=ano;
end;
 
 #### step 2 : Constructing JDBC application to execute OUT-Parameter
 Procedure

