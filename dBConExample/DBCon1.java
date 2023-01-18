package dBConExample;

import java.sql.*;
import java.util.Scanner;

public class DBCon1 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		try (sc1) {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##batch111",
					"shivam");
			PreparedStatement ps1 = con.prepareStatement("select * from BankCustomer50 where accno=?");
			// Compilation
			PreparedStatement ps2 = con.prepareStatement("update BankCustomer50 set balance=balance+? where accno=?");
			// Compilation
			System.out.println("Commit Status : " + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("Commit Status : " + con.getAutoCommit());
			Savepoint sp = con.setSavepoint();
			System.out.println("Enter home accNo:");
			long hAccNo = sc1.nextLong();
			ps1.setLong(1, hAccNo);
			ResultSet rs1 = ps1.executeQuery();// Execution
			if (rs1.next()) {
				float bal = rs1.getFloat(4);
				System.out.println("Enter benefieciery AccNo:");
				long bAccNo = sc1.nextLong();
				ps1.setLong(1, bAccNo);
				ResultSet rs2 = ps1.executeQuery();// Execution
				if (rs2.next()) {
					System.out.println("Enter the amt to be transferred:");
					float amt = sc1.nextFloat();
					if (amt <= bal) {
						// statement-1
						ps2.setFloat(1, -amt);
						ps2.setLong(2, hAccNo);
						int p = ps2.executeUpdate();// Buffer Updated
						// Statement-2
						ps2.setFloat(1, amt);
						ps2.setLong(2, bAccNo);
						int q = ps2.executeUpdate();// Buffer Update
						if (p == 1 && q == 1) {
							con.commit();// Update Database
							System.out.println("Transaction Successfull..");
						} else {
							System.out.println("Insufficient fund...");
						}
					} else {
						System.out.println("Invalid bAccNo...");
					}
				} else {
					System.out.println("Invalid hAccNo...");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
