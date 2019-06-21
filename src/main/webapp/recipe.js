
const getRecipes = () => {
    // removes any existing tables
    const tableContainer = document.getElementById('recipeTable');
    if (tableContainer.rows.length > 1) {
        let tableSize = tableContainer.rows.length;
        for (i = tableSize; i > 1; i--) {
            tableContainer.deleteRow(i - 1);
        }
    }

    makeRequest("GET", "http://" + ipAddress + "/BakingInventory/api/recipe/getAllRecipes")
        .then((req) => {
            let data = JSON.parse(req.responseText);
            console.log(data);
            console.log(data[0].name);

            const tableContainer = document.getElementById('recipeTable');
            tableContainer.className = "table table-hover"; //bootstrap

            // creating table rows and adding data into the rows
            for (let i = 0; i < data.length; i++) {
                let aRow = document.createElement('tr')
                tableContainer.appendChild(aRow);

                let aRecipeId = document.createElement('td');
                aRecipeId.innerHTML = data[i].recipeId;
                let aName = document.createElement('td');
                aName.innerHTML = data[i].name;

                let changeName = document.createElement('td');
                let editName = document.createElement('input');
                editName.id = data[i].name + "text";
                editName.type = "text";
                
                let editButton = document.createElement('button');
                editButton.id = data[i].name;
                editButton.innerText = "Edit Recipe Name";

                editButton.addEventListener("click", buttonClick = () => {
                    document.getElementById('idRecipe').value =  aRecipeId.innerHTML;
                    document.getElementById('recipeName').value =  editName.value;
                    updateRecipe();
                });



                aRow.appendChild(aRecipeId);
                aRow.appendChild(aName);
                aRow.appendChild(editName);
                aRow.appendChild(editButton);
            }
        })
        .catch((error) => { console.log(error.message) });

}


const getRecipe = () => {
    let recipeToSearch = document.getElementById('idRecipe').value;

    // removes any existing tables
    const tableContainer = document.getElementById('recipeTable');
    if (tableContainer.rows.length > 1) {
        let tableSize = tableContainer.rows.length;
        for (i = tableSize; i > 1; i--) {
            tableContainer.deleteRow(i - 1);
        }
    }


    makeRequest("GET", "http://" + ipAddress + "/BakingInventory/api/recipe/getARecipe/" + recipeToSearch)
        .then((req) => {
            data = JSON.parse(req.responseText);
            console.log(data);
            console.log(data.name);
            const tableContainer = document.getElementById('recipeTable');
            ////
            tableContainer.className = "table table-hover";

            let aRow = document.createElement('tr');
            tableContainer.appendChild(aRow);

            let aRecipeId = document.createElement('td');
            aRecipeId.innerHTML = data.recipeId;
            let aName = document.createElement('td');
            aName.innerHTML = data.name;



            let changeName = document.createElement('td');
            let editName = document.createElement('input');
            editName.id = data.name + "text";
            editName.type = "text";
            
            let anEdit = document.createElement('td');
            let editButton = document.createElement('button');
            editButton.id = data.name;
            editButton.innerText = "Edit Recipe Name";

            editButton.addEventListener("click", buttonClick = () => {
                document.getElementById('idRecipe').value =  aRecipeId.innerHTML;
                document.getElementById('recipeName').value =  editName.value;
                updateRecipe();
            });

            aRow.appendChild(aRecipeId);
            aRow.appendChild(aName);
            aRow.appendChild(editName);
            aRow.appendChild(editButton);

        })
        .catch((error) => { console.log(error.message) });
}

const addRecipe = () => {
    let recipeName = document.getElementById('recipeName').value;

    const recipeObject = {
        name: recipeName,
    }

    let recipeJSON = JSON.stringify(recipeObject);

    makeRequest("POST", "http://" + ipAddress + "/BakingInventory/api/recipe/createRecipe", recipeJSON)
        .then((req) => {
            getRecipes();
            console.log(recipeJSON);
        })
        .catch((error) => { console.log(error.message) });

}

const removeRecipe = () => {
    let recipeToRemove = document.getElementById('idRecipe').value;
    makeRequest("DELETE", "http://" + ipAddress + "/BakingInventory/api/recipe/removeRecipe/" + recipeToRemove)
        .then((req) => {
            getRecipes();
            console.log(req.responseText);
        })
        .catch((error) => { console.log(error.message) })

}

const updateRecipe = () => {
    let recipeToUpdate = document.getElementById('idRecipe').value;

    let recipeName = document.getElementById('recipeName').value;

    const recipeObject = {
        name: recipeName,
    }

    console.log(JSON.stringify(recipeObject));
    makeRequest("PUT", "http://" + ipAddress + "/BakingInventory/api/recipe/updateRecipe/" + recipeToUpdate, JSON.stringify(recipeObject))
        .then((req) => {
            getRecipes();
            console.log(req.responseText);
        })
        .catch((error) => { console.log(error.message) })

}

getRecipes();