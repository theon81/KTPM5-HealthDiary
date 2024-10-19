// ADD WATER
document.getElementById('add-water').addEventListener('click', () => {
    document.querySelector('.default-content').style.display = 'none';
    document.getElementById('amount-options').style.display = 'flex';
    document.getElementById('cancel-btn').style.display = 'block';
});

document.getElementById('cancel-btn').addEventListener('click', () => {
    document.querySelector('.default-content').style.display = 'flex';
    document.getElementById('amount-options').style.display = 'none';
    document.getElementById('custom-amount-container').style.display = 'none';
    document.getElementById('cancel-btn').style.display = 'none';
});

document.querySelectorAll('.amount-btn').forEach(button => {
    button.addEventListener('click', (event) => {
        let amount = parseInt(event.target.getAttribute('data-amount'));
        addWater(amount);
        document.querySelector('.default-content').style.display = 'flex';
        document.getElementById('amount-options').style.display = 'none';
        document.getElementById('cancel-btn').style.display = 'none';
    });
});

document.getElementById('custom-btn').addEventListener('click', () => {
    document.getElementById('amount-options').style.display = 'none';
    document.getElementById('custom-amount-container').style.display = 'flex';
});

document.getElementById('confirm-custom-amount').addEventListener('click', () => {
    confirmCustomAmount();
    document.querySelector('.default-content').style.display = 'flex';
    document.getElementById('custom-amount-container').style.display = 'none';
    document.getElementById('cancel-btn').style.display = 'none';
});

function confirmCustomAmount() {
    let amount = parseInt(document.getElementById('custom-amount').value);
    if (!isNaN(amount)) {
        addWater(amount);
        document.getElementById('custom-amount').value = '';
    }
}

function addWater(amount) {
    let currentAmount = parseInt(document.getElementById('current-amount').textContent);
    currentAmount += amount;
    document.getElementById('current-amount').textContent = currentAmount;

    updateProgress(currentAmount);
}

function updateProgress(amount) {
    let goal = 2000; // luong nuoc dat boi nguoi dung, mac dinh la 2000ml
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
        document.getElementById('interval-input').value = '';
        hideCardForm('reminder-card');
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

function setWaterGoal(goal) {
    document.getElementById('current-goal').textContent = `${goal}ml`;
    // Additional logic to save the goal can be added here
}

function setReminderInterval(interval) {
    document.getElementById('current-interval').textContent = `${interval} hour${interval > 1 ? 's' : ''}`;
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