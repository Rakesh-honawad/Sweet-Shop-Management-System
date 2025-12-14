import React from 'react';
import { Sweet } from '../../types';

interface SweetCardProps {
  sweet: Sweet;
}

export const SweetCard: React.FC<SweetCardProps> = ({ sweet }) => {
  return (
    <div className="bg-white rounded-lg shadow-lg overflow-hidden hover:shadow-xl transition-shadow">
      <img
        src={sweet.imageUrl}
        alt={sweet.name}
        className="w-full h-48 object-cover"
      />
      <div className="p-4">
        <h3 className="text-lg font-semibold text-gray-800 mb-2">
          {sweet.name}
        </h3>
        <p className="text-gray-600 text-sm mb-3">
          {sweet.description}
        </p>
        
        <div className="flex items-center justify-between mb-3">
          <span className="text-xl font-bold text-primary-600">
            ₹{sweet.price}
          </span>
          <span className="text-sm text-gray-500">
            Stock: {sweet.stock}
          </span>
        </div>

        <span className="inline-block px-3 py-1 bg-purple-100 text-purple-700 rounded-full text-xs font-semibold mb-4">
          {sweet.category}
        </span>

        <button className="w-full bg-primary-600 hover:bg-primary-700 text-white font-semibold py-2 rounded-lg transition-colors">
          Add to Cart
        </button>
      </div>
    </div>
  );
};
