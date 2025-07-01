# 💳 PaymentService

A modular Spring Boot microservice that facilitates payment initiation using multiple gateways such as Razorpay and Stripe. It is part of a larger e-commerce system and can be integrated easily via REST APIs.

## 🚀 Features

- 🔄 Supports **Stripe** and **Razorpay**
- ✅ Strategy Pattern used to dynamically choose the best gateway
- 📬 Stripe webhook endpoint to receive payment notifications
- 📎 Generates short payment links
- 📦 Built with Spring Boot 3.4.5, Java 17

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot (Web, Configuration Processor)
- Stripe Java SDK
- Razorpay Java SDK
- Maven

---

## 📁 Folder Structure

```
PaymentService/
├── configuration/
│   └── RazorPayConfig.java
├── controllers/
│   ├── PaymentController.java
│   └── WebhookController.java
├── dtos/
│   └── InitiatePaymentDto.java
├── services/
│   ├── IPaymentService.java
│   └── PaymentService.java
├── strategies/
│   ├── IPaymentGateway.java
│   ├── PaymentGatewayStrategy.java
│   ├── RazorpayPaymentGateway.java
│   └── StripePaymentGateway.java
├── resources/
│   └── application-sample.properties
```

---

## 📦 Dependencies

Major dependencies from `pom.xml`:

```xml
<dependency>
  <groupId>com.razorpay</groupId>
  <artifactId>razorpay-java</artifactId>
  <version>1.4.8</version>
</dependency>

<dependency>
  <groupId>com.stripe</groupId>
  <artifactId>stripe-java</artifactId>
  <version>29.2.0-beta.1</version>
</dependency>
```

---

## 📲 API Endpoints

### 1. Initiate Payment

`POST /payment`

```json
{
  "amount": 1000,
  "orderId": "ORDER123",
  "phoneNumber": "9999999999",
  "name": "Harshal",
  "email": "harshal@example.com"
}
```

🔁 Returns a short payment URL (Stripe or Razorpay)

---

### 2. Stripe Webhook

`POST /stripeWebhook`

Used to log incoming webhook events from Stripe (logs to console).

---

## ⚙️ Configuration

You can copy and rename `application-sample.properties` to `application.properties`, and fill in the credentials:

```properties
spring.application.name=PaymentService

# Razorpay Config
razorpay.id = your_razorpay_id
razorpay.secret = your_razorpay_secret

# Stripe Config
stripe.key = your_stripe_secret_key
```

---

## 🧠 Design Pattern

This service uses the **Strategy Design Pattern** to dynamically select the appropriate payment gateway at runtime (`PaymentGatewayStrategy.java`).

---

## ✅ To Run the Service

```bash
  mvn clean install
  mvn spring-boot:run
```

Default server runs at: `http://localhost:8080`

---

## 🧪 Future Improvements

- Add DB persistence for transactions
- Dynamic gateway selection based on success/failure rate
- Stripe webhook verification
- Razorpay webhook support
- Unit and integration testing

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## ✨ Author

Developed by **Harshal Kalewar**

Connect with me on [GitHub](https://github.com/harshalkalewar)
