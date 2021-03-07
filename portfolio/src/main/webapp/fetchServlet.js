/** Fetches the answer from the server and adds it to the page. */
async function showFavoriteColors() {
  const responseFromServer = await fetch('/Favorite-Colors');
  const colors = await responseFromServer.json();
  console.log(colors);


  ColorsContainer.innerText = textFromResponse;
 
}