<div align="center">

# 🍬 Sweet Shop

### Full-Stack E-Commerce Platform for Traditional Indian Sweets

[![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)](https://github.com/yourusername/sweet-shop)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-18.2.0-61dafb.svg)](https://reactjs.org/)
[![TypeScript](https://img.shields.io/badge/TypeScript-5.0-blue.svg)](https://www.typescriptlang.org/)
[![MongoDB](https://img.shields.io/badge/MongoDB-7.0-green.svg)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

[Features](#-features) • [Demo](#-demo) • [Installation](#-quick-start) • [Documentation](#-api-documentation) • [Contributing](#-contributing)

</div>

---

## 📖 Overview

**Sweet Shop** is a modern, production-ready e-commerce application designed specifically for managing and selling traditional Indian sweets online. Built with enterprise-grade technologies, it offers a seamless shopping experience for customers and powerful management tools for administrators.

### 🎯 Key Highlights

- **Secure Authentication** - JWT-based authentication with role-based access control
- **Real-time Inventory** - Live stock management and updates
- **Responsive Design** - Mobile-first design with Tailwind CSS
- **RESTful API** - Well-documented API endpoints
- **Type-Safe** - Full TypeScript implementation on frontend
- **Scalable Architecture** - Microservices-ready architecture with Spring Boot

---

## ✨ Features

### 👥 Customer Features

| Feature | Description |
|---------|-------------|
| 🛍️ **Product Catalog** | Browse extensive collection of traditional Indian sweets with high-quality images |
| 🔍 **Smart Search** | Advanced search and filtering by category, price, and availability |
| 🛒 **Shopping Cart** | Intuitive cart management with real-time price calculations |
| 💳 **Secure Checkout** | Safe and streamlined checkout process |
| 👤 **User Profiles** | Personalized user accounts with order history |
| 📦 **Order Tracking** | Real-time order status and history tracking |
| 📱 **Responsive UI** | Seamless experience across all devices |

### 🔐 Admin Features

| Feature | Description |
|---------|-------------|
| 📊 **Dashboard Analytics** | Comprehensive overview of sales, orders, and inventory |
| ➕ **Product Management** | Full CRUD operations for sweet products |
| 📋 **Inventory Control** | Real-time stock tracking and low-stock alerts |
| 👥 **User Management** | Manage customer accounts and permissions |
| 📈 **Order Management** | Process, track, and manage all customer orders |
| 🔐 **Access Control** | Role-based permissions (Admin/User) |
| 📑 **Reports** | Generate sales and inventory reports |

---

## 🛠️ Tech Stack

<table>
<tr>
<td valign="top" width="33%">

### Backend
- **Java 17** - Core language
- **Spring Boot 3.2.0** - Application framework
- **Spring Security** - Authentication & authorization
- **Spring Data MongoDB** - Database integration
- **JWT (jjwt 0.11.5)** - Token-based auth
- **Maven** - Dependency management
- **Lombok** - Boilerplate reduction

</td>
<td valign="top" width="33%">

### Frontend
- **React 18.2** - UI library
- **TypeScript 5.0** - Type safety
- **Vite** - Build tool & dev server
- **React Router v6** - Navigation
- **Axios** - HTTP client
- **Tailwind CSS** - Utility-first styling
- **Lucide React** - Modern icons

</td>
<td valign="top" width="33%">

### Database & Tools
- **MongoDB 7.0** - NoSQL database
- **MongoDB Compass** - Database GUI
- **Postman** - API testing
- **Git** - Version control
- **Docker** - Containerization (optional)

</td>
</tr>
</table>

---

## 🎬 Demo

> **Note:** Add screenshots or GIF demos of your application here

```
🚀 Live Demo: [Coming Soon]
📱 Screenshots: [Add your screenshots here]
```

---

## 📦 Prerequisites

Before you begin, ensure you have the following installed on your system:

### Required Software

<details>
<summary><b>1. Java Development Kit (JDK) 17+</b></summary>

```bash
# Check if Java is installed
java -version

# Expected output: java version "17.x.x" or higher
```

**Download:** [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) | [OpenJDK](https://adoptium.net/)

</details>

<details>
<summary><b>2. Node.js 18+ and npm</b></summary>

```bash
# Check Node.js version
node -v

# Check npm version
npm -v

# Expected output: v18.x.x or higher
```

**Download:** [Node.js Official Website](https://nodejs.org/)

</details>

<details>
<summary><b>3. MongoDB 7.0+</b></summary>

```bash
# Check MongoDB version
mongod --version

# Expected output: db version v7.x.x or higher
```

**Download:** [MongoDB Community Server](https://www.mongodb.com/try/download/community)

**Alternative:** [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) (Cloud-hosted, free tier available)

</details>

<details>
<summary><b>4. Git</b></summary>

```bash
# Check Git version
git --version

# Expected output: git version 2.x.x or higher
```

**Download:** [Git Official Website](https://git-scm.com/downloads)

</details>

<details>
<summary><b>5. Maven (Optional)</b></summary>

```bash
# Check Maven version (if installed)
mvn -v
```

**Note:** Spring Boot includes Maven Wrapper (mvnw), so Maven installation is optional.

**Download:** [Apache Maven](https://maven.apache.org/download.cgi)

</details>

---

## 🚀 Quick Start

### 📥 Step 1: Clone the Repository

```bash
# Clone the repository
git clone https://github.com/yourusername/sweet-shop.git

# Navigate to project directory
cd sweet-shop
```

### 🗄️ Step 2: Database Setup

#### Start MongoDB

**On Windows:**
```bash
net start MongoDB
```

**On macOS/Linux:**
```bash
sudo systemctl start mongod

# Or using Homebrew (macOS)
brew services start mongodb-community
```

#### Initialize Database

```bash
# Open MongoDB shell
mongosh

# Or if using older MongoDB versions
mongo
```

**In MongoDB shell, run:**

```javascript
// Switch to sweetshop database
use sweetshop

// Create admin user (password: admin123)
db.users.insertOne({
  username: "admin",
  email: "admin@sweetshop.com",
  password: "$2a$10$slYQmyNdGzin7olVN3p5be4DFH5yYFHwPcKstWx.Ms41WB4.utC3m",
  role: "ADMIN",
  createdAt: new Date()
})

// Add sample sweets data
db.sweets.insertMany([
  {
    name: "Gulab Jamun",
    description: "Soft and spongy milk-solid balls soaked in sweet syrup",
    category: "Traditional",
    price: NumberDecimal("120.00"),
    imageUrl: "https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=400",
    stock: 50,
    createdAt: new Date()
  },
  {
    name: "Kaju Katli",
    description: "Diamond-shaped cashew fudge with silver leaf",
    category: "Premium",
    price: NumberDecimal("450.00"),
    imageUrl: "https://images.unsplash.com/photo-1599599810769-bcde5a160d32?w=400",
    stock: 30,
    createdAt: new Date()
  },
  {
    name: "Rasgulla",
    description: "Spongy cottage cheese balls in sugar syrup",
    category: "Traditional",
    price: NumberDecimal("100.00"),
    imageUrl: "https://images.unsplash.com/photo-1631452180519-c014fe946bc7?w=400",
    stock: 40,
    createdAt: new Date()
  },
  {
    name: "Jalebi",
    description: "Crispy, syrup-soaked spiral-shaped dessert",
    category: "Traditional",
    price: NumberDecimal("80.00"),
    imageUrl: "https://images.unsplash.com/photo-1583158546114-e6a4e8df9b5e?w=400",
    stock: 60,
    createdAt: new Date()
  }
])

// Exit MongoDB shell
exit
```

**Default Admin Credentials:**
- **Username:** `admin`
- **Password:** `admin123`

### ⚙️ Step 3: Backend Setup

```bash
# Navigate to backend directory
cd backend
```

#### Configure Application Properties

Create or edit `src/main/resources/application.properties`:

```properties
# MongoDB Configuration
spring.data.mongodb.uri=mongodb://localhost:27017/sweetshop
spring.data.mongodb.database=sweetshop

# Server Configuration
server.port=8081
server.error.include-message=always

# JWT Configuration
jwt.secret=yourSecretKeyHereChangeThisInProductionMinimum256BitsRequired
jwt.expiration=86400000

# CORS Configuration
cors.allowed.origins=http://localhost:3000

# Logging
logging.level.com.sweetshop=DEBUG
logging.level.org.springframework.security=DEBUG
```

#### Install Dependencies and Build

**Using Maven Wrapper (Recommended):**
```bash
# On Windows
mvnw.cmd clean install

# On macOS/Linux
./mvnw clean install
```

**Or using Maven:**
```bash
mvn clean install
```

#### Start Backend Server

```bash
# Using Maven Wrapper
./mvnw spring-boot:run

# Or using Maven
mvn spring-boot:run

# Or run the JAR file
java -jar target/sweetshop-backend-1.0.0.jar
```

✅ **Backend running at:** http://localhost:8081

### 🎨 Step 4: Frontend Setup

Open a new terminal window:

```bash
# Navigate to frontend directory (from project root)
cd frontend
```

#### Install Dependencies

```bash
npm install

# If you encounter dependency conflicts
npm install --legacy-peer-deps
```

#### Configure API Endpoint (Optional)

Edit `src/services/api.ts` if needed:

```typescript
const API_BASE_URL = 'http://localhost:8081/api';
```

#### Start Development Server

```bash
npm run dev
```

✅ **Frontend running at:** http://localhost:3000

---

## 🎯 Usage

### Access the Application

1. **Customer Portal:** http://localhost:3000
2. **Admin Dashboard:** http://localhost:3000/admin

### Test Accounts

| Role | Username | Password |
|------|----------|----------|
| Admin | `admin` | `admin123` |
| User | Register new account | - |

### Quick Actions

**As Customer:**
1. Browse the sweet catalog
2. Add items to cart
3. Proceed to checkout
4. View order history

**As Admin:**
1. Login with admin credentials
2. Access admin dashboard
3. Manage products, orders, and users
4. View analytics and reports

---

## 📡 API Documentation

### Base URL
```
http://localhost:8081/api
```

### Authentication Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| `POST` | `/api/auth/register` | Register new user | ❌ No |
| `POST` | `/api/auth/login` | User login | ❌ No |
| `GET` | `/api/auth/me` | Get current user | ✅ Yes |

#### Example: Register User

```bash
curl -X POST http://localhost:8081/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "email": "john@example.com",
    "password": "securePassword123"
  }'
```

#### Example: Login

```bash
curl -X POST http://localhost:8081/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "username": "admin",
  "email": "admin@sweetshop.com",
  "role": "ADMIN"
}
```

### Sweet/Product Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| `GET` | `/api/sweets` | Get all sweets | ❌ No |
| `GET` | `/api/sweets/{id}` | Get sweet by ID | ❌ No |
| `GET` | `/api/sweets/category/{category}` | Get sweets by category | ❌ No |
| `POST` | `/api/sweets` | Create new sweet | ✅ Admin |
| `PUT` | `/api/sweets/{id}` | Update sweet | ✅ Admin |
| `DELETE` | `/api/sweets/{id}` | Delete sweet | ✅ Admin |

#### Example: Get All Sweets

```bash
curl -X GET http://localhost:8081/api/sweets
```

#### Example: Create Sweet (Admin)

```bash
curl -X POST http://localhost:8081/api/sweets \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "name": "Barfi",
    "description": "Traditional milk-based sweet",
    "category": "Traditional",
    "price": 250.00,
    "imageUrl": "https://example.com/barfi.jpg",
    "stock": 40
  }'
```

### Cart Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| `GET` | `/api/cart` | Get user's cart | ✅ User |
| `POST` | `/api/cart/add` | Add item to cart | ✅ User |
| `PUT` | `/api/cart/update/{itemId}` | Update cart item quantity | ✅ User |
| `DELETE` | `/api/cart/remove/{itemId}` | Remove item from cart | ✅ User |
| `DELETE` | `/api/cart/clear` | Clear entire cart | ✅ User |

#### Example: Add to Cart

```bash
curl -X POST http://localhost:8081/api/cart/add \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "sweetId": "65a1b2c3d4e5f6g7h8i9j0k1",
    "quantity": 2
  }'
```

### Order Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| `POST` | `/api/orders` | Create new order | ✅ User |
| `GET` | `/api/orders/user` | Get user's orders | ✅ User |
| `GET` | `/api/orders/{id}` | Get order by ID | ✅ User |
| `GET` | `/api/orders/all` | Get all orders | ✅ Admin |
| `PUT` | `/api/orders/{id}/status` | Update order status | ✅ Admin |

#### Example: Create Order

```bash
curl -X POST http://localhost:8081/api/orders \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "items": [
      {
        "sweetId": "65a1b2c3d4e5f6g7h8i9j0k1",
        "quantity": 2,
        "price": 120.00
      }
    ],
    "totalAmount": 240.00,
    "shippingAddress": {
      "street": "123 Main St",
      "city": "Mumbai",
      "state": "Maharashtra",
      "zipCode": "400001",
      "country": "India"
    }
  }'
```

---

## 📁 Project Structure

```
sweet-shop/
│
├── backend/                          # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/sweetshop/
│   │   │   │   ├── config/
│   │   │   │   │   ├── SecurityConfig.java
│   │   │   │   │   ├── CorsConfig.java
│   │   │   │   │   └── MongoConfig.java
│   │   │   │   ├── controller/
│   │   │   │   │   ├── AuthController.java
│   │   │   │   │   ├── SweetController.java
│   │   │   │   │   ├── CartController.java
│   │   │   │   │   └── OrderController.java
│   │   │   │   ├── model/
│   │   │   │   │   ├── User.java
│   │   │   │   │   ├── Sweet.java
│   │   │   │   │   ├── Cart.java
│   │   │   │   │   └── Order.java
│   │   │   │   ├── repository/
│   │   │   │   │   ├── UserRepository.java
│   │   │   │   │   ├── SweetRepository.java
│   │   │   │   │   ├── CartRepository.java
│   │   │   │   │   └── OrderRepository.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── UserService.java
│   │   │   │   │   ├── SweetService.java
│   │   │   │   │   ├── CartService.java
│   │   │   │   │   └── OrderService.java
│   │   │   │   ├── security/
│   │   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   │   └── UserDetailsServiceImpl.java
│   │   │   │   ├── util/
│   │   │   │   │   └── JwtUtil.java
│   │   │   │   └── SweetShopApplication.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── application-prod.properties
│   │   └── test/
│   │       └── java/com/sweetshop/
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
│
├── frontend/                         # React Frontend
│   ├── public/
│   │   ├── index.html
│   │   └── favicon.ico
│   ├── src/
│   │   ├── components/
│   │   │   ├── common/
│   │   │   │   ├── Header.tsx
│   │   │   │   ├── Footer.tsx
│   │   │   │   └── Navbar.tsx
│   │   │   ├── product/
│   │   │   │   ├── ProductCard.tsx
│   │   │   │   └── ProductList.tsx
│   │   │   └── cart/
│   │   │       └── CartItem.tsx
│   │   ├── pages/
│   │   │   ├── Home.tsx
│   │   │   ├── Login.tsx
│   │   │   ├── Register.tsx
│   │   │   ├── Products.tsx
│   │   │   ├── ProductDetail.tsx
│   │   │   ├── Cart.tsx
│   │   │   ├── Checkout.tsx
│   │   │   ├── Orders.tsx
│   │   │   └── admin/
│   │   │       ├── Dashboard.tsx
│   │   │       ├── ManageProducts.tsx
│   │   │       ├── ManageOrders.tsx
│   │   │       └── ManageUsers.tsx
│   │   ├── services/
│   │   │   ├── api.ts
│   │   │   ├── authService.ts
│   │   │   ├── productService.ts
│   │   │   ├── cartService.ts
│   │   │   └── orderService.ts
│   │   ├── types/
│   │   │   ├── user.ts
│   │   │   ├── product.ts
│   │   │   ├── cart.ts
│   │   │   └── order.ts
│   │   ├── context/
│   │   │   └── AuthContext.tsx
│   │   ├── hooks/
│   │   │   └── useAuth.ts
│   │   ├── utils/
│   │   │   └── helpers.ts
│   │   ├── App.tsx
│   │   ├── main.tsx
│   │   └── index.css
│   ├── package.json
│   ├── tsconfig.json
│   ├── vite.config.ts
│   ├── tailwind.config.js
│   └── postcss.config.js
│
├── .gitignore
├── README.md
└── LICENSE
```

---

## ⚙️ Configuration

### Environment Variables

For better security and flexibility, use environment variables:

#### Backend `.env` (Optional)

Create `backend/.env`:

```properties
MONGODB_URI=mongodb://localhost:27017/sweetshop
JWT_SECRET=yourSecretKeyHere
SERVER_PORT=8081
CORS_ORIGINS=http://localhost:3000
```

#### Frontend `.env`

Create `frontend/.env`:

```properties
VITE_API_URL=http://localhost:8081/api
VITE_APP_NAME=Sweet Shop
```

### MongoDB Connection Options

**Local MongoDB:**
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/sweetshop
```

**MongoDB Atlas (Cloud):**
```properties
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/sweetshop?retryWrites=true&w=majority
```

**MongoDB with Authentication:**
```properties
spring.data.mongodb.uri=mongodb://username:password@localhost:27017/sweetshop?authSource=admin
```

---

## 🏗️ Build & Production

### Production Build - Backend

```bash
cd backend

# Create production JAR
./mvnw clean package -DskipTests

# The JAR file will be in target/
ls target/*.jar
```

### Production Build - Frontend

```bash
cd frontend

# Create optimized production build
npm run build

# The build files will be in dist/
ls dist/
```

### Run Production

#### Backend
```bash
# Set environment variables
export MONGODB_URI=mongodb://your-production-db/sweetshop
export JWT_SECRET=your-production-secret-key

# Run the application
java -jar target/sweetshop-backend-1.0.0.jar
```

#### Frontend
```bash
# Preview production build locally
npm run preview

# Or serve with a static server
npx serve -s dist -l 3000
```

---

## 🐳 Docker Deployment

### Docker Compose (Recommended)

Create `docker-compose.yml` in project root:

```yaml
version: '3.8'

services:
  mongodb:
    image: mongo:7.0
    container_name: sweetshop-mongo
    ports:
      - "27017:27017"
    volumes:
      - mongo-data:/data/db
    environment:
      MONGO_INITDB_DATABASE: sweetshop
    networks:
      - sweetshop-network

  backend:
    build: ./backend
    container_name: sweetshop-backend
    ports:
      - "8081:8081"
    environment:
      - SPRING_DATA_MONGODB_URI=mongodb://mongodb:27017/sweetshop
      - JWT_SECRET=yourProductionSecretKeyHere
      - CORS_ALLOWED_ORIGINS=http://localhost:3000
    depends_on:
      - mongodb
    networks:
      - sweetshop-network

  frontend:
    build: ./frontend
    container_name: sweetshop-frontend
    ports:
      - "3000:3000"
    environment:
      - VITE_API_URL=http://localhost:8081/api
    depends_on:
      - backend
    networks:
      - sweetshop-network

volumes:
  mongo-data:

networks:
  sweetshop-network:
    driver: bridge
```

### Dockerfiles

**Backend Dockerfile** (`backend/Dockerfile`):

```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
```

**Frontend Dockerfile** (`frontend/Dockerfile`):

```dockerfile
FROM node:18-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

FROM node:18-alpine
WORKDIR /app
COPY --from=build /app/dist ./dist
COPY --from=build /app/package*.json ./
RUN npm ci --production
EXPOSE 3000
CMD ["npm", "run", "preview", "--", "--host", "0.0.0.0"]
```

### Run with Docker

```bash
# Build and start all services
docker-compose up -d

# View logs
docker-compose logs -f

# Stop all services
docker-compose down

# Stop and remove volumes
docker-compose down -v
```

---

## 🌐 Deployment Options

### Frontend Deployment

#### Vercel (Recommended)
```bash
npm install -g vercel
cd frontend
vercel
```

#### Netlify
```bash
cd frontend
npm run build
# Drag and drop dist/ folder to Netlify
```

#### AWS S3 + CloudFront
```bash
# Build frontend
npm run build

# Upload to S3
aws s3 sync dist/ s3://your-bucket-name --delete

# Invalidate CloudFront cache
aws cloudfront create-invalidation --distribution-id YOUR_DIST_ID --paths "/*"
```

### Backend Deployment

#### Heroku
```bash
# Login to Heroku
heroku login

# Create app
heroku create sweetshop-backend

# Add MongoDB addon
heroku addons:create mongolab

# Deploy
git push heroku main
```

#### AWS EC2
```bash
# SSH into EC2 instance
ssh -i your-key.pem ec2-user@your-instance-ip

# Install Java
sudo yum install java-17-amazon-corretto

# Upload JAR file
scp -i your-key.pem target/sweetshop-backend-1.0.0.jar ec2-user@your-instance-ip:~/

# Run application
java -jar sweetshop-backend-1.0.0.jar
```

#### Railway
```bash
# Install Railway CLI
npm install -g @railway/cli

# Login
railway login

# Deploy
railway up
```

---

## 🐛 Troubleshooting

<details>
<summary><b>MongoDB Connection Failed</b></summary>

**Error:**
```
MongoServerError: connect ECONNREFUSED 127.0.0.1:27017
```

**Solutions:**

1. **Ensure MongoDB is running:**
   ```bash
   # Windows
   net start MongoDB
   
   # macOS/Linux
   sudo systemctl start mongod
   sudo systemctl status mongod
   ```

2. **Check MongoDB port:**
   ```bash
   netstat -an | grep 27017
   ```

3. **Verify connection string:**
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/sweetshop
   ```

4. **Check MongoDB logs:**
   ```bash
   # macOS/Linux
   tail -f /usr/local/var/log/mongodb/mongo.log
   
   # Windows
   # Check Event Viewer > Windows Logs > Application
   ```

</details>

<details>
<summary><b>Port Already in Use</b></summary>

**Error:**
```
Port 8081 is already in use
```

**Solutions:**

1. **Find and kill the process:**
   ```bash
   # Windows
   netstat -ano | findstr :8081
   taskkill /PID <PID> /F
   
   # macOS/Linux
   lsof -ti:8081 | xargs kill -9
   ```

2. **Change the port:**
   Edit `application.properties`:
   ```properties
   server.port=8082
   ```

</details>

<details>
<summary><b>CORS Error</b></summary>

**Error:**
```
Access to XMLHttpRequest blocked by CORS policy
```

**Solutions:**

1. **Check CORS configuration:**
   ```properties
   cors.allowed.origins=http://localhost:3000
   ```

2. **Ensure frontend URL matches:**
   Frontend running on port 3000, backend allows port 3000

3. **Clear browser cache:**
   - Open DevTools (F12)
   - Right-click refresh button
   - Select "Empty Cache and Hard Reload"

</details>

<details>
<summary><b>JWT Token Expired</b></summary>

**Error:**
```
401 Unauthorized - Token expired
```

**Solution:**
Login again to get a new token. Tokens expire after 24 hours by default.

</details>

<details>
<summary><b>npm install fails</b></summary>

**Error:**
```
ERESOLVE unable to resolve dependency tree
```

**Solutions:**

1. **Use legacy peer deps:**
   ```bash
   npm install --legacy-peer-deps
   ```

2. **Clear npm cache:**
   ```bash
   npm cache clean --force
   rm -rf node_modules package-lock.json
   npm install
   ```

3. **Use correct Node version:**
   ```bash
   nvm use 18
   npm install
   ```

</details>

<details>
<summary><b>Build fails - Java version mismatch</b></summary>

**Error:**
```
error: invalid source release: 17
```

**Solution:**
Ensure you're using JDK 17+:
```bash
java -version
# If wrong version, update JAVA_HOME
export JAVA_HOME=/path/to/jdk17
```

</details>

<details>
<summary><b>Frontend not connecting to backend</b></summary>

**Checklist:**
1. Backend is running on port 8081
2. Frontend API URL is correct in `api.ts`
3. CORS is properly configured
4. Network tab shows requests to correct URL
5. Check browser console for errors

</details>

---

## 🧪 Testing

### Backend Testing

```bash
cd backend

# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=SweetControllerTest

# Run with coverage
./mvnw test jacoco:report
```

### Frontend Testing

```bash
cd frontend

# Run tests (if configured)
npm test

# Run with coverage
npm test -- --coverage
```

---

## 📚 Additional Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [React Documentation](https://react.dev/)
- [MongoDB Manual](https://www.mongodb.com/docs/manual/)
- [TypeScript Handbook](https://www.typescriptlang.org/docs/)
