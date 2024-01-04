//func after reload page
window.onload = function () {
    getAllCurrencyExchangeRates();
};
async function getAllCurrencyExchangeRates(){
    // Get the element from DIV
    const exchengeRatesElement = document.getElementById('exchangeRates');
    const apiUrl = 'http://localhost:8080/api/v1/ratecards?useDb=true ';

    try{
        // Get the response from the API endpoint.
        const response = await fetch(apiUrl);
        // Get the data from the response as JSON
        const data = await response.json();
        // Log the data to the console to control
        console.log(data);

        // Create a list of the currencies
        const ul = document.createElement('ul');
        // Iterate the data and create a list item for each currency
        // Use Promise.all to wait for all promises to be finalized.
        await Promise.all(data.map(async (rate) => {
            const li = document.createElement('li');
            li.textContent = `${rate.shortName} - ${rate.valMid}`;
            ul.appendChild(li);
        }));

        // Append the currencies to the DOM
        exchengeRatesElement.innerHTML = '';
        exchengeRatesElement.appendChild(ul);
    }
    catch(error){
        console.error(error);
    }
}


