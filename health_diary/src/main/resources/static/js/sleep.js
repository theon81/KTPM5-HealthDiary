document.addEventListener('DOMContentLoaded', function() {
  flatpickr('.time-picker', {
      enableTime: true,
      noCalendar: true,
      dateFormat: 'H:i',
      time_24hr: true
  });

  document.getElementById('set-reminder').addEventListener('click', function() {
      const bedtime = document.getElementById('bedtime').value;

      if (bedtime) {
          const bedtimeParts = bedtime.split(':');
          const bedtimeHours = parseInt(bedtimeParts[0], 10);
          const bedtimeMinutes = parseInt(bedtimeParts[1], 10);

          const now = new Date();
          const bedtimeDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), bedtimeHours, bedtimeMinutes);

          if (bedtimeDate < now) {
              bedtimeDate.setDate(bedtimeDate.getDate() + 1);
          }

          const sleepCycles = calculateSleepCycles(bedtimeDate);
          displaySleepCycles(sleepCycles);

          document.getElementById('sleep-cycle-tab').style.display = 'block';
          void document.getElementById('sleep-cycle-tab').offsetWidth;
          document.getElementById('reminder-tab').classList.add('active');
          document.getElementById('sleep-cycle-tab').classList.add('active');

          setTimeout(() => {
              alert('Time to go to bed!');
          }, bedtimeDate.getTime() - now.getTime());

          document.getElementById('sleep-cycles').addEventListener('click', function(event) {
              if (event.target.tagName === 'LI') {
                  const wakeupTime = new Date(event.target.dataset.time);
                  setWakeupReminder(wakeupTime);
              }
          });
      } else {
          alert('Please set a bedtime.');
      }
  });

  function calculateSleepCycles(bedtimeDate) {
      const sleepCycles = [];
      const sleepCycleMinutes = 90;
      const fallAsleepMinutes = 14;

      for (let i = 1; i <= 6; i++) {
          const cycleTime = new Date(bedtimeDate.getTime() + (fallAsleepMinutes + sleepCycleMinutes * i) * 60000);
          sleepCycles.push(cycleTime);
      }

      return sleepCycles;
  }

  function displaySleepCycles(sleepCycles) {
      const sleepCyclesList = document.getElementById('sleep-cycles');
      sleepCyclesList.innerHTML = '';

      sleepCycles.forEach(cycle => {
          const listItem = document.createElement('li');
          listItem.textContent = cycle.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
          listItem.dataset.time = cycle;
          sleepCyclesList.appendChild(listItem);
      });
  }

  function setWakeupReminder(wakeupTime) {
      const now = new Date();
      setTimeout(() => {
          alert('Time to wake up!');
      }, wakeupTime.getTime() - now.getTime());
  }
});