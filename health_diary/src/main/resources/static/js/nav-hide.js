document.querySelectorAll('a').forEach(anchor => {
    anchor.addEventListener('mouseover', function(event) {
        event.preventDefault();
    });

    anchor.addEventListener('mouseout', function(event) {
        event.preventDefault();
    });

    anchor.addEventListener('click', function(event) {
        window.location.href = this.href;
    });
});