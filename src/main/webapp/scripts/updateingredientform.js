const autofillValues = () => {
    document.getElementById('updateName').value = sessionStorage.getItem('name');
    document.getElementById('updateCategory').value = sessionStorage.getItem('category');
    document.getElementById('updateQuantity').value = sessionStorage.getItem('quantity');
    document.getElementById('updateThreshold').value = sessionStorage.getItem('threshold');
    document.getElementById('updateExpiryDate').value = sessionStorage.getItem('expirydate');
}

const updateIngredient = () => {
    let ingredientToUpdate = sessionStorage.getItem('id');

    let ingrName = document.getElementById('updateName').value;
    let ingrCategory = document.getElementById('updateCategory').value;
    let ingrQuantity = document.getElementById('updateQuantity').value;
    let ingrThreshold = document.getElementById('updateThreshold').value;
    let ingrExpiryDate = document.getElementById('updateExpiryDate').value;

    const ingrObject = {
        name: ingrName,
        category: ingrCategory,
        quantity: ingrQuantity,
        threshold: ingrThreshold,
        expiryDate: ingrExpiryDate,
    }


    makeRequest("PUT", "http://" + ipAddress + "/BakingInventory/api/ingredient/updateIngredient/" + ingredientToUpdate, JSON.stringify(ingrObject))
        .then((req) => {
            console.log(req.responseText);
            document.getElementById("message").innerText = "Ingredient " + ingredientToUpdate + " has been successfully updated!";
        })
        .catch((error) => { console.log(error.message) })

}

const backButtonHandler = () => {
    window.location.href = "ingredient.html";
}

