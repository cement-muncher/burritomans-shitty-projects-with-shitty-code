package tests;
import java.math.*;

public class Labyrinth {
	static final char[][] maze= {
			{'#','#','#','#','#'},
			{'#',' ',' ','#','#'},
			{'#','#',' ',' ',' '},
			{' ',' ',' ','#','#'},
			{'#','#','#','#','#'}
	};
	
	public void load_maze() {
		LinkedList<Cell> cells=new LinkedList<Cell>();
		for (int i=0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++) {
				if (maze[i][j]==' ') {
						cells.add(new Cell(i,j,true),cells.n);
					} else {
						cells.add(new Cell(i,j,false),cells.n);
					}
			}
		}
		Coordenadas entrada=new Coordenadas(3,0);
		int posicionCasillaEntrada=0;
		for  (int i=0;i<cells.n;i++) {
			if (cells.getObjeto(i).recorrible) {
				cells.getObjeto(i).interlinkCells(cells,i,maze.length,maze[0].length);
				if (cells.getObjeto(i).posicion.x==entrada.x &&
					cells.getObjeto(i).posicion.y==entrada.y) {
					posicionCasillaEntrada=i;
				}
			}
		}
		start.cell=cells.getObjeto(posicionCasillaEntrada);
		start.origen=null;
		Coordenadas salida=new Coordenadas(2,4);
		recorrerLaberinto(cells,salida,cells.getObjeto(posicionCasillaEntrada),null,start);
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
		boolean recorrible;
		Cell (int a,int b,boolean c) {
			this.posicion=new Coordenadas(a,b);
			this.cellDown=null;
			this.cellLeft=null;
			this.cellRight=null;
			this.cellUp=null;
			this.recorrible=c;
		}
		void interlinkCells(LinkedList<Cell> a,int pos,int lonY,int lonX) {
			//.out.print("->"+pos+"\n");
			try {
				if (a.getObjeto(pos-1).recorrible&&(a.getObjeto(pos-1).posicion.y==this.posicion.y)) {
					this.cellLeft=a.getObjeto(pos-1);
		//			System.out.print(this.posicion.x+" "+this.posicion.y+" l\n");
				}

			} catch (Exception E) {
				
			}
			try {	
				if (a.getObjeto(pos+1).recorrible&&(a.getObjeto(pos+1).posicion.y==this.posicion.y)) {
					this.cellRight=a.getObjeto(pos+1);
	//				System.out.print(this.posicion.x+" "+this.posicion.y+" r\n");
				}
			} catch (Exception E) {
				
			}
			try {
				if (a.getObjeto(pos+lonX).recorrible) {
					this.cellDown=a.getObjeto(pos+lonX);
			//		System.out.print(this.posicion.x+" "+this.posicion.y+" d\n");
				}
			} catch (Exception E) {
				
			}
			try {
				if (a.getObjeto(pos-lonX).recorrible) {
					this.cellUp=a.getObjeto(pos-lonX);
		//			System.out.print(this.posicion.x+" "+this.posicion.y+" u\n");
				}	
			} catch (Exception E) {
				
			}
		}
		
	}
	private class CellNode {
		Cell origen;
		CellNode[] destino=new CellNode[3];
		Cell cell;
		CellNode(Cell a,Cell b) {
			this.cell=a;
			this.origen=b;
		}
	}
	private Queue<CellNode> queue=new Queue<CellNode>();
	private Stack<CellNode> stack=new Stack<CellNode>();
	private CellNode start;
	private void breadthFirstSearch(LinkedList<Cell> a, Coordenadas salida,CellNode origen) {
		CellNode b=;
		queue.ad
		
		
	}
	private void recorrerLaberinto(LinkedList<Cell> a,Coordenadas salida,Cell posicionActual,Cell previousCell,CellNode b) {
		int i=0;
		posicionActual.recorrible=false;
		b.origen=previousCell;
		//	System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
		try {
			if (posicionActual.cellDown.recorrible) {
				System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				b.destino[i++]=new CellNode(posicionActual.cellDown,posicionActual);
				recorrerLaberinto(a,salida,posicionActual.cellDown,posicionActual,b);
			}
		} catch (Exception E) {
	//	System.out.print("a");
		}
		try {
			if (posicionActual.cellUp.recorrible) {
				System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				b.destino[i++]=new CellNode(posicionActual.cellUp,posicionActual);
				recorrerLaberinto(a,salida,posicionActual.cellUp,posicionActual,b);
			}
		} catch (Exception E) {
	//	System.out.print("b");
		}
		try {
			if (posicionActual.cellLeft.recorrible) {
				System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				b.destino[i++]=new CellNode(posicionActual.cellLeft,posicionActual);
				recorrerLaberinto(a,salida,posicionActual.cellLeft,posicionActual,b);
			}
		} catch (Exception E) {
		//	System.out.print("c");
		}
		try {
			
			if (posicionActual.cellRight.recorrible) {
				System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				b.destino[i++]=new CellNode(posicionActual.cellRight,posicionActual);
				recorrerLaberinto(a,salida,posicionActual.cellRight,posicionActual,b);
			}
		} catch (Exception E) {
//	System.out.print("d");
		}
		return;
	}
}
