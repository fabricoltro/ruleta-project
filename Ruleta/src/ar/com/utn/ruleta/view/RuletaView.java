package ar.com.utn.ruleta.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ar.com.utn.ruleta.dao.JugadorDao;
import ar.com.utn.ruleta.dao.Opcion2NumeroDAO;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.Numero;
import ar.com.utn.ruleta.modelo.Opcion;
import ar.com.utn.ruleta.modelo.Opcion1Numero;
import ar.com.utn.ruleta.modelo.Opcion2Numeros;
import ar.com.utn.ruleta.modelo.Opcion4Numeros;
import ar.com.utn.ruleta.modelo.OpcionGrupoRojo;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class RuletaView implements View {

	private JFrame frame;
	private JTable tblApuesta;
	private JTextField textField_2;
	private JCheckBox chckbxRojo;
	private JCheckBox cbPrimerColumna;
	//atributos para mi uso
	private List<Opcion> opciones = new ArrayList<Opcion>();
	private String arrayOpciones[][];
	
	//array de numeros
	private String arrayJugadores		[]					;
	private String arrayNumeros			[]	= new String[37];
	private String arrayDosNumeros		[] 	= new String[57];
	private String arrayCuatroNumeros	[]	= new String[22];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RuletaView window = new RuletaView();
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
	public RuletaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        JPanel panel = new JPanel();
       
		
			
		
		
		
		JLabel lblRuleta = new JLabel("Ruleta");
		lblRuleta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblRuleta.setBounds(191, 25, 109, 37);
		frame.getContentPane().add(lblRuleta);
		
		JLabel lblNewLabel = new JLabel("asda");
		lblNewLabel.setIcon(new ImageIcon(RuletaView.class.getResource("/ar/com/utn/ruleta/view/imagenes/ruleta.jpg")));
		lblNewLabel.setBounds(10, 90, 334, 150);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox cmbNumeros = new JComboBox();
		cmbNumeros.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		//llena el combo ***************
		for(int i =0;i<37;i++)
			arrayNumeros[i]=Integer.toString(i);
		
		cmbNumeros.setModel(new DefaultComboBoxModel(arrayNumeros));
		//fin llena combo  ********************+
		
		cmbNumeros.setBounds(140, 264, 58, 31);
		frame.getContentPane().add(cmbNumeros);
		
		JButton btnApostarNumero = new JButton("Apostar");
		btnApostarNumero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnApostarNumero.setBounds(334, 263, 140, 33);
		frame.getContentPane().add(btnApostarNumero);
		
		JButton btnTirarBola = new JButton("Tirar bola");
		btnTirarBola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTirarBola.setBounds(550, 327, 89, 23);
		frame.getContentPane().add(btnTirarBola);
		
		JButton btnLi = new JButton("Limpiar Apuesta");
		btnLi.setBounds(543, 371, 116, 23);
		frame.getContentPane().add(btnLi);
		
		JLabel lblApuesta = new JLabel("Apuesta:");
		lblApuesta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApuesta.setBounds(550, 117, 109, 29);
		frame.getContentPane().add(lblApuesta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(540, 151, 312, 165);
		frame.getContentPane().add(scrollPane);
		
		tblApuesta = new JTable();
		tblApuesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, opciones.get(tblApuesta.getSelectedRow()));
			}
		});

		scrollPane.setViewportView(tblApuesta);
		
		JComboBox cmbJugadores = new JComboBox();
		//************* llena el combo *******************
		JugadorDao jugDao = new JugadorDao();
		try {
			List<Jugador> jugadores = jugDao.leer(null);
			arrayJugadores = new String[jugadores.size()];
			int i=0;
			arrayJugadores[0]="Seleccione";
			for (Jugador jugador : jugadores)
				arrayJugadores[i++]= jugador.getAlias();
			
				
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "se produjo en error en la base de datos llamar a alquien que sepa");
			e1.printStackTrace();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "hay un error en el sql llama al programador que el sabe");
			e1.printStackTrace();
		}		
		//************** fin llena el combo***************
		cmbJugadores.setModel(new DefaultComboBoxModel(arrayJugadores));
		cmbJugadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbJugadores.setBounds(563, 32, 129, 31);
		frame.getContentPane().add(cmbJugadores);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(406, 474, 97, 31);
		frame.getContentPane().add(textField_2);
		
		chckbxRojo = new JCheckBox("Rojo");
		chckbxRojo.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxRojo.setBounds(6, 461, 97, 23);
		frame.getContentPane().add(chckbxRojo);
		
		JCheckBox chckbxNegro = new JCheckBox("Negro");
		chckbxNegro.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxNegro.setBounds(6, 416, 97, 23);
		frame.getContentPane().add(chckbxNegro);
		
		JCheckBox chckbxPar = new JCheckBox("Par");
		chckbxPar.setBounds(16, 494, 97, 23);
		frame.getContentPane().add(chckbxPar);
		
		JCheckBox chckbxImpar = new JCheckBox("Impar");
		chckbxImpar.setBounds(203, 494, 97, 23);
		frame.getContentPane().add(chckbxImpar);
		
		cbPrimerColumna = new JCheckBox("Primer Columna");
		cbPrimerColumna.setBounds(648, 405, 97, 23);
		frame.getContentPane().add(cbPrimerColumna);
		
		JLabel lblApuesta_id = new JLabel("");
		lblApuesta_id.setOpaque(true);
		lblApuesta_id.setBackground(Color.CYAN);
		lblApuesta_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApuesta_id.setBounds(683, 117, 100, 25);
		frame.getContentPane().add(lblApuesta_id);
		
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJugadores.setBounds(410, 29, 129, 37);
		frame.getContentPane().add(lblJugadores);
		
		JLabel lblNumeros = new JLabel("numeros");
		lblNumeros.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNumeros.setBounds(20, 259, 100, 37);
		frame.getContentPane().add(lblNumeros);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaldo.setBounds(334, 471, 78, 37);
		frame.getContentPane().add(lblSaldo);
		
		JLabel lblNumeros_2 = new JLabel("2 numeros");
		lblNumeros_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNumeros_2.setBounds(20, 302, 107, 25);
		frame.getContentPane().add(lblNumeros_2);
		//******llena combo ****************************
		//TODO llenar el combo de dos numeros
		Opcion2NumeroDAO opc2NumDao = new Opcion2NumeroDAO();
		List<Opcion> lstOpc2Num;
		try {
			lstOpc2Num = opc2NumDao.leer(null);
			int i =0;
			for (Opcion opcion : lstOpc2Num) {
				arrayDosNumeros[i++]=opcion.getValores();
			}
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "se produjo un error de conexion con la base de datos");
			e1.printStackTrace();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "aprende sql cara de naipe antes de mejer mano");
			e1.printStackTrace();
		}
		
		//******fin llena combo*************************
		
		JComboBox cmbNumeros_1 = new JComboBox();
		cmbNumeros_1.setModel(new DefaultComboBoxModel(arrayDosNumeros));
		cmbNumeros_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbNumeros_1.setBounds(140, 301, 100, 31);
		frame.getContentPane().add(cmbNumeros_1);
		
		JButton btnApostarNumero_1 = new JButton("Apostar");
		btnApostarNumero_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnApostarNumero_1.setBounds(334, 307, 140, 33);
		frame.getContentPane().add(btnApostarNumero_1);
		
		JLabel lblNumeros_2_1 = new JLabel("4 numeros");
		lblNumeros_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNumeros_2_1.setBounds(20, 345, 107, 25);
		frame.getContentPane().add(lblNumeros_2_1);
		
		JComboBox cmbNumeros_1_1 = new JComboBox();
		cmbNumeros_1_1.setModel(new DefaultComboBoxModel(new String[] {"31-32-34-36"}));
		cmbNumeros_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbNumeros_1_1.setBounds(140, 344, 160, 31);
		frame.getContentPane().add(cmbNumeros_1_1);
		
		JButton btnApostarNumero_1_1 = new JButton("Apostar");
		btnApostarNumero_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnApostarNumero_1_1.setBounds(334, 350, 140, 33);
		frame.getContentPane().add(btnApostarNumero_1_1);
		
		JLabel lblJugadores_1 = new JLabel("Grupos");
		lblJugadores_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJugadores_1.setBounds(370, 383, 109, 37);
		frame.getContentPane().add(lblJugadores_1);
		
		JButton btnApostarNumero_2 = new JButton("Apostar");
		btnApostarNumero_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnApostarNumero_2.setBounds(132, 411, 140, 33);
		frame.getContentPane().add(btnApostarNumero_2);
		
		JButton btnApostarNumero_2_1 = new JButton("Apostar");
		btnApostarNumero_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnApostarNumero_2_1.setBounds(132, 456, 140, 33);
		frame.getContentPane().add(btnApostarNumero_2_1);
		
		try {
			opciones = getDatosDummy();
			llenarGrilla(opciones);
		} catch (RuletaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void refresh() throws ClassNotFoundException, SQLException {
		
		
		
	}
	private void llenarGrilla(List<Opcion> opciones)
	{
		int fila=0;
		arrayOpciones= new String[opciones.size()][2];
		for (Opcion opcion : opciones) {
			for(int col=0;col<2;col++){
				switch (col) {
				case 0:
					arrayOpciones[fila][col] = opcion.getValores();
					break;
				case 1:
					arrayOpciones[fila][col] = Integer.toString(opcion.getSaldo());
					break;

				default:
					break;
				}
			}
				
				fila++;
		}
		
		tblApuesta.setModel(new DefaultTableModel(
				arrayOpciones,
				new String[] {
					"opcion", "Monto"
				}
			));
	}
	
	private List<Opcion> getDatosDummy() throws RuletaException{
		List<Opcion> opcionesDummy = new ArrayList<Opcion>();
		
		opcionesDummy.add(new Opcion1Numero(100, new Numero(1) ));
		opcionesDummy.add(new Opcion2Numeros(100, 1,2));
		opcionesDummy.add(new Opcion4Numeros(1,1,2,4,5,100));
		opcionesDummy.add(new OpcionGrupoRojo(100));
		
		return opcionesDummy;
	}
}
