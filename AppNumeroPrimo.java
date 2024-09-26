import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Revisao3 extends JFrame implements ActionListener {

	private JLabel lblDialogo, lblResposta, lblResposta2;
	private JTextField txtDigite;
	private JButton btnCalcular, btnLimpar, btnFechar;
	private GridBagConstraints restricoes=new GridBagConstraints();
	private JPanel pnlDialogo, pnlDigite, pnlResposta, pnlBotoes, pnlGeral ;
	Font fonte = new Font ("Comic Sans", Font.BOLD, 10);
	Font fonte2 = new Font ("Comic Sans", Font.ITALIC, 15);
	
	
	public Revisao3() {
	
		this.setTitle("Número primo?");
		this.setSize(600,400);
		this.setLocation(700,100);
		this.setResizable(true);
			
	lblDialogo=new JLabel("Digite o número que você deseja consultar:", JLabel.RIGHT);
	lblDialogo.setForeground(Color.white);
	lblDialogo.setFont(fonte2);
	
	
	lblResposta=new JLabel("Resposta:", JLabel.RIGHT); 
	lblResposta.setForeground(Color.white);
	lblResposta.setFont(fonte2);
	lblResposta2=new JLabel(" ", JLabel.RIGHT);
	lblResposta2.setForeground(Color.white);
	lblResposta2.setFont(fonte2);
	
	txtDigite = new JTextField (10);
	txtDigite.setSize(20, 20);
	txtDigite.setToolTipText("Digite o número que você deseja consultar");
	
	btnCalcular=new JButton("Calcular");
	btnCalcular.setToolTipText("Clique aqui para calcular.");
	btnCalcular.addActionListener(this);
	btnCalcular.setBackground(Color.blue);
	btnCalcular.setForeground(Color.yellow);
	btnCalcular.setFont(fonte);
		
	
	btnLimpar=new JButton("Limpar");
	btnLimpar.setToolTipText("Clique aqui para limpar.");
	btnLimpar.addActionListener(this);
	btnLimpar.setBackground(Color.yellow);
	btnLimpar.setForeground(Color.blue);
	btnLimpar.setFont(fonte);
	
	btnFechar=new JButton("Fechar");
	btnFechar.setToolTipText("Clique aqui para fechar.");
	btnFechar.addActionListener(this);
	btnFechar.setBackground(Color.RED);
	btnFechar.setForeground(Color.green);
	btnFechar.setFont(fonte);
	
	restricoes.fill=GridBagConstraints.BOTH;
	restricoes.insets=new Insets(8,8,8,8);
	
	pnlDialogo = new JPanel(new GridBagLayout());
	addGridBag(0,0,lblDialogo, pnlDialogo);
	pnlDialogo.setBackground(Color.black);
	
	pnlDigite = new JPanel(new GridBagLayout());
	addGridBag(0,0, txtDigite, pnlDigite);
	pnlDigite.setBackground(Color.black);
	pnlDigite.setSize(50,50);
	
	pnlBotoes = new JPanel (new GridBagLayout());
	addGridBag(0,0, btnCalcular, pnlBotoes);
	addGridBag(1,0, btnLimpar, pnlBotoes);
	addGridBag(2,0, btnFechar, pnlBotoes);
	pnlBotoes.setBackground(Color.black);
	
	pnlResposta = new JPanel (new GridBagLayout());
	addGridBag(0,0, lblResposta, pnlResposta);
	addGridBag(0,1, lblResposta2, pnlResposta);
	pnlResposta.setBackground(Color.black);
	
	pnlGeral = new JPanel (new GridBagLayout());
	pnlGeral.setBackground(Color.black);
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

	

	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object origem=event.getSource();
    	if (origem==btnCalcular)
    	{
    		int numero;
    		int divisores=0;
    		ArrayList<Integer> lista = new ArrayList<Integer>();
    		
    		try
    		{
    			numero = (int) Float.parseFloat(txtDigite.getText());
    			
    			for (int j = 2; j < numero; j++) {
    		        if (numero % j == 0) {
    		        	divisores ++;
    		        	lista.add(j);
    		        }
    		     
    		  }
    		  if (divisores >=1) {
    			  lblResposta.setText("O número " +numero +" não é primo! ");
    			  lblResposta2.setText("Divisores: 1, " +lista.toString() +" e " +numero);
    		  }
    		  else {
    			  lblResposta.setText("O número " +numero + " é primo, pois só é divisível por 1 e por " +numero +".");
    			  lblResposta2.setText(" ");
    		  }
    			
    			   			
    			    	
    			}    		catch (Exception erro)
    		{
    			JOptionPane.showMessageDialog(null, "Você não digitou um número válido.");
    			txtDigite.requestFocus();
    			txtDigite.selectAll();
    		}
    	}else if (origem==btnLimpar)
    	{
    		txtDigite.setText("");
    		lblResposta.setText("Resposta:");
    		lblResposta2.setText(" ");
    		txtDigite.requestFocus();
    		
    	}else if (origem==btnFechar)
    	{
    		System.exit(0);
    	}
	}
	
	public static void main(String[] args) {
		Revisao3 revisao = new Revisao3();
		revisao.setVisible(true);
	}

}
