Use Case
A payment processing system has a new third-party payment gateway, but its API is incompatible with the existing system. We’ll use an adapter to bridge the gap.

Object Adapter
Step 1: Target Interface Define the interface expected by the client:
 

Step 2: Adaptee This is the third-party payment gateway with an incompatible interface:

Step 3: Adapter The adapter bridges the gap between the PaymentProcessor interface and ThirdPartyPaymentGateway:

Step 4: Client The client interacts with the PaymentProcessor interface and remains unaware of the third-party API:

