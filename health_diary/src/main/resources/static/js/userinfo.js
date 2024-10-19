document.addEventListener('DOMContentLoaded', function() {

    fetch('/get-reminder')
        .then(response => response.text())
        .then(data => {
            document.querySelector('.time-number').textContent = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
