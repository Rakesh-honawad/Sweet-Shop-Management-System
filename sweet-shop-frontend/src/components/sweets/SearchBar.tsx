// src/components/sweets/SearchBar.tsx
import React, { useState } from 'react';
import { SearchFilters } from '../../types';

interface SearchBarProps {
  onSearch: (filters: SearchFilters) => Promise<void>;
}

export const SearchBar: React.FC<SearchBarProps> = ({ onSearch }) => {
  const [filters, setFilters] = useState<SearchFilters>({});
  const [loading, setLoading] = useState(false);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    setFilters(prev => ({
      ...prev,
      [name]: value || undefined
    }));
  };

  const handleSearch = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    try {
      await onSearch(filters);
    } finally {
      setLoading(false);
    }
  };

  const handleReset = async () => {
    setFilters({});
    await onSearch({});
  };

  return (
    <div className="bg-white rounded-xl shadow-md p-6 mb-8">
      <form onSubmit={handleSearch} className="space-y-4">
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
          <div>
            <label className="block text-sm font-medium mb-2">Search by Name</label>
            <input
              type="text"
              name="name"
              value={filters.name || ''}
              onChange={handleChange}
              placeholder="Sweet name..."
              className="input-field"
              disabled={loading}
            />
          </div>

          <div>
            <label className="block text-sm font-medium mb-2">Category</label>
            <select
              name="category"
              value={filters.category || ''}
              onChange={handleChange}
              className="input-field"
              disabled={loading}
            >
              <option value="">All Categories</option>
              <option value="Traditional">Traditional</option>
              <option value="Modern">Modern</option>
              <option value="Imported">Imported</option>
              <option value="Seasonal">Seasonal</option>
            </select>
          </div>

          <div>
            <label className="block text-sm font-medium mb-2">Min Price</label>
            <input
              type="number"
              name="minPrice"
              value={filters.minPrice || ''}
              onChange={handleChange}
              placeholder="₹0"
              className="input-field"
              disabled={loading}
            />
          </div>

          <div>
            <label className="block text-sm font-medium mb-2">Max Price</label>
            <input
              type="number"
              name="maxPrice"
              value={filters.maxPrice || ''}
              onChange={handleChange}
              placeholder="₹10000"
              className="input-field"
              disabled={loading}
            />
          </div>
        </div>

        <div className="flex gap-4">
          <button type="submit" className="btn-primary" disabled={loading}>
            {loading ? 'Searching...' : 'Search'}
          </button>
          <button
            type="button"
            onClick={handleReset}
            className="btn-secondary"
            disabled={loading}
          >
            Reset
          </button>
        </div>
      </form>
    </div>
  );
};
