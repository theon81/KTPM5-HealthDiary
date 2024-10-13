document.addEventListener('DOMContentLoaded', function() {
    const timeInput = document.getElementById('bedtime');
    const clockFill = document.querySelector('.clock-fill');

    // Initialize the input with the default ":"
    timeInput.value = "00:00";

    timeInput.addEventListener('input', function() {
        const time = timeInput.value.split(':');
        if (time.length === 2) {
            const hours = parseInt(time[0], 10);
            const minutes = parseInt(time[1], 10);

            if (!isNaN(hours) && !isNaN(minutes) && hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60) {
                const totalMinutes = hours * 60 + minutes;
                const percentage = totalMinutes / 1440; // 1440 minutes in a day
                const angle = percentage * 360;

                const largeArcFlag = angle > 180 ? 1 : 0;
                const endX = 50 + 45 * Math.cos((angle - 90) * Math.PI / 180);
                const endY = 50 + 45 * Math.sin((angle - 90) * Math.PI / 180);

                const pathData = `M 50 5 A 45 45 0 ${largeArcFlag} 1 ${endX} ${endY}`;
                clockFill.setAttribute('d', pathData);
            } else {
                clockFill.setAttribute('d', ''); // Clear the clock fill if the input is invalid
            }
        } else {
            clockFill.setAttribute('d', ''); // Clear the clock fill if the input is invalid
        }
    });

    // Restrict input to numbers and ":"
    timeInput.addEventListener('keydown', function(event) {
        const allowedKeys = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', 'Backspace', 'ArrowLeft', 'ArrowRight'];
        if (!allowedKeys.includes(event.key)) {
            event.preventDefault();
        }
    });

    // Ensure the input always has the ":" separator
    timeInput.addEventListener('blur', function() {
        const time = timeInput.value.split(':');
        if (time.length === 2) {
            let hours = parseInt(time[0], 10);
            let minutes = parseInt(time[1], 10);

            if (isNaN(hours) || hours < 0 || hours > 23) {
                hours = 0;
            }
            if (isNaN(minutes) || minutes < 0 || minutes > 59) {
                minutes = 0;
            }

            timeInput.value = `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}`;
        } else {
            timeInput.value = "00:00";
        }
    });
});