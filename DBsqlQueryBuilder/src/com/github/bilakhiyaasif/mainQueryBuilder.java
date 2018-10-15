/**
 * 
 */
package com.github.bilakhiyaasif;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author Asif Bilakhiya
 * 
 */
public class mainQueryBuilder {

	String scanner_input_file;
	String scanner_output_file;
	String delimiter;
	String Database_Name;
	String TableName;
	int num_column;
	String n_Column_name[];
	String column_String = "";

	public void Main_Class_Level() {
		try {
			mainQueryBuilder p1 = new mainQueryBuilder();
			Scanner console = new Scanner(System.in);
			System.out.println("-------------------------------");
			System.out.println("Database Query Builder Dynamic");
			System.out.println("-------------------------------");
			System.out.println("Asif Bilakhiya");
			System.out.println("-------------------------------");
			System.out.println("1.....Insert");
			System.out.println("2.....Update");
			System.out.println("3.....Delete");
			System.out.println("4.....Select");
			System.out.println("5.....Alter");
			System.out.println("6.....Exit");
			System.out.println("-------------------------------");
			int ch = console.nextInt();
			switch (ch) {
			case 1:
				p1.method_insert();
				break;
			case 2:
				p1.method_update();
				break;
			case 3:
				p1.method_delete();
				break;
			case 4:
				p1.method_select();
				break;
			case 5:
				p1.method_alter();
				break;
			case 6:
				// p1.method_exit();
				break;
			default:
				System.out.println("Invalid input");

			}
			console.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public void method_insert() {
		this.scanner_input_file = "Database/db_scanner_file/create_sc/create_s_data.txt";
		this.scanner_output_file = "Database/db_query_output/create_out/create_q_data.sql";

		this.common_input();
		this.print_common_Data();
		try {
			File f1 = new File(this.scanner_input_file);
			File f2 = new File(this.scanner_output_file);
			Scanner sc = new Scanner(f1);
			FileWriter fw = new FileWriter(this.scanner_output_file);
			long i1 = 1;
			while (sc.hasNext()) {
				String qdata[] = sc.nextLine().split(this.delimiter);
				String qString = "";
				for (int i = 0; i < qdata.length; i++) {
					qString = qString + "'" + qdata[i] + "'";
					if (i < qdata.length - 1) {
						qString = qString + ",";
					}
				}
				fw.write("insert into " + Database_Name + "." + TableName + "("
						+ column_String + ")" + " values(" + qString + ");\n");
				i1++;
			}
			fw.close();
			System.out.println("SQL Query File Location:\n"
					+ f2.getAbsolutePath());
		}

		catch (Exception e) {
			System.out.println("Error(method_insert): " + e);
		}
	}

	public void method_update() {
		this.scanner_input_file = "Database/db_scanner_file/create_sc/create_s_data.txt";
		this.scanner_output_file = "Database/db_query_output/create_out/create_q_data.sql";

		this.common_input();
		this.print_common_Data();
		try {
			File f1 = new File(this.scanner_input_file);
			File f2 = new File(this.scanner_output_file);
			Scanner sc = new Scanner(f1);
			FileWriter fw = new FileWriter(this.scanner_output_file);
			long i1 = 1;
			while (sc.hasNext()) {
				String qdata[] = sc.nextLine().split(this.delimiter);
				String qString = "";
				for (int i = 0; i < qdata.length; i++) {
					qString = qString + "'" + qdata[i] + "'";
					if (i < qdata.length - 1) {
						qString = qString + ",";
					}
				}
				fw.write("insert into " + Database_Name + "." + TableName + "("
						+ column_String + ")" + " values(" + qString + ");\n");
				i1++;
			}
			fw.close();
			System.out.println("SQL Query File Location:\n"
					+ f2.getAbsolutePath());
		}

		catch (Exception e) {
			System.out.println("Error(method_insert): " + e);
		}
	}

	public void method_delete() {
	}

	public void method_select() {
	}

	public void method_alter() {
	}

	public void common_input() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Delimiter for Data Parsing(Fatching):");
			this.delimiter = sc.next();
			System.out.println("Enter Database Name:");
			this.Database_Name = sc.next();
			System.out.println("Enter Table Name:");
			this.TableName = sc.next();
			System.out.println("Enter Num of Column for your Table:");
			this.num_column = sc.nextInt();

			this.n_Column_name = new String[this.num_column];
			System.out.println("Column Names:");
			for (int i1 = 1; i1 <= this.num_column; i1++) {
				System.out.println("Enter " + i1 + "st Column  Name:");
				this.n_Column_name[i1 - 1] = sc.next();
				this.column_String = this.column_String
						+ this.n_Column_name[i1 - 1];
				if (i1 < this.num_column) {
					this.column_String = this.column_String + ",";
				}
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Error(common_input): " + e);
		}
	}

	public void print_common_Data() {
		System.out.println("Database Input Data File Path:\t"
				+ this.scanner_input_file);
		System.out.println("Database Output File Path:\t"
				+ this.scanner_output_file);
		System.out.println("Delimiter:\t\t\t" + this.delimiter);
		System.out.println("DatabaseName:\t\t\t" + this.Database_Name);
		System.out.println("TableName:\t\t\t" + this.TableName);
		System.out.println("Num of Column:\t\t\t" + this.num_column);
		System.out.println("ColumnName:\t\t\t" + this.column_String);
	}

	public static void main(String args[]) {
		mainQueryBuilder p1 = new mainQueryBuilder();
		p1.Main_Class_Level();
	}
}
