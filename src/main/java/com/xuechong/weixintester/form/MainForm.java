
package com.xuechong.weixintester.form;

/**
 * @author xuechong
 */
@SuppressWarnings("serial")
public class MainForm extends javax.swing.JFrame {

	/** Creates new form MainForm */
	public MainForm() {
		initComponents();
	}

	private void initComponents() {

		btnGo = new javax.swing.JButton();
		inputUrl = new javax.swing.JTextField();
		inputToken = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		content = new javax.swing.JTextPane();
		inputQuestion = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		menuBar = new javax.swing.JMenuBar();
		helpMenu = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		btnGo.setText("Go");
		btnGo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGoActionPerformed(evt);
			}
		});

		inputUrl.setText("url");

		inputToken.setText("token");

		jLabel1.setText("url");

		jLabel2.setText("token");

		content.setEditable(false);
		jScrollPane1.setViewportView(content);

		inputQuestion.setText("question");

		jLabel3.setText("question");

		helpMenu.setText("Help");
		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								org.jdesktop.layout.GroupLayout.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																jScrollPane1,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																690,
																Short.MAX_VALUE)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												jLabel1)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												inputUrl,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												428,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.UNRELATED)
																										.add(
																												jLabel2)
																										.addPreferredGap(
																												org.jdesktop.layout.LayoutStyle.RELATED)
																										.add(
																												inputToken,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												136,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												jLabel3)
																										.add(
																												18,
																												18,
																												18)
																										.add(
																												inputQuestion,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												566,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				btnGo)))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								jLabel1)
																						.add(
																								inputToken,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jLabel2)
																						.add(
																								inputUrl,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								inputQuestion,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								jLabel3)))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				28,
																				28,
																				28)
																		.add(
																				btnGo)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												12, Short.MAX_VALUE)
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												218,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {
		this.content.setText(this.content.getText() + "\r\nnew line");
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}

	
	/////////////
	////private/////
	////////////////
	private javax.swing.JButton btnGo;
	private javax.swing.JTextPane content;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JTextField inputQuestion;
	private javax.swing.JTextField inputToken;
	private javax.swing.JTextField inputUrl;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JMenuBar menuBar;
	
}