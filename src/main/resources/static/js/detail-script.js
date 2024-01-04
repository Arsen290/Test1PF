// Event listener for form submission
document.getElementById('shortnameForm').addEventListener('submit', function (event) {
    // Prevent the default form submission behavior, which would cause a page reload
    event.preventDefault();
    const shortNameInput = document.getElementById('shortNameInput').value;
    getDetailRate(shortNameInput);
});

async function getDetailRate(shortName){
    // Get the element from DIV
    const exchengeRatesElement = document.getElementById('detailsRate');
    const apiUrl = 'http://localhost:8080/api/v1/ratecards?useDb=true';

    try{
        // Get the response from the API endpoint.
        const response = await fetch(apiUrl);
        // Get the data from the response as JSON
        const data = await response.json();
        // Log the data to the console to control
        console.log(data);

        // Find the currency by its shortName
        const currency = data.find(rate => rate.shortName === shortName);

        //Create a list of the currencies
        if (currency) {
                    exchengeRatesElement.innerHTML = `
                        <h2>${currency.name} (${currency.shortName})</h2>
                        <p>Country: ${currency.country}</p>
                        <p>Move: ${currency.move}</p>
                        <p>Amount: ${currency.amount}</p>
                        <p>Value buy: ${currency.valBuy}</p>
                        <p>Value sell: ${currency.valSell}</p>
                        <p>Middle value: ${currency.valMid}</p>
                        <p>Currency buy: ${currency.currBuy}</p>
                        <p>Currency sell: ${currency.currSell}</p>
                        <p>Currency mid: ${currency.currMid}</p>
                        <p>Version: ${currency.version}</p>
                        <p>CNB Mid: ${currency.cnbMid}</p>
                        <p>ECB Mid: ${currency.ecbMid}</p>
                        <p>Date: ${currency.validFrom}</p>
                    `;
                } else {
                    exchengeRatesElement.innerHTML = 'Currency not found.';
                }
    }
    catch(error){
        console.error(error);
    }
}

getDetailRate(shortnameValue);