"use strict";

const ADDR = "http://localhost:8080";

// Divs
const RESULTS_DIV = document.querySelector("#results-div");
const FORM_DIV = document.querySelector("#form-div");

// Buttons
const CREATE_BTN = document.querySelector("#create-btn");

// Inputs
const FNAME = document.querySelector(".fname-input");
const LNAME = document.querySelector(".lname-input");
const UNAME = document.querySelector(".uname-input");

// Get request
const getAll = () => {
    axios.get(`${ADDR}/user/getAll`)
        .then((resp) => {

            RESULTS_DIV.innerHTML = "";
            const RESULTS = resp.data;

            for (let result of RESULTS) {
                printResult(result);
            }

        }).catch((err) => console.error(err))
}

// Post request
const create = () => {
    
}

// Put request
const update = () => {
    
}

// Delete request
const del = (id) => {
    
}

const statusMsg = (bool) => {

}

const printResult = (result) => {

    const ENTRY_DIV = document.createElement("div");
    ENTRY_DIV.setAttribute("class", "entry-div");

    const ENTRY = document.createElement("div");
    ENTRY.setAttribute("class", "entry");

    const VALUES = document.createElement("div");
    VALUES.setAttribute("class", "entry-values");
    VALUES.textContent = `${result.firstName} | ${result.lastName} | ${result.username}`;
    
    const EDIT = document.createElement("button");
    EDIT.type = "button";
    EDIT.textContent = "Edit";
    EDIT.id = `${result.id}`;
    EDIT.setAttribute("class", "btn btn-sm btn-primary edit-btn");
    EDIT.setAttribute("onClick", "openEdit(this.id)");

    const DEL = document.createElement("button");
    DEL.type = "button";
    DEL.textContent = "Delete";
    DEL.id = `${result.id}`;
    DEL.setAttribute("class", "btn btn-sm btn-danger del-btn");
    DEL.setAttribute("onClick", "del(this.id)");

    ENTRY.appendChild(VALUES);
    ENTRY_DIV.appendChild(ENTRY);

    // ENTRY_DIV.appendChild(EDIT);
    // ENTRY_DIV.appendChild(DEL);

    RESULTS_DIV.appendChild(ENTRY_DIV);
}

const validateForm = (type) => {

}

const openEdit = (id) => {
    // Show modal and configure date field
    $("#edit-modal").modal("show");

    // Get the current values for selected entry
    axios.get(`${ADDR}/user/getById/${id}`)
        .then((resp) => {
            const ENTRY = resp.data;
            // Populate modal form with current values
            const EDIT_FORM = document.forms["editForm"];
            EDIT_FORM["fname"].value = ENTRY.firstName;
            EDIT_FORM["lname"].value = ENTRY.lastName;
            EDIT_FORM["username"].value = ENTRY.username;
            EDIT_FORM["entry-id"].value = ENTRY.id;
        }).catch((err) => console.error(err))
}