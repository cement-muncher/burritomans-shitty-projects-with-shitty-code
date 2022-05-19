package tests;
import java.math.*;

public class Labyrinth {
	static final char[][] maze= {
			{'#','#','#','#'},
			{'#',' ',' ',' '},
			{'#',' ','#','#'},
			{' ',' ','#','#'},
			{'#','#','#','#'}
	};
	
	public void load_maze() {
		LinkedList<Cell> cells=new LinkedList<Cell>();
		for (int i=0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++) {
				if (maze[i][j]==' ') {
					cells.add(new Cell(i,j),cells.getLength());
				}
			}
		}
		Coordenadas entrada=new Coordenadas(3,0);
		int posicionCasillaEntrada;
		for  (int i=0;i<cells.getLength();i++) {
			cells.getObjeto(i).interlinkCells(cells,i,maze[0].length);
			if (cells.getObjeto(i).posicion.x==entrada.x &&
				cells.getObjeto(i).posicion.y==entrada.y) {
				posicionCasillaEntrada=i;
			}
		}

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
		boolean recorrida;
		Cell (int a,int b) {
			this.posicion=new Coordenadas(a,b);
			this.cellDown=null;
			this.cellLeft=null;
			this.cellRight=null;
			this.cellUp=null;
			this.recorrida=false;
		}
		void interlinkCells(LinkedList<Cell> a,int pos,int lonY) {
			if (a.getObjeto(pos+1)==this) {
				this.cellLeft=a.getObjeto(pos+1);
				a.getObjeto(pos+1).cellRight=this;
			}
			if (a.getObjeto(pos+lonY)==this) {
				this.cellDown=a.getObjeto(lonY+pos);
				a.getObjeto(lonY+pos).cellUp=this;
			}
		}
	}
	private void recorrerLaberinto(LinkedList<Cell> a,Coordenadas salida,Cell posicionActual) { 
		Stack<Cell> ultimaInterseccion=new Stack<Cell>();
		int direction;
		Stack<Cell> celdasRecorridas=new Stack<Cell>(posicionActual);
		while (true) {
			posicionActual.recorrida=true;
			if (posicionActual.cellDown==null&&
					posicionActual.cellUp==null&&
					posicionActual.cellLeft==null&&
					posicionActual.cellLeft.recorrida) {
				celdasRecorridas.push(posicionActual);
				posicionActual=posicionActual.cellRight;
				continue;
			} else if (posicionActual.cellDown==null&&
					posicionActual.cellUp==null&&
					posicionActual.cellRight==null&&
					posicionActual.cellRight.recorrida) {
				celdasRecorridas.push(posicionActual);
				posicionActual=posicionActual.cellLeft;
				continue;
			} else if (posicionActual.cellDown==null&&
					posicionActual.cellRight==null&&
					posicionActual.cellLeft==null&&
					posicionActual.cellDown.recorrida) {
				celdasRecorridas.push(posicionActual);
				posicionActual=posicionActual.cellUp;
				continue;
			} else if (posicionActual.cellRight==null&&
					posicionActual.cellUp==null&&
					posicionActual.cellLeft==null&&
					posicionActual.cellUp.recorrida) {
				celdasRecorridas.push(posicionActual);
				posicionActual=posicionActual.cellDown;
				continue;
			} else {
				while (true) {
					if (celdasRecorridas.pop()==ultimaInterseccion.peek()) break; 
				}
			}
			ultimaInterseccion.push(posicionActual);
			while (true) {
				direction=((int) Math.random()*100)%4;
				if (direction==0&&
						!posicionActual.cellDown.recorrida) {
					celdasRecorridas.push(posicionActual.cellDown);
					posicionActual=posicionActual.cellDown;
					break;
				} else if (direction==1&&
						!posicionActual.cellUp.recorrida) {
					celdasRecorridas.push(posicionActual.cellUp);
					posicionActual=posicionActual.cellUp;
					break;
				} else if (direction==2&&
						!posicionActual.cellLeft.recorrida) {
					celdasRecorridas.push(posicionActual.cellLeft);
					posicionActual=posicionActual.cellLeft;
					break;
				} else if (direction==1&&
						!posicionActual.cellRight.recorrida) {
					celdasRecorridas.push(posicionActual.cellRight);
					posicionActual=posicionActual.cellRight;
					break;
				}
			}
		
			
		}
	}
}
