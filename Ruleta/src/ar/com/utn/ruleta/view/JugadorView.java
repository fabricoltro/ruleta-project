package ar.com.utn.ruleta.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ar.com.utn.ruleta.controller.Controller;
import ar.com.utn.ruleta.controller.JugadorController;
import ar.com.utn.ruleta.dao.DAO;
import ar.com.utn.ruleta.dao.JugadorDao;
import ar.com.utn.ruleta.modelo.Jugador;
import ar.com.utn.ruleta.modelo.exceptions.RuletaException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JugadorView implements View {

	private JFrame frame;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textAlias;
	private JTable table;
	
	private Controller jugadorController;
	private DAO		   jugadorDao;
	
	private String jugadoresArray[][];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JugadorView window = new JugadorView();
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
	public JugadorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("abmc de jugadores");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(197, 0, 204, 29);
		frame.getContentPane().add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setEnabled(false);
		textCodigo.setBounds(193, 99, 86, 20);
		frame.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(53, 93, 86, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("nombre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(53, 130, 86, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(193, 136, 86, 20);
		frame.getContentPane().add(textNombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(53, 178, 86, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(193, 184, 86, 20);
		frame.getContentPane().add(textApellido);
		
		JLabel lblNewLabel_1_3 = new JLabel("Alias");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(53, 220, 86, 25);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textAlias = new JTextField();
		textAlias.setColumns(10);
		textAlias.setBounds(193, 226, 86, 20);
		frame.getContentPane().add(textAlias);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 289, 533, 135);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouse click" + jugadoresArray[table.getSelectedRow()][0]);
				textCodigo.setText( jugadoresArray[table.getSelectedRow()][0]);
				textNombre.setText(jugadoresArray[table.getSelectedRow()][1]);
				textApellido.setText(jugadoresArray[table.getSelectedRow()][2]);
				textAlias.setText(jugadoresArray[table.getSelectedRow()][3]);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2", "3", "4"},
			},
			new String[] {
				"Codigo", "Nombre", "Apellido", "Alias"
			}
		));
		scrollPane.setViewportView(table);
		try {
			refresh();
		} catch (ClassNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "Hubo un error en la BD comuniquese con alguien que sepa");
			e2.printStackTrace();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Hubo un error en la BD comuniquese con alguien que sepa");
			e2.printStackTrace();
		}
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Maty hay que hacer el Action Performed del Modificar y el eliminar siguiendo este mismo criterio
				//creo un objeto jugador
				Jugador jug = new Jugador(	textNombre.getText()	, 
											textApellido.getText()	, 
											textAlias.getText())	;
				
				jugadorController= new JugadorController();
				jugadorDao 		 = new JugadorDao();
				
				try {
					jugadorController.agregarHandler(jug, jugadorDao);
					refresh();
					limpiarCampos();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error interno comuniquese con alguien que sepa");
					e1.printStackTrace();
				} catch (RuletaException e1) {
					JOptionPane.showMessageDialog(null, "error:" + e1.getMessage());
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error en la BD comuniquese con alguien que sepa");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(306, 98, 225, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador jug = new Jugador( Integer.parseInt(textCodigo.getText()),	
						textNombre.getText()	, 
						textApellido.getText()	, 
						textAlias.getText())	;

				jugadorController= new JugadorController();
				jugadorDao 		 = new JugadorDao();
				try {
						jugadorController.modificarHandler(jug, jugadorDao);
						refresh();
						limpiarCampos();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error interno comuniquese con alguien que sepa");
					e1.printStackTrace();
				} catch (RuletaException e1) {
					JOptionPane.showMessageDialog(null, "error:" + e1.getMessage());
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error en la BD comuniquese con alguien que sepa");
					e1.printStackTrace();
				}
			}
		});
		
		
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificar.setBounds(306, 142, 225, 33);
		frame.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador jug = new Jugador();
						//si el codigo esta vacio le pongo 0, caso contrario paso el texto a un entero
				jug.setCodigo(textCodigo.getText().isEmpty()?0:Integer.parseInt(textCodigo.getText()));
				jugadorController= new JugadorController();
				jugadorDao 		 = new JugadorDao();
				try {
						jugadorController.eliminarHandler(jug, jugadorDao);
						refresh();
						limpiarCampos();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error interno comuniquese con alguien que sepa");
					e1.printStackTrace();
				} catch (RuletaException e1) {
					JOptionPane.showMessageDialog(null, "error:" + e1.getMessage());
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error en la BD comuniquese con alguien que sepa");
					e1.printStackTrace();
				}

				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(306, 195, 225, 33);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnBucar = new JButton("Buscar");
		btnBucar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador jug = new Jugador( 	textNombre.getText()	, 
											textApellido.getText()	, 
											textAlias.getText())	;

				jugadorController= new JugadorController();
				jugadorDao 		 = new JugadorDao();
				try {
						llenarGrilla((List<Jugador>)jugadorController.leernarHandler(jug, jugadorDao));
						//refresh();
						limpiarCampos();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error interno comuniquese con alguien que sepa");
					e1.printStackTrace();
				} catch (RuletaException e1) {
					JOptionPane.showMessageDialog(null, "error:" + e1.getMessage());
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Hubo un error en la BD comuniquese con alguien que sepa");
					e1.printStackTrace();
				}
			}							
		});
		btnBucar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBucar.setBounds(306, 239, 225, 33);
		frame.getContentPane().add(btnBucar);
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiarCampos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimpiarCampos.setBounds(298, 55, 233, 32);
		frame.getContentPane().add(btnLimpiarCampos);
	}


	@Override	
	public void refresh() throws ClassNotFoundException, SQLException {
		JugadorDao jugDao = new JugadorDao();
		llenarGrilla(jugDao.leer(null));
		
	}

	/**
	 * Este método tiene la finalidad de llenar la grilla con una lista 
	 * @param jugadores es una lista de jugadores que deberán llenar la grilla
	 */
	private void llenarGrilla(List<Jugador> jugadores){
		jugadoresArray = new String[jugadores.size()][4];
//estas son las filas
		int fila=0;
		for (Jugador jugador : jugadores) {
			for(int col=0;col<4;col++){
				switch (col) {
				case 0:
					jugadoresArray[fila][col]=Integer.toString(jugador.getCodigo());
					break;
				case 1:
					jugadoresArray[fila][col]=jugador.getNombre();
					break;
				case 2:
					jugadoresArray[fila][col]=jugador.getApellido();
					break;
				case 3:
					jugadoresArray[fila][col]=jugador.getAlias();
					break;
				default:
					break;
				}
				
			}
			fila++;
		}

		table.setModel(new DefaultTableModel(
				jugadoresArray,
				new String[] {
					"Codigo", "Nombre", "Apellido", "Alias"
				}
			));

	}
	
	/**
	 *Este metodo tiene la finalidad de limpiar todo los campos
	 * 
	 */
	private void limpiarCampos(){
		textCodigo.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textAlias.setText("");
	}
}
