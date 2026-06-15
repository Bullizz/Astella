package handlers;

import java.util.Arrays;

import main.Definitions;

public class MazeHandler
{
	Definitions defs;

	int dim;
	boolean[][] visitedCellsMaze;
	int[][] stepArray = new int[1][2];
	
	public MazeHandler(Definitions defs)
	{
		this.defs = defs;
	}

	public void genMaze()
	{
		/*
		 (0. Get init. pos)
		 1. Get neighbours
		 2. Backtrack if all visited
		 3. Randomize new cell to visit
		 4. Remove wall(s) and set as visited
		 */
		
		dim = defs.DIM;
		
		int[][] maze = new int[dim][dim];
		
		int x = 0;
		int y = 0;
		
		maze = initMaze();
		initVisitedCellsMaze();
		visitedCellsMaze[y][x] = true;
			
		// Get goal pos.
		int xFinal = (dim / 2) + 1;
		int yFinal = (dim / 2) + 1;
		
		int visitedCells = 1;
		
		while(visitedCells < (dim * dim))
		{
			int[][] neighboursPos = getNeighboursPos(x, y);
			
			if(allNeighboursVisited(neighboursPos))
			{
				backtrack();
				x = stepArray[stepArray.length - 1][0];
				y = stepArray[stepArray.length - 1][1];
				continue;
			}
			
			// Get pos. of next cell
			int[] nextPos = null;
			while(nextPos == null)
			{
				int nextPosIndex = (int) (Math.random() * neighboursPos.length);
				nextPos = neighboursPos[nextPosIndex];
			}
			appendStepArray(nextPos);
			
			int wallUp    = defs.WALL_UP;
			int wallLeft  = defs.WALL_LEFT;
			int wallDown  = defs.WALL_DOWN;
			int wallRight = defs.WALL_RIGHT;
			
			// Remove above wall
			if(nextPos[1] < y)
			{
				maze[y][x] -= wallUp;
				maze[y - 1][x] -= wallDown;
			}
			// Remove left wall
			if(nextPos[0] < x)
			{
				maze[y][x] -= wallLeft;
				maze[y][x - 1] -= wallRight;
			}
			// Remove bot wall
			if(nextPos[1] > y)
			{
				maze[y][x] -= wallDown;
				maze[y + 1][x] -= wallUp;
			}
			// Remove right wall
			if(nextPos[0] > x)
			{
				maze[y][x] -= wallRight;
				maze[y][x + 1] -= wallLeft;
			}
			
			// Update x, y
			x = nextPos[0];
			y = nextPos[1];
			visitedCellsMaze[y][x] = true;
			
			visitedCells = countVisitedCells();
		}
		
		defs.setMaze(maze);
	}
	
	private int countVisitedCells()
	{
		int counter = 0;
		for(int i = 0; i < dim; i++)
		{
			for(int j = 0; j < dim; j++)
			{
				if(visitedCellsMaze[i][j])
					counter++;
			}
		}
		
		return counter;
	}

	private void appendStepArray(int[] newStep)
	{
		int index = 0;
		int[][] newStepArray = new int[stepArray.length + 1][stepArray[0].length];
		for(index = 0; index < stepArray.length; index++)
			newStepArray[index] = stepArray[index];
		
		newStepArray[index] = newStep;
		stepArray = newStepArray;
	}

	private void backtrack()
	{
		stepArray = Arrays.copyOf(stepArray, stepArray.length - 1);
	}

	private boolean allNeighboursVisited(int[][] neighboursPos)
	{
		for(int i = 0; i < neighboursPos.length; i++)
		{
			if(neighboursPos[i] != null)
				return false;
		}
		
		return true;
	}

	private int[][] getNeighboursPos(int x, int y)
	{
		int[] posUp		= null,
			  posLeft	= null,
			  posDown	= null,
			  posRight	= null;
		if(y > 0 && !visitedCellsMaze[y - 1][x])
			posUp = new int[]{x, y - 1};
		if(x > 0 && !visitedCellsMaze[y][x - 1])
			posLeft = new int[]{x - 1, y};
		if(y < dim - 1 && !visitedCellsMaze[y + 1][x])
			posDown = new int[]{x, y + 1};
		if(x < dim - 1 && !visitedCellsMaze[y][x + 1])
			posRight = new int[]{x + 1, y};
		
		int[][] neighbourPos = {posUp, posLeft, posDown, posRight};
		return neighbourPos;
	}

	private void initVisitedCellsMaze()
	{
		visitedCellsMaze = new boolean[dim][dim];
		
		for(int i = 0; i < dim; i++)
		{
			for(int j = 0; j < dim; j++)
				visitedCellsMaze[i][j] = false;
		}	
	}

	private int[][] initMaze()
	{
		int[][] maze = new int[dim][dim];
		// Assign cells
		for(int i = 0; i < dim; i++)
		{
			for(int j = 0; j < dim; j++)
				maze[i][j] = 15;
		}
		
		return maze;
	}
}