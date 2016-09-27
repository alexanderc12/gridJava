package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyDialog extends JDialog{
	
	private static final int COLUMNS_NUMBER = 12;
	private static final Dimension INITIAL_DIMENSION = new Dimension(0, 0);
	public static final Color BTN_COLOR = Color.decode("#4d90fe");
	private static final int DIALOG_HEIGHT = 300;
	private static final int DIALOG_WIDTH = 500;
	private static final String TITTLE = "Grid en Java";
	private static final long serialVersionUID = 1L;
	private JTextField txName;
	private JFormattedTextField txPrice;
	private JButton btnImage;

	public MyDialog() {
		setTitle(TITTLE);
		setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		
		// Se define como layout el GridBag que permite tener una grilla flexible
		setLayout(new GridBagLayout());
		
		// Esta clase se instancia una vez y guarda los datos de la posicion actual del compente, la idea es reutilizarla
		GridBagConstraints c = new GridBagConstraints();
		// Esta linea permite aprovechar el espacio horizontal y vertical de la grilla, se solo se quiere uno se puede 
		// cambiar por horizontal(hace el componete lo más ancho posible en el espacio dado) o vertical(lo mismo pero)
		// vertical
		c.fill = GridBagConstraints.BOTH;
		//Este metodo modifica el comportamiento inicial dejando 12 columnas del mismo tamaño
		generateBasicGrid(c);
		
		txName = new JTextField();
		txName.setBorder(BorderFactory.createTitledBorder("Name:"));
		//Se ubica en que fila se quiere dejar el componete(las filas inician en 1)
		c.gridy = 1;
		//Se da la altura para esa fila 0.1 es el 10% del tamaño actual del componente
		c.weighty = 0.4;
		//Se define en que columna inicia el componente que se va a agregar 
		c.gridx = 1;
		// se dice cuantas columnas va a ocupar el componente
		c.gridwidth = 10;
		add(txName, c);
		
		txPrice = new JFormattedTextField();
		txPrice.setBorder(BorderFactory.createTitledBorder("Price:"));
		//en este caso quiero cambiar de fila
		c.gridy = 2;
		// tambien se puede cambiar de columna
		c.gridx = 2;
		// se cambia el ancho del componente
		c.gridwidth = 4;
		//notese que no cambie la altura del componente por la tanto va a seguir siendo la altura anteior
		add(txPrice, c);
		
		btnImage = new JButton("Add image");
		//Los botones tiene el problema que se adpatan al texto por eso no respetan la grilla, asi que se usa esta linea
		btnImage.setPreferredSize(INITIAL_DIMENSION);
		// en este caso NO quiero cambiar de fila
		// como el componente anteior iniciaba en la columna 2 y tenia tamaño 4, debo iniciar desde la columna 7 
		//y tendria maximo 6 columnas para el tamaño 
		c.gridx = 7;
		c.gridwidth = 2;
		add(btnImage, c);

		JButton btnAddProduct = new JButton("Add order");
		btnAddProduct.setBackground(BTN_COLOR);
		btnAddProduct.setForeground(Color.WHITE);
		btnAddProduct.setPreferredSize(INITIAL_DIMENSION);
		//margen externa	
		c.insets = new Insets(10,0,10,0);
		c.gridy = 3;
		c.gridx = 4;
		c.gridwidth = 3;
		c.weighty = 0.2;
		add(btnAddProduct,c );
		
		setVisible(true);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		//esta linea se quita en producción
		c.weighty = 0.01;
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			c.gridx = i;
			add(new JLabel("" + i), c);
		}
	}
	
	public static void main(String[] args) {
		new MyDialog();
	}
}