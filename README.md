# Assignment #3 — Bridge Pattern

## Topic

Online Shopping System

## Bridge Pattern

The Bridge pattern separates the order abstraction from the payment implementation.

### Abstraction
- `Order`

### Refined Abstractions
- `OnlineOrder`
- `SubscriptionOrder`

### Implementor
- `PaymentProcessor`

### Concrete Implementors
- `CardPayment`
- `KaspiPayment`

### Client
- `Main`

The client can switch payment implementations without changing the order abstraction.


```java
Order onlineOrder = new OnlineOrder(cardPayment);
Order anotherOrder = new OnlineOrder(kaspiPayment);

Project Structure
src/
├── Main.java
├── Order.java
├── OnlineOrder.java
├── SubscriptionOrder.java
├── PaymentProcessor.java
├── CardPayment.java
└── KaspiPayment.java

Clean Code Principles
1. Separation of Responsibilities — orders and payments have separate responsibilities.
2. Meaningful Names — classes and methods clearly describe their purpose.
3. Small Classes — each class has a focused responsibility.
4. No Duplicated Logic — payment implementations provide their own pay() logic.
5. Extensible Design — new payment methods can be added without changing Order.
Requirements
- Java implementation of the Bridge pattern
- 2 Refined Abstractions
- 2 Concrete Implementors
- Runtime switching of implementations
- 5 Clean Code principles