
const getAllIngredients = () => {
    
    const tableContainer = document.getElementById('ingredientTable');
    if (tableContainer.rows.length > 1) {
        let tableSize = tableContainer.rows.length;
        for (let i = tableSize; i > 1; i--) {
            tableContainer.deleteRow(i - 1);
        }
    }
    makeRequest("GET", "http://" + ipAddress + "/BakingInventory/api/ingredient/getAllIngredients")
        .then((req) => {
            let data = JSON.parse(req.responseText);
           
            tableContainer.className = "table table-hover"; //bootstrap

            // creating table rows and adding data into the rows
            for (let j = 0; j < data.length; j++) {
                let aRow = document.createElement('tr')
                tableContainer.appendChild(aRow);

                let anIngredientId = document.createElement('td');
                anIngredientId.innerHTML = data[j].ingredientId;
                let aName = document.createElement('td');
                aName.innerHTML = data[j].name;
                let aCategory = document.createElement('td');
                aCategory.innerHTML = data[j].category;
                let aQuantity = document.createElement('td');
                aQuantity.innerHTML = data[j].quantity;
                let aThreshold = document.createElement('td');
                aThreshold.innerHTML = data[j].threshold;
                let anExpiryDate = document.createElement('td');
                anExpiryDate.innerHTML = data[j].expiryDate;

                
                let updateButton = document.createElement('button');

                updateButton.id = data[j].name;
                updateButton.innerText = "Update";

                updateButton.addEventListener("click", buttonClick = () => {
                    sessionStorage.setItem('id', anIngredientId.innerHTML);
                    sessionStorage.setItem('name', aName.innerHTML);
                    sessionStorage.setItem('category', aCategory.innerHTML);
                    sessionStorage.setItem('quantity', aQuantity.innerHTML);
                    sessionStorage.setItem('threshold', aThreshold.innerHTML);
                    sessionStorage.setItem('expirydate', anExpiryDate.innerHTML);

                    window.location.href = "updateingredientform.html";

                });



                aRow.appendChild(anIngredientId);
                aRow.appendChild(aName);
                aRow.appendChild(aCategory);
                aRow.appendChild(aQuantity);
                aRow.appendChild(aThreshold);
                aRow.appendChild(anExpiryDate);
                aRow.appendChild(updateButton);

            }
        })
        .catch((error) => { console.log(error.message) });

}


const getAnIngredient = () => {
    let ingredientToSearch = document.getElementById('idIngredient').value;

    // removes any existing tables
    const tableContainer = document.getElementById('ingredientTable');
    if (tableContainer.rows.length > 1) {
        let tableSize = tableContainer.rows.length;
        for (let i = tableSize; i > 1; i--) {
            tableContainer.deleteRow(i - 1);
        }
    }

    document.getElementById("aMessage").innerText.replace("");


    makeRequest("GET", "http://" + ipAddress + "/BakingInventory/api/ingredient/getAnIngredient/" + ingredientToSearch)
        .then((req) => {
            let data = JSON.parse(req.responseText);
         
            tableContainer.className = "table table-hover";

            let aRow = document.createElement('tr');
            tableContainer.appendChild(aRow);

            let anIngredientId = document.createElement('td');
            anIngredientId.innerHTML = data.ingredientId;
            let aName = document.createElement('td');
            aName.innerHTML = data.name;
            let aCategory = document.createElement('td');
            aCategory.innerHTML = data.category;
            let aQuantity = document.createElement('td');
            aQuantity.innerHTML = data.quantity;
            let aThreshold = document.createElement('td');
            aThreshold.innerHTML = data.threshold;
            let anExpiryDate = document.createElement('td');
            anExpiryDate.innerHTML = data.expiryDate;

            
            let updateButton = document.createElement('button');
            
            updateButton.id = data.name; 
            updateButton.innerText = "Update";

            updateButton.addEventListener("click", buttonClick = () => {
                sessionStorage.setItem('id', anIngredientId.innerHTML);
                sessionStorage.setItem('name', aName.innerHTML);
                sessionStorage.setItem('category', aCategory.innerHTML);
                sessionStorage.setItem('quantity', aQuantity.innerHTML);
                sessionStorage.setItem('threshold', aThreshold.innerHTML);
                sessionStorage.setItem('expirydate', anExpiryDate.innerHTML);

                window.location.href = "updateingredientform.html";

            });

            aRow.appendChild(anIngredientId);
            aRow.appendChild(aName);
            aRow.appendChild(aCategory);
            aRow.appendChild(aQuantity);
            aRow.appendChild(aThreshold);
            aRow.appendChild(anExpiryDate);
            aRow.appendChild(updateButton);

           
          
        })
        .catch((error) => { console.log(error.message) });


}

const addIngredient = () => {
    let ingrName = document.getElementById('ingrName').value;
    let ingrCategory = document.getElementById('ingrCategory').value;
    let ingrQuantity = document.getElementById('ingrQuantity').value;
    let ingrThreshold = document.getElementById('ingrThreshold').value;
    let ingrExpiryDate = document.getElementById('ingrExpiry').value;

    const ingrObject = {
        name: ingrName,
        category: ingrCategory,
        quantity: ingrQuantity,
        threshold: ingrThreshold,
        expiryDate: ingrExpiryDate,
    }

    let ingrJSON = JSON.stringify(ingrObject);

    makeRequest("POST", "http://" + ipAddress + "/BakingInventory/api/ingredient/addIngredient", ingrJSON)
        .then((req) => {
            getAllIngredients();
            console.log(ingrJSON);
            document.getElementById("aMessage").innerText = ingrName + " has been added";
        })
        .catch((error) => { console.log(error.message) });

}

const removeIngredient = () => {
    let ingredientToRemove = document.getElementById('idIngredient').value;
    makeRequest("DELETE", "http://" + ipAddress + "/BakingInventory/api/ingredient/removeIngredient/" + ingredientToRemove)
        .then((req) => {
            getAllIngredients();
            console.log(req.responseText);
        })
        .catch((error) => { console.log(error.message) })

}


getAllIngredients();

