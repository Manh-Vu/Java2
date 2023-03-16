package model;

public class Students implements Comparable<Students> {
    private String id,full_name,address,email,year,phone;
    private int gender;
    private double gpa;

    public Students() {
    }

    public Students(String id, String full_name,int gender, String year,String address, String email, String phone, double gpa) {
        this.id = id;
        this.full_name = full_name;
        this.address = address;
        this.email = email;
        this.year = year;
        this.gender = gender;
        this.phone = phone;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public int getGender() {
        return gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getYear() {
        return year;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", year='" + year + '\'' +
                ", gender=" + gender +
                ", phone=" + phone +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        if(this.gpa > o.gpa){
            return 1;
        }
        else if(this.gpa < o.gpa){
            return  -1;
        }
        return 0;
    }

}
