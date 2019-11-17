## ERP System Of Medical Equipment Factory
The system includes 2 main modules HR and Inventory module.<br/>
Hr module which includes the workers of the factory.<br/>
Inventory module which includes raw material store and products store .<br/>
## User permissions are divided into <br/>
1-System Admin <br/>
2-HR Admin <br/>
3-Raw Material Store Admin <br/>
4-Products Store Admin <br/> 
### 1- System Admin who has permissions to : <br/>
a- search about any raw material/product. <br/>
b- export raw material/products table ,reports of consumed quantities and added quantities to excel sheet. <br/>
c- approve or cancel (delete) new material/products requests from waiting list . <br/>
d- approve or cancel (delete) consumed quantity requests from consumed quantity list . <br/>
e- approve or cancel (delete) add quantity requests from add quantity list . <br/>
f- update any raw material/product . <br/>
g- delete any raw material/product . <br/>
h- has the same permissions like HR Admin (HR module). <br/>
### 2- HR Admin who has permissions to :  <br/>
a- search about any worker . <br/>
b- add new worker. <br/>
c- edit workers data. <br/>   
### 3- Raw Material/Products Store Admin who has permissions to : <br/>  
a- search about any raw material/product. <br/>
b- export raw material/products table to excel sheet. <br/>
c- add new raw material/product (which will be added to the waiting list that need the approval of the admin). <br/>
d- can add/consume quantity requests to(from) raw material/products (which also need the approval of the admin). <br/>
e- have no permissions to delete or update any raw material/product .<br/>

The System Admin,Raw Material Store Admin and Products Store Admin can search about any raw material/products by 2 main options
the name (metal plates - skewer - Metal nail - chair , bed - ... ) and the type(Iron - Stainless - Aluminum - Plastic products - glass - ....)
the Admin can use the advanced option to add any attribute of the raw material/products to search with (price ,date , supplier ,code, .... ).
the Admin can add new raw material/product with all details (the name,the type,the dimensions the,code,the critical limit,quantity,supplier,bill number,price and image)
the Admin can click on the name of raw material /product then new page will display all details of the chosen raw material/product.
then, he could make consumed quantity request or add request (have validation of consumed quantity request that he can't break the critical limit).
<br/>
The System Amin has all the permissions that we mentioned earlier.
when he needs to make some raw material/products invisible to Raw Material Store Admin or Products Store Admin, he can update it (use edit button) and chose between visible or waiting (Radio Button).
visible raw material can be accessed by store admin (search , consume quantity , add quantity)
waiting raw material/product (will be added to waiting list ) visible only to System Admin .
when System Admin adds any raw material/product to waiting list, all consumed quantity requests and add requests of the updated raw material/product will be automatically deleted , but the reports will remain .
but if he deletes the raw material/product from the waiting list. then, the reports (con or add ) will be automatically deleted .
if he deletes any raw material then , all requests (consumed/add) and reports (consumed/add) will be automatically deleted .
<br/>
### Technologies :
Application Development Framework (ADF)<br/>
Java SE <br/>
Java EE <br/>
Oracle Database <br/>
ADF BCs <br/>
JDBC <br/>
ADF Faces <br/>
<br/>
### Tools :
Oracle JDeveloper 12c <br/>
Weblogic Server <br/>
Oracle 10g Database <br/>
Toad <br/>
Visual Paradigm <br/>
