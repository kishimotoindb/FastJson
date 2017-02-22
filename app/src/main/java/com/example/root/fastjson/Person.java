package com.example.root.fastjson;

/**
 * Created by haichen.cui on 17-1-6.
 */

public class Person {
    private String name;
    private int age;
    private Other other;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.other = new Other("beijing","126");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    class Other {
        public String address;
        public String phone;

        public Other() {

        }

        public Other(String address, String phone) {
            this.address = address;
            this.phone = phone;
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

        @Override
        public String toString() {
            return "Other{" +
                    "address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
}
