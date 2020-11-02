package View;
    
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

<<<<<<< HEAD:bridge_crane_project/src/View/DJView.java
import Controller.BeatController;
import Controller.BridgeCraneController;
import Controller.ControllerInterface;
import Controller.HeartController;
import Model.BeatModelInterface;
import Model.BridgeCraneAdapter;

public class DJView implements ActionListener,  BeatObserver, BPMObserver, MatrizObserver {
=======
import Controller.ControllerInterface;
import Model.BeatModelInterface;

public class DJView implements ActionListener,  BeatObserver, BPMObserver {
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/DJView.java
	BeatModelInterface model;
	ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
<<<<<<< HEAD:bridge_crane_project/src/View/DJView.java
    JLabel positionNumber;
    JFrame paredes;
    int type;
    
=======

>>>>>>> origin/Third:heartbeat_project/src/combined/djview/DJView.java
    public DJView(ControllerInterface controller, BeatModelInterface model) {	
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
    }
    
    public void createView() {
		// Create all Swing components here
<<<<<<< HEAD:bridge_crane_project/src/View/DJView.java
    	JFrame.setDefaultLookAndFeelDecorated(false);
    	viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");              
=======
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/DJView.java
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        
<<<<<<< HEAD:bridge_crane_project/src/View/DJView.java
        if(type==3)
        	viewFrame.setLocation(148,200);
        else if(type==2)
            viewFrame.setLocation(925,200);	
        else if(type==1)
            viewFrame.setLocation(1198,200);	
	}
  
    public void createView2()
    {
    	int filas=8;
    	int columnas=8;
    	
    	JFrame.setDefaultLookAndFeelDecorated(false);
    	posiciones = new JPanel[filas][columnas]; 
		JPanel	deposito = new JPanel(new GridLayout(filas,columnas));
		for(int i=0;i<filas;i++)
    		for(int j=0;j<columnas;j++)
    		{
    			posiciones[i][j]=new JPanel(new GridLayout(1,1));
    			posiciones[i][j].setBackground(new Color(90,58,7));
    			deposito.add(posiciones[i][j]);
    		}
		
		positionNumber = new JLabel("Posicion de la grua: ", SwingConstants.LEFT);
		JSplitPane general = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		general.setBottomComponent(deposito);
		general.setTopComponent(positionNumber);

		
    	paredes = new JFrame("Deposito");
    	paredes.setSize(new Dimension(1000, 800));
    	paredes.getContentPane().add(general, BorderLayout.CENTER);
    	updateMatriz(filas,columnas);
        paredes.pack();
        paredes.setVisible(true);
        paredes.setLocation(310,200);
        paredes.setSize(500, 500);
        paredes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
=======
        viewFrame.setLocation(148,200);	//Se agrega para mejorar la organizacion de las ventanas en pantalla.
	}
  
  
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/DJView.java
    public void createControls() {
		// Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));

        menuBar = new JMenuBar();
        menu = new JMenu("DJ Control");
        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.start();
            }
        });
        stopMenuItem = new JMenuItem("Stop");
        menu.add(stopMenuItem); 
        stopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.stop();
            }
        });
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menu.add(exit);
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10,40));
        increaseBPMButton = new JButton(">>");
        decreaseBPMButton = new JButton("<<");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);
        
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
        
        controlFrame.pack();
        controlFrame.setVisible(true);
        
<<<<<<< HEAD:bridge_crane_project/src/View/DJView.java
        if(type==3)
        controlFrame.setLocation(150,269);
        else if(type==2)
        controlFrame.setLocation(927,269);	
        else if(type==1)
        controlFrame.setLocation(1200,269);	
=======
        controlFrame.setLocation(150,292); //Se agrega para mejorar la organizacion de las ventanas en pantalla.
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/DJView.java
    }

	public void enableStopMenuItem() {
    	stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
    	stopMenuItem.setEnabled(false);
	}

	public void enableStartMenuItem() {
    	startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
    	startMenuItem.setEnabled(false);
	}

    public void actionPerformed(ActionEvent event) {
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
        	controller.setBPM(bpm);
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
    }

	public void updateBPM() {
		if (model != null) {
			int bpm = model.getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("offline");
				}
			} else {
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("Current BPM: " + model.getBPM());
				}
			}
		}
	}
  
	public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}
<<<<<<< HEAD:bridge_crane_project/src/View/DJView.java
	
	public void updateMatriz(int filas, int columnas){
		int [][] matriz = new int[filas][columnas];
		
		BridgeCraneAdapter m = (BridgeCraneAdapter) model;
		matriz = m.getMatriz();
		
		for (int i=0; i<filas; i++)
			for (int j=0; j<columnas; j++)
			{
				if (matriz[i][j]==1)
					{
						posiciones[i][j].setBackground(new Color(255,255,255));
						positionNumber.setText("Posicion de la grua: " + "Fila: " + i + ", Columna: " + j);
					}
				else 
					posiciones[i][j].setBackground(new Color(90,58,7));			
			}
		
	}
	
	public void verificar()
	{
		try
		{
			BeatController b = (BeatController) controller;
			type = 1;
		}
		catch(ClassCastException e){}
	
		try
		{
			HeartController h = (HeartController) controller;
			type = 2;
		}
		catch(ClassCastException r) {}
		
		try
		{
			BridgeCraneController c = (BridgeCraneController) controller;
			type = 3;
		}
		catch(ClassCastException t) {}
		
	}
=======
>>>>>>> origin/Third:heartbeat_project/src/combined/djview/DJView.java
}
