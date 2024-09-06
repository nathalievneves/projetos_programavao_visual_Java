import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Revisao extends JFrame implements ActionListener {

	private JLabel lblDialogo, lblResposta;
	private JTextField txtDigite;
	private JButton btnCalcular, btnLimpar, btnFechar;
	private GridBagConstraints restricoes=new GridBagConstraints();
	private JPanel pnlDialogo, pnlDigite, pnlResposta, pnlBotoes, pnlGeral ;
	
	
	public Revisao() {
	
		this.setTitle("Par ou ímpar?");
		this.setSize(300,300);
		this.setLocation(900,200);
		this.setResizable(false);

	
	lblDialogo=new JLabel("Digite o número que você deseja consultar:", JLabel.RIGHT);
	
	lblResposta=new JLabel("Resposta:", JLabel.RIGHT); 
	
	txtDigite = new JTextField (20);
	txtDigite.setToolTipText("Digite o número que você deseja consultar");
	
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
	
	pnlBotoes = new JPanel (new GridBagLayout());
	addGridBag(0,0, btnCalcular, pnlBotoes);
	addGridBag(1,0, btnLimpar, pnlBotoes);
	addGridBag(2,0, btnFechar, pnlBotoes);
	
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
		Revisao revisao = new Revisao();
		revisao.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object origem=event.getSource();
    	if (origem==btnCalcular)
    	{
    		float numero;
    		try
    		{
    			numero = Float.parseFloat(txtDigite.getText());
    			if (numero%2==0)
    			{
    				lblResposta.setText("O número digitado é PAR.");
    			}
    			else {
    				
    				lblResposta.setText("O número digitado é ÍMPAR.");
        	
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
    		txtDigite.requestFocus();
    		
    	}else if (origem==btnFechar)
    	{
    		System.exit(0);
    	}
	}

}
