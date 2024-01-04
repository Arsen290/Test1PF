// File: src/components/DetailsRate.js
import React, { useState } from 'react';

const Details = () => {
    // State to store the shortName input value
    const [shortNameInput, setShortNameInput] = useState('');
    // State to store the currency details
    const [currencyDetails, setCurrencyDetails] = useState(null);

    // Function to handle form submission
    const handleFormSubmit = async (event) => {
        event.preventDefault();
        await getDetailRate(shortNameInput);
    };

    // Function to fetch currency details
    const getDetailRate = async (shortName) => {
        // API URL for fetching details from the Spring Boot backend
        const apiUrl = `http://localhost:8080/api/v1/ratecards?useDb=true`;

        try {
            // Fetch data from the API
            const response = await fetch(apiUrl);
            // Parse response data as JSON
            const data = await response.json();

            // Find the currency by its shortName
            const currency = data.find((rate) => rate.shortName === shortName);

            // Update currencyDetails state
            setCurrencyDetails(currency);
        } catch (error) {
            console.error(error);
        }
    };

    // Render component content
    return (
        <div>
            <h1>Exchange Rate Detail</h1>
            {/* Form for user input */}
            <form onSubmit={handleFormSubmit}>
                <label htmlFor="shortNameInput">Enter Shortname:</label>
                <input
                    type="text"
                    id="shortNameInput"
                    value={shortNameInput}
                    onChange={(e) => setShortNameInput(e.target.value)}
                />
                <button type="submit">Get Details</button>
            </form>
            {/* Container to display the exchange rate details */}
            <div id="detailsRate">
                {currencyDetails && (
                    <>
                        <h2>{`${currencyDetails.name} (${currencyDetails.shortName})`}</h2>
                        <p>Country: {currencyDetails.country}</p>
                        <p>Move: {currencyDetails.move}</p>
                        <p>Amount: {currencyDetails.amount}</p>
                        <p>Value buy: {currencyDetails.valBuy}</p>
                        <p>Value sell: {currencyDetails.valSell}</p>
                        <p>Middle value: {currencyDetails.valMid}</p>
                        <p>Currency buy: {currencyDetails.currBuy}</p>
                        <p>Currency sell: {currencyDetails.currSell}</p>
                        <p>Currency mid: {currencyDetails.currMid}</p>
                        <p>Version: {currencyDetails.version}</p>
                        <p>CNB Mid: {currencyDetails.cnbMid}</p>
                        <p>ECB Mid: {currencyDetails.ecbMid}</p>
                        <p>Date: {currencyDetails.validFrom}</p>
                    </>
                )}
                {!currencyDetails && <p>Currency not found.</p>}
            </div>
        </div>
    );
}
export default Details;
