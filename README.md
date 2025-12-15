# 🍬 Sweet Shop - E-Commerce Platform

<div align="center">

**Full-Stack E-Commerce Solution for Traditional Indian Sweets**

[![Live Demo](https://img.shields.io/badge/demo-live-success)](https://sweet-shop-management-system-khaki.vercel.app/)
[![Backend](https://img.shields.io/badge/backend-Spring%20Boot-green)](https://sweet-shop-management-system-6n23.onrender.com/api/sweets)
[![Frontend](https://img.shields.io/badge/frontend-React-blue)](https://sweet-shop-management-system-khaki.vercel.app/)
[![Database](https://img.shields.io/badge/database-MongoDB-brightgreen)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

[🌐 Live Demo](#-live-demo) • [✨ Features](#-features) • [🚀 Quick Start](#-quick-start) • [📖 Documentation](#-api-documentation) • [🤝 Contributing](#-contributing)

</div>

---

## 📖 Overview

Sweet Shop is a modern, production-ready e-commerce platform built for managing and selling traditional Indian sweets online. Designed with enterprise-grade architecture, it provides a seamless shopping experience for customers and comprehensive management tools for administrators.

### 🎯 Key Highlights

- ✅ **JWT-Based Security** - Secure authentication with role-based access control (Admin/User)
- ✅ **Real-Time Inventory** - Live stock management and product availability tracking
- ✅ **Responsive Design** - Mobile-first UI with Tailwind CSS, works on all devices
- ✅ **Type-Safe Code** - Full TypeScript implementation across frontend
- ✅ **RESTful API** - Well-documented, production-ready API endpoints
- ✅ **Cloud Ready** - Deployed on Vercel (Frontend), Render (Backend), MongoDB Atlas (Database)

---

## 🌐 Live Demo

| Platform | URL | Status |
|----------|-----|--------|
| 🎨 **Frontend** | [https://sweet-shop-management-system-khaki.vercel.app/](https://sweet-shop-management-system-khaki.vercel.app/) | ✅ Live |
| 🔌 **Backend API** | [https://sweet-shop-management-system-6n23.onrender.com/api/sweets](https://sweet-shop-management-system-6n23.onrender.com/api/sweets) | ✅ Live |

**Test Account:**
```
Username: admin
Password: admin123
```

---

## ✨ Features

### 👥 Customer Features

| Feature | Details |
|---------|---------|
| 🛍️ **Browse Catalog** | View extensive collection of traditional Indian sweets with high-quality images |
| 🔍 **Smart Search** | Filter sweets by category, price range, and availability |
| 🛒 **Shopping Cart** | Add/remove items, update quantities, see real-time price calculations |
| 💳 **Secure Checkout** | Safe order placement with delivery address management |
| 👤 **User Account** | Create profile, view order history, track deliveries |
| 📦 **Order Tracking** | Real-time status updates on orders |
| 📱 **Mobile Friendly** | Fully responsive design for all devices |

### 🔐 Admin Features

| Feature | Details |
|---------|---------|
| 📊 **Dashboard** | Overview of sales, orders, and inventory metrics |
| ➕ **Product Management** | Add, edit, delete sweets with images and descriptions |
| 📋 **Inventory Control** | Real-time stock tracking with low-stock alerts |
| 👥 **User Management** | View and manage customer accounts |
| 📈 **Order Management** | Process orders, update status, manage shipments |
| 🔐 **Role-Based Access** | Restrict features based on user roles |

---

## 🛠️ Tech Stack

### 🖥️ Backend
- **Java 17** - Type-safe language
- **Spring Boot 3.2** - REST API framework
- **Spring Security** - Authentication & JWT
- **Spring Data MongoDB** - Database ORM
- **Maven** - Dependency management
- **Lombok** - Reduce boilerplate code

### 🎨 Frontend
- **React 18** - UI library
- **TypeScript 5** - Type safety
- **Vite** - Lightning-fast build tool
- **React Router v6** - Client-side routing
- **Axios** - HTTP client
- **Tailwind CSS** - Utility-first styling
- **Lucide React** - Icon library

### 🗄️ Infrastructure
- **MongoDB Atlas** - Cloud NoSQL database
- **Render** - Backend deployment
- **Vercel** - Frontend hosting
- **JWT (jjwt)** - Token-based auth
- **Docker** - Containerization
- **Git** - Version control

---

## 📋 Prerequisites

Before starting, ensure you have:

| Requirement | Version | Download |
|------------|---------|----------|
| **Java JDK** | 17+ | [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) \| [OpenJDK](https://openjdk.org/) |
| **Node.js** | 18+ | [Node.js](https://nodejs.org/) |
| **MongoDB** | 7.0+ | [Community Server](https://www.mongodb.com/try/download/community) \| [Atlas (Cloud)](https://www.mongodb.com/cloud/atlas) |
| **Git** | Latest | [Git](https://git-scm.com/) |

---

## 🚀 Quick Start

### 1️⃣ Clone Repository

```bash
git clone https://github.com/Rakesh-honawad/Sweet-Shop-Management-System.git
cd Sweet-Shop-Management-System
```

### 2️⃣ Backend Setup

```bash
cd backend

# Configure application.properties
# Update: mongodb.uri, jwt.secret, cors.origins

# Build and run
./mvnw clean install
./mvnw spring-boot:run
```

**Backend runs on:** `http://localhost:8080`

### 3️⃣ MongoDB Setup

#### Option A: Local MongoDB

```bash
# Start MongoDB service
mongod

# Add admin user and sample data via MongoDB Shell or Compass
```

#### Option B: MongoDB Atlas (Cloud)

1. Go to [https://www.mongodb.com/cloud/atlas](https://www.mongodb.com/cloud/atlas)
2. Create free M0 cluster
3. Create database user (sweetshop:YourPassword)
4. Add IP whitelist: `0.0.0.0/0`
5. Copy connection string
6. Update in `application.properties`

**Connection String Format:**
```
spring.data.mongodb.uri=mongodb+srv://sweetshop:PASSWORD@cluster0.xxxxx.mongodb.net/sweetshop?retryWrites=true&w=majority
```

### 4️⃣ Frontend Setup

```bash
cd frontend

# Install dependencies
npm install

# Start development server
npm run dev
```

**Frontend runs on:** `http://localhost:5173`

### 5️⃣ Access Application

```
🏠 Customer Portal: http://localhost:5173
🔐 Admin Login: http://localhost:5173 (use admin credentials)
```

---

## 🔑 Default Credentials

```
👤 Admin Account:
  Username: admin
  Password: admin123
  Role: ADMIN

📝 Or register a new account as customer
```

---

## 📁 Project Structure

```
Sweet-Shop-Management-System/
│
├── 📂 backend/                    # Spring Boot Application
│   ├── src/main/java/com/sweetshop/
│   │   ├── config/               # Configuration classes
│   │   │   ├── SecurityConfig.java
│   │   │   ├── CorsConfig.java
│   │   │   └── MongoConfig.java
│   │   ├── controller/           # REST Controllers
│   │   │   ├── AuthController.java
│   │   │   ├── SweetController.java
│   │   │   ├── CartController.java
│   │   │   └── OrderController.java
│   │   ├── service/              # Business Logic
│   │   │   ├── UserService.java
│   │   │   ├── SweetService.java
│   │   │   ├── CartService.java
│   │   │   └── OrderService.java
│   │   ├── repository/           # Database Queries
│   │   │   ├── UserRepository.java
│   │   │   ├── SweetRepository.java
│   │   │   ├── CartRepository.java
│   │   │   └── OrderRepository.java
│   │   ├── model/                # Entity Classes
│   │   │   ├── User.java
│   │   │   ├── Sweet.java
│   │   │   ├── Cart.java
│   │   │   └── Order.java
│   │   ├── security/             # JWT & Security
│   │   │   ├── JwtAuthenticationFilter.java
│   │   │   └── JwtUtil.java
│   │   └── SweetShopApplication.java
│   ├── src/main/resources/
│   │   └── application.properties # Configuration
│   ├── pom.xml                   # Maven dependencies
│   ├── Dockerfile               # Docker container
│   └── mvnw / mvnw.cmd          # Maven wrapper
│
├── 📂 frontend/                   # React Application
│   ├── src/
│   │   ├── components/           # Reusable Components
│   │   │   ├── Header.tsx
│   │   │   ├── Footer.tsx
│   │   │   ├── ProductCard.tsx
│   │   │   └── CartItem.tsx
│   │   ├── pages/                # Page Components
│   │   │   ├── Home.tsx
│   │   │   ├── Login.tsx
│   │   │   ├── Products.tsx
│   │   │   ├── Cart.tsx
│   │   │   ├── Orders.tsx
│   │   │   └── admin/
│   │   │       ├── Dashboard.tsx
│   │   │       └── ManageProducts.tsx
│   │   ├── services/             # API Services
│   │   │   ├── api.ts            # Axios config
│   │   │   ├── authService.ts
│   │   │   └── productService.ts
│   │   ├── context/              # Global State
│   │   │   └── AuthContext.tsx
│   │   ├── types/                # TypeScript Interfaces
│   │   │   ├── user.ts
│   │   │   ├── product.ts
│   │   │   └── order.ts
│   │   ├── App.tsx               # Main component
│   │   └── main.tsx              # Entry point
│   ├── package.json
│   ├── tsconfig.json
│   ├── vite.config.ts
│   └── tailwind.config.js
│
├── .gitignore
├── README.md
└── LICENSE
```

---

## 🔌 API Documentation

### Base URL
```
http://localhost:8080/api
```

### 🔐 Authentication Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | User login |
| GET | `/auth/me` | Get current user info |

**Login Request:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'
```

**Login Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "username": "admin",
  "email": "admin@sweetshop.com",
  "role": "ADMIN"
}
```

### 🍬 Product Endpoints

| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/sweets` | ❌ | Get all products |
| GET | `/sweets/{id}` | ❌ | Get product by ID |
| POST | `/sweets` | ✅ Admin | Create product |
| PUT | `/sweets/{id}` | ✅ Admin | Update product |
| DELETE | `/sweets/{id}` | ✅ Admin | Delete product |

**Get All Products:**
```bash
curl http://localhost:8080/api/sweets
```

**Create Product (Admin):**
```bash
curl -X POST http://localhost:8080/api/sweets \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -d '{
    "name": "Barfi",
    "description": "Traditional milk-based sweet",
    "category": "Traditional",
    "price": 250.00,
    "stock": 40
  }'
```

### 🛒 Cart Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/cart` | Get user cart |
| POST | `/cart/add` | Add to cart |
| PUT | `/cart/update/{itemId}` | Update quantity |
| DELETE | `/cart/remove/{itemId}` | Remove from cart |

### 📦 Order Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/orders` | Create order |
| GET | `/orders/user` | Get user's orders |
| GET | `/orders/all` | Get all orders (Admin) |
| PUT | `/orders/{id}/status` | Update status (Admin) |

---

## ⚙️ Configuration

### Backend Configuration

Create/Edit `backend/src/main/resources/application.properties`:

```properties
# Application Name
spring.application.name=sweet-shop-backend

# Server Port
server.port=${PORT:8080}

# MongoDB Connection (Atlas)
spring.data.mongodb.uri=${MONGODB_URI:mongodb+srv://sweetshop:password@cluster0.xxxxx.mongodb.net/sweetshop?retryWrites=true&w=majority}

# JWT Configuration
jwt.secret=${JWT_SECRET:your-super-secret-key-minimum-256-bits}
jwt.expiration=86400000

# CORS Configuration
cors.allowed.origins=${CORS_ALLOWED_ORIGINS:https://sweet-shop-management-system-khaki.vercel.app,http://localhost:3000}

# Logging
logging.level.com.sweetshop=DEBUG
logging.level.org.springframework.security=DEBUG

# JSON Configuration
spring.jackson.serialization.write-dates-as-timestamps=false
```

### Frontend Configuration

Create `frontend/.env`:

```env
VITE_API_URL=http://localhost:8080/api
VITE_APP_NAME=Sweet Shop
```

---

## 🌍 Deployment

### 🚀 Deploy Backend (Render)

1. Create `Dockerfile` in `backend/`
2. Push to GitHub
3. Go to [Render](https://render.com/) → New Web Service
4. Configure:
   - **Root Directory:** `backend`
   - **Dockerfile Path:** `backend/Dockerfile`
5. Add Environment Variables:
   ```
   MONGODB_URI = mongodb+srv://...
   JWT_SECRET = your-secret
   CORS_ALLOWED_ORIGINS = your-frontend-url
   ```
6. Deploy!

### 🎨 Deploy Frontend (Vercel)

1. Create account on [Vercel](https://vercel.com/)
2. Import GitHub repo
3. Configure:
   - **Root Directory:** `frontend`
   - **Environment Variable:** `VITE_API_URL = your-backend-url`
4. Deploy!

### 💾 MongoDB Atlas Setup

1. Create free M0 cluster on [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
2. Create database user (sweetshop:Password)
3. Whitelist IP: `0.0.0.0/0` for cloud access
4. Get connection string and use in backend

---

## 🐳 Docker Deployment

### Run with Docker Compose

```bash
# Build and start all services
docker-compose up -d

# View logs
docker-compose logs -f

# Stop services
docker-compose down
```

### docker-compose.yml

```yaml
version: '3.8'

services:
  mongodb:
    image: mongo:7.0
    ports:
      - "27017:27017"
    volumes:
      - mongo-data:/data/db
    environment:
      MONGO_INITDB_DATABASE: sweetshop

  backend:
    build: ./backend
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATA_MONGODB_URI=mongodb://mongodb:27017/sweetshop
      - JWT_SECRET=your-secret
    depends_on:
      - mongodb

  frontend:
    build: ./frontend
    ports:
      - "3000:3000"
    environment:
      - VITE_API_URL=http://localhost:8080/api
    depends_on:
      - backend

volumes:
  mongo-data:
```

---

## 🐛 Troubleshooting

### ❌ MongoDB Connection Error

**Error:** `MongoServerError: connect ECONNREFUSED`

**Solutions:**
```bash
# Start MongoDB locally
mongod

# Or use MongoDB Atlas connection string
# Add to application.properties
spring.data.mongodb.uri=mongodb+srv://user:pass@cluster.mongodb.net/db
```

### ❌ CORS Error

**Error:** `Access to XMLHttpRequest blocked by CORS policy`

**Solution:**
```properties
# Update cors.allowed.origins in application.properties
cors.allowed.origins=https://your-frontend-url.com,http://localhost:3000
```

### ❌ Port Already in Use

**Solution:**
```bash
# Kill process using port 8080
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# macOS/Linux
lsof -ti:8080 | xargs kill -9
```

### ❌ JWT Token Expired

**Solution:** Login again to get a new token (expires after 24 hours)

### ❌ Dockerfile Not Found (Render)

**Solution:** Ensure `backend/Dockerfile` exists and push to GitHub

---

## 📊 Database Schema

### Users Collection

```json
{
  "_id": "ObjectId",
  "username": "admin",
  "email": "admin@sweetshop.com",
  "password": "hashed_password",
  "role": "ADMIN",
  "createdAt": "Date"
}
```

### Sweets Collection

```json
{
  "_id": "ObjectId",
  "name": "Gulab Jamun",
  "description": "Soft balls in syrup",
  "category": "Traditional",
  "price": 120,
  "imageUrl": "https://...",
  "stock": 50,
  "createdAt": "Date"
}
```

### Orders Collection

```json
{
  "_id": "ObjectId",
  "userId": "ObjectId",
  "items": [...],
  "totalAmount": 500,
  "status": "PENDING",
  "orderDate": "Date",
  "deliveryAddress": {...}
}
```

---

## 🧪 Testing

### Backend Tests

```bash
cd backend
./mvnw test
```

### Frontend Tests

```bash
cd frontend
npm test
```

---

## 📚 Learning Resources

- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [React Documentation](https://react.dev/)
- [MongoDB University](https://university.mongodb.com/)
- [TypeScript Handbook](https://www.typescriptlang.org/docs/)

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create feature branch: `git checkout -b feature/AmazingFeature`
3. Commit changes: `git commit -m 'Add AmazingFeature'`
4. Push to branch: `git push origin feature/AmazingFeature`
5. Open Pull Request

---

## 📄 License

This project is licensed under the MIT License - see [LICENSE](LICENSE) file for details.

---

## 🙏 Support

If you found this project helpful, please consider:

- ⭐ Star the repository
- 🐛 Report issues on [GitHub](https://github.com/Rakesh-honawad/Sweet-Shop-Management-System/issues)
- 💬 Share feedback

---

<div align="center">

**Made with ❤️ by [Rakesh Honawad](https://github.com/Rakesh-honawad)**

Questions? [Open an issue](https://github.com/Rakesh-honawad/Sweet-Shop-Management-System/issues) or start a discussion!

</div>
