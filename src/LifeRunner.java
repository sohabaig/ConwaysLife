import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import info.gridworld.grid.*;
import info.gridworld.world.*;

public final class LifeRunner {

	private JFrame frame = new JFrame("Life, as we know it!");
	private JPanel panel;
	private int currentGen;
	private int numClicks;
	private int[][] grid;// to be constructed in the makeGrid method
	private final boolean SHOW_GUI = true;

	public static void main(String[] args) {
		new LifeRunner().start();
	}

	private void start() {
		makeGrid(25,20, 50);// add 50 "lives" to a 25 row X 20 col grid
		if(this.SHOW_GUI)
			makeFrame();

		printGrid();
		if(this.SHOW_GUI)
			this.frame.repaint();
		nextGen();
		printGrid();
		if(this.SHOW_GUI)
			frame.repaint();


	}



	private void makeFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// code to draw on graphics
				
				g.setColor(new Color(100,100,100));
				g.fillRect(200, 100+15*currentGen, 75, 20);
				g.setColor(Color.RED);
				g.drawLine(10+10*currentGen, 50, 600, 100);
				showLife(g);
			}
		};
		frame.add(panel);
		panel.setLayout(null);
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Code to be performed when button is clicked
				nextGen();
				panel.repaint();
			}
		});
		panel.add(button);
		button.setBounds(350, 250, 100,100);
		panel.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setVisible(true);
	}
	final int OK = 40;
	protected void showLife(Graphics g) {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				if(grid[r][c]==1)
					g.setColor(Color.green);
				else 
					g.setColor(Color.red);
				g.fillRect(c*OK, r*OK, OK, OK);
				g.drawRect(c*OK, r*OK, OK, OK);
			}
		}
	
		
	}

	/**
	 * create a grid with dimension of rows X cols with lives objects
	 * randomly placed into the grid.  One tricky part is to make sure you are 
	 * placing the correct number of objects in the grid.  If you randomly 
	 * come up with the same location, your code needs to account for that!
	 * 
	 * After making the grid, it is added to the List of grids
	 * 
	 * @param rows number of rows in the grid
	 * @param cols number of cols in the grid
	 * @param lives number of lives to be added to the grid
	 */
	private void makeGrid(int rows, int cols, int lives) {
		grid = new int[rows+2][cols+2];
		while(lives > 0) {
		int r = (int)(Math.random()*rows)+1,
		 	c = (int)(Math.random()*cols)+1;
		if(grid[r][c]==0) {
			grid[r][c]=1;
			lives--;
			}
		}
		
	}
	/**
	 * Prints the specified 2D array of int to the console.
	 * @param grid2 
	 */
	private void printGrid() {
		
		for(int r = 1; r < grid.length-1; r++) {
			for(int c = 1; c<grid[r].length-1; c++) {
				if(grid[r][c]==0)
					System.out.print("-");
			}
		}
		
		
	}
	/**
	 * This method advances grid from the previous generation to the next generation
	 * based on these two simple rules:
	 * 1.  If there are 3 neighboring objects around a cell, that cell will contain a 
	 *     life in the subsequent generation.
	 * 2.  If there are 3 neighboring objects around a cell that currently contains an 
	 *     object, then that object lives on into the next generation.
	 *     
	 * Be sure to make all the changes to a different grid.
	 * Finally, the newest grid is added to the list of generations
	 */
	private void nextGen() {

		this.currentGen++;
		System.out.println("creating next gen "+currentGen);
		for(int r = 1; r <grid.length; r++) {
			for(int c= 1; c<grid[r].length; c++) {
				
			}
		}
		
	}


}
