// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random fact to the page.
 */
function addRandomFact() {
  const facts =[
    'I measure about 5 feet 10 inches!',

    'I am really good at MarioKart and Just Dance!',

    'Some of my favorite movies are Now You See Me and Ratatouille!',

    'I have a 6 month Cane Corso named Mamba!',

    'I am allergic to cats:(!',
    
    'One of my favorite shows is Hells Kitchen!'];

  // Pick a random fact.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

/** Fetches info from the server and adds them to the DOM. */
function loadTasks() {
  fetch('/list-info').then(response => response.json()).then((forms) => {
    const formListElement = document.getElementById('form-list');
    tasks.forEach((form) => {
      formListElement.appendChild(createFormElement(form));
    })
  });
}

/** Creates an element that represents a task, including its delete button. */
function createFormElement(form) {
  const formElement = document.createElement('li');
  formElement.className = 'Form';

  const titleElement = document.createElement('span');
  emailElement.innerText = form.email;

  formElement.appendChild(emailElement);
  return formElement;

}

/** Tells the server to delete the task. */
//function deleteTask(form) {
//  const params = new URLSearchParams();
 // params.append('id', task.id);
 // fetch('/delete-task', {method: 'POST', body: params});
//}