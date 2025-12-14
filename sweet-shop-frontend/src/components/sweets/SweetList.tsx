import React from 'react';
import { Sweet } from '../../types';

interface SweetListProps {
  sweets: Sweet[];
  onEdit: (sweet: Sweet) => void;
  onDelete: (id: number) => void;
}

export const SweetList: React.FC<SweetListProps> = ({ sweets, onEdit, onDelete }) => {
  if (sweets.length === 0) {
    return (
      <div className="text-center py-8 text-gray-500">
        No sweets added yet. Add your first sweet using the form!
      </div>
    );
  }

  return (
    <div className="space-y-4">
      {sweets.map((sweet) => (
        <div
          key={sweet.id}
          className="border border-gray-200 rounded-lg p-4 hover:shadow-md transition-shadow"
        >
          <div className="flex gap-4">
            <img
              src={sweet.imageUrl}
              alt={sweet.name}
              className="w-24 h-24 object-cover rounded-lg"
            />
            <div className="flex-1">
              <div className="flex justify-between items-start">
                <div>
                  <h3 className="text-lg font-semibold text-gray-800">
                    {sweet.name}
                  </h3>
                  <p className="text-sm text-gray-600 mt-1">
                    {sweet.description}
                  </p>
                  <div className="flex gap-4 mt-2 text-sm">
                    <span className="text-primary-600 font-semibold">
                      ₹{sweet.price}
                    </span>
                    <span className="text-gray-500">
                      Stock: {sweet.stock}
                    </span>
                    <span className="px-2 py-1 bg-purple-100 text-purple-700 rounded text-xs">
                      {sweet.category}
                    </span>
                  </div>
                </div>
                <div className="flex gap-2">
                  <button
                    onClick={() => onEdit(sweet)}
                    className="px-3 py-1 bg-blue-500 text-white rounded hover:bg-blue-600 text-sm"
                  >
                    Edit
                  </button>
                  <button
                    onClick={() => onDelete(sweet.id)}
                    className="px-3 py-1 bg-red-500 text-white rounded hover:bg-red-600 text-sm"
                  >
                    Delete
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};
