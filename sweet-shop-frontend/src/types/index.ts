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
  username: string;
  email: string;
  role: 'USER' | 'ADMIN';
}

export interface SweetFormData {
  name: string;
  description: string;
  price: string;
  imageUrl: string;
  category: string;
  stock: string;
}
