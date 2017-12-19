import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * reads the input file
 */
public class Reader {


	/**
	 *reads and returns the map we are working on
	 */
	public Map read() {
		Map map = null;

		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line;
			int mapsize = 5; //todo change
			String[][] mapStringArr = new String[mapsize][mapsize];
			line = br.readLine();
			int mapStringArrLine = 0;
			while (line != null) {
				for (int i = 0; i < line.length(); i++) {
					mapStringArr[mapStringArrLine][i] = Character.toString(line.charAt(i));
				}
				mapStringArrLine++;
				line = br.readLine();
			}

			map = new Map(mapsize, mapStringArr);

		} catch (Exception e) {
			//todo handle error
		}
		return map;
	}
}
