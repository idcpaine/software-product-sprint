async function showHello(){
    const responseFromServer = await fetch('/hello');
    const jsonFromResponse = await responseFromServer.json();
    const helloContainer = document.getElementById('hello-container');
    const quote = jsonFromResponse[Math.floor(Math.random() * jsonFromResponse.length)];
    // helloContainer.innerText = jsonFromResponse[2];
    helloContainer.innerText = quote;

    // const textFromResponse = await responseFromServer.text();
    // const helloContainer = document.getElementById('hello-container');
    // helloContainer.innerText = textFromResponse;
}