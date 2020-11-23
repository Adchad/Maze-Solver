	package ui;
	import javax.swing.*;

	public class ActionsMenu extends JMenu{
		 private final SolveMenuItem solveMenuItem ;
		 private final EraseMenuItem eraseMenuItem;
		 private final ChangeDepartureMenuItem changeDepartureMenuItem;
		 private final ChangeArrivalMenuItem changeArrivalMenuItem;
		 private final RemoveWallMenuItem removeWallMenuItem ;
		 private final AddWallMenuItem addWallMenuItem ;
		 private final StopMenuItem stopMenuItem;

		   public StopMenuItem getStopMenuItem() {
			return stopMenuItem;
		}

		public ChangeArrivalMenuItem getChangeArrivalMenuItem() {
			return changeArrivalMenuItem;
		}

		public ChangeDepartureMenuItem getChangeDepartureMenuItem() {
			return changeDepartureMenuItem;
		}

		public EraseMenuItem getEraseMenuItem() {
			return eraseMenuItem;
		}

		public SolveMenuItem getSolveMenuItem() {
			return solveMenuItem;
		}
		
		public RemoveWallMenuItem getRemoveWallMenuItem() {
			return removeWallMenuItem;
		}
		public AddWallMenuItem getAddWallMenuItem() {
			return addWallMenuItem ;
		}

		public ActionsMenu(DrawingApp drawingApp)
		   {
		      super("Actions") ;

		      // Create and add menu items
		      eraseMenuItem = new EraseMenuItem(drawingApp);
		      stopMenuItem = new StopMenuItem(drawingApp);
		      // these 2 MenuItem don't have to exist at the launch 
		      
		      add(solveMenuItem=new SolveMenuItem(drawingApp)) ;
		      add(changeDepartureMenuItem  = new ChangeDepartureMenuItem(drawingApp));
		      add(changeArrivalMenuItem = new ChangeArrivalMenuItem(drawingApp));
		      add(removeWallMenuItem= new RemoveWallMenuItem(drawingApp));
		      add(addWallMenuItem= new AddWallMenuItem(drawingApp));
		   }
	}


