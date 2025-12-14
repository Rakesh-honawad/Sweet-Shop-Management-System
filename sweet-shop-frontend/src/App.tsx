import React from 'react';
import './App.css';

function App() {
  return (
    <div className="min-h-screen bg-gradient-to-br from-pink-50 via-purple-50 to-blue-50">
      <div className="container mx-auto px-4 py-8">
        <div className="text-center">
          <h1 className="text-4xl font-bold text-gray-800 mb-4">
            🍬 Sweet Shop Management System
          </h1>
          <p className="text-gray-600 text-lg">
            Frontend setup complete! Ready to build amazing features.
          </p>
          <div className="mt-8 p-6 bg-white rounded-xl shadow-lg max-w-md mx-auto">
            <h2 className="text-2xl font-bold text-primary-600 mb-4">
              Setup Checklist ✅
            </h2>
            <ul className="text-left space-y-2 text-gray-700">
              <li>✅ React with TypeScript</li>
              <li>✅ Tailwind CSS configured</li>
              <li>✅ Axios for API calls</li>
              <li>✅ React Router installed</li>
              <li>✅ Testing libraries ready</li>
              <li>✅ Project structure created</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;