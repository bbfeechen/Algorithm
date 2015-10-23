package uber;

import java.util.HashMap;
import java.util.List;

public class uber_excel {
	public class Cell {
		String val;
		int row;
		int col;

		Cell up;
		Cell right;
		Cell down;
		Cell left;

		List<Cell> parents;
		List<Cell> children;
		
		public String getValue() { return val; }
		public void setValue(String val) { this.val = val; }
		public int getRow() { return row; }
		public int getCol() { return col; }
	}
	
	public class Excel { 
		private HashMap<Integer, HashMap<Integer, Cell>> cellsMap = 
				new HashMap<Integer, HashMap<Integer, Cell>>(); 
		private int countRows = -1; 
		private int countCols = -1; 
		public String getValue(int row, int col) { 
			HashMap<Integer, Cell> colsMap= cellsMap.get(row); 
			if (colsMap == null) { 
				return ""; 
			} 
			Cell cell = colsMap.get(col); 
			if (cell == null) { 
				return ""; 
			} 
			return cell.getValue();
		}
		
		public void SetValue(Cell cell) {
		    int row = cell.getRow();
		    int col = cell.getCol();

		    HashMap<Integer, Cell> colsMap = cellsMap.get(row);
		    if (colsMap == null) {
		        colsMap = new HashMap<Integer, Cell>();
		        cellsMap.put(row, colsMap);
		    }
		    colsMap.put(col, cell);
		    this.countCols = Math.max(this.countCols, col + 1);
		    this.countRows = Math.max(this.countRows, row + 1);
		    breakDependencyOnParents(row, col);
		    updateChildren(cell);
		}
		
		public void breakDependencyOnParents(int row, int col) {
		    Cell cell = cellsMap.get(row).get(col);
		    if (cell.parents != null) {
		        for (Cell cellParent : cell.parents) {
		            cellParent.children.remove(cell);
		        }

		        for (int i = cell.parents.size() - 1; i >= 0; i--) {
		            cell.parents.remove(i);
		        }
		    }
		}

		public void updateChildren(Cell cell) {
		    if (cell.children == null) {
		        return;
		    }
		    for (Cell cellChild : cell.children) {
		        int row = cell.getRow();
		        int col = cell.getCol();
		        for (Cell cellChildParent : cellChild.parents) {
		            if (cellChildParent.getRow() == row && cellChildParent.getCol() == col) {
		                cellChildParent.setValue(cell.getValue());
		            }
		        }
		        updateChildren(cellChild);
		    }
		}

		public int getCountCols() {
		    return countCols;
		}

		public void setCountCols(int countCols) {
		    this.countCols = countCols;
		}

		public int getCountRows() {
		    return countRows;
		}

		public void setCountRows(int countRows) {
		    this.countRows = countRows;
		}

		@Override
		public String toString() {
		    StringBuilder sb = new StringBuilder("Table:\n");

		    for (int i = 0; i < this.countCols; i++) {
		        sb.append("Column: ").append(i).append(":\t");
		        for (int j = 0; j < this.countRows; j++) {
		            sb.append(getValue(i, j));
		            if (j == this.countRows - 1) {
		                sb.append("\n");
		            } else {
		                sb.append(", ");
		            }
		        }
		    }

		    return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
