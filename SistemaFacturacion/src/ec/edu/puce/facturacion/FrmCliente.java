package ec.edu.puce.facturacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textCedula;
	private JTextField textNombres;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTable table;
	private Cliente cliente = new Cliente();
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setTitle("Cliente");
		setBounds(100, 100, 398, 470);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cédula");
		lblNewLabel.setBounds(46, 31, 64, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(46, 56, 64, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(46, 81, 64, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección");
		lblNewLabel_3.setBounds(46, 106, 64, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(46, 131, 64, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(46, 156, 64, 14);
		getContentPane().add(lblNewLabel_5);
		
		textCedula = new JTextField();
		textCedula.setBounds(120, 28, 86, 20);
		getContentPane().add(textCedula);
		textCedula.setColumns(10);
		
		textNombres = new JTextField();
		textNombres.setBounds(120, 53, 86, 20);
		getContentPane().add(textNombres);
		textNombres.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(120, 78, 86, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(120, 103, 86, 20);
		getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(120, 128, 86, 20);
		getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(120, 153, 86, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNewButton.setBounds(29, 199, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(camposValidos()) {
					crearCliente();
		        }
			}
		});
		btnNewButton_1.setBounds(143, 199, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(260, 199, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 254, 362, 163);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00E9dula", "Nombres", "Apellidos", "Direcci\u00F3n", "Telefono", "Email"
			}
		));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

	}
	private void crearCliente() {
		cliente.setCedula(textCedula.getText());
		cliente.setNombre(textNombres.getText());
		cliente.setApellido(textApellidos.getText());
		cliente.setDireccion(textDireccion.getText());
		cliente.setTelefono(textTelefono.getText());
		cliente.setEmail(textEmail.getText());
		agregarFila();
		limpiarCampos();
	}

	private void agregarFila() {
		Object[] fila = new Object[6];
		fila[0] = cliente.getCedula();
		fila[1] = cliente.getNombre();
		fila[2] = cliente.getApellido();
		fila[3] = cliente.getDireccion();
		fila[4] = cliente.getTelefono();
		fila[5] = cliente.getEmail();
		model.addRow(fila);
	}
	
	private void limpiarCampos() {
        textCedula.setText("");
        textNombres.setText("");
        textApellidos.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textEmail.setText("");
    }
	private boolean camposValidos() {
	    return !textCedula.getText().isEmpty() && !textNombres.getText().isEmpty()
	            && !textApellidos.getText().isEmpty() && !textDireccion.getText().isEmpty()
	            && !textTelefono.getText().isEmpty() && !textEmail.getText().isEmpty();
	}
}
