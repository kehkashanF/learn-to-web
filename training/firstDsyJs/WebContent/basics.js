////////////////////////////////////TYPES OF POP UP BOXES////////////////////////////////
//alert("new DAY!!");
//var ch= confirm("Sure you want to continue?"); //OK returns true <--1; Cancel returns false which gets converted to 0
//if(ch===1){
////alert(prompt("Enter first number"));//if you hit cancel null is returned
//var n1=parseInt(prompt("Enter first number"));
//var n2=	parseInt(prompt("Enter second number"));
//alert(n1+n2);
//alert(typeof n1);
//}
//else
//	alert("What the hell DUDUE!");
//Nan represents a number that cannot be represented 
//console.log('recommended for debugging');

///////////////////////////////////////////////////variables in js///////////////////////////////////////////
//using var (local) or without using var (global)

//var i = 5; //integer
//var j=true; //boolean
//var k="hello"; //object
//var m={}; //object
//var p=[]; //array, data type is object
//var n; // <--undefined which is also a datatype in js
//var q = null; //OBJECT
//alert(typeof i);
//alert(typeof j);
//alert(typeof k);
//alert(typeof m);
//alert(typeof p);
//alert(typeof n);
//if not using var then value has to be initialized (simple doing --> n; will give an error)


/////////////////////////////////////////////ARRAYS//////////////////////////////////////////////////
//var array = []; //empty array
//array[0]=1;
//array[1]=2;
//array[2]=3;
//array[3]=4;
//
//alert(array.length);

//for(var count=0;count<array.length;count++) //2 types of for loop
//for(var count in array) //for in loop
//	alert(count+" : "+array[count]);

//var array= new Array(1,2,3);
//array[3]=4;
//array[99999]=5; //this will give length of 1lac and all the elements in between will be undefined :P --> absolutely POOR CODE
//thus when adding use the push method

//array.push(4);
//array.push(5);
//alert(array.length);

///////////////////////////////////////////FALSEY VALUES IN JS///////////////////////////////////////////
//1. boolean value false
//2. 0
//3. empty string
//4. undefined
//5. null
//var i = null;
//if("0")
//	alert('Always returns true');
//else
//	alert('always returns false');


////////////////////////////////////////////OPERATORS/////////////////////////////////////////////////
//=== <--- STRICT EQUALITY OPERATOR <---type must also be the same
//== <---also used but more leniently

//alert(1 === "1"); //false
//alert(1 == "1")//true <-- if string is numeric it is converted to number
//alert("1" == true) //boolean and string are both converted to a number
//alert ("true" == true);//false


////////////////////////////////////////FUNCTION/////////////////////////////////////
//function checkProbation(isProbation, name){
//	if(isProbation)
//		alert(name + ' is on Probation');
//	else
//		alert(name + ' is confirmed');
//	
//}
//
//checkProbation(true, "BLEH"); //number of arguments passed need not be same as arguments defined
//default value of all unspecified values is undefined irrespective of datatype
//var i =5; //global
//j=10; //global
////display(); //function hoisting
////parsing of js is done in two phases ---> first it looks for function declarations and then it executes the functions
//
//function display(){
//	var k=15; //local to fn diaplay
//	l=20; //global
//	
//	function inner(){
//		var m=25; //local to inner
//		n=30; //global
//		
//		alert(m);
//		alert(n);
//		alert(i);
//		alert(j);
//		alert(k);
//		alert(l);
//	}
//	alert(i);
//	alert(j);
//	alert(k);
//	alert(l);
//	alert('function declaration');
//	inner();
//}
//display();
//
//alert(i);
//alert(j);
////alert(k);
//alert(l);

//(function(){for(var count=0; count<1;count++)
//	alert(count);})(); 
////this is an anonymuos fn eg and it is not the declaration of any fn
//
//alert(count); //if it is not defined under any function thus count is global //0 , 1 if for loop not but within a fn

//function display(){
//	alert('display version 1');
//}
//function display(){
//	alert('display version 2');
//}
//function display(isProbation, name, age, address){
//	alert('display version 3');
//}
//
//function display(){
//	alert('display version 4');
//}
//
//var isProbation;
//var name;
//var age;
//var address;
//display(isProbation, name, age, address); //always it will be display version 4 no matter what
//
//var length = 5;
//var array = [1,2,3,4];
//
//function changeValue(v){
//	if(Array.isArray(v))
//		v.push(5);
//	else
//		v = 6;
//}
//alert(length);
//alert(array);
//
//changeValue(length);
//changeValue(array);
//
//alert(length);
//alert(array);

//function display(){
//	alert('before return');
//	 return 5;
//	 alert('after return'); //this will not give an error but the code will run and only before return will be displayed and anything 
//	 //written after returning is ignored
//}
//display();


////////////////////////////////////OBJECTS////////////////////////////////////
//WAY !:

//var obj = {}; //empty object
////add property to an object
//// 1. using dot operator
//// 2. using ["property_name"] //prop name can be an expr also but it should result into a  valid string
//obj.role="developer";
//
//alert(obj.role);
//
//obj["location"]="nagpur";
//
//alert(obj.location);
//
////2. To update a property
//obj.role="tester";
//
//alert(obj.role);
//
////if prop doesn't exist then using dot (.) prop creates it, else updates it
//
//alert(obj.name); //doesnt give error, just gives value as undefined
//
//var result=delete obj.role; //deleting properties
//if(result)
//	alert('deleted successfully');
//else
//	alert('cannot delete');
//
//alert(obj.role);


//WAY 2:

//var obj=new Object();
//obj.role="developer";
//obj["location"]="nagpur";
//
//for(var prop in obj){
//	alert(prop+" : "+obj[prop]);
//}
//
//var obj = {
//		role : "developer",
//		getRole : function(){
//			return this.role;
//		}
//};
//
//alert(obj.getRole()); //developer


//
//var obj = {
//		role : "developer",
//		getRole : function(){
//			role = "tester";
//			//return role;
//		}
//};
//
//obj.getRole(); //initializes role of getRole
//alert(role); //will output tester 
 //THESE ARE SINGLETON OBJECTS

//Use CONSTRUCTOR to get obj that are not singleton
//function Employee(r){
//	this.role=r;
//	var roler=9090;
//	this.getRole = function(){
//		alert(roler);
//	};
//}
////
//var e1=new Employee("developer");
////e1.getRole = function(){
//	alert('e1 version of getRole');
//}; //changes the func def of getRole for e1
//
//
//var e2=new Employee("tester");
//
//e1.roler;
//e1.getRole(); //e1 versiom of getRole
//e2.getRole(); //tester

//
//function Employee(l){
//	this.location = l;
//}
//
//var e1 = new Employee("Mumbai");
////1. object
////2. prop added to oj
////3. prop attributes
//
//Object.defineProperty(e1, "role",{
//		value: "developer",
//			writable : true,
//			configurable : true,
//			ennumerable : true
//}); //this API will not allow you to update the property or delete it and this is default behaviour :O unless writable & configurable : true is set
//
//
//
//for(var prop in e1){
//	alert(prop+" : "+e1[prop]);
//}
//alert(e1.role);
//
//e1.role="tester";
//
//alert(e1.role); //remains developer
//
//delete e1.role;
//
//alert(e1.role); //NO DELETEION...HAHAHAH :D


////////////////////////////////////////////PROTOTYPE KEYWORD//////////////////////////////////////
//functions should be written as a prototype (analogy is static) as then only one copy is available and not repeated for each new object creation
//
//function Employee(r){
//this.role=r;
//this.getRole = function(){
//	alert('CONS');
//};
//}
//
//Employee.prototype.getRole = function(){
//	alert('PROTOTYPE');
//};
//
//
//var e1 = new Employee("developer");
//e1.getRole(); //CONS or PROTOTYPE (when CONS comment)
//e1.getRole = function(){
//	alert('ABBE OH!');
//};
//e1.getRole(); //ABBE OH! if cons commented
//var e2 = new Employee("Hum");
//e2.getRole(); //PROTOTYPE
//var e3 = new Employee();
//var e4 = new Employee();
//var e5 = new Employee();
//
//
//Employee.prototype.accounts = ['SBI'];
//
//var e1 = new Employee();
//var e2 = new Employee();
//
//e1.accounts.push('HDFC');
//
//alert(e1.accounts);
//alert(e2.accounts);
 

////////////////////////////////////////////INHERITANCE////////////////////////////////////////
//function Parent(h){
//	//this = child object
//	this.home = h;
//}
//
//function Child(home){
//	//this = child object
//	Parent.call(this); //constructor stealing --> calling parent ctr in child but will use values of child
////every instance of child will have its own Parent
//	this.location="Pune";
//	this.home="Nagpur";
//}
//
//var c1 = new Child("Goa");
//
//alert(c1.home);

//in classical inheritance prototype are not inherited
//function GrandParent(){
//	this.property = "Mumbai";
//}
//
//function Parent(){
//	this.accounts=['SBI'];
//}
//Parent.prototype.getAccounts = function(){
//	alert(this.accounts);
//};
//function Child(){
//	Parent.call(this); //will not work for PROTOTYPE objects as they will not be inherited
//}
//
////PROTOTYPE CHAINING
//Child.prototype = new Parent();
////as good as writing an instance in which you COPY all the functions prototype instances and variables of Parent
//
//var c1 = new Child();
//var c2 = new Child();
//
//c1.accounts.push('ICICI');
//
//c1.getAccounts(); // SBI,ICICI
//c2.getAccounts(); // SBI

//use a mix of Prototype Chaining and Classical Inheritance together

////////////////////////////////CLOSURE///////////////////////////////

//to make a variable private
//function addCounter(){
//	var counter = 0;
//	
//	return function inner(){
//		counter++;
//		return counter;
//	};
//	
//}
// var getCounter = addCounter();
// 
// getCounter();
// getCounter();
// getCounter();
// getCounter();
// 
// 
////addCounter();
////addCounter();
////addCounter();
////addCounter();
// 
// 
// 
// 
//// creating private variables in JS
// 
//// function  (){
////	 var balance = 10000;
////	 this.getBalance = function(){
////		 return balance;
////	 };
////	 
////	 this.setBalance = function(b){
////		 balance=b;
////	 };
//// }
//// 
//// var e1=new Employee();
//// 
//// alert(e1.balance); //balance is not a property of Employee w/o this so undefined but not error
//// //if prop doesnt exist in obj and tried to access using (.) operator, gives undefined but never error
//// 
//// 
//// alert(e1.getBalance()); //returns 10000
//// e1.setBalance(20000);
//// 
//// alert(e1.getBalance()); //returns 20000
// 
// 
//// function Employee(){
////	 var balance = 10000;
////	 this.balance=2000;
////	 this.getBalance = function(){
////		 return this.balance;
////	 };
////	 
////	 this.setBalance = function(b){
////		 balance=b;
////	 };
//// }
//// 
//// var e1=new Employee();
//// 
//// alert(e1.balance); 
//// 
//// 
//// alert(e1.getBalance()); 
//// e1.setBalance(20000);
//// 
//// alert(e1.getBalance()); //returns 20000
// 
// //////////////////////////////////////////EVENT HANDLING////////////////////////
// /*alert(document.getElementById("div1").nodeName);
// alert(document.getElementById("div1").nodeType);
// alert(document.getElementById("div1").nodeValue);
//
// //to get the text 
// //document.getElementById("div1").innerHTML = "Updated section";
//
//
// //Text node
// alert(document.getElementById("div1").firstChild.nodeName);
// alert(document.getElementById("div1").firstChild.nodeType);
// alert(document.getElementById("div1").firstChild.nodeValue);
//
// //to update the text using text node
// document.getElementById("div1").firstChild.nodeValue = "updated section";*/
//
//
//
//
// //It returns an array
// //alert(document.getElementsByName("input1")[0].value);
// //value will return the value.
//
//
//
//
//
//
// /*//Inline event handling
// document.getElementById("addstockName").onclick = addStockName;
// document.getElementById("addstockName").onclick = displayMessage;
// //By this statement we are just binding the event handler
//
//
// function addStockName() {
// 	var inputElement = document.createElement("input");
// 	inputElement.setAttribute("value", "enter stock name");
// 	//document.getElementById("div1").appendChild(inputElement);
// 	
// 	document.getElementById("div1").insertBefore(inputElement, document.getElementById("addstockName"));
// }
//
// function displayMessage() {
// 	alert("stock name box is created successfully");
// }*/
//
//
//
//
//
//
//
//
//
// //****************************************************
// //MULTIPLE EVENT HANDLERS
// document.getElementById("addstockName").addEventListener("click", addStockName(), true);
// document.getElementById("addstockName").addEventListener("click", displayMessage(), true);
// //By this statement we are just binding the event handler
//
//
// function addStockName() {
// 	var inputElement = document.createElement("input");
// 	inputElement.setAttribute("value", "enter stock name");
// 	//document.getElementById("div1").appendChild(inputElement);
// 	
// 	document.getElementById("div1").insertBefore(inputElement, document.getElementById("addstockName"));
// }
//
// function displayMessage() {
// 	alert(event);
// 	alert(event.type);
// 	alert(event.target);
// 	alert(event.target.id);
// 	alert(event.which);
// 	alert("stock bo created successfully");
// }
// 
// 
// document.getElementById("btn1").addEventListener('click', btnHandler, false);
// //bubble phase --> false
// 
// document.getElementById("div1").addEventListener('click', divHandler, true); //div is parent for btn
// //capture phase
// //parent event handler has not been changed so child is true or false won't matter
// 
// function btnHandler(){
//	 alert('btn handler');
//	 event.stopPropagation();//to stop cascade
// }
// 
// function divHandler(){
//	 alert('div handler');
// }
 
 
//////////////////////////////TIMEOUT////////////////////////////
 
 setTimeout(timer, 2000);
 
 function timer(){
	 alert
	 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 