import api from './api';
import { Sweet, PurchaseRequest, SearchFilters } from '../types';

export const sweetService = {
  getAllSweets: async (): Promise<Sweet[]> => {
    const response = await api.get('/sweets');
    return response.data.data;
  },

  getSweetById: async (id: number): Promise<Sweet> => {
    const response = await api.get(`/sweets/${id}`);
    return response.data.data;
  },

  searchSweets: async (filters: SearchFilters): Promise<Sweet[]> => {
    const params = new URLSearchParams();
    if (filters.name) params.append('name', filters.name);
    if (filters.category) params.append('category', filters.category);
    if (filters.minPrice) params.append('minPrice', filters.minPrice.toString());
    if (filters.maxPrice) params.append('maxPrice', filters.maxPrice.toString());
    
    const response = await api.get(`/sweets/search?${params.toString()}`);
    return response.data.data;
  },

  createSweet: async (sweet: Omit<Sweet, 'id'>): Promise<Sweet> => {
    const response = await api.post('/sweets', sweet);
    return response.data.data;
  },

  updateSweet: async (id: number, sweet: Partial<Sweet>): Promise<Sweet> => {
    const response = await api.put(`/sweets/${id}`, sweet);
    return response.data.data;
  },

  deleteSweet: async (id: number): Promise<void> => {
    await api.delete(`/sweets/${id}`);
  },

  purchaseSweet: async (id: number, request: PurchaseRequest): Promise<Sweet> => {
    const response = await api.post(`/sweets/${id}/purchase`, request);
    return response.data.data;
  },

  restockSweet: async (id: number, request: PurchaseRequest): Promise<Sweet> => {
    const response = await api.post(`/sweets/${id}/restock`, request);
    return response.data.data;
  }
};