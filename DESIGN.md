## Design

Bank ACME Application is an "example" project to demonstrate software development.

### Entities
+ Access

    Representation of resources access i.e. login.  To create a new <code>Access</code>, the user will need to do the 
    <code>sign-in</code> operation.
    
    Properties:
    
    > + id: A UUID uniquely identifying a login access entry.
    > + email: Will represent the <code>username</code>
    > + password: Will represent the secret.
    > + customerId: A UUID reference to a Customer resource.  When a person sign-in, it will also create a new Customer entry (in addition of creating a new Access entry).

+ Customer

    Representation of a Person acting as a Customer of a Bank.  A Customer may have zero to many Bank Accounts.
    Operations allowed on a Customer are the standard CRUD (**C**reate, **R**ead, **U**pdate, **D**elete).
    
    Properties
    > + id:  A UUID uniquely representing the identity of a Customer.
    > + firstname: Customer first name.
    > + lastname: Customer last name.
    > + dob: Customer Date of Birth.
    
+ CustomerProfile

    Representation of a Customer object and a List<Account> that the Customer has created.
    
    Properties:
    > + Customer
    > + List<Account>
    
+ Account

    Representation of a Bank Account.
    
    > + id: A UUID uniquely identifying an Account.
    > + customerId: unique UUID identifying the Customer.
    > + type: The type of Bank Account: {'CHEQUING', 'SAVING', 'TFSA'}
    > + balance: The account balance.
    > + status: The state of the account {'ACTIVE','CLOSED'}


+ AccountTransaction

    Representation of a transaction (account creation, deposit, withdraw, closing) applied on an account resource.
    This resource can be use to show the Customer all his past transactions applied on his/her account.  It also
    can be used as "re-play" the state of the account (from the time it was created and all the deposit and withdrawal 
    and possible closure of the account).
    
    + id: A UUID uniquely identifying the transaction.
    + accountId: The Account to which the transaction is applied.
    + type:  The type of transaction {'CREATE', 'DEPOSIT', 'WITHDRAW', 'CLOSE'}
    + amount: The amount, if any, involved in the transaction.  (CREATE will be 0.00, while CLOSE will be NULL).
    + status: the state of the transaction: {'PENDING', 'SUCCESS', 'FAIL'}
    + txDate: the date and time of the transaction.



### Operations:

#### Sign-in and Login
           
1. Read the SignInLogin Resource.

    This operation would simply show the options for sign-in operation and login operation along with all the input
    fields required to do those operations.  

1. Sign-in operation

    The sign-in operation will take as input the following properties:
    
    > + firsname
    > + lastname
    > + dob (Date of birth)
    > + email
    > + password
    
    **Successful output:**
    
    The result of this operation would be the successful creation of one Access object entry (create one instance of Access object) and one
    Customer object entry (create one instance of a Customer object).  The Access object will need to set the customerId
    property generated from the Customer object.  The result of this operation should return void. 
    
    **Failure output:**
    The failure result should throw an Exception.
 
1. Login operation

    The login operation will take as input the following properties:
    
    > + Email
    > + Password 
    
    The result of this operation will either accept the credentials (success) or refuse them (fail).

    **Successful output:**
    
    The successful login result should return a CustomerProfile object.

    **Failure output:**
    
    The failure login result should return a null.     

1. Read a CustomerProfile resource

    This operation would read (fetch) a CustomerProfile object and display the properties.  In addition, this
    resource should also display the next possible operations (such as create a Bank Account).

1. Create bank account operation

    This operation would take as input a Bank Account Type.  One of: <code>{'CHEQUING','SAVING','TFSA'}</code>
    
    **Successful output:**
    
    The successful account creation would have successfully created an Account object entry and an AccountTransaction
    object entry.  This operation would return the created Account object.

    **Failure output:**
    
    The failure should either return a null or throw an Exception with an error message as to why it failed.
    It would be best to throw an IllegalStateException (a RunTime Exception not a checked Exception).

1. Read a banck account operation

    This operation will take as input, the UUID of the account that we want to see and return the Account object.
    
    **Successful output:**
    
    Return the existing Account object.
    
    **Failure output:**
    
    throw a RunTimeException with message "Account not found".

1. Deposit operation

    This operation will take as input the UUID of the account we want to deposit the money and the dollar amount.  
    
    **Successful output:**
    This operation will update the Account balance accordingly and create a new AccountTransaction object entry.
    Return the newly updated Account object.
    
    **Failure output:**
    throw a new RunTimeException with message of the cause.
    
1. Withdraw operation

    This operation will take as input the UUID of the account we want to withdraw the money and the dollar amount.
    This operation will need to check if the account has sufficient funds.
    
    **Successful output:**
    This operation would update the Account balance accordingly and create a new AccountTransaction object entry.
    Return the newly updated Account object.
    
1. Read the list of account transactions resource

    **Successful output:**
    
    This operation would take as input the UUID of the account and return a List<AccountTransaction> object.
    
    **Failure output:**
    
    If the UUID does not exist, throw an RunTimeException with message "Account does not exist".
    
1. Transfer money operation

    This will take as input two different account UUID (from and to) and an amount.  It should find both Account objects
    and update each account balance.  Create two AccountTransaction objects (one will be a withdraw and the other 
    will be a deposit).
    
    **Successful output**
    Return a List<Account> (there should be only two account: from and to) where the first item in the list is the "from" account
    and the second item of the list is the "to" account.
    
    **Failure output**
    
    throw a RunTimeException with the cause as message. (example not enough funds in the "from" account)
    

## Do similar design for other "resources" such as "Goal" and even "Manual/Automatic Bill Payment"

Also, the above is only an API to your Bank App.  You need to also design the GUI and CL (Command Line) interface.
This GUI/CL interface could be uniformly called XXXResource or XXXForm  (e.g. AccountGuiForm, AccountClForm). You will 
need to toy with that.

Note:  A "Payment" idea might be good as it can be "separated" to another team member.