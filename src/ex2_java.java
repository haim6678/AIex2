import java.io.PrintWriter;

public class ex2_java {


	public static void main(String[] args) {
		Reader reader = new Reader();
		Map map = reader.read();

		String res = "";
		PrintWriter writer = null;

		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(res);
			writer.close();

		} catch (Exception e) {
			System.out.print("error");
		}
	}


}
