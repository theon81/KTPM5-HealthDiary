// ADD WATER
document.getElementById('add-water').addEventListener('click', () => {
    document.querySelector('.default-content').style.display = 'none';
    document.getElementById('amount-options').style.display = 'block';
    document.getElementById('cancel-btn').style.display = 'block';
});

document.querySelectorAll('.amount-btn').forEach(btn => {
    btn.addEventListener('click', function() {
        let amount = parseInt(this.getAttribute('data-amount'));
        addWater(amount);
        resetUI();
    });
});

document.getElementById('custom-btn').addEventListener('click', () => {
    document.getElementById('amount-options').style.display = 'none';
    document.getElementById('custom-amount-container').style.display = 'block';
    document.getElementById('add-custom-btn').style.display = 'block';
    document.getElementById('cancel-custom-btn').style.display = 'block';
});

document.getElementById('custom-amount').addEventListener('input', function() {
    let value = this.value;
    let addCustomBtn = document.getElementById('add-custom-btn');
    if (value && !isNaN(value)) {
        addCustomBtn.disabled = false;
    } else {
        addCustomBtn.disabled = true;
    }
});

document.getElementById('cancel-btn').addEventListener('click', resetUI);
document.getElementById('cancel-custom-btn').addEventListener('click', resetUI);

document.getElementById('add-custom-btn').addEventListener('click', confirmCustomAmount);

function confirmCustomAmount() {
    let amount = parseInt(document.getElementById('custom-amount').value);
    if (!isNaN(amount)) {
        addWater(amount);
        resetUI();
    }
}

function addWater(amount) {
    let currentAmount = parseInt(document.getElementById('current-amount').textContent);
    currentAmount += amount;
    document.getElementById('current-amount').textContent = currentAmount;

    updateProgress(currentAmount);
    resetReminder();
}

function resetUI() {
    document.getElementById('amount-options').style.display = 'none';
    document.getElementById('custom-amount-container').style.display = 'none';
    document.getElementById('cancel-btn').style.display = 'none';
    document.getElementById('add-custom-btn').style.display = 'none';
    document.getElementById('cancel-custom-btn').style.display = 'none';
    document.querySelector('.default-content').style.display = 'flex';
}

function resetReminder() {
    // Logic to reset the reminder timer
}

function updateProgress(currentAmount) {
    // Logic to update the progress bar or other UI elements
}

let waterGoal = 2000; // Default goal

function updateProgress(amount) {
    let goal = waterGoal; // Use dynamic goal
    let progress = Math.min((amount / goal) * 100, 100); // calculate progress percentage
    let progressPath = document.querySelector('.progress');
    let circumference = 2 * Math.PI * 31.831; // circumference of the circle
    let offset = circumference - (progress / 100) * circumference;

    if (amount === 0) {
        progressPath.style.display = 'none';
        progressPath.style.strokeDasharray = '0';
        progressPath.style.strokeDashoffset = '0';
    } else {
        progressPath.style.display = 'block';
        progressPath.style.strokeDasharray = `${circumference} ${circumference}`;
        progressPath.style.strokeDashoffset = offset;
    }
}


// GOAL & REMINDER

document.getElementById('goal-card').addEventListener('click', () => {
    showCardForm('goal-card');
});

document.getElementById('reminder-card').addEventListener('click', () => {
    showCardForm('reminder-card');
});

document.getElementById('confirm-goal').addEventListener('click', () => {
    let goal = parseInt(document.getElementById('goal-input').value);
    if (!isNaN(goal)) {
        setWaterGoal(goal);
        document.getElementById('goal-input').value = '';
        hideCardForm('goal-card');
    }
});

document.getElementById('cancel-goal').addEventListener('click', (event) => {
    event.stopPropagation();
    hideCardForm('goal-card');
});

document.getElementById('confirm-interval').addEventListener('click', () => {
    let interval = parseInt(document.getElementById('interval-input').value);
    if (!isNaN(interval)) {
        setReminderInterval(interval);
        resetUI();
    }
});

document.getElementById('cancel-interval').addEventListener('click', (event) => {
    event.stopPropagation();
    hideCardForm('reminder-card');
});

function showCardForm(cardId) {
    let card = document.getElementById(cardId);
    let form = card.querySelector('.card-form');
    form.style.display = 'flex';
}

function hideCardForm(cardId) {
    let card = document.getElementById(cardId);
    let form = card.querySelector('.card-form');
    form.style.display = 'none';
}

document.getElementById('cancel-goal').addEventListener('click', resetUI);

function setWaterGoal(goal) {
    waterGoal = goal; // Update the dynamic goal
    document.getElementById('current-goal').textContent = `${goal}ml`;
    // Update the progress bar with the current amount
    let currentAmount = parseInt(document.getElementById('current-amount').textContent);
    updateProgress(currentAmount);
}

document.getElementById('cancel-interval').addEventListener('click', resetUI);


function setReminderInterval(interval) {
    document.getElementById('current-interval').textContent = `${interval} minute${interval > 1 ? 's' : ''}`;
    // Additional logic to set the reminder interval can be added here
}

function addWater(amount) {
    let currentAmount = parseInt(document.getElementById('current-amount').textContent);
    currentAmount += amount;
    document.getElementById('current-amount').textContent = currentAmount;

    updateProgress(currentAmount);
    resetReminder();
}

function resetReminder() {
    // Logic to reset the reminder timer
}