let timeout; // Biến lưu timeout
const nav = document.querySelector('nav'); // Chọn thanh điều hướng

function hideNav() {
    nav.classList.add('hidden'); // Thêm class để ẩn thanh điều hướng
}

function showNav() {
    nav.classList.remove('hidden'); // Bỏ class để hiện thanh điều hướng
    resetTimeout(); // Đặt lại timeout
}

function resetTimeout() {
    clearTimeout(timeout); // Xóa timeout cũ
    timeout = setTimeout(hideNav, 8000); // Đặt timeout mới sau 8 giây
}

// Thiết lập sự kiện cho việc di chuột vào thanh điều hướng
nav.addEventListener('mouseover', showNav);
// Reset timeout khi người dùng di chuột vào bất kỳ đâu trên trang
document.addEventListener('mousemove', resetTimeout);

// Khởi động timeout khi trang được tải
resetTimeout();

