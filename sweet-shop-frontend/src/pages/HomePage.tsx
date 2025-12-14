// src/pages/HomePage.tsx
import React, { useState, useEffect } from 'react';
import { SearchBar } from '../components/sweets/SearchBar';
import { SweetCard } from '../components/sweets/SweetCard';
import { sweetService } from '../services/sweetService';
import { Sweet, SearchFilters } from '../types';

export const HomePage: React.FC = () => {
  const [sweets, setSweets] = useState<Sweet[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  const loadSweets = async () => {
    try {
      setLoading(true);
      const data = await sweetService.getAllSweets();
      setSweets(data);
      setError('');
    } catch (err) {
      setError('Failed to load sweets');
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadSweets();
  }, []);

  const handleSearch = async (filters: SearchFilters) => {
    try {
      setLoading(true);
      const data = await sweetService.searchSweets(filters);
      setSweets(data);
      setError('');
    } catch (err) {
      setError('Search failed');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-pink-50 via-purple-50 to-blue-50">
      <div className="max-w-7xl mx-auto px-4 py-8">
        <div className="text-center mb-8">
          <h1 className="text-4xl font-bold text-gray-800 mb-2">Welcome to Sweet Shop</h1>
          <p className="text-gray-600">Discover our delicious collection of sweets</p>
        </div>

        <SearchBar onSearch={handleSearch} />

        {error && (
          <div className="mb-4 p-4 bg-red-50 border border-red-200 rounded-lg text-red-700">
            {error}
          </div>
        )}

        {loading ? (
          <div className="text-center py-12">
            <div className="inline-block animate-spin rounded-full h-12 w-12 border-b-2 border-primary-600"></div>
            <p className="mt-4 text-gray-600">Loading sweets...</p>
          </div>
        ) : sweets.length === 0 ? (
          <div className="text-center py-12">
            <p className="text-gray-600 text-lg">No sweets found</p>
          </div>
        ) : (
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
            {sweets.map((sweet) => (
              <SweetCard key={sweet.id} sweet={sweet} onUpdate={loadSweets} />
            ))}
          </div>
        )}
      </div>
    </div>
  );
};