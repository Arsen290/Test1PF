// Find the element by its ID
var myElement = document.getElementById('detailsRate');

// Check if the element is found
if (myElement) {
    // Get the value of the 'th:value' attribute
    var shortnameValue = myElement.getAttribute('value');
    console.log('Value attr th:value:', shortnameValue);
} else {
    console.log('Element not found.');
}