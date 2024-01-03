async function getResponse(){
    // Get the element from DIV
    const exchengeRatesElement = document.getElementById('exchangeRates');
    const apiUrl = 'https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e';

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

getResponse()
