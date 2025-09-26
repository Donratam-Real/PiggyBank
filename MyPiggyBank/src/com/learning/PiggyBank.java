package com.learning;

public class PiggyBank {

    String ownerName;
    double money;

    public PiggyBank(String ownerName) {
        this.ownerName = ownerName;
        this.money = 0.0;
    }

    public void addMoney(double amount) {
        this.money += amount;
        System.out.println("เพิ่มเงินจำนวน " + amount + " ให้กับกระปุกออมสินของ " + this.ownerName);
    }

    public void showMoney() {
        System.out.println("กระปุกออมสินของ " + this.ownerName + " มีเงินทั้งหมด " + this.money + " บาท");
    }
}
