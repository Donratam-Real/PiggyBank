package com.learning;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<PiggyBank> piggyBanks = new ArrayList<>();
        // Add initial piggy banks
        piggyBanks.add(new PiggyBank("น้องพอใจ"));
        piggyBanks.add(new PiggyBank("น้องพอเพียง"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- เมนูหลัก ---");
            System.out.println("1. สร้างกระปุกออมสินใหม่");
            System.out.println("2. จัดการกระปุกออมสิน");
            System.out.println("3. ออกจากโปรแกรม");
            System.out.print("กรุณาเลือก (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("กรุณากรอกชื่อเจ้าของกระปุกออมสินใหม่: ");
                    String ownerName = scanner.nextLine();
                    piggyBanks.add(new PiggyBank(ownerName));
                    System.out.println("สร้างกระปุกออมสินสำหรับ '" + ownerName + "' เรียบร้อยแล้ว!");
                    break;
                case 2:
                    if (piggyBanks.isEmpty()) {
                        System.out.println("ยังไม่มีกระปุกออมสิน กรุณาสร้างก่อน");
                        break;
                    }
                    System.out.println("\n--- เลือกกระปุกออมสิน ---");
                    for (int i = 0; i < piggyBanks.size(); i++) {
                        System.out.println((i + 1) + ". " + piggyBanks.get(i).ownerName);
                    }
                    System.out.print("กรุณาเลือกกระปุกออมสิน: ");
                    int bankChoice = scanner.nextInt();
                    if (bankChoice > 0 && bankChoice <= piggyBanks.size()) {
                        handlePiggyBank(piggyBanks.get(bankChoice - 1), scanner);
                    } else {
                        System.out.println("ตัวเลือกไม่ถูกต้อง");
                    }
                    break;
                case 3:
                    System.out.println("กำลังออกจากโปรแกรม...");
                    break;
                default:
                    System.out.println("ตัวเลือกไม่ถูกต้อง กรุณาลองใหม่อีกครั้ง");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void handlePiggyBank(PiggyBank piggyBank, Scanner scanner) {
        int action;
        do {
            System.out.println("\n--- จัดการกระปุกออมสินของ " + piggyBank.ownerName + " ---");
            System.out.println("1. ฝากเงิน");
            System.out.println("2. แสดงยอดเงินคงเหลือ");
            System.out.println("3. กลับไปเมนูหลัก");
            System.out.print("กรุณาเลือก (1-3): ");
            action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.print("กรุณากรอกจำนวนเงินที่จะฝาก: ");
                    double amount = scanner.nextDouble();
                    piggyBank.addMoney(amount);
                    piggyBank.showMoney();
                    break;
                case 2:
                    piggyBank.showMoney();
                    break;
                case 3:
                    System.out.println("กลับไปเมนูหลัก...");
                    break;
                default:
                    System.out.println("ตัวเลือกไม่ถูกต้อง กรุณาลองใหม่อีกครั้ง");
            }
        } while (action != 3);
    }
}
