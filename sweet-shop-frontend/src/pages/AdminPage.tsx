// src/pages/AdminPage.tsx
import React, { useEffect, useState } from 'react';
import { sweetService } from '../services/sweetService';
import { Sweet } from '../types';
import { SweetForm } from '../components/sweets/SweetForm';
import { SweetList } from '../components/sweets/SweetList';

export const AdminPage: React.FC = () => {
  const [sweets, setSweets] = useState<Sweet[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [editingSweet, setEditingSweet] = useState<Sweet | undefined>(undefined);

  useEffect(() => {
    loadSweets();
  }, []);

  const loadSweets = async () => {
    try {
      setLoading(true);
      const data = await sweetService.getAllSweets();
      setSweets(data || []);
    } catch (err: any) {
      console.error('Error loading sweets:', err);
      setError('Failed to load sweets');
      setSweets([]);
    } finally {
      setLoading(false);
    }
  };

  const handleAddSweet = async (sweetData: any) => {
    try {
      const payload = {
        name: sweetData.name,
        description: sweetData.description,
        price: Number(sweetData.price),
        imageUrl: sweetData.imageUrl,
        category: sweetData.category,
        stock: Number(sweetData.stock)
      };
      await sweetService.createSweet(payload);
      await loadSweets();
      alert('Sweet added successfully!');
    } catch (err: any) {
      alert(err.response?.data?.message || 'Failed to add sweet');
    }
  };

  const handleUpdateSweet = async (id: number, sweetData: any) => {
    try {
      const payload = {
        name: sweetData.name,
        description: sweetData.description,
        price: Number(sweetData.price),
        imageUrl: sweetData.imageUrl,
        category: sweetData.category,
        stock: Number(sweetData.stock)
      };
      await sweetService.updateSweet(id, payload);
      await loadSweets();
      setEditingSweet(undefined);
      alert('Sweet updated successfully!');
    } catch (err: any) {
      alert(err.response?.data?.message || 'Failed to update sweet');
    }
  };

  const handleDeleteSweet = async (id: number) => {
    if (!window.confirm('Are you sure you want to delete this sweet?')) {
      return;
    }
    try {
      await sweetService.deleteSweet(id);
      await loadSweets();
      alert('Sweet deleted successfully!');
    } catch (err: any) {
      alert(err.response?.data?.message || 'Failed to delete sweet');
    }
  };

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-xl">Loading...</div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gradient-to-br from-pink-50 via-purple-50 to-blue-50 py-8">
      <div className="container mx-auto px-4">
        <h1 className="text-3xl font-bold text-gray-800 mb-8">
          🍬 Admin Panel - Manage Sweets
        </h1>

        {error && (
          <div className="mb-4 p-4 bg-red-50 border border-red-200 rounded-lg text-red-700">
            {error}
          </div>
        )}

        <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
          <div className="lg:col-span-1">
            <div className="bg-white rounded-xl shadow-lg p-6">
              <h2 className="text-xl font-bold mb-4">
                {editingSweet ? 'Edit Sweet' : 'Add New Sweet'}
              </h2>
              <SweetForm
                sweet={editingSweet}
                onSubmit={async (data) => {
                  if (editingSweet) {
                    await handleUpdateSweet(editingSweet.id, data);
                  } else {
                    await handleAddSweet(data);
                  }
                }}
                onCancel={() => setEditingSweet(undefined)}
              />
            </div>
          </div>

          <div className="lg:col-span-2">
            <div className="bg-white rounded-xl shadow-lg p-6">
              <h2 className="text-xl font-bold mb-4">
                Existing Sweets ({sweets.length})
              </h2>
              <SweetList
                sweets={sweets}
                onEdit={setEditingSweet}
                onDelete={handleDeleteSweet}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
