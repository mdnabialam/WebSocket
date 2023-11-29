package server.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Application {
	public static void main(String[] args)throws Exception {
		
		try (ServerSocket ss = new ServerSocket(4444)) {
			Socket s= ss.accept();
			InputStream is = s.getInputStream();
			BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(is));
			
			OutputStream outputStream= s.getOutputStream();
			PrintStream printStream= new PrintStream(outputStream);
			BufferedReader bufferedReader2= new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				String string= bufferedReader.readLine();
				System.out.println(string);
				String string2= bufferedReader2.readLine();
				printStream.println(string2);
				if (string.equals("bye") && string2.equals("bye")) {
					System.exit(0);
				}
			}
		}
	}

}
