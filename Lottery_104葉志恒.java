package ych;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

public class Lottery_104葉志恒 extends JFrame {

	private JPanel contentPane;
	JTextField[] txtNums = new JTextField[6];
	JTextField[] txtWinNums = new JTextField[7];
	private JButton[] btnNum = new JButton[49];
	ArrayList<Integer> selectedNumAL = new ArrayList();
	static ArrayList<Integer> winNumAL = new ArrayList();
	private JButton btn_random;
	private JButton btn_confirm;
	private JButton btn_clear;
	private JButton btn_check;
	private JList list;
	private JButton btn_del;
	private JPanel panel_1;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_6;
	private DefaultListModel<String> listModel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextPane txtResult;
	private JPanel panel_5;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel lblNewLabel_1;
	private JLabel label_2;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lottery_104葉志恒 frame = new Lottery_104葉志恒();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Lottery_104葉志恒() {
		this.setBackground(new Color(255, 222, 173));
		this.setResizable(false);
		this.setTitle("大樂透");
		this.setDefaultCloseOperation(3);
		this.setBounds(100, 100, 650, 650);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(240, 240, 240));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(5, 10));
		this.panel = new JPanel();
		panel.setBackground(Color.CYAN);
		this.panel.setPreferredSize(new Dimension(150, 220));
		this.contentPane.add(this.panel, "North");
		this.panel.setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("選取的號碼");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 70, 100, 40);
		this.panel.add(lblNewLabel_2);
		for (int i = 0; i < this.txtNums.length; ++i) {
			this.txtNums[i] = new JTextField();
			this.txtNums[i].setHorizontalAlignment(0);
			this.txtNums[i].setFont(new Font("微軟正黑體", 0, 14));
			this.txtNums[i].setBounds(130 + i * 50, 70, 50, 50);
			this.txtNums[i].setEditable(false);
			this.txtNums[i].setBackground(Color.white);
			this.panel.add(this.txtNums[i]);
		}

		for (int i = 0; i < this.txtWinNums.length; ++i) {
			this.txtWinNums[i] = new JTextField();
			this.txtWinNums[i].setHorizontalAlignment(0);
			this.txtWinNums[i].setFont(new Font("微軟正黑體", 0, 14));
			this.txtWinNums[i].setBounds(130 + i * 50, 120, 50, 50);
			this.txtWinNums[i].setEditable(false);
			this.txtWinNums[i].setBackground(Color.white);
			this.panel.add(this.txtWinNums[i]);
		}

		this.txtWinNums[6].setBackground(Color.white);
		this.txtWinNums[6].setBounds(130 + 400, 120, 50, 50);
		this.btn_random = new JButton("電腦選號");
		this.btn_random.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.btn_random.setActionCommand("快選");
		this.btn_random.setBounds(-3, 180, 160, 40);
		this.panel.add(this.btn_random);
		this.btn_confirm = new JButton("\u5132\u5B58\u9078\u865F");
		this.btn_confirm.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.btn_confirm.setBounds(315, 180, 160, 40);
		this.panel.add(this.btn_confirm);
		this.btn_clear = new JButton("\u6E05\u9664\u9078\u865F");
		this.btn_clear.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.btn_clear.setBounds(156, 180, 160, 40);
		this.panel.add(this.btn_clear);
		this.btn_check = new JButton("開獎GO");
		this.btn_check.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.btn_check.setBounds(474, 180, 160, 40);
		this.panel.add(this.btn_check);
		JLabel label = new JLabel("開獎號碼");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		label.setBounds(20, 125, 100, 40);
		this.panel.add(label);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLUE);
		panel_7.setBounds(0, 0, 634, 64);
		panel.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		label_1 = new JLabel(
				"\u4EBA\u751F\u52DD\u5229\u7D44\u5927\u6A02\u900F");
		label_1.setForeground(new Color(224, 255, 255));
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		panel_7.add(label_1);
		
		label_2 = new JLabel("\u7279\u5225\u865F");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(436, 125, 100, 40);
		panel.add(label_2);
		this.panel_1 = new JPanel();
		panel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		this.panel_1.setPreferredSize(new Dimension(50, 50));
		this.contentPane.add(this.panel_1, "Center");
		this.panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2, "South");
		this.panel_2.setLayout(new BoxLayout(this.panel_2, 0));
		this.panel_3 = new JPanel();
		this.panel_3.setPreferredSize(new Dimension(120, 70));
		this.panel_3.setBackground(Color.WHITE);
		this.panel_2.add(this.panel_3);
		this.panel_3.setLayout(new BorderLayout(0, 0));
		this.scrollPane_1 = new JScrollPane();
		this.panel_3.add(this.scrollPane_1, "Center");
		this.txtResult = new JTextPane();
		txtResult.setForeground(Color.WHITE);
		txtResult.setBackground(new Color(154, 205, 50));
		this.txtResult.setEditable(false);
		this.txtResult.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		this.scrollPane_1.setViewportView(this.txtResult);

		lblNewLabel = new JLabel("\u958B\u734E\u7D50\u679C");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(71, 30));
		scrollPane_1.setColumnHeaderView(lblNewLabel);
		this.panel_5 = new JPanel();
		this.panel_2.add(this.panel_5);
		this.panel_4 = new JPanel();
		this.panel_4.setPreferredSize(new Dimension(10, 170));
		this.panel_2.add(this.panel_4);
		this.panel_4.setLayout(new BorderLayout(3, 3));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(
				Lottery_104葉志恒.class.getResource("/resource/lottery.png")));
		panel_4.add(lblNewLabel_1, BorderLayout.CENTER);
		this.listModel = new DefaultListModel();
		this.panel_6 = new JPanel();
		this.contentPane.add(this.panel_6, "East");
		this.panel_6.setLayout(new BoxLayout(this.panel_6, 1));
		JLabel lblNewLabel_3 = new JLabel("\u865F\u78BC\u5132\u5B58\u5340");
		lblNewLabel_3.setMaximumSize(new Dimension(260, 23));
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_3.setPreferredSize(new Dimension(50, 30));
		this.scrollPane = new JScrollPane();
		panel_6.add(scrollPane);
		this.list = new JList(this.listModel);
		this.list.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		this.list.setSelectionMode(0);
		this.scrollPane.setViewportView(this.list);
		this.btn_del = new JButton("\u522A\u9664\u9078\u865F");
		btn_del.setMaximumSize(new Dimension(260, 40));
		btn_del.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_6.add(btn_del);
		this.btn_del.setPreferredSize(new Dimension(90, 25));
		this.btn_del.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		for (int i = 0; i < this.btnNum.length; ++i) {
			this.btnNum[i] = new JButton(String.format("%02d", i + 1));
			this.btnNum[i].setBackground(Color.WHITE);
			this.btnNum[i].setFont(new Font("微軟正黑體", 0, 14));
			this.panel_1.add(this.btnNum[i]);
		}

		invokeNumbtn();
		inputNum();
		ranNum();
		save();
		delete();
		chkWin();
		reset();
	}

	public void invokeNumbtn() {
		for (int i = 0; i < this.btnNum.length; i++) {
			this.btnNum[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton) e.getSource();
					int selectedNum = Integer.parseInt(button.getText());
					if (button.getBackground() == Color.WHITE) {
						if (Lottery_104葉志恒.this.selectedNumAL.size() < 6) {
							button.setBackground(Color.cyan);
							Lottery_104葉志恒.this.selectedNumAL
									.add(Integer.valueOf(selectedNum));
						} else {
							JOptionPane.showMessageDialog(null, "最多選擇6個號碼!");
						}
					} else if (Lottery_104葉志恒.this.selectedNumAL
							.contains(Integer.valueOf(selectedNum))) {
						Lottery_104葉志恒.this.selectedNumAL
								.remove(Integer.valueOf(selectedNum));
						button.setBackground(Color.WHITE);
					}
					Lottery_104葉志恒.this.showNum();
				}
			});
		}

	}

	public void showNum() {
		try {
			Collections.sort(this.selectedNumAL);

			int i;
			for (i = 0; i < this.txtNums.length; ++i) {
				this.txtNums[i].setText("");
			}

			for (i = 0; i < this.selectedNumAL.size(); ++i) {
				if (this.selectedNumAL.contains(this.selectedNumAL.get(i))) {
					this.txtNums[i].setText(String.format("%02d",
							(Integer) this.selectedNumAL.get(i)));
				} else {
					this.txtNums[i].setText("");
				}
			}
		} catch (Exception var2) {
			var2.printStackTrace();
		}
	}

	public void inputNum() {
	}

	public void ranNum() {
		this.btn_random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lottery_104葉志恒.this.selectedNumAL.clear();
				new Thread() {
					public void run() {
						for (int x = 0; x < 15; x++) {
							try {
								Thread.sleep(70L);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							for (int j = 0; j < 6; j++) {
								for (int k = 0; k < 49; k++) {
									Lottery_104葉志恒.this.btnNum[k]
											.setBackground(Color.WHITE);
								}
								int ran = (int) (Math.random() * 49.0D);
								Lottery_104葉志恒.this.btnNum[ran]
										.setBackground(Color.cyan);
								Lottery_104葉志恒.this.txtNums[j].setText(
										String.format("%d", new Object[] {
												Integer.valueOf(ran) }));
							}
						}
						JButton[] arrayOfJButton;
						int ran = (arrayOfJButton = Lottery_104葉志恒.this.btnNum).length;
						for (int j = 0; j < ran; j++) {
							JButton btn = arrayOfJButton[j];
							btn.setBackground(Color.white);
						}
						for (int i = 0; i < 6; i++) {
							int num;
							do {
								num = (int) (Math.random() * 49.0D) + 1;
							} while (Lottery_104葉志恒.this.selectedNumAL
									.contains(Integer.valueOf(num)));
							Lottery_104葉志恒.this.selectedNumAL
									.add(Integer.valueOf(num));
							Lottery_104葉志恒.this.btnNum[(num - 1)]
									.setBackground(Color.cyan);
						}
						Lottery_104葉志恒.this.showNum();
					}
				}.start();
			}
		});
	}

	public void save() {
		this.btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Lottery_104葉志恒.this.selectedNumAL.size() < 6) {
					JOptionPane.showMessageDialog(null, "不足6個號碼",
							"error", 0);
				} else {
					String strNums = "";
					for (int i = 0; i < Lottery_104葉志恒.this.selectedNumAL
							.size(); i++) {
						strNums = strNums + String.format(" %02d ",
								new Object[] { Integer.valueOf(
										((Integer) Lottery_104葉志恒.this.selectedNumAL
												.get(i)).intValue()) });
					}
					Lottery_104葉志恒.this.listModel.addElement(strNums);
					Lottery_104葉志恒.this.clear();
				}
			}
		});
	}

	public void clear() {
		this.selectedNumAL.clear();
		for (int i = 0; i < 6; i++) {
			this.txtNums[i].setText("");
			this.txtWinNums[i].setText("");
		}
		this.txtWinNums[6].setText("");
		for (int i = 0; i < this.btnNum.length; i++) {
			this.btnNum[i].setBackground(Color.WHITE);
		}
	}

	public void reset() {
		this.btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lottery_104葉志恒.this.btn_random.setEnabled(true);
				Lottery_104葉志恒.this.btn_confirm.setEnabled(true);
				Lottery_104葉志恒.this.clear();
				Lottery_104葉志恒.this.listModel.clear();
				Lottery_104葉志恒.this.txtResult.setText("");
				for (int z = 0; z < Lottery_104葉志恒.this.btnNum.length; z++) {
					Lottery_104葉志恒.this.btnNum[z].setEnabled(true);
				}
			}
		});
	}

	public void delete() {
		this.btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Lottery_104葉志恒.this.list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "請選取要刪除的項目", "error",
							0);
				} else {
					Lottery_104葉志恒.this.listModel.remove(
							Lottery_104葉志恒.this.list.getSelectedIndex());
				}
			}
		});
	}

	public void chkWin() 
	  {
	    this.btn_check.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	//Lottery_104葉志恒.clear();
	    	Lottery_104葉志恒.this.winNumAL.clear();
	        if (Lottery_104葉志恒.this.list.getModel().getSize() <= 0) {
	          JOptionPane.showMessageDialog(null, "你必須至少儲存一組數字", "error", 0);
	        } else {
	          new Thread()
	          {
	            public void run()
	            {
	              int speNum = 0;
	              String result = "";
                      for(int x =0;x<15;x++)
                      {
	                try
	                {
	                  Thread.sleep(90L);
	                }
	                catch (InterruptedException e)
	                {
	                  e.printStackTrace();
	                }
	                for (int j = 0; j < 7; j++)
	                {
	                  for (int k = 0; k < 49; k++) {
	                	Lottery_104葉志恒.this.btnNum[k].setBackground(Color.WHITE);
	                  }
	                  int ran = (int)(Math.random() * 49.0D);
	                  Lottery_104葉志恒.this.btnNum[ran].setBackground(new Color(255, 215, 0));
	                  Lottery_104葉志恒.this.txtWinNums[j].setText(String.format("%d", new Object[] { Integer.valueOf(ran) }));
	                }
	              }
	              JButton[] arrayOfJButton;
	              int ran = (arrayOfJButton = Lottery_104葉志恒.this.btnNum).length;
	              for (int j = 0; j < ran; j++)
	              {
	                JButton btn = arrayOfJButton[j];
	                btn.setBackground(Color.white);
	              }
	              for (int i = 0; i < 6; i++)
	              {
	                int winNum;
	                do
	                {
	                  winNum = (int)(Math.random() * 49.0D) + 1;
	                } while (Lottery_104葉志恒.this.winNumAL.contains(Integer.valueOf(winNum)));
	                Lottery_104葉志恒.winNumAL.add(Integer.valueOf(winNum));
	              }
	              try
	              {
	                Collections.sort(Lottery_104葉志恒.this.winNumAL);
	                for (int i = 0; i < Lottery_104葉志恒.this.txtWinNums.length; i++) {
	                	Lottery_104葉志恒.this.txtWinNums[i].setText("");
	                }
	                for (int i = 0; i < Lottery_104葉志恒.this.winNumAL.size(); i++) {
	                  if (Lottery_104葉志恒.this.winNumAL.contains(Lottery_104葉志恒.this.winNumAL.get(i))) {
	                	  Lottery_104葉志恒.this.txtWinNums[i].setText(String.format("%02d", new Object[] { Integer.valueOf(((Integer)Lottery_104葉志恒.this.winNumAL.get(i)).intValue()) }));
	                  } else {
	                	  Lottery_104葉志恒.this.txtWinNums[i].setText("");
	                  }
	                }
	                do
	                {
	                  speNum = (int)(Math.random() * 49.0D) + 1;
	                } while (Lottery_104葉志恒.this.winNumAL.contains(Integer.valueOf(speNum)));
	                Lottery_104葉志恒.this.txtWinNums[6].setText(String.format("%02d", new Object[] { Integer.valueOf(speNum) }));
	              }
	              catch (Exception ex)
	              {
	                ex.printStackTrace();
	              }
	              for (int j = 0; j < 6; j++) {
	            	  Lottery_104葉志恒.this.btnNum[(Integer.parseInt(Lottery_104葉志恒.this.txtWinNums[j].getText()) - 1)].setBackground(new Color(255, 215, 0));
	              }
	              Lottery_104葉志恒.this.btnNum[(speNum - 1)].setBackground(new Color(255, 69, 0));
	              
	              String[] strNums = new String[6];
	              int[] intNums = new int[6];
	              for (int i = 0; i < Lottery_104葉志恒.this.list.getModel().getSize(); i++)
	              {
	                String listItem = (String)Lottery_104葉志恒.this.list.getModel().getElementAt(i);
	                listItem.trim();
	                strNums = listItem.split("  ");
	                for (int idx = 0; idx < 6; idx++) {
	                  intNums[idx] = Integer.parseInt(strNums[idx].trim());
	                }
	                result = result + String.format("你的第 %d組號碼", new Object[] { Integer.valueOf(i + 1) });
	                for (int b = 0; b < 6; b++) {
	                  result = result + String.format("%02d ", new Object[] { Integer.valueOf(intNums[b]) });
	                }
	                result = result + "\n";
	                
	                boolean ifSpe = false;
	                for (int a = 0; a < intNums.length; a++) {
	                  if (intNums[a] == speNum)
	                  {
	                    ifSpe = true;
	                    break;
	                  }
	                }
	                int wincount = 0;
	                int[] arrayOfInt1;
	                int j = (arrayOfInt1 = intNums).length;
	                for (int u = 0; u < j; u++)
	                {
	                  int w = arrayOfInt1[u];
	                  if (Lottery_104葉志恒.winNumAL.contains(Integer.valueOf(w))) {
	                    wincount++;
	                  }
	                }
	                if (ifSpe) {
	                  switch (wincount)
	                  {
	                  case 1: 
	                    result = result + "對中\"特別號\"及1個號碼 !";
	                    break;
	                  case 2: 
	                    result = result + "對中\"特別號\"及2個號碼, 恭喜你獲得\"柒獎\" !";
	                    break;
	                  case 3: 
	                    result = result + "對中\"特別號\"及3個號碼, 恭喜你獲得\"陸獎\" !";
	                    break;
	                  case 4: 
	                    result = result + "對中\"特別號\"及4個號碼, 恭喜你獲得\"肆獎\" !";
	                    break;
	                  case 5: 
	                    result = result + "對中\"特別號\"及5個號碼, 恭喜你獲得\"貳獎\" !";
	                    break;
	                  default: 
	                    result = result + "對中\"特別號\"!";
	                    
	                    break;
	                  }
	                } else {
	                  switch (wincount)
	                  {
	                  case 1: 
	                    result = result + "對中1個號碼 !";
	                    break;
	                  case 2: 
	                    result = result + "對中2個號碼 !";
	                    break;
	                  case 3: 
	                    result = result + "對中3個號碼, 恭喜你獲得\"普獎\" !";
	                    break;
	                  case 4: 
	                    result = result + "對中4個號碼, 恭喜你獲得\"伍獎\" !";
	                    break;
	                  case 5: 
	                    result = result + "對中5個號碼, 恭喜你獲得\"參獎\" !";
	                    break;
	                  case 6: 
	                    result = result + "對中6個號碼, 恭喜你獲得\"頭獎\" !";
	                    break;
	                  default: 
	                    result = result + "沒有對中任何一個號碼!";
	                  }
	                }
	                result = result + "\n";
	                Lottery_104葉志恒.this.txtResult.setText(result);
	                Lottery_104葉志恒.this.btn_random.setEnabled(false);
	                Lottery_104葉志恒.this.btn_confirm.setEnabled(false);
	                for (int z = 0; z < Lottery_104葉志恒.this.btnNum.length; z++) {
	                	Lottery_104葉志恒.this.btnNum[z].setEnabled(false);
	                }
	              }
	            }
	          }.start();
	        }
               }	      
	    });

	}
}
