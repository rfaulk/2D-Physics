package graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import sprites.Sprite;

public class PhysicsWindow extends JFrame {
	private static final long serialVersionUID = -6003246824888646351L;
	
	ArrayList<Sprite> sprites = null;
	Dispatcher disp = null;
	
	private int height;
	private int width;
	
	private JPanel contentPane;
	
	/*** Constructors ***/
	
	public PhysicsWindow() {
		height = 300;
		width = 450;
		initGUI();
	}
	public PhysicsWindow(int w, int h, Dispatcher d) {
		width = w;
		height = h;
		disp = d;
		initGUI();
	}
	
	/*** Initialization ***/
		
	// initialize the GUI
	private void initGUI(){
		setTitle("Physics!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 100 + width, 100 + height);
		setSize(width, height);
		contentPane = new ContentPane(disp);
		setContentPane(contentPane);
	}
	
	/*** Accessors ***/
	
	public int width(){
		return width;
	}
	public int height(){
		return height;
	}
	public JPanel panel(){
		return contentPane;
	}
	
	public void setSprites(ArrayList<Sprite> a){
		sprites = a;
	}
	
	public void setDisp(Dispatcher d){
		disp = d;
	}
	
	/*** Debugging ***/
	
	// launch the window locally
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhysicsWindow frame = new PhysicsWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
