// src/pages/AdminPage.tsx
import React, { useState, useEffect } from 'react';
import { SweetForm } from '../components/sweets/SweetForm';
import { SweetCard } from '../components/sweets/SweetCard';
import { sweetService } from '../services/sweetService';
import { Sweet, SweetFormData } from '../types';

export const AdminPage: React.FC = () => {
  const [sweets, setSweets] = useState<Sweet[]>([]);
  const [loading, setLoading] = useState(true);
  const [showForm, setShowForm] = useState(false);
  const [editingSweet, setEditingSweet] = useState<Sweet | undefined>();

  const loadSweets = async () => {
    try {
      setLoading(true);
      const data = await sweetService.getAllSweets();
      setSweets(data);
    } catch (error) {
      alert('Failed to load sweets');
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadSweets();
  }, []);

  const handleSubmit = async (formData: SweetFormData) => {
    try {
      const sweetData = {
        name: formData.name,
        category: formData.category,
        price: parseFloat(formData.price),
        quantity: parseInt(formData.quantity),
        description: formData.description,
        imageUrl: formData.imageUrl
      };

      if (editingSweet) {
        await sweetService.updateSweet(editingSweet.id, sweetData);
        alert('Sweet updated successfully!');
      } else {
        await sweetService.createSweet(sweetData);
        alert('Sweet added successfully!');
      }

      setShowForm(false);
      setEditingSweet(undefined);
      loadSweets();
    } catch (error: any) {
      alert(error.response?.data?.message || 'Operation failed');
    }
  };

  const handleEdit = (sweet: Sweet) => {
    setEditingSweet(sweet);
    setShowForm(true);
  };

  const handleCancel = () => {
    setShowForm(false);
    setEditingSweet(undefined);
  };

  const handleRestock = async (sweetId: number) => {
    const quantityStr = prompt('Enter quantity to add:');
    if (!quantityStr) return;

    const quantity = parseInt(quantityStr);
    if (isNaN(quantity) || quantity <= 0) {
      alert('Invalid quantity');
      return;
    }

    try {
      await sweetService.restockSweet(sweetId, { quantity });
      alert('Restocked successfully!');
      loadSweets();
    } catch (error) {
      alert('Restock failed');
    }
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-pink-50 via-purple-50 to-blue-50">
      <div className="max-w-7xl mx-auto px-4 py-8">
        <div className="flex justify-between items-center mb-8">
          <div>
            <h1 className="text-4xl font-bold text-gray-800">Admin Panel</h1>
            <p className="text-gray-600 mt-2">Manage your sweet inventory</p>
          </div>
          
          {!showForm && (
            <button onClick={() => setShowForm(true)} className="btn-primary">
              Add New Sweet
            </button>
          )}
        </div>

        {showForm && (
          <div className="mb-8">
            <SweetForm
              sweet={editingSweet}
              onSubmit={handleSubmit}
              onCancel={handleCancel}
            />
          </div>
        )}

        {loading ? (
          <div className="text-center py-12">
            <div className="inline-block animate-spin rounded-full h-12 w-12 border-b-2 border-primary-600"></div>
            <p className="mt-4 text-gray-600">Loading sweets...</p>
          </div>
        ) : (
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
            {sweets.map((sweet) => (
              <div key={sweet.id} className="relative">
                <SweetCard sweet={sweet} onUpdate={loadSweets} onEdit={handleEdit} />
                <button
                  onClick={() => handleRestock(sweet.id)}
                  className="absolute top-2 right-2 bg-green-600 text-white px-3 py-1 rounded-lg text-sm hover:bg-green-700"
                >
                  Restock
                </button>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
};
