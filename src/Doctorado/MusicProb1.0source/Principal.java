package Doctorado;

import java.awt.EventQueue;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Enumeration;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

import abc.notation.Tune;
import abc.parser.TuneParser;
import abc.ui.swing.JScoreComponent;
import abc.midi.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.TextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.FlowLayout;

public class Principal {

	private JFrame frame= new JFrame();
	private Tune tuneInit;
	private Tune tuneFinal;
	private final JTextField textFieldInit= new JTextField();
	private final JPanel panelMusicInit = new JPanel();
	private final JSeparator separator = new JSeparator();
	private final JLabel lblCabezaDelTema = new JLabel("Cabeza");
	private final JLabel lblDesinencia = new JLabel("Desinencia");
	private final JPanel panelMusicFinal = new JPanel();
	private final JTextField textFieldFinal = new JTextField();
	private final JButton btnPlayFinal = new JButton("Play");
	private final JButton btnPlayInit = new JButton("Play");
	private final JSlider sliderPuntoComienzoInit = new JSlider();
	private final JLabel lblProbabilidadLongitud = new JLabel("Punto de comienzo");
	private final JSeparator separator_1 = new JSeparator();
	private final JSlider sliderProbLongitudFin = new JSlider();
	private final JButton btnProcesar = new JButton("EJECUTAR");
	private final JLabel lblProbabilidadSilencioCon = new JLabel("Probab. mutacion silencio");
	private final JSlider sliderProbSilencio = new JSlider();
	private final JComboBox comboBoxRepeticiones = new JComboBox();
	private final JComboBox comboBoxPartes = new JComboBox();
	private final JLabel lblRepeticiones = new JLabel("Repeticiones");
	private final JLabel lblPuntoComienzoInit = new JLabel("0");
	JSlider sliderProbMutacionInit = new JSlider();
	JLabel lblProbabilidadMutacin = new JLabel("Probabilidad mutaci\u00F3n");
	private final JLabel lblProbMutacionInit = new JLabel("0");
	private final JRadioButton rdbtnPoissonInit = new JRadioButton("Poisson");
	private final JRadioButton rdbtnUniformeInit = new JRadioButton("Uniforme");
	private final JRadioButton rdbtnGaussianaInit = new JRadioButton("Gaussiana");
	ButtonGroup rgProbabilidadInit = new ButtonGroup();
	ButtonGroup rgProbabilidadFin = new ButtonGroup();
	ButtonGroup rgProbabilidadSilencio = new ButtonGroup();
	JRadioButton rdbtnPoissonFin = new JRadioButton("Poisson");
	JRadioButton rdbtnUniformeFin = new JRadioButton("Uniforme");
	JRadioButton rdbtnGaussianaFin = new JRadioButton("Gaussiana");
	JLabel label = new JLabel("Punto de comienzo");
	JLabel label_1 = new JLabel("Probabilidad mutaci\u00F3n");
	JLabel lblProbMutacionFin = new JLabel("0");
	JSlider sliderProbMutacionFin = new JSlider();
	private final JSlider sliderPuntoComienzoFin = new JSlider();
	private final JRadioButton rdbtnPoissonSilencio = new JRadioButton("Poisson");
	private final JRadioButton rdbtnUniformeSilencio = new JRadioButton("Uniforme");
	private final JRadioButton rdbtnGaussianaSilencio = new JRadioButton("Gaussiana");
	JComboBox comboSemicorcheasSilencio = new JComboBox();
	JLabel lblSemicorcheasDeSilencio = new JLabel("Semicorcheas de silencio");
	private final JLabel lblPuntoComienzoFin = new JLabel("0");
	private final JLabel lblProbSilencio = new JLabel("0");
	private final JLabel lblSilencios = new JLabel("Silencios");
	private final JMenu mnProceso = new JMenu("Proceso       ");
	private final JMenuItem mntmFicheromidSalida = new JMenuItem("Fichero .mid Salida...");
	private final JMenuItem mntmEjecutar = new JMenuItem("Ejecutar");
	private final JLabel lblPathSalida = new JLabel("Resultado");
	private JTextField txtPathMidi;
	JCheckBox chckbxCrecienteInit = new JCheckBox("Creciente");
	JCheckBox chckbxCrecienteFin = new JCheckBox("Creciente");
	private final JCheckBox chckbxQuitarInicioInit = new JCheckBox("Quitar inicio");
	private final JCheckBox chckbxQuitarInicioFin = new JCheckBox("Quitar inicio");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		colocaInterface();
		changeMusicInit();
		changeMusicFinal();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		for(int i=1;i<50;i++)
		{
		comboBoxRepeticiones.addItem(i);
		comboBoxPartes.addItem(i);
		comboSemicorcheasSilencio.addItem(i);
		}

		

		
		
		
		btnPlayInit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TunePlayer player = new TunePlayer();
				//starts the player and play the tune
				player.start();
				player.play(tuneInit);
			}
		});
		btnPlayFinal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TunePlayer player = new TunePlayer();
				//starts the player and play the tune
				player.start();
				player.play(tuneFinal);
				
			}
		});
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProcesar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				procesar();
				
			}
		});
		sliderPuntoComienzoInit.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				String valor=Integer.toString(sliderPuntoComienzoInit.getValue());
				lblPuntoComienzoInit.setText(valor);
			}
		});
		
		sliderPuntoComienzoInit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String valor=Integer.toString(sliderPuntoComienzoInit.getValue());
				lblPuntoComienzoInit.setText(valor);
			}
		});
		sliderProbMutacionInit.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				String valor=Integer.toString(sliderProbMutacionInit.getValue());
				lblProbMutacionInit.setText(valor);
			}
		});
		sliderProbMutacionInit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String valor=Integer.toString(sliderProbMutacionInit.getValue());
				lblProbMutacionInit.setText(valor);
			}
		});
		
		sliderPuntoComienzoFin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				String valor=Integer.toString(sliderPuntoComienzoFin.getValue());
				lblPuntoComienzoFin.setText(valor);
			}
		});
		
		sliderPuntoComienzoFin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String valor=Integer.toString(sliderPuntoComienzoFin.getValue());
				lblPuntoComienzoFin.setText(valor);
			}
		});
		sliderProbMutacionFin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				String valor=Integer.toString(sliderProbMutacionFin.getValue());
				lblProbMutacionFin.setText(valor);
			}
		});
		sliderProbMutacionFin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String valor=Integer.toString(sliderProbMutacionFin.getValue());
				lblProbMutacionFin.setText(valor);
			}
		});
		sliderProbSilencio.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				String valor=Integer.toString(sliderProbSilencio.getValue());
				lblProbSilencio.setText(valor);
			}
		});
		sliderProbSilencio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String valor=Integer.toString(sliderProbSilencio.getValue());
				lblProbSilencio.setText(valor);
			}
		});
		
		
		
		

	}

//This method returns the selected radio button in a button group
public static JRadioButton getSelection(ButtonGroup group) {
 for (Enumeration e=group.getElements(); e.hasMoreElements(); ) {
     JRadioButton b = (JRadioButton)e.nextElement();
     if (b.getModel() == group.getSelection()) {
         return b;
     }
 }
 return null;
}
private void procesar()
{
	ProcesaMusicRandom pm=new ProcesaMusicRandom();
	
	String strMusicInit=textFieldInit.getText();
	String strMusicFinal=textFieldFinal.getText();
	double puntoComienzoInit=(double)sliderPuntoComienzoInit.getValue()/100;
	double puntoComienzoFin=(double)sliderPuntoComienzoFin.getValue()/100;
	double probMutacionInit=(double)sliderProbMutacionInit.getValue()/100;
	double probMutacionFin=(double)sliderProbMutacionFin.getValue()/100;
	double probSilencio=(double)sliderProbSilencio.getValue()/100;
	int partes=Integer.parseInt(comboBoxPartes.getSelectedItem().toString());
	int repeticiones=1+Integer.parseInt(comboBoxRepeticiones.getSelectedItem().toString());
	int semicorcheasSilencio=Integer.parseInt(comboSemicorcheasSilencio.getSelectedItem().toString());
	String distribucionProbabilidadInit=getSelection(rgProbabilidadInit).getText();
	String distribucionProbabilidadFin=getSelection(rgProbabilidadFin).getText();
	String distribucionProbabilidadSilencio=getSelection(rgProbabilidadSilencio).getText();
	String pathOutMidi=txtPathMidi.getText();
	boolean isCrecienteInit=chckbxCrecienteInit.isSelected();
	boolean isCrecienteFin=chckbxCrecienteFin.isSelected();
	boolean isQuitarInicioInit=chckbxQuitarInicioInit.isSelected();
	boolean isQuitarInicioFin=chckbxQuitarInicioFin.isSelected();
	
	pm.setHead(strMusicInit, puntoComienzoInit, probMutacionInit, distribucionProbabilidadInit, isCrecienteInit, isQuitarInicioInit);
	pm.setEnd(strMusicFinal, puntoComienzoFin, probMutacionFin, distribucionProbabilidadFin, isCrecienteFin, isQuitarInicioFin);
	pm.setSilence(probSilencio, distribucionProbabilidadSilencio, repeticiones, partes, semicorcheasSilencio);
	pm.setOutMidi(pathOutMidi);
	
	pm.procesa();
}
private void colocaInterface()
{
	frame.setBounds(100, 100, 887, 738);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	textFieldInit.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			changeMusicInit();
		}
	});
	textFieldInit.setBounds(21, 197, 549, 20);
	frame.getContentPane().add(textFieldInit);
	textFieldInit.setColumns(10);
	FlowLayout flowLayout = (FlowLayout) panelMusicInit.getLayout();
	flowLayout.setAlignment(FlowLayout.LEFT);
	panelMusicInit.setBounds(23, 30, 547, 156);
	frame.getContentPane().add(panelMusicInit);
	
	btnPlayInit.setBounds(608, 194, 89, 23);
	frame.getContentPane().add(btnPlayInit);
	separator.setBounds(0, 245, 916, 10);
	
	frame.getContentPane().add(separator);
	lblCabezaDelTema.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblCabezaDelTema.setBounds(23, 11, 186, 14);
	
	frame.getContentPane().add(lblCabezaDelTema);
	lblDesinencia.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDesinencia.setBounds(21, 266, 186, 14);
	
	frame.getContentPane().add(lblDesinencia);
	FlowLayout flowLayout_1 = (FlowLayout) panelMusicFinal.getLayout();
	flowLayout_1.setAlignment(FlowLayout.LEFT);
	panelMusicFinal.setBounds(23, 285, 547, 144);
	
	frame.getContentPane().add(panelMusicFinal);
	textFieldFinal.addKeyListener(new KeyAdapter() {

		@Override
		public void keyReleased(KeyEvent e) {
			changeMusicFinal();
		}
	});


	textFieldFinal.setColumns(10);
	textFieldFinal.setBounds(23, 440, 547, 20);
	
	frame.getContentPane().add(textFieldFinal);
	
	btnPlayFinal.setBounds(608, 439, 89, 23);
	
	frame.getContentPane().add(btnPlayFinal);
	
	
	sliderPuntoComienzoInit.setValue(0);
	
	sliderPuntoComienzoInit.setBounds(613, 53, 137, 23);
	frame.getContentPane().add(sliderPuntoComienzoInit);
	
	
	lblProbabilidadLongitud.setBounds(613, 28, 117, 14);
	frame.getContentPane().add(lblProbabilidadLongitud);
	
	
	separator_1.setBounds(0, 473, 916, 10);
	frame.getContentPane().add(separator_1);
	sliderProbLongitudFin.setValue(100);
	
	
	btnProcesar.setBounds(711, 595, 137, 57);
	frame.getContentPane().add(btnProcesar);
	lblProbabilidadSilencioCon.setHorizontalAlignment(SwingConstants.RIGHT);
	
	lblProbabilidadSilencioCon.setBounds(21, 561, 162, 23);
	frame.getContentPane().add(lblProbabilidadSilencioCon);
	sliderProbSilencio.setValue(0);
	
	sliderProbSilencio.setBounds(219, 561, 101, 23);
	frame.getContentPane().add(sliderProbSilencio);
	
	comboBoxRepeticiones.setBounds(219, 596, 76, 20);
	frame.getContentPane().add(comboBoxRepeticiones);
	lblRepeticiones.setHorizontalAlignment(SwingConstants.RIGHT);
	
	lblRepeticiones.setBounds(21, 595, 162, 23);
	frame.getContentPane().add(lblRepeticiones);
	lblPuntoComienzoInit.setHorizontalAlignment(SwingConstants.CENTER);
	

	lblPuntoComienzoInit.setBounds(569, 53, 46, 14);
	frame.getContentPane().add(lblPuntoComienzoInit);
	
	JLabel lblPartes = new JLabel("Partes");
	lblPartes.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPartes.setBounds(23, 631, 162, 23);
	frame.getContentPane().add(lblPartes);
	
	
	comboBoxPartes.setBounds(219, 628, 76, 20);
	frame.getContentPane().add(comboBoxPartes);
	
	

	sliderProbMutacionInit.setValue(0);
	sliderProbMutacionInit.setBounds(613, 140, 137, 23);
	frame.getContentPane().add(sliderProbMutacionInit);
	

	lblProbabilidadMutacin.setBounds(613, 118, 117, 14);
	frame.getContentPane().add(lblProbabilidadMutacin);
	lblProbMutacionInit.setHorizontalAlignment(SwingConstants.CENTER);
	lblProbMutacionInit.setBounds(569, 143, 46, 14);
	
	frame.getContentPane().add(lblProbMutacionInit);
	rdbtnPoissonInit.setBounds(756, 144, 92, 23);
	
	frame.getContentPane().add(rdbtnPoissonInit);
	rdbtnUniformeInit.setSelected(true);
	rdbtnUniformeInit.setBounds(756, 118, 92, 23);
	
	frame.getContentPane().add(rdbtnUniformeInit);
	rdbtnGaussianaInit.setBounds(756, 170, 92, 23);
	
	frame.getContentPane().add(rdbtnGaussianaInit);

	
	rgProbabilidadInit.add(rdbtnPoissonInit);
	rgProbabilidadInit.add(rdbtnUniformeInit);
	rgProbabilidadInit.add(rdbtnGaussianaInit);
	
	rgProbabilidadFin.add(rdbtnPoissonFin);
	rgProbabilidadFin.add(rdbtnUniformeFin);
	rgProbabilidadFin.add(rdbtnGaussianaFin);
	
	rgProbabilidadSilencio.add(rdbtnPoissonSilencio);
	rgProbabilidadSilencio.add(rdbtnUniformeSilencio);
	rgProbabilidadSilencio.add(rdbtnGaussianaSilencio);
	
	rdbtnPoissonFin.setBounds(756, 390, 109, 23);
	frame.getContentPane().add(rdbtnPoissonFin);
	rdbtnUniformeFin.setSelected(true);
	

	rdbtnUniformeFin.setBounds(756, 364, 109, 23);
	frame.getContentPane().add(rdbtnUniformeFin);
	

	rdbtnGaussianaFin.setBounds(756, 417, 109, 23);
	frame.getContentPane().add(rdbtnGaussianaFin);
	

	label.setBounds(613, 283, 117, 14);
	frame.getContentPane().add(label);
	

	label_1.setBounds(613, 364, 117, 14);
	frame.getContentPane().add(label_1);
	lblProbMutacionFin.setHorizontalAlignment(SwingConstants.CENTER);
	

	lblProbMutacionFin.setBounds(580, 389, 35, 14);
	frame.getContentPane().add(lblProbMutacionFin);
	

	sliderProbMutacionFin.setValue(0);
	sliderProbMutacionFin.setBounds(613, 386, 137, 23);
	frame.getContentPane().add(sliderProbMutacionFin);
	sliderPuntoComienzoFin.setValue(0);
	sliderPuntoComienzoFin.setBounds(613, 305, 137, 23);
	
	frame.getContentPane().add(sliderPuntoComienzoFin);
	rdbtnPoissonSilencio.setBounds(326, 574, 109, 23);
	
	frame.getContentPane().add(rdbtnPoissonSilencio);
	rdbtnUniformeSilencio.setSelected(true);
	rdbtnUniformeSilencio.setBounds(326, 555, 109, 23);
	
	frame.getContentPane().add(rdbtnUniformeSilencio);
	rdbtnGaussianaSilencio.setBounds(326, 593, 109, 23);
	
	frame.getContentPane().add(rdbtnGaussianaSilencio);
	

	comboSemicorcheasSilencio.setBounds(219, 530, 76, 20);
	frame.getContentPane().add(comboSemicorcheasSilencio);
	lblSemicorcheasDeSilencio.setHorizontalAlignment(SwingConstants.RIGHT);
	
	lblSemicorcheasDeSilencio.setBounds(21, 536, 162, 14);
	frame.getContentPane().add(lblSemicorcheasDeSilencio);
	

	

	frame.getContentPane().add(textFieldInit);
	lblPuntoComienzoFin.setHorizontalAlignment(SwingConstants.CENTER);
	lblPuntoComienzoFin.setBounds(580, 308, 35, 14);
	
	frame.getContentPane().add(lblPuntoComienzoFin);
	lblProbSilencio.setHorizontalAlignment(SwingConstants.CENTER);
	lblProbSilencio.setBounds(179, 565, 35, 14);
	
	frame.getContentPane().add(lblProbSilencio);
	lblSilencios.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSilencios.setBounds(21, 493, 186, 14);
	
	frame.getContentPane().add(lblSilencios);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setBounds(569, 679, 1, -206);
	frame.getContentPane().add(separator_2);
	
	Box horizontalBox_2 = Box.createHorizontalBox();
	horizontalBox_2.setBounds(31, 518, 401, 150);
	frame.getContentPane().add(horizontalBox_2);
	
	JSeparator separator_3 = new JSeparator();
	separator_3.setOrientation(SwingConstants.VERTICAL);
	separator_3.setBounds(510, 477, 10, 202);
	frame.getContentPane().add(separator_3);
	lblPathSalida.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPathSalida.setBounds(523, 494, 186, 14);
	
	frame.getContentPane().add(lblPathSalida);
	
	txtPathMidi = new JTextField();
	txtPathMidi.setText("default.mid");
	txtPathMidi.setBounds(530, 547, 332, 20);
	frame.getContentPane().add(txtPathMidi);
	txtPathMidi.setColumns(10);
	
	JLabel lblPathDeSalida = new JLabel("Path de salida");
	lblPathDeSalida.setBounds(530, 530, 117, 14);
	frame.getContentPane().add(lblPathDeSalida);
	
	
	chckbxCrecienteInit.setBounds(756, 30, 97, 23);
	frame.getContentPane().add(chckbxCrecienteInit);
	chckbxCrecienteFin.setBounds(756, 290, 97, 23);
	
	frame.getContentPane().add(chckbxCrecienteFin);
	chckbxQuitarInicioInit.setBounds(756, 53, 97, 23);
	
	frame.getContentPane().add(chckbxQuitarInicioInit);
	chckbxQuitarInicioFin.setBounds(756, 316, 97, 23);
	
	frame.getContentPane().add(chckbxQuitarInicioFin);
	
	JMenuBar menuBar = new JMenuBar();
	frame.setJMenuBar(menuBar);
	
	JMenu mnArchivo = new JMenu("Archivo      ");
	menuBar.add(mnArchivo);
	
	JMenuItem mntmNuevo = new JMenuItem("Nuevo...");
	mntmNuevo.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent arg0) {
			setBlank();
		}
	});
	mnArchivo.add(mntmNuevo);
	
	JMenuItem mntmNewMenuItem_4 = new JMenuItem("Abrir...");
	mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			Document doc;
			 String strXML="";
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int seleccion = fileChooser.showOpenDialog(frame);
			if (seleccion == JFileChooser.APPROVE_OPTION)
			{
				 try {
				   File fichero = fileChooser.getSelectedFile();
				   BufferedReader reader = new BufferedReader(new FileReader(fichero));
				   String linea = reader.readLine();
				  
				   while (linea != null)
				   {
				      strXML+=linea;
						linea = reader.readLine();
					
				     
				   } 
				 } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			   doc=string2DOM(strXML);
			   processDoc(doc);
			}
		}
	});
	mnArchivo.add(mntmNewMenuItem_4);
	
	JMenuItem mntmGuardar = new JMenuItem("Guardar...");
	mntmGuardar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			//Creamos el XML del documento
			Document doc=makeDoc();
			System.out.print(DOM2String(doc));
			String strXML=DOM2String(doc);
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int seleccion = fileChooser.showSaveDialog(frame);
			if (seleccion == JFileChooser.APPROVE_OPTION)
			{
			   File fichero = fileChooser.getSelectedFile();
			   try{
				   PrintWriter writer = new PrintWriter(fichero);
			   writer.print(strXML);
			   writer.close();
			   }
			   catch(Exception error){
				   
			   }
			   
			}
			
		}});
	
	mnArchivo.add(mntmGuardar);
	
	JMenuItem mntmSalir = new JMenuItem("Salir");
	mnArchivo.add(mntmSalir);
	
	menuBar.add(mnProceso);
	mntmFicheromidSalida.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int seleccion = fileChooser.showOpenDialog(frame);
			if (seleccion == JFileChooser.APPROVE_OPTION)
			{
			   File fichero = fileChooser.getSelectedFile();
			   txtPathMidi.setText(fichero.getAbsolutePath());
			}
		}
	});

	mnProceso.add(mntmFicheromidSalida);
	
	mnProceso.add(mntmEjecutar);
	
	JMenu mnAyuda = new JMenu("Ayuda");
	menuBar.add(mnAyuda);
	
	JMenuItem mntmNewMenuItem = new JMenuItem("Contenido...");
	mnAyuda.add(mntmNewMenuItem);
	
	JMenuItem mntmNewMenuItem_1 = new JMenuItem("Acerca de...");
	mnAyuda.add(mntmNewMenuItem_1);
	
	
	
}
public String DOM2String(Document doc)
{
    TransformerFactory transformerFactory =TransformerFactory.newInstance();
    Transformer transformer = null;
    try{
        transformer = transformerFactory.newTransformer();
    }catch (javax.xml.transform.TransformerConfigurationException error){
        
        return null;
    }

    Source source = new DOMSource(doc);

    StringWriter writer = new StringWriter();
    Result result = new StreamResult(writer);
    try{
        transformer.transform(source,result);
    }catch (javax.xml.transform.TransformerException error){
       
        return null;
    }

    String s = writer.toString();
    return s;
}
public Document string2DOM(String s)
{
    Document tmpX=null;
    DocumentBuilder builder = null;
    try{
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }catch(javax.xml.parsers.ParserConfigurationException error){
       
        return null;
    }
    try{
        tmpX=builder.parse(new ByteArrayInputStream(s.getBytes()));
    }catch(org.xml.sax.SAXException error){
       
        return null;
    }catch(IOException error){
       
        return null;
    }
    return tmpX;
}
private Document makeDoc() {
    try {
      DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = fact.newDocumentBuilder();
      Document doc = parser.newDocument();

      Node root = doc.createElement("xml");
      doc.appendChild(root);

      Node head = doc.createElement("head");
      root.appendChild(head);
	      
	      Node score = doc.createElement("score");
	      head.appendChild(score);
	      score.appendChild(doc.createTextNode(textFieldInit.getText()));
	      
	      Node startPoint = doc.createElement("startPoint");
	      head.appendChild(startPoint);
	      startPoint.appendChild(doc.createTextNode(Integer.toString(sliderPuntoComienzoInit.getValue())));
	      
	      Node mutationProb = doc.createElement("mutationProb");
	      head.appendChild(mutationProb);
	      mutationProb.appendChild(doc.createTextNode(Integer.toString(sliderProbMutacionInit.getValue())));
	
	      Node distributionProbType = doc.createElement("distributionProbType");
	      head.appendChild(distributionProbType);
	      distributionProbType.appendChild(doc.createTextNode(getSelection(rgProbabilidadInit).getText()));
      
      Node end = doc.createElement("end");
      root.appendChild(end);
      
	      Node score2 = doc.createElement("score");
	      end.appendChild(score2);
	      score2.appendChild(doc.createTextNode(textFieldFinal.getText()));
	      
	      Node startPoint2 = doc.createElement("startPoint");
	      end.appendChild(startPoint2);
	      startPoint2.appendChild(doc.createTextNode(Integer.toString(sliderPuntoComienzoFin.getValue())));
	      
	      Node mutationProb2 = doc.createElement("mutationProb");
	      end.appendChild(mutationProb2);
	      mutationProb2.appendChild(doc.createTextNode(Integer.toString(sliderProbMutacionFin.getValue())));
	
	      Node distributionProbType2 = doc.createElement("distributionProbType");
	      end.appendChild(distributionProbType2);
	      distributionProbType2.appendChild(doc.createTextNode(getSelection(rgProbabilidadFin).getText()));
      
      Node silence = doc.createElement("silence");
      root.appendChild(silence);
      
	      Node mutationProbSilence = doc.createElement("mutationProb");
	      silence.appendChild(mutationProbSilence);
	      mutationProbSilence.appendChild(doc.createTextNode(Integer.toString(sliderProbSilencio.getValue())));
	      
	      Node distributionProbTypeSilence = doc.createElement("distributionProbType");
	      silence.appendChild(distributionProbTypeSilence);
	      distributionProbTypeSilence.appendChild(doc.createTextNode(getSelection(rgProbabilidadSilencio).getText()));
	      
	      Node repeat = doc.createElement("repeat");
	      silence.appendChild(repeat);
	      repeat.appendChild(doc.createTextNode(comboBoxRepeticiones.getSelectedItem().toString()));
	      
	      Node parts = doc.createElement("parts");
	      silence.appendChild(parts);
	      parts.appendChild(doc.createTextNode(comboBoxPartes.getSelectedItem().toString()));
	      
	      Node semiquavers = doc.createElement("semiquavers");
	      silence.appendChild(semiquavers);
	      semiquavers.appendChild(doc.createTextNode(comboSemicorcheasSilencio.getSelectedItem().toString()));
	      
	  Node pathOutMidi = doc.createElement("pathOutMidi");
	  root.appendChild(pathOutMidi);
	  pathOutMidi.appendChild(doc.createTextNode(txtPathMidi.getText()));
	  
      return doc;

    } catch (Exception ex) {
      System.err.println("+============================+");
      System.err.println("|        XML Error           |");
      System.err.println("+============================+");
      System.err.println(ex.getClass());
      System.err.println(ex.getMessage());
      System.err.println("+============================+");
      return null;
    }
  }
private void setBlank()
{
	textFieldInit.setText("") ;
    sliderPuntoComienzoInit.setValue(0);
    lblPuntoComienzoInit.setText("0");
    sliderProbMutacionInit.setValue(0);
    lblProbMutacionInit.setText("0");
    rdbtnUniformeInit.setSelected(true);
   
    textFieldFinal.setText("") ;
    sliderPuntoComienzoFin.setValue(0);
    lblPuntoComienzoFin.setText("0");
    sliderProbMutacionFin.setValue(0);
    lblProbMutacionFin.setText("0");
    rdbtnUniformeFin.setSelected(true);
    
    sliderProbSilencio.setValue(0);
    lblProbSilencio.setText("0");

    rdbtnUniformeSilencio.setSelected(true);
    comboSemicorcheasSilencio.setSelectedIndex(0);
    comboBoxRepeticiones.setSelectedIndex(0);
    comboBoxPartes.setSelectedIndex(0);
    
    txtPathMidi.setText("default.mid");
	changeMusicInit();
	changeMusicFinal();
}
private void processDoc(Document doc) {
	//para head
	NodeList nList = doc.getElementsByTagName("head");
	for (int temp = 0; temp < nList.getLength(); temp++) {

	   Node nNode = nList.item(temp);
	   if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	      Element eElement = (Element) nNode;

	      textFieldInit.setText(getTagValue("score", eElement)) ;
	      sliderPuntoComienzoInit.setValue(Integer.valueOf(getTagValue("startPoint", eElement)));
	      lblPuntoComienzoInit.setText(getTagValue("startPoint", eElement));
	      sliderProbMutacionInit.setValue(Integer.valueOf(getTagValue("mutationProb", eElement)));
	      lblProbMutacionInit.setText(getTagValue("mutationProb", eElement));
	      String strRB=getTagValue("distributionProbType", eElement);
	      if(strRB.equals("Uniforme"))rdbtnUniformeInit.setSelected(true);
	      if(strRB.equals("Gaussiana"))rdbtnGaussianaInit.setSelected(true);
	      if(strRB.equals("Poisson"))rdbtnPoissonInit.setSelected(true);
	   }
	}
	//para end
	nList = doc.getElementsByTagName("end");
	for (int temp = 0; temp < nList.getLength(); temp++) {

	   Node nNode = nList.item(temp);
	   if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	      Element eElement = (Element) nNode;

	      textFieldFinal.setText(getTagValue("score", eElement)) ;
	      sliderPuntoComienzoFin.setValue(Integer.valueOf(getTagValue("startPoint", eElement)));
	      lblPuntoComienzoFin.setText(getTagValue("startPoint", eElement));
	      sliderProbMutacionFin.setValue(Integer.valueOf(getTagValue("mutationProb", eElement)));
	      lblProbMutacionFin.setText(getTagValue("mutationProb", eElement));
	      String strRB=getTagValue("distributionProbType", eElement);
	      if(strRB.equals("Uniforme"))rdbtnUniformeFin.setSelected(true);
	      if(strRB.equals("Gaussiana"))rdbtnGaussianaFin.setSelected(true);
	      if(strRB.equals("Poisson"))rdbtnPoissonFin.setSelected(true);
	   }
	}
	//para silencio
	nList = doc.getElementsByTagName("silence");
	for (int temp = 0; temp < nList.getLength(); temp++) {

	   Node nNode = nList.item(temp);
	   if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	      Element eElement = (Element) nNode;
	      sliderProbSilencio.setValue(Integer.valueOf(getTagValue("mutationProb", eElement)));
	      lblProbSilencio.setText(getTagValue("mutationProb", eElement));
	      String strRB=getTagValue("distributionProbType", eElement);
	      if(strRB.equals("Uniforme"))rdbtnUniformeSilencio.setSelected(true);
	      if(strRB.equals("Gaussiana"))rdbtnGaussianaSilencio.setSelected(true);
	      if(strRB.equals("Poisson"))rdbtnPoissonSilencio.setSelected(true);
	      
	      comboSemicorcheasSilencio.setSelectedIndex(-1+Integer.parseInt(getTagValue("semiquavers", eElement)));
	      comboBoxRepeticiones.setSelectedIndex(-1+Integer.parseInt(getTagValue("repeat", eElement)));
	      comboBoxPartes.setSelectedIndex(-1+Integer.parseInt(getTagValue("parts", eElement)));
	   }
	}
	//para path
	nList = doc.getElementsByTagName("xml");
	for (int temp = 0; temp < nList.getLength(); temp++) {

	   Node nNode = nList.item(temp);
	   if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	      Element eElement = (Element) nNode;
	      txtPathMidi.setText(getTagValue("pathOutMidi", eElement));
	      
	   }
	}
	changeMusicInit();
	changeMusicFinal();
		   
	
	
}
	 private static String getTagValue(String sTag, Element eElement) {
			NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		 
		        Node nValue = (Node) nlList.item(0);
		 
			return nValue.getNodeValue();
		  }
public void changeMusicInit()
{
	String tuneAsString="X:2\nM:2/4\nK:C\n";
	tuneAsString += textFieldInit.getText().toString();
	tuneAsString+="\n";
	tuneInit = new TuneParser().parse(tuneAsString);
	JScoreComponent scoreUI =new JScoreComponent();
	scoreUI.setTune(tuneInit);
	panelMusicInit.removeAll();
	panelMusicInit.add(scoreUI);
	panelMusicInit.repaint();
	panelMusicInit.setVisible(true);
}
public void changeMusicFinal()
{
	String tuneAsString="X:2\nM:2/4\nK:C\n";
	tuneAsString += textFieldFinal.getText().toString();
	tuneAsString+="\n";
	tuneFinal = new TuneParser().parse(tuneAsString);
	JScoreComponent scoreUI =new JScoreComponent();
	scoreUI.setTune(tuneFinal);
	panelMusicFinal.removeAll();
	panelMusicFinal.add(scoreUI);
	panelMusicFinal.repaint();
	panelMusicFinal.setVisible(true);
	
}
}

