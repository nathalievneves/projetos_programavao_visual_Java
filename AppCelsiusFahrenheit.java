

	import java.awt.Component;
	import java.awt.Container;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
	import javax.swing.JTextField;

	public class Revisao2 extends JFrame implements ActionListener {

		private JLabel lblDialogo,  lblResposta;
		private JTextField txtDigite;
		private JButton btnCalcular, btnLimpar, btnFechar;
		private JRadioButton btnCelsius, btnFahrenheit;
		private GridBagConstraints restricoes=new GridBagConstraints();
		private JPanel pnlDialogo, pnlDigite, pnlResposta, pnlBotoes, pnlGeral ;
		private ButtonGroup group;
		
		
		public Revisao2() {
		
			this.setTitle("Conversor Celsius x Fahrenheit");
			this.setSize(500,300);
			this.setLocation(800,200);
			this.setResizable(false);

		
		lblDialogo=new JLabel("Digite a temperatura que deseja converter:", JLabel.RIGHT);
				
		lblResposta=new JLabel("Resposta:", JLabel.RIGHT); 
		
		txtDigite = new JTextField (20);
		txtDigite.setToolTipText("Digite a temperatura:");
		
		btnCelsius = new JRadioButton("De Celsius para Fahrenheit", true);
		btnCelsius.setToolTipText("De Celsius para Fahrenheit");
		btnCelsius.addActionListener(this);
		
		btnFahrenheit = new JRadioButton("De Fahrenheit para Celsius", false);
		btnFahrenheit.setToolTipText("De Fahrenheit para Celsius");
		btnFahrenheit.addActionListener(this);
		group = new ButtonGroup();
		group.add(btnCelsius);
		group.add(btnFahrenheit);
	  
		btnCalcular=new JButton("Calcular");
		btnCalcular.setToolTipText("Clique aqui para calcular.");
		btnCalcular.addActionListener(this);
		
		btnLimpar=new JButton("Limpar");
		btnLimpar.setToolTipText("Clique aqui para limpar.");
		btnLimpar.addActionListener(this);
		
		btnFechar=new JButton("Fechar");
		btnFechar.setToolTipText("Clique aqui para fechar.");
		btnFechar.addActionListener(this);
		
		restricoes.fill=GridBagConstraints.BOTH;
		restricoes.insets=new Insets(8,8,8,8);
		
		pnlDialogo = new JPanel(new GridBagLayout());
		addGridBag(0,0,lblDialogo, pnlDialogo);
		
		pnlDigite = new JPanel(new GridBagLayout());
		addGridBag(0,0, txtDigite, pnlDigite);
		addGridBag(1,0, btnCalcular, pnlDigite);
		
		pnlBotoes = new JPanel (new GridBagLayout());
		addGridBag(0,0, btnCelsius, pnlBotoes);
		addGridBag(1,0, btnFahrenheit, pnlBotoes);
		addGridBag(0,1, btnLimpar, pnlBotoes);
		addGridBag(1,1, btnFechar, pnlBotoes);
		
		pnlResposta = new JPanel (new GridBagLayout());
		addGridBag(0,0, lblResposta, pnlResposta);
		
		pnlGeral = new JPanel (new GridBagLayout());
		addGridBag(0,0,pnlDialogo, pnlGeral);
		addGridBag(0,1,pnlDigite,pnlGeral);
		addGridBag(0,2,pnlBotoes,pnlGeral);
		addGridBag(0,3, pnlResposta, pnlGeral);
		
		Container P=getContentPane();
		P.add(pnlGeral);
		
		
		
		}
		
		public void addGridBag(final int x,final int y,final Component obj,final JPanel pnl)
		{
			restricoes.gridx=x;
			restricoes.gridy=y;
			pnl.add(obj,restricoes);
		}

		public static void main(String[] args) {
			Revisao2 revisao2 = new Revisao2();
			revisao2.setVisible(true);
			revisao2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		
	
		public void actionPerformed(ActionEvent event) {
			
			
			Object origem=event.getSource();
			
		
	    	if (origem==btnCalcular)
	    	{
	    		float numero, resultado;
	    			try
	    			{
	    			numero = (int) Float.parseFloat(txtDigite.getText());
	    			
	    			if (btnCelsius.isSelected()) {
		    			
	    			resultado = (float) ((numero * 1.8) +32);
	    			lblResposta.setText("A temperatura é de " +resultado +" graus Fahrenheit.");
		    			}
		    		
		    			else {
		    				resultado = (float) ((numero - 32) /1.8);
			    			lblResposta.setText("A temperatura é de " +resultado +" graus Celsius.");
		    			}
	    			    			
	    		}catch (Exception erro)
	    		{
	    			JOptionPane.showMessageDialog(null, "Você não digitou um número válido.");
	    			txtDigite.requestFocus();
	    			txtDigite.selectAll();
	    		}
	    	}else if (origem==btnLimpar)
	    	{
	    		txtDigite.setText("");
	    		lblResposta.setText("Resposta:");
	    		btnCelsius.setSelected(true);
		    	btnFahrenheit.setSelected(false);
	    		txtDigite.requestFocus();
	    		
	    	}else if (origem==btnFechar)
	    	{
	    		System.exit(0);
	    	}
		}

	}


