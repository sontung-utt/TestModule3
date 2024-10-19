package model;

public class Room {
    private int id;
    private String customerName;
    private String phone;
    private String time;
    private int idPayment;
    private String note;
    private String namePayment;

    public Room() {
    }

    public Room(String customerName, String phone, String time, int idPayment, String note) {
        this.customerName = customerName;
        this.phone = phone;
        this.time = time;
        this.idPayment = idPayment;
        this.note = note;
    }

    public Room(int id, String customerName, String phone, String time, int idPayment, String note) {
        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
        this.time = time;
        this.idPayment = idPayment;
        this.note = note;
    }

    public Room(String customerName, String phone, int idPayment, String note) {
        this.customerName = customerName;
        this.phone = phone;
        this.idPayment = idPayment;
        this.note = note;
    }

    public Room(int id,String customerName, String phone, int idPayment, String note) {
        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
        this.idPayment = idPayment;
        this.note = note;
    }

    public Room(int id, String customerName, String phone, String time, int idPayment, String note, String namePayment) {
        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
        this.time = time;
        this.idPayment = idPayment;
        this.note = note;
        this.namePayment = namePayment;
    }

    public String getNamePayment() {
        return namePayment;
    }

    public void setNamePayment(String namePayment) {
        this.namePayment = namePayment;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
