const next = document.getElementById("button-next");
const prev = document.getElementById("button-prev");

next.addEventListener('click', () =>{
    const items = document.querySelectorAll(".slide-item");
    document.querySelector("#slide").appendChild(items[0]);
},);

prev.addEventListener('click', () => {
    const items = document.querySelectorAll(".slide-item");
    document.querySelector("#slide").prepend(items[items.length-1]);
},);