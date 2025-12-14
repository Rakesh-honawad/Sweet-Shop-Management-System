import api from './api';
import { Sweet } from '../types';

export const sweetService = {
  getAllSweets: async (): Promise<Sweet[]> => {
    const response = await api.get('/sweets');
    return response.data;
  },

  getSweetById: async (id: number): Promise<Sweet> => {
    const response = await api.get(`/sweets/${id}`);
    return response.data;
  },

  createSweet: async (sweet: Omit<Sweet, 'id'>): Promise<Sweet> => {
    const response = await api.post('/sweets', sweet);
    return response.data;
  },

  updateSweet: async (id: number, sweet: Omit<Sweet, 'id'>): Promise<Sweet> => {
    const response = await api.put(`/sweets/${id}`, sweet);
    return response.data;
  },

  deleteSweet: async (id: number): Promise<void> => {
    await api.delete(`/sweets/${id}`);
  },

  searchSweets: async (params: {
    name?: string;
    category?: string;
    minPrice?: number;
    maxPrice?: number;
  }): Promise<Sweet[]> => {
    const response = await api.get('/sweets/search', { params });
    return response.data;
  }
};
