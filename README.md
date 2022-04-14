## Payment

This project is used for _online paymen_.

The project uses h2 as a database.

## Build 
_You need [Apache Maven](https://maven.apache.org/) to build the project_

~~~
mvn clean install
~~~

## How to run a project

* _Clone this repository_
~~~
https://github.com/Kurmanali1508/payment.git
~~~

#### In IntelliJ IDEA
1. Open IntelliJ IDEA and select File > Open....
2. Choose the _payment_ directory and click OK.
3. Select File > Project Structure and ensure that the Project SDK and language level are set to use Java 11.

#### In Eclipse
1. Open Eclipse and select File > Import.
2. In the import wizard, choose Maven > Existing Maven Projects, then click Next.
3. Select the _payment_ as the project root directory.
4. Click Finish to complete the import.
5. Select Project > Properties . In Java Build Path, ensure that under the Libraries tab, Modulepath is set to JRE System Library (JavaSE-11). In Java Compiler, ensure that the Use compliance from execution environment 'JavaSE-11' on the 'Java Build Path' checkbox is selected.

---

#### Project structure
* Entities
  * Bank
  * Client
  * Payment

#### API

~~~
localhost:8080/bank
~~~

This api contains all the crud functions for the bank.

~~~
localhost:8080/client
~~~

Here we can create a client and check the client's requisite

~~~
localhost:8080/payment
~~~

  * In order to make a payment, the client must pass authentication.
  * Authentication is implemented with jwt tokens.
  * In order to get a jwt token, you need to knock on the api
~~~
localhost:8080/authenticate
~~~
  * If the token is valid, you will authenticate and get access to make the payment.
  * If the token is not valid, it will throw an ClientNotFoundException exception. 
  * You can make a payment and then cancel your payment if necessary.
  * Also after the payment you have the opportunity to check the status of your payment.

Statuses in project are implemented as enum.
  * If the payment is completed successfully, the status will be SUCCESS.
  * If you don't have enough money on your balance, the status will be a FAILED.
  * If you canceled the payment, the status will be CANCELLED

