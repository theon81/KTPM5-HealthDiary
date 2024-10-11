package com.project.health_diary.model;



public class OtherUser extends User {
    private int limit;

    // Constructor mặc định
    public OtherUser() {
        super(); // Gọi constructor của lớp cha (User)
        this.limit = 1; // Giới hạn mặc định là 1
    }

    // Constructor có tham số
    public OtherUser(String ID, String Roles, String Username, String Password, int limit) {
        super(ID, Roles, Username, Password); // Gọi constructor của lớp cha (User)
        this.setLimit(limit);
    }

    // Getter và Setter cho limit
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    // Phương thức để kiểm tra giới hạn
    public void checkLimit() {
        if (limit > 0) {
            System.out.println("Bạn vẫn còn " + limit + " lượt sử dụng.");
        } else {
            System.out.println("Bạn đã hết lượt sử dụng.");
        }
    }

    // Phương thức để giảm giới hạn khi thực hiện một hành động
    public void useLimit() {
        if (limit > 0) {
            limit--;
            System.out.println("Bạn đã sử dụng 1 lượt. Còn lại: " + limit + " lượt.");
        } else {
            System.out.println("Không thể sử dụng vì bạn đã hết lượt.");
        }
    }

    public String getIF(){
        String info;
        info = this.getID() + "<ot>" + this.getUsername() + "<ot>";
        return info;
    }
    // Ghi đè phương thức viewProfile từ lớp User
    // @Override
    // public void viewProfile() {
    //     if (this.getLimit() > 0) {
    //         super.viewProfile(); // Gọi phương thức của lớp cha
    //     } else {
    //         System.out.println("Không thể xem thông tin cá nhân vì bạn đã hết lượt.");
    //     }
    // }
}
