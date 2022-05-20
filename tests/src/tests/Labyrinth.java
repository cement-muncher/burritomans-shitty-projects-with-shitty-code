package tests;


public class Labyrinth {
	static  char[][] maze= {
			{'#','#','#','#','#'},
			{'#',' ',' ','#','#'},
			{'#',' ','#',' ',' '},
			{'#',' ','#',' ','#'},
			{'#',' ','#',' ','#'},
			{'#',' ','#',' ','#'},
			{'#',' ',' ',' ','#'},
			{' ',' ','#',' ','#'},
			{'#','#','#',' ','#'},
			{'#',' ',' ',' ','#'},
			{'#',' ','#',' ','#'},
			{'#',' ',' ',' ','#'},
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
		Coordenadas entrada=new Coordenadas(7,0);
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
		CellNode start=new CellNode(cells.getObjeto(posicionCasillaEntrada),null);
		Coordenadas salida=new Coordenadas(2,4);
		recorrerLaberinto(cells,salida,cells.getObjeto(posicionCasillaEntrada),start);
		System.out.print("\n");
		caminoMasCorto(cells,salida,start);
		for (int i=0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.print('\n');
		}
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
			//System.out.print(this.posicion.x+" "+this.posicion.y+" l\n");
				}

			} catch (Exception E) {
				
			}
			try {	
				if (a.getObjeto(pos+1).recorrible&&(a.getObjeto(pos+1).posicion.y==this.posicion.y)) {
					this.cellRight=a.getObjeto(pos+1);
		//		System.out.print(this.posicion.x+" "+this.posicion.y+" r\n");
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
		CellNode origen;
		CellNode[] destino=new CellNode[3];
		Cell cell;
		CellNode(Cell a,CellNode b) {
			this.cell=a;
			this.origen=b;
			this.destino[0]=null;
			this.destino[1]=null;
			this.destino[2]=null;
		}
	}
	private void caminoMasCorto(LinkedList<Cell> a, Coordenadas salida,CellNode origen) {
		Queue<CellNode> fifo=new Queue<CellNode>(origen);
		CellNode node;
		while (true) {
			node=fifo.check();
			if (node.cell.posicion.x==salida.x&&node.cell.posicion.y==salida.y) break;
			for (int i=0;i<3;i++) {
				if (node.destino[i]!=null) {
					fifo.add(node.destino[i]);
			
				}
			}
			//System.out.print(node.cell.posicion.x+" "+node.cell.posicion.y+"\n");
			fifo.serve();
		}
		
		while (node.origen!=null) {
			maze[node.cell.posicion.y][node.cell.posicion.x]='$';
			node=node.origen;
		}
		maze[node.cell.posicion.y][node.cell.posicion.x]='$';
	}
	private void recorrerLaberinto(LinkedList<Cell> a,Coordenadas salida,Cell posicionActual,CellNode currentCell) {
		int i=0;
		posicionActual.recorrible=false;
		System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
		try {
			if (posicionActual.cellDown.recorrible) {
		//		System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				currentCell.destino[i]=new CellNode(posicionActual.cellDown,currentCell);
				recorrerLaberinto(a,salida,posicionActual.cellDown,currentCell.destino[i]);
				i++;
			}
		} catch (Exception E) {
	//	System.out.print("a");
		}
		try {
			if (posicionActual.cellUp.recorrible) {
	//			System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				currentCell.destino[i]=new CellNode(posicionActual.cellUp,currentCell);
				recorrerLaberinto(a,salida,posicionActual.cellUp,currentCell.destino[i]);
				i++;
			}
		} catch (Exception E) {
	//	System.out.print("b");
		}
		try {
			if (posicionActual.cellLeft.recorrible) {
	//			System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				currentCell.destino[i]=new CellNode(posicionActual.cellLeft,currentCell);
				recorrerLaberinto(a,salida,posicionActual.cellLeft,currentCell.destino[i]);
				i++;
			}
		} catch (Exception E) {
		//	System.out.print("c");
		}
		try {
			
			if (posicionActual.cellRight.recorrible) {
	//			System.out.print(posicionActual.posicion.x+" "+posicionActual.posicion.y+"\n");
				currentCell.destino[i]=new CellNode(posicionActual.cellRight,currentCell);
				recorrerLaberinto(a,salida,posicionActual.cellRight,currentCell.destino[i]);
				i++;
			}
		} catch (Exception E) {
//	System.out.print("d");
		}
		return;
	}
}
