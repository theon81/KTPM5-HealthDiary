document.addEventListener('DOMContentLoaded', function() {
    flatpickr('.time-picker', {
      enableTime: true,
      noCalendar: true,
      dateFormat: 'H:i',
      time_24hr: true
    });
  
    document.getElementById('set-reminder').addEventListener('click', function() {
      const bedtime = document.getElementById('bedtime').value;
      const waketime = document.getElementById('waketime').value;
  
      if (bedtime && waketime) {
        const bedtimeParts = bedtime.split(':');
        const waketimeParts = waketime.split(':');
  
        const bedtimeHours = parseInt(bedtimeParts[0], 10);
        const bedtimeMinutes = parseInt(bedtimeParts[1], 10);
  
        const waketimeHours = parseInt(waketimeParts[0], 10);
        const waketimeMinutes = parseInt(waketimeParts[1], 10);
  
        const now = new Date();
        const bedtimeDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), bedtimeHours, bedtimeMinutes);
        const waketimeDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), waketimeHours, waketimeMinutes);
  
        if (bedtimeDate < now) {
          bedtimeDate.setDate(bedtimeDate.getDate() + 1);
        }
        if (waketimeDate < now) {
          waketimeDate.setDate(waketimeDate.getDate() + 1);
        }
  
        const bedtimeTimeout = bedtimeDate.getTime() - now.getTime();
        const waketimeTimeout = waketimeDate.getTime() - now.getTime();
  
        setTimeout(() => {
          alert('Time to go to bed!');
        }, bedtimeTimeout);
  
        setTimeout(() => {
          alert('Time to wake up!');
        }, waketimeTimeout);
  
        alert('Reminders set successfully!');
      } else {
        alert('Please set both bedtime and wake time.');
      }
    });
  });