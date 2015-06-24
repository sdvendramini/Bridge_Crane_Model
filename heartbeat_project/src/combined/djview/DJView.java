package combined.djview;
    
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DJView implements ActionListener,  BeatObserver, BPMObserver, MatrizObserver {
	BeatModelInterface model;
	ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel bpmLabel;
    JPanel[][] posiciones;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JButton upBPMButton;
    JButton downBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
    
    public DJView(ControllerInterface controller, BeatModelInterface model) {	
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
		model.registerObserver((MatrizObserver)this);
    }
    
    public void createView() {
		// Create all Swing components here
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
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
        
        viewFrame.setLocation(150,300);
	}
  
    public void createView2()
    {
    	int filas=8;
    	int columnas=8;
    	
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	posiciones = new JPanel[filas][columnas]; 
		JPanel	deposito = new JPanel(new GridLayout(filas,columnas));
		for(int i=0;i<filas;i++)
    		for(int j=0;j<columnas;j++)
    		{
    			//JButton hola = new JButton(".");
    			posiciones[i][j]=new JPanel(new GridLayout(1,1));
    			posiciones[i][j].setBackground(new Color(90,58,7));
    			//posiciones[i][j].add(hola);
    			deposito.add(posiciones[i][j]);
    		}
    	JFrame paredes = new JFrame("Galpon");
    	paredes.setSize(new Dimension(1000, 800));
    	paredes.getContentPane().add(deposito, BorderLayout.CENTER);
    	updateMatriz(filas,columnas);
        paredes.pack();
        paredes.setVisible(true);
        paredes.setLocation(300,300);
        paredes.setSize(500, 500);
    }
    
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
        upBPMButton = new JButton("^");
        downBPMButton = new JButton("v");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);
        upBPMButton.addActionListener(this);
        downBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
 
		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(5, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(upBPMButton);
        insideControlPanel.add(buttonPanel);
        insideControlPanel.add(downBPMButton);
        controlPanel.add(insideControlPanel);
        
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
        
        controlFrame.setLocation(150,362);
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
		} else if (event.getSource() == upBPMButton) {
			controller.up();
		} else if (event.getSource() == downBPMButton) {
			controller.down();
		}
    }

	public void updateBPM() {
		
		if (model != null) {
			int bpm = model.getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("offline");
				}
			} else if(bpm == -10){
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("Disponible");
				}				
			}else if(bpm == -20){
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("Cargando");
				}else{
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("Current BPM: " + model.getBPM());
					}
				}
			}
		}
	}

    
	public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}
	
	public void updateMatriz(int filas, int columnas){
		int [][] matriz = new int[filas][columnas];
		
		BridgeCraneAdapter m = (BridgeCraneAdapter) model;
		matriz = m.getMatriz();
		
		for (int i=0; i<filas; i++)
			for (int j=0; j<columnas; j++)
			{
				if (matriz[i][j]==1)
					posiciones[i][j].setBackground(new Color(255,255,255));
				else 
					posiciones[i][j].setBackground(new Color(90,58,7));			
			}
		
	}
}
