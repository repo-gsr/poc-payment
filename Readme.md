# Getting Started

### Reference Documentation

* For Running Application 

    * PreRequisites 
       
       jdk 1.8
       maven any version
       
   * To run the application you need run the BottomlineApplication.java this is main class to start the application.
   
   * Application is using in-memory data base.

* In this sample the following apis were there

1)  Creating Payment Plan by passing some request Body

  Url :  localhost:8081/v1/payment

  Request Body : 

    {
    	"totalAmount": 10,
    	"numberOfPayments": 3
    }
  
  Response :   
  
     {
	    "paymentId": 1,
	    "totalAmount": 10,
	    "numberOfPayments": 3,
	    "regularPaymentAmount": 3.33,
	    "lastAmount": 3.34
	  }

 2) Get the PaymentPlan Details By PaymentID
 
   URL: localhost:8081/v1/payment/?paymentId=4
 
   Request param: 1
   
   Response : 
   
   {
    "paymentId": 4,
    "totalAmount": 10.00,
    "numberOfPayments": 3,
    "regularPaymentAmount": 3.33,
    "lastAmount": 3.34
   }
  
 3) Get all the PaymentPlan Details  
 
  URL : localhost:8081/v1/payment
  
  Response :
  
  [
    {
        "paymentId": 1,
        "totalAmount": 10.00,
        "numberOfPayments": 3,
        "regularPaymentAmount": 3.33,
        "lastAmount": 3.34
    },
    {
        "paymentId": 2,
        "totalAmount": 10.00,
        "numberOfPayments": 3,
        "regularPaymentAmount": 3.33,
        "lastAmount": 3.34
    },
    {
        "paymentId": 3,
        "totalAmount": 10.00,
        "numberOfPayments": 3,
        "regularPaymentAmount": 3.33,
        "lastAmount": 3.34
    },
    {
        "paymentId": 4,
        "totalAmount": 10.00,
        "numberOfPayments": 3,
        "regularPaymentAmount": 3.33,
        "lastAmount": 3.34
    },
    {
        "paymentId": 5,
        "totalAmount": 10.00,
        "numberOfPayments": 3,
        "regularPaymentAmount": 3.33,
        "lastAmount": 3.34
    }
]
   
     

