console.log("init... JS");

(function (){

    const divContainer = document.getElementById('container');
    const h1 = document.createElement('h1')
    h1.setAttribute('class', 'home-header')
    h1.setAttribute('id', 'header')
    h1.textContent = 'Hello Lunar!'
    divContainer.appendChild(h1);
})();