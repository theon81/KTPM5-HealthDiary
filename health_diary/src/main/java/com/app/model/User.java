package com.app.model;
public class User {
    private String ID;
    private String Roles;
    private String Username;
    private String Password;
    private boolean statusLogin = false;

    public User() {
    }

    public User(String ID, String Roles, String Username, String Password) {
        this.setID(ID);
        this.setRoles(Roles);
        this.setUsername(Username);
        this.setPassword(Password);
    }

    
    public String getID() {
        return ID;
    }
    
    public String getRoles() {
        return Roles;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void setRoles(String Roles) {
        this.Roles = Roles;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    public void login (String Username, String Password){
        if (this.getUsername().equals(Username)&& this.getPassword().equals(Password)){
            statusLogin = true;
            System.out.println("Đăng nhập thành công");
        }
        else{
            System.out.println("Thông tin đăng nhập không chính xác!");
        }
    }
    public void logout(){
        if (statusLogin = true){
            statusLogin = false;
            System.out.println("Bạn đã đăng xuất");
        }
        else{
            System.out.println("Bạn chưa đăng nhập!");
        }
    }
    public String viewProfile(){
        if(statusLogin = true){
            String Info;
            Info = this.getID() + "</acc>" + this.getUsername() + "</acc>" + this.getRoles();
            return Info;
        }
        return "";
    }
    public static void main(String[] args) {
        User user = new User();
        
        user.setID("001");
        user.setRoles("Admin");
        user.setUsername("user1");
        user.setPassword("pass123");

        System.out.println("---- Kiểm tra đăng nhập thành công ----");
        user.login("user1", "pass123");  
        user.viewProfile();

        System.out.println("---- Kiểm tra đăng nhập thất bại ----");
        user.login("user1", "wrongpass");  
        user.viewProfile();

        System.out.println("---- Kiểm tra đăng xuất ----");
        user.logout();
        user.viewProfile();
    }
}


