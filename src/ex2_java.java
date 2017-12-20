import java.io.PrintWriter;


public class ex2_java {

	/**
	 * the main func that runs the program
	 */
	public static void main(String[] args) {
		Reader reader = new Reader();
		Map map = reader.read();
		MinMaxAlgo minMaxAlgo = new MinMaxAlgo();
		GameLogicMeneger gameLogicMeneger = new GameLogicMeneger();
		GameMeneger gameMeneger = new GameMeneger(map, minMaxAlgo, gameLogicMeneger);
		String res = gameMeneger.play();

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
