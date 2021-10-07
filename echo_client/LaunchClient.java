import java.util.Scanner;

public class LaunchClient {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		EchoClient ec = new EchoClient("localhost");

		System.out.print("Enter a string: ");

		String message = input.next();

		while(!message.equals("Q")) {

			System.out.println(ec.sendEcho(message));

			System.out.print("Enter a string: ");

			message = input.next();
		}

	}//end main

}//end class
