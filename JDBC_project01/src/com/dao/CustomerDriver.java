package com.dao;

public class CustomerDriver {

    public static void main(String[] args) {

        CustomerDao dao = new CustomerDao();

        while (true) {

            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. Insert Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Show Customer");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(IO.readln("Enter Choice : "));

            try {

                switch (choice) {

                    case 1:

                        int id = Integer.parseInt(IO.readln("Enter Id : "));
                        String name = IO.readln("Enter Name : ");
                        String location = IO.readln("Enter Location : ");
                        int mob = Integer.parseInt(IO.readln("Enter Mobile Number : "));

                        dao.insertCustomer(id, name, location, mob);
                        break;

                    case 2:

                        int uid = Integer.parseInt(IO.readln("Enter Id : "));
                        String uname = IO.readln("Enter New Name : ");
                        String ulocation = IO.readln("Enter New Location : ");
                        int umob = Integer.parseInt(IO.readln("Enter New Mobile Number : "));

                        dao.updateCustomer(uid, uname, ulocation, umob);
                        break;

                    case 3:

                        int did = Integer.parseInt(IO.readln("Enter Id : "));
                        dao.deleteCustomer(did);
                        break;

                    case 4:

                        dao.fetchCustomer();
                        break;   

                    case 5:

                        System.out.println("Program Ended...");
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice");
                }

            } catch (Exception e) {

                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}