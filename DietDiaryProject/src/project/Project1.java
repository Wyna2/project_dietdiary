package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Project1 extends JFrame implements ActionListener {

	DbConnect db=new DbConnect();

	Container cp;
	JButton loginBtn,joinBtn;
	JLabel lblImg,imgtext;
	static JTextField tfid;
	JPasswordField tfpw;
	ImageIcon img;
			
	public Project1(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(750, 330 ,300 ,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255,204,255));
	
		//������ �޼��� ȣ��..
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(null);
		
		//���̵� �Է� �ؽ�Ʈ
		tfid=new JTextField();
		tfid.setBounds(145, 200, 90, 30);
		this.add(tfid);
		
		//�н����� �Է� �ؽ�Ʈ
		tfpw=new JPasswordField(20);
		tfpw.setEchoChar('*');
		tfpw.setBounds(145, 240, 90, 30);
		this.add(tfpw);
		
		JLabel lblLogin=new JLabel("ID",JLabel.CENTER);
		lblLogin.setBorder(new LineBorder(new Color(204,153,255),4));
		lblLogin.setBounds(73, 200, 50, 30);
		this.add(lblLogin);
		
		JLabel lblPassword=new JLabel("PW",JLabel.CENTER);
		lblPassword.setBorder(new LineBorder(new Color(204,153,255),4));
		lblPassword.setBounds(73, 240, 50, 30);
		this.add(lblPassword);
		
		//�̹��� ���� �ؽ�Ʈ
		JLabel imgtext=new JLabel("Diet Diary",JLabel.CENTER);
		Font myFont1 = new Font("Serif", Font.BOLD|Font.ITALIC , 35);
		imgtext.setBounds(44, 72, 200, 70);
		imgtext.setForeground(new Color(153,051,255));
		imgtext.setFont(myFont1);
		this.add(imgtext);
		
		//�α��� ��ư
		loginBtn=new JButton("�α���");
		loginBtn.setBounds(150, 290, 85, 30);
		this.add(loginBtn);
		loginBtn.addActionListener(this);
		
		//ȸ������ ��ư
		joinBtn=new JButton("ȸ������");
		joinBtn.setBounds(50, 290, 85, 30);
		this.add(joinBtn);
		joinBtn.addActionListener(this);

		//�̹��� ����
		cp.setLayout(null);
		
		img=new ImageIcon("C:\\sist0117\\image\\purple.jpg");
		lblImg=new JLabel(img);
		lblImg.setBounds(17, 30, 250, 150);
		cp.add(lblImg);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob=e.getSource();
		
		if(ob==joinBtn)
		{
			JoinFrame jf=new JoinFrame("ȸ������");
			jf.setVisible(true);
		} else if(ob==loginBtn)
		{
			String pw="";
			char[] secretpw=tfpw.getPassword();
			for(char cha:secretpw) {
				Character.toString(cha);
				pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
			}
			
			String id=tfid.getText();
						
			LoginFrame log=LoginFrame.getInstance();
			int result=log.findByIdPw(id, pw);
			if(result==1) {
				JOptionPane.showMessageDialog(null, "�α��� ����");
				this.setVisible(false);
				BMI bmi = new BMI("BMI");
				bmi.setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(null,	"�α��� ����!");
			}
		}
	}

	public static JTextField getTfid() {
		return tfid;
	}

	public void setTfid(JTextField tfid) {
		this.tfid = tfid;
	}

	public static void main(String[] args) {
		new Project1("MAIN");
		
		
	}

}
