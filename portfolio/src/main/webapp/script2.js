async function showHello(){
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.text();
    const helloContainer = document.getElementById('hello-container');
    helloContainer.innerText = textFromResponse;
}