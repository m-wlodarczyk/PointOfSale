#Manual
The database consists of 50 products. Each products has a name, price and a randomly generated barcode.

There are 3 types of commands: adding a product to a receipt, exiting one shopping action and turning off the Point of Sale system:

 - To add new product User has to type the barcode in the console. For example:
```
2244-4771 //user input
Name: Orange Price: 1.99 
```
 - To finish one shopping user has to type 'exit' command which will sum up the action, print the total value of purchased items on the console and create a receipt file. The receipt file will be created in the project directory with a name that follows a given pattern - "Receipt " + date.
```
exit //user input
Total price: 10.98 
```  
```  
Receipt #1
Mon Apr 30 12:41:54 CEST 2018
Orange 1.99
Mushroom 8.99
Total: 10.98
```  

 - To turn off the Point of Sale system user has to type 'poweroff'
```  
poweroff //user input
Point of Sale system shutdown.
```  



Created by Michał Włodarczyk