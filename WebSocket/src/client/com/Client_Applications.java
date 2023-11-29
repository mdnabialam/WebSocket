package client.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client_Applications {
	public static void main(String[] args) {
		  try (Socket socket = new Socket("localhost",4444)) {
			OutputStream outputStream= socket.getOutputStream();
			PrintStream  printStream= new PrintStream(outputStream);
			BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
			InputStream inputStream= socket.getInputStream();
			BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
			while (true) {
				String string= bufferedReader.readLine();
				printStream.println(string);
				String string2= bufferedReader2.readLine();
				System.out.println(string2);
				
				if (string.equals("bye") && string2.equals("bye")) {
					System.exit(0);
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
