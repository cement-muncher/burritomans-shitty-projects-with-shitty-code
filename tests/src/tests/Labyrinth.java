package tests;


public class Labyrinth {
	static final char[][] maze= {
			{'#','#','#','#'},
			{'#',' ',' ',' '},
			{'#',' ','#','#'},
			{' ',' ','#','#'},
			{'#','#','#','#'}
	};
	Cell[][] cells=new Cell[maze.length][maze[0].length];
	public void load_maze() {
		for (int i=0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++) {
				if (maze[i][j]==' ') {
					cells[i][j]=new Cell(i,j);
				} else {
					cells[i][j]=null;
				}
			}
		}
		Coordenadas coordenadasActuales=new Coordenadas(0,0);
		for (int i=0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++) {
				coordenadasActuales.x=j;
				coordenadasActuales.y=i;
				if (cells[i][j]!=null) cells[i][j].interlinkCells(cells, coordenadasActuales);
			}
		}
		
		Coordenadas entrada=new Coordenadas(3,0);
		Coordenadas salida=new Coordenadas(1,3);
		
	}
	
	private class Coordenadas{
		int x;
		int y;
		Coordenadas(int a, int b) {
			y=a;
			x=b;
		}
	}
	private class Cell{
		Cell cellUp;
		Cell cellDown;
		Cell cellLeft;
		Cell cellRight;
		Coordenadas posicion;
		Cell (int a,int b) {
			Coordenadas posicion=new Coordenadas(a,b);
		}
		void interlinkCells(Cell[][] array,Coordenadas a) {
			if (a.x+1<array[0].length ) {
				if (array[a.y][a.x+1]!=null) {
					array[a.y][a.x+1].cellLeft=array[a.y][a.x];
				}
			if (a.y-1>0) {
				if (array[a.y-1][a.x]!=null) {
					array[a.y][a.x].cellUp=array[a.y-1][a.x];
				}
			}
			if (a.y+1<array.length) {
				if (array[a.y+1][a.x]!=null) {			
					array[a.y][a.x].cellDown=array[a.y+1][a.x];
				}
			}
			
			}
			if (a.x-1>array[0].length) {
				if (array[a.y][a.x]!=null) {
					array[a.y][a.x-1].cellRight=array[a.y][a.x];
				}
			}
			return;
		}
	}
}
