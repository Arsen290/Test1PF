// src/App.js
import React from 'react';
import Details from './components/DetailsRate.js';
import ExchangeRates from './components/ExchangeRates';


function App() {
  return (
      <div>
        <ExchangeRates />
        <Details />
      </div>
  );
}

export default App;
