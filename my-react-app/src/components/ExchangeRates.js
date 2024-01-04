// src/components/ExchangeRates.js
//*useEffect* is a React hook that runs after the first render of the component.
//*useEffect* hook takes a callback function as an argument.
import React, { useEffect, useState } from 'react';

const ExchangeRates = () => {
    const [exchangeRates, setExchangeRates] = useState([]);
    //useEffect hook takes a callback function as an argument.
    useEffect(() => {
        getAllCurrencyExchangeRates();
    }, []);

    const getAllCurrencyExchangeRates = async () => {
        const apiUrl = 'http://localhost:8080/api/v1/ratecards?useDb=true';

        try {
            const response = await fetch(apiUrl);
            const data = await response.json();
            setExchangeRates(data);
        } catch (error) {
            console.error(error);
        }
    };
    //Render the list of currencies
    return (
        <div>
            <h1>Currency Exchange Rates</h1>
            <div>
                {exchangeRates.map((rate) => (
                    <p key={rate.shortName}>{`${rate.shortName} - ${rate.valMid}`}</p>
                ))}
            </div>
        </div>
    );
};

export default ExchangeRates;