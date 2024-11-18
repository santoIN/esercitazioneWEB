// Attende il caricamento della pagina
document.addEventListener('DOMContentLoaded', function() {

    // benvenuto
    alert("Benvenuto alla pagina di Alessandro Del Piero!");

    // ingradisce l'immagine quando passi col cursore su di essa
    const images = document.querySelectorAll('img');
    images.forEach((img) => {
        img.addEventListener('mouseover', () => {
            img.style.transform = "scale(1.05)";
            img.style.transition = "transform 0.3s ease";
        });

        img.addEventListener('mouseout', () => {
            img.style.transform = "scale(1)";
        });
    });

    // torna su button proporzioni e stile
    const topButton = document.createElement('button');
    topButton.textContent = "Torna Su";
    topButton.style.position = "fixed";
    topButton.style.bottom = "20px";
    topButton.style.right = "20px";
    topButton.style.padding = "10px 15px";
    topButton.style.backgroundColor = "#007bff";
    topButton.style.color = "#fff";
    topButton.style.border = "none";
    topButton.style.borderRadius = "5px";
    topButton.style.cursor = "pointer";
    topButton.style.display = "none";
    document.body.appendChild(topButton);

    // scroll
    window.addEventListener('scroll', () => {
        if (window.scrollY > 300) {
            topButton.style.display = "block";
        } else {
            topButton.style.display = "none";
        }
    });

    // torna su Button
    topButton.addEventListener('click', () => {
        window.scrollTo({ top: 0, behavior: 'smooth' });
    });
});
