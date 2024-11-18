
// la tabella si evidenzia col colore al passaggio del mouse
const table = document.querySelector('table');

table.addEventListener('mouseenter', function() {
    table.style.backgroundColor = '#f0f8ff';
});
//il colore si ripristina quando il mouse non è sulla tabella
table.addEventListener('mouseleave', function() {
    table.style.backgroundColor = '';
});
