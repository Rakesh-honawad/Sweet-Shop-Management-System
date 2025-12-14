import api from './api';
import { AuthResponse, LoginRequest, RegisterRequest } from '../types';

export const authService = {
  register: async (data: RegisterRequest): Promise<AuthResponse> => {
    const response = await api.post('/auth/register', data);
    const authData = response.data.data;
    
    // Store token and user data
    localStorage.setItem('token', authData.token);
    localStorage.setItem('user', JSON.stringify({
      username: authData.username,
      email: authData.email,
      role: authData.role
    }));
    
    return authData;
  },

  login: async (data: LoginRequest): Promise<AuthResponse> => {
    const response = await api.post('/auth/login', data);
    const authData = response.data.data;
    
    // Store token and user data
    localStorage.setItem('token', authData.token);
    localStorage.setItem('user', JSON.stringify({
      username: authData.username,
      email: authData.email,
      role: authData.role
    }));
    
    return authData;
  },

  logout: () => {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
  },

  getCurrentUser: () => {
    const userStr = localStorage.getItem('user');
    return userStr ? JSON.parse(userStr) : null;
  },

  isAuthenticated: (): boolean => {
    return !!localStorage.getItem('token');
  },

  isAdmin: (): boolean => {
    const user = authService.getCurrentUser();
    return user?.role === 'ADMIN';
  }
};
