/** Project: Lab3
 * Purpose Details: Integrates with SQL, MongoDB, and Redis databases, along with blockchain functionality
 * Course: IST 242
 * Author: Charlie Defelice
 * Date Developed: 2/16/24
 * Last Date Changed: 2/18/24
 * Rev: 2.2
 */

package org.example;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select database:");
        System.out.println("1. MySQL");
        System.out.println("2. MongoDB");
        System.out.println("3. Redis");
        System.out.println("4. Blockchain");

        int choice = scanner.nextInt();
        switch (choice)
        {
            case 1:
                performMySQLCRUD();
                break;
            case 2:
                performMongoDBCRUD();
                break;
            case 3:
                performRedisCRUD();
                break;
            case 4:
                performBlockchain();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    //method for mySQL CRUD operations
    private static void performMySQLCRUD()
    {
        mySQLCRUD mySQLCRUD = new mySQLCRUD();
        mySQLCRUD.performCRUD();
    }

    //method for MongoDB CRUD operations
    private static void performMongoDBCRUD()
    {
        MongoDBCRUD mongoDBCRUD = new MongoDBCRUD();
        mongoDBCRUD.performCRUD();
    }

    //method for Redis CRUD operations
    private static void performRedisCRUD()
    {
        RedisCRUD redisCRUD = new RedisCRUD();
        redisCRUD.performCRUD();
    }

    //method for blockchain operations
    private static void performBlockchain()
    {
        SimpleBlockchain blockchain = new SimpleBlockchain();
        blockchain.addBlock("Transaction 1");
        blockchain.addBlock("Transaction 2");
        blockchain.addBlock("Transaction 3");
        blockchain.printBlockchain();
    }
}
