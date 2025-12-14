// src/pages/HomePage.tsx
import React, { useEffect, useState } from 'react';
import { sweetService } from '../services/sweetService';
import { Sweet } from '../types';
import { SweetCard } from '../components/sweets/SweetCard';
import { useAuth } from '../hooks/useAuth';
import { useNavigate } from 'react-router-dom';

export const HomePage: React.FC = () => {
  const [sweets, setSweets] = useState<Sweet[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const { user } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    loadSweets();
  }, []);

  const loadSweets = async () => {
    try {
      setLoading(true);
      const data = await sweetService.getAllSweets();
      setSweets(data || []); // Ensure it's always an array
    } catch (err: any) {
      console.error('Error loading sweets:', err);
      setError('Failed to load sweets');
      setSweets([]); // Set to empty array on error
    } finally {
      setLoading(false);
    }
  };

  const handleAddToCart = (sweet: Sweet) => {
    // TODO: Implement cart functionality
    alert(`Added ${sweet.name} to cart!`);
  };

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-xl">Loading sweets...</div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-red-600">{error}</div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gradient-to-br from-pink-50 via-purple-50 to-blue-50">
      <div className="container mx-auto px-4 py-8">
        <div className="text-center mb-12">
          <h1 className="text-4xl font-bold text-gray-800 mb-4">
            🍬 Welcome to Sweet Shop
          </h1>
          <p className="text-gray-600 text-lg">
            Discover our delicious collection of sweets
          </p>
        </div>

        {sweets.length === 0 ? (
          <div className="text-center py-12">
            <p className="text-xl text-gray-600 mb-4">
              No sweets available yet!
            </p>
            {user?.role === 'ADMIN' && (
              <button
                onClick={() => navigate('/admin')}
                className="btn-primary"
              >
                Add Your First Sweet
              </button>
            )}
          </div>
        ) : (
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
            {sweets.map((sweet) => (
              <SweetCard key={sweet.id} sweet={sweet} />
            ))}
          </div>
        )}
      </div>
    </div>
  );
};
