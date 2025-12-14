// src/components/layout/Header.tsx
import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../../hooks/useAuth';

export const Header: React.FC = () => {
  const { user, isAuthenticated, isAdmin, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  return (
    <header className="bg-white shadow-sm">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between items-center h-16">
          <Link to="/" className="flex items-center space-x-2">
            <span className="text-2xl">🍬</span>
            <span className="text-xl font-bold text-gray-800">Sweet Shop</span>
          </Link>

          <nav className="flex items-center space-x-6">
            <Link to="/" className="text-gray-700 hover:text-primary-600 font-medium">
              Home
            </Link>
            
            {isAuthenticated ? (
              <>
                {isAdmin && (
                  <Link to="/admin" className="text-gray-700 hover:text-primary-600 font-medium">
                    Admin Panel
                  </Link>
                )}
                
                <div className="flex items-center space-x-4 border-l border-gray-200 pl-6">
                  <span className="text-sm text-gray-600">
                    Welcome, <span className="font-medium text-gray-800">{user?.username}</span>
                    {isAdmin && (
                      <span className="ml-2 px-2 py-1 bg-primary-100 text-primary-700 text-xs rounded">
                        Admin
                      </span>
                    )}
                  </span>
                  <button
                    onClick={handleLogout}
                    className="text-sm text-gray-700 hover:text-red-600 font-medium"
                  >
                    Logout
                  </button>
                </div>
              </>
            ) : (
              <Link to="/login" className="btn-primary">
                Login
              </Link>
            )}
          </nav>
        </div>
      </div>
    </header>
  );
};
