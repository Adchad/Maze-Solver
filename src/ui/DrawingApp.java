package ui;
import javax.swing.*;
import javax.swing.event.* ;
import javax.swing.filechooser.*;

import Dijkstra.*;
import maze.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class DrawingApp extends JFrame implements ActionListener, MouseListener {
	private Maze maze ;
	private Dijkstra dijkstra;
	private final DrawingMenuBar drawingMenuBar ;
	private boolean changeArrival ;
	private boolean changeDeparture ;
	private boolean removeWall ;
	private boolean addWall;

	private  ButtonsPanel buttonsPanel;
	private final JFileChooser fc = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Text only" ,"txt");
	
	
	public DrawingApp(Maze maze, Dijkstra dijkstra) throws IOException
	   {
		
	      super("Drawing Application") ; // Window title"e	
	      
	      fc.setFileFilter(filter);
	      fc.setCurrentDirectory(new File(System.getProperty("user.home") ));
	      
	      changeArrival = false;
	      changeDeparture = false;
	      removeWall = false ;
	      addWall = false ;
	      this.maze = maze;
	      this.dijkstra = dijkstra;
	      setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;
	      buttonsPanel = new ButtonsPanel(this, maze,dijkstra);
	      setContentPane(buttonsPanel);


	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; // Explicit !

	      pack() ;            // Components sizes and positions
	      setVisible(true) ;  // The great show
	   }
	
	public void setEmptyMaze(int i, int j) {
		maze.setEmptyMaze(i, j);
		buttonsPanel.setMaze(maze);
		buttonsPanel.setVirginLayout();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(e.getSource() == drawingMenuBar.getActionsMenu().getSolveMenuItem()) {
			try {
				buttonsPanel.showSolvedMaze() ; 
				drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getSolveMenuItem());
				drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getEraseMenuItem());}
			catch(Exception nopath){
				JOptionPane.showMessageDialog(null, "No Path", "Alert", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == drawingMenuBar.getActionsMenu().getEraseMenuItem()) {
			buttonsPanel.setVirginLayout() ; 
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getEraseMenuItem());
			drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getSolveMenuItem());
		}
		if(e.getSource() == drawingMenuBar.getActionsMenu().getChangeArrivalMenuItem()) {
			changeArrival = true;
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getEraseMenuItem());
			drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getSolveMenuItem());
		}
		if(e.getSource() == drawingMenuBar.getActionsMenu().getChangeDepartureMenuItem()) {
			changeDeparture= true;
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getEraseMenuItem());
			drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getSolveMenuItem());
		}
		if(e.getSource() == drawingMenuBar.getFileMenu().getNewMenuItem()) {

			String sizetxt = JOptionPane.showInputDialog("Size ?");
			int size = Integer.parseInt(sizetxt);
			setEmptyMaze(size,size);

		}
		if(e.getSource() == drawingMenuBar.getActionsMenu().getRemoveWallMenuItem()) {
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getRemoveWallMenuItem());
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getAddWallMenuItem());
			drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getStopMenuItem());
			removeWall = true ;
		}
		
		if(e.getSource() == drawingMenuBar.getActionsMenu().getAddWallMenuItem()) {
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getAddWallMenuItem());
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getRemoveWallMenuItem());
			drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getStopMenuItem());
			addWall = true ;
		}
		
		if(e.getSource() == drawingMenuBar.getActionsMenu().getStopMenuItem()) {
			drawingMenuBar.getActionsMenu().remove(drawingMenuBar.getActionsMenu().getStopMenuItem());
			drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getAddWallMenuItem());
			drawingMenuBar.getActionsMenu().add(drawingMenuBar.getActionsMenu().getRemoveWallMenuItem());
			addWall =false;
			removeWall = false;
		}
		
		if(e.getSource() == drawingMenuBar.getFileMenu().getOpenMenuItem()) {
			 int returnVal = fc.showOpenDialog(DrawingApp.this);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
						try {
							maze.initFromTextFile(file.getAbsolutePath());
							buttonsPanel.setMaze(maze);
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
						buttonsPanel.setVirginLayout();
					
		        }
		}
		if(e.getSource() == drawingMenuBar.getFileMenu().getSaveMenuItem()) {
					 int returnVal = fc.showSaveDialog(DrawingApp.this);

				        if (returnVal == JFileChooser.APPROVE_OPTION) {
				            File file = fc.getSelectedFile();
								try {
									file.createNewFile();
									maze.saveToTextFile(file.getAbsolutePath());
									
								} catch (IOException e1) {
									
									e1.printStackTrace();
								}
								buttonsPanel.setVirginLayout();
							
				        }
		        }
		}
		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(changeArrival) {
			ColorIndicator box = (ColorIndicator) e.getSource();
			
			maze.setArrival(box.getXCoord(),box.getYCoord());
			buttonsPanel.setMaze(maze);
			buttonsPanel.setVirginLayout();
		    changeArrival = false;
			
		}
		if(changeDeparture) {
			ColorIndicator box = (ColorIndicator) e.getSource();
			maze.setDeparture(box.getXCoord(),box.getYCoord());	
			buttonsPanel.setMaze(maze);
			buttonsPanel.setVirginLayout();
			changeDeparture = false;
		}
		
		if (removeWall) {
			ColorIndicator box = (ColorIndicator) e.getSource() ;
			if (maze.getBox(box.getXCoord(),box.getYCoord()).getLabel() != "WBox") {
				removeWall= false;
				return ;
			}
			//remplacer la case W par une case E
			maze.setEBox(box.getXCoord(),box.getYCoord());
			buttonsPanel.setMaze(maze);
			buttonsPanel.setVirginLayout();
				}
		
		if (addWall) {
			ColorIndicator box = (ColorIndicator) e.getSource() ;
			if (maze.getBox(box.getXCoord(),box.getYCoord()).getLabel() != "EBox") {
				addWall= false;
				return ;
			}
			//remplacer la case E par une case W
			maze.setWBox(box.getXCoord(),box.getYCoord());
			buttonsPanel.setMaze(maze);
			buttonsPanel.setVirginLayout();
			
		}
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
