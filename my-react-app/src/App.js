import React from 'react';
import Details from './components/DetailsRate.js';
import ExchangeRates from './components/ExchangeRates';

import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
    return (
        // Router component to define routes
        <Router>
            <div>
                <Routes>
                    <Route path="/details" element={<Details />} />
                    <Route path="/" element={<ExchangeRates />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
