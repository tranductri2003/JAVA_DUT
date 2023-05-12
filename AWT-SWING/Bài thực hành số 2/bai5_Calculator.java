import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.script.*;
public class bai5_Calculator extends JFrame implements ActionListener 
{
	JTextField txt;
	JButton btnnum[]=new JButton[10];
	JButton btnDot,btnAdd,btnSub,btnMul,btnDiv;
	JButton btnC,btnEquals;
    
    JPanel pnBtn, pnOverall;


    public bai5_Calculator(String t)
    {
        super(t);
        GUI();
    }
    public void GUI()
    {
        txt = new JTextField(15);
		txt.setFont(new Font("Arial",Font.BOLD,20));
		txt.setHorizontalAlignment(SwingConstants.RIGHT);

        for (int i=0;i<10;i++)
        {
            btnnum[i]= new JButton(Integer.toString(i));
            btnnum[i].addActionListener(this);
        }

		btnDot=new JButton(".");
		btnAdd=new JButton("+");
		btnSub=new JButton("-");
		btnMul=new JButton("*");
		btnDiv=new JButton("/");
		btnC=new JButton("C");
		btnEquals=new JButton("=");
		
		btnDot.addActionListener(this);
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		btnC.addActionListener(this);
		btnEquals.addActionListener(this);

        pnOverall = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        pnBtn = new JPanel(new GridLayout(4,4));
		pnBtn.add(btnnum[7]);
		pnBtn.add(btnnum[8]);
		pnBtn.add(btnnum[9]);
		pnBtn.add(btnDiv);
		pnBtn.add(btnnum[4]);
		pnBtn.add(btnnum[5]);
		pnBtn.add(btnnum[6]);
		pnBtn.add(btnMul);
		pnBtn.add(btnnum[1]);
		pnBtn.add(btnnum[2]);
		pnBtn.add(btnnum[3]);
		pnBtn.add(btnSub);
		pnBtn.add(btnnum[0]);
        pnBtn.add(btnDot);
		pnBtn.add(btnAdd);
		pnBtn.add(btnC);
		pnBtn.add(btnAdd);


		
		gridBagConstraints.fill=GridBagConstraints.BOTH;
		gridBagConstraints.gridx=0;
		gridBagConstraints.gridy=0;
		// gridBagConstraints.weightx=0.1;
		gridBagConstraints.weighty=0.2;
		gridBagConstraints.gridwidth=2;
		gridBagConstraints.insets = new Insets(1, 1, 1, 1);
        pnOverall.add(txt,gridBagConstraints);


        gridBagConstraints.fill=GridBagConstraints.BOTH;
		gridBagConstraints.gridx=0;
		gridBagConstraints.gridy=1;
		gridBagConstraints.gridwidth=1;
		gridBagConstraints.weightx=0.9;
		gridBagConstraints.weighty=0.8;
		gridBagConstraints.insets = new Insets(1, 1, 1, 1);
        pnOverall.add(pnBtn,gridBagConstraints);

		gridBagConstraints.fill=GridBagConstraints.BOTH;
		gridBagConstraints.gridx=1;
		gridBagConstraints.gridy=1;
		gridBagConstraints.weightx=0.2;
		// gridBagConstraints.weighty=0.8;
		gridBagConstraints.gridheight=1;
		gridBagConstraints.insets = new Insets(1, 1, 1, 1);
        pnOverall.add(btnEquals,gridBagConstraints);




        add(pnOverall);
        setSize(500,400);
        show();
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String t="";
		if(e.getSource()==btnnum[0]) 
		{
			t+=txt.getText()+"0";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[1]) 
		{
			t+=txt.getText()+"1";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[2]) 
		{
			t+=txt.getText()+"2";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[3]) 
		{
			t+=txt.getText()+"3";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[4]) 
		{
			t+=txt.getText()+"4";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[5]) 
		{
			t+=txt.getText()+"5";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[6]) 
		{
			t+=txt.getText()+"6";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[7]) 
		{
			t+=txt.getText()+"7";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[8]) 
		{
			t+=txt.getText()+"8";
			txt.setText(t);
		}
		if(e.getSource()==btnnum[9]) 
		{
			t+=txt.getText()+"9";
			txt.setText(t);
		}
		if(e.getSource()==btnAdd) 
		{
			t+=txt.getText()+"+";
			txt.setText(t);
		}
		if(e.getSource()==btnSub) 
		{
			t+=txt.getText()+"-";
			txt.setText(t);
		}
		if(e.getSource()==btnMul) 
		{
			t+=txt.getText()+"*";
			txt.setText(t);
		}
		if(e.getSource()==btnDiv) 
		{
			t+=txt.getText()+"/";
			txt.setText(t);
		}
		if(e.getSource()==btnDot) 
		{
			t+=txt.getText()+".";
			txt.setText(t);
		}
		if(e.getSource()==btnEquals) 
		{
			String expression = txt.getText();
			double value=0;
			try {
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("JavaScript");
				Object result = engine.eval(expression);
				value = Double.parseDouble(result.toString());
				txt.setText(Double.toString(value));
			} catch (ScriptException ee) {
				ee.printStackTrace();
			}
		}
			
		
		if(e.getSource()==btnC) 
		{
			
			txt.setText("");
		}
	}


	public static void main(String[] args) {
		new bai5_Calculator("Caculator");
	}
}