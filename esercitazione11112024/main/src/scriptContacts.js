// messaggio di conferma quando l'utente preme invio
document.addEventListener('DOMContentLoaded', function() {

    // Seleziona gli elementi dove andremo ad aggiungere le funzionalità
    const form = document.querySelector('form');
    const inputs = form.querySelectorAll('input, textarea');

    // label evidenziata quando la selezioniamo
    inputs.forEach(input => {
        input.addEventListener('focus', () => {
            input.style.backgroundColor = '#f0f8ff';
        });
        input.addEventListener('blur', () => {
            input.style.backgroundColor = '';
        });
    });

    // Mostra un messaggio di conferma dopo l'invio
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // caso default
        alert('Grazie per averci contattato! Il tuo messaggio è stato inviato con successo.');
        form.reset(); // Pulisce il modulo dopo l'invio
    });
});
