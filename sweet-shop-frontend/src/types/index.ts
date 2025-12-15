// src/types/index.ts

export interface Sweet {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
  category: string;
  stock: number;
}

export interface User {
  id: number;
  username: string;
  email: string;
  role: string;
}

export interface AuthResponse {
  token: string;
  username: string;
  email: string;
  role: string;
}

export interface LoginRequest {
  username: string;
  password: string;
}

export interface RegisterRequest {
  username: string;
  email: string;
  password: string;
}

export interface SearchFilters {
  name?: string;
  category?: string;
  minPrice?: number;
  maxPrice?: number;
}
