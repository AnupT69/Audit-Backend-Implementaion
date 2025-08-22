# Audit Logging System Documentation

## Overview

The **Audit Logging System** provides comprehensive tracking of user and system actions within this Application. It ensures accountability, security, and traceability by capturing critical activities such as authentication, Notes, and administrative operations.

## System Architecture

### Backend Components (Spring Boot)

#### 1. AuditLog Entity
The `AuditLog` entity represents an audit record in the system, storing details such as:
- User information
- Action performed
- Timestamp
- Related entity (e.g., User , Note)
- Additional metadata

#### 2. Audits API

The system exposes RESTful endpoints for interacting with audit logs.

---

### API Endpoints

#### **Get Audit Log**

- **GET** `/api/audits`
- **Description:** List of Audits .

##### Example JSON Request


##### Example JSON Response

```json
{
  "id": "abcde-12345",
  "userId": "12345",
  "action": "PAYMENT_PROCESSED",
  "entityType": "Payment",
  "entityId": "67890",
  "timestamp": "2025-08-22T03:09:51Z",
  "metadata": {
    "amount": 5000,
    "currency": "INR",
    "method": "UPI"
  },
  "status": "SUCCESS"
}
[
{
"id": 1,
"timestamp": "2025-08-21T21:37:40.725048Z",
"userId": "system",
"userRole": "SYSTEM",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "Authentication",
"action": "LOGIN",
"entityType": "User",
"status": "SUCCESS",
"remarks": null
},
{
"id": 2,
"timestamp": "2025-08-21T21:39:08.945063Z",
"userId": "system",
"userRole": "SYSTEM",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "UserManagement",
"action": "Updating User role",
"entityType": "User",
"status": "SUCCESS",
"remarks": null
},
{
"id": 3,
"timestamp": "2025-08-21T21:44:41.439911Z",
"userId": "Anup",
"userRole": "ROLE_ADMIN",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "Authentication",
"action": "LOGIN",
"entityType": "User",
"status": "SUCCESS",
"remarks": null
},
{
"id": 4,
"timestamp": "2025-08-21T21:49:26.490392Z",
"userId": "system",
"userRole": "SYSTEM",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "Authentication",
"action": "REGISTER",
"entityType": "User",
"status": "SUCCESS",
"remarks": null
},
{
"id": 5,
"timestamp": "2025-08-21T21:52:37.590045Z",
"userId": "Anup",
"userRole": "ROLE_ADMIN",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "Note Management",
"action": "CREATE NOTE",
"entityType": "Note",
"status": "SUCCESS",
"remarks": null
},
{
"id": 6,
"timestamp": "2025-08-21T21:53:11.902113Z",
"userId": "Anup",
"userRole": "ROLE_ADMIN",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "Note Management",
"action": "CREATE NOTE",
"entityType": "Note",
"status": "SUCCESS",
"remarks": null
},
{
"id": 7,
"timestamp": "2025-08-21T21:58:46.997444Z",
"userId": "Anup",
"userRole": "ROLE_ADMIN",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "Note Management",
"action": "UPDATE NOTE",
"entityType": "Note",
"status": "SUCCESS",
"remarks": null
},
{
"id": 8,
"timestamp": "2025-08-21T21:59:12.598142Z",
"userId": "Anup",
"userRole": "ROLE_ADMIN",
"ipAddress": "0:0:0:0:0:0:0:1",
"module": "Note Management",
"action": "UPDATE NOTE",
"entityType": "Note",
"status": "FAILED",
"remarks": "Note not found"
},
]
```

---


## Technologies Used

- **Spring Boot** (Java)
- **RESTful APIs**
- **JSON** for request/response
- **Database:** Relational (PostgreSQL)

## Contribution

Feel free to contribute by submitting issues or pull requests. For setup and further documentation, see the `/docs` directory or contact the maintainers.

---

## License

This project is licensed under the MIT License.
