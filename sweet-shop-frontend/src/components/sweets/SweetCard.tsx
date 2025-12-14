// src/components/sweets/SweetCard.tsx
import React, { useState } from 'react';
import { Sweet } from '../../types';
import { sweetService } from '../../services/sweetService';
import { useAuth } from '../../hooks/useAuth';

interface SweetCardProps {
  sweet: Sweet;
  onUpdate: () => void;
  onEdit?: (sweet: Sweet) => void;
}

export const SweetCard: React.FC<SweetCardProps> = ({ sweet, onUpdate, onEdit }) => {
  const [loading, setLoading] = useState(false);
  const { isAdmin } = useAuth();

  const handlePurchase = async () => {
    const quantity = prompt('How many would you like to purchase?');
    if (!quantity) return;

    const qty = parseInt(quantity);
    if (isNaN(qty) || qty <= 0) {
      alert('Invalid quantity');
      return;
    }

    if (qty > sweet.quantity) {
      alert('Not enough in stock');
      return;
    }

    setLoading(true);
    try {
      await sweetService.purchaseSweet(sweet.id, { quantity: qty });
      alert('Purchase successful!');
      onUpdate();
    } catch (error) {
      alert('Purchase failed');
    } finally {
      setLoading(false);
    }
  };

  const handleDelete = async () => {
    if (!window.confirm('Are you sure you want to delete this sweet?')) return;

    setLoading(true);
    try {
      await sweetService.deleteSweet(sweet.id);
      alert('Sweet deleted successfully!');
      onUpdate();
    } catch (error) {
      alert('Delete failed');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      {sweet.imageUrl && (
        <img src={sweet.imageUrl} alt={sweet.name} className="w-full h-40 object-cover rounded-lg mb-4" />
      )}
      <h3 className="text-lg font-bold text-gray-800 mb-2">{sweet.name}</h3>
      <p className="text-sm text-gray-600 mb-2">{sweet.category}</p>
      {sweet.description && <p className="text-sm text-gray-700 mb-3">{sweet.description}</p>}
      
      <div className="flex justify-between items-center mb-4">
        <div>
          <p className="text-2xl font-bold text-primary-600">₹{sweet.price}</p>
          <p className={`text-sm ${sweet.quantity > 0 ? 'text-green-600' : 'text-red-600'}`}>
            {sweet.quantity > 0 ? `${sweet.quantity} in stock` : 'Out of stock'}
          </p>
        </div>
      </div>

      <div className="flex gap-2">
        {!isAdmin ? (
          <button
            onClick={handlePurchase}
            disabled={sweet.quantity === 0 || loading}
            className="flex-1 btn-primary disabled:opacity-50"
          >
            {loading ? 'Processing...' : 'Buy'}
          </button>
        ) : (
          <>
            <button onClick={() => onEdit?.(sweet)} className="flex-1 btn-secondary">
              Edit
            </button>
            <button onClick={handleDelete} disabled={loading} className="flex-1 btn-danger">
              Delete
            </button>
          </>
        )}
      </div>
    </div>
  );
};
