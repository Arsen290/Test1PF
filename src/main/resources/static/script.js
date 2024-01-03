async function getResponse(){
    const exchengeRatesElement = document.getElementById('exchangeRates');
    const apiUrl = 'https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e';

    try{
        const response = await fetch(apiUrl); // Get the response from the API endpoint.
        const data = await response.json(); // Get the data from the response as JSON
        console.log(data); // Log the data to the console

        // Create a list of the currencies
        const ul = document.createElement('ul');
        data.forEach(rate => {
            const li = document.createElement('li');
            li.textContent = `${rate.shortName} - ${rate.valMid}`;
            ul.appendChild(li);
        });

        // Очистить контейнер и добавить новый список
        exchengeRatesElement.innerHTML = '';
        exchengeRatesElement.appendChild(ul);
    }
    catch(error){
        console.error(error);
    }
}

getResponse()
