package aplication;
import java.io.*;
import java.util.*;
public class Labyrinth {
	static private File []labyrinths;
	private static class loadedLabyrinth {
		static char[][] labyrinth;
		static int width;
		static int height;
	}
	Labyrinth() {
		File dir=new File("src/aplication/"+Config.labyrinthsPath);
		labyrinths=dir.listFiles();
	}
	public void loadLabyrinth(String input)  {
		for (int i=0;i<labyrinths.length;i++) {
			if (labyrinths[i].toString().endsWith("/"+input)) {
				if (readLabyrinth(labyrinths[i])==1) {
					System.err.print("Algo fue mal cargando el fichero\n");
				}
				return;
			}
		}
	}
	private static int readLabyrinth(File file) {
		try {
			int i=0,j=0;
			Scanner scanner=new Scanner(file);
			Scanner readFile=new Scanner(file);
			while (scanner.hasNextLine()) {
				i+=scanner.nextLine().length();
				j++;
				if (i%j!=0) {
					System.out.print("El laberinto no es un rectangulo o cuadrado\n");
					scanner.close();
					readFile.close();
					return 1;
				}
			}
			loadedLabyrinth.labyrinth=new char[i/j][j];
			loadedLabyrinth.width=i/j;
			loadedLabyrinth.height=j;
			String buffer="";
			for (j=0;j<loadedLabyrinth.height;j++) {
				buffer=readFile.nextLine();
				for (i=0;i<loadedLabyrinth.width;i++) {
					loadedLabyrinth.labyrinth[i][j]=buffer.toCharArray()[i];
				}
				
			}
			scanner.close();
			readFile.close();
			return 0;
			} catch (Exception e) {
				System.err.print(e+"\n");
				return 1;	
		}
	}
	public void printLabyrinth() {
		for (int i=0;i<loadedLabyrinth.height;i++) {
			for (int j=0;j<loadedLabyrinth.width;j++) {
				System.out.print(loadedLabyrinth.labyrinth[j][i]);
			}
		System.out.print("\n");
		}
	}
}
