// src/pages/NotFoundPage.tsx
import React from 'react';
import { Link } from 'react-router-dom';

export const NotFoundPage: React.FC = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-pink-50 via-purple-50 to-blue-50 flex items-center justify-center p-4">
      <div className="text-center">
        <h1 className="text-9xl font-bold text-gray-300">404</h1>
        <h2 className="text-3xl font-bold text-gray-800 mt-4">Page Not Found</h2>
        <p className="text-gray-600 mt-2 mb-8">
          The page you're looking for doesn't exist.
        </p>
        <Link to="/" className="btn-primary inline-block">
          Go Back Home
        </Link>
      </div>
    </div>
  );
};
