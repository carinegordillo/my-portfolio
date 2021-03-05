/** Fetches the answer from the server and adds it to the page. */
async function showJokeAnswer() {
  const responseFromServer = await fetch('/Golf-Joke');
  const textFromResponse = await responseFromServer.text();

  const dateContainer = document.getElementById('golf-joke');
  dateContainer.innerText = textFromResponse;
}