package cn.ccnu.wpy.pojo;

public class Receiver {
    private int id;
    private String name;
    private String province;
    private String city;
    private String country;
    private String address;
    private String phone;
    private String postcode;
    private String street;
    private int userId;

    public Receiver(){}
    public Receiver(int id, String name, String province, String city, String country, String address, String phone, String postcode, String street, int userId) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.city = city;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.postcode = postcode;
        this.street = street;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
