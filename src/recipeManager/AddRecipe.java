/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recipeManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Andy Smith
 */
public class AddRecipe{

	private JLabel addIngredientLabel;
	private JLabel addRecipeLabel;
	private ImageIcon addIngredientIcon;
	private ImageIcon addIngredientIconO;
	private ImageIcon addRecipeIcon;
	private ImageIcon addRecipeIconO;
	
    private JTextField amount;
    private JTextField ingredient;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea listIngredients;
    private JComboBox mainIngredient;
    private JComboBox mealCatagory;
    private JPanel actualPanel;
    private JPanel panCreate;
    private JTextArea recipeInstructions;
    private JTextField recipeTitle;
    private Color bgColor = new Color(255, 255, 255);
    /**
     * Creates new form NewJFrame
     */
    public AddRecipe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panCreate = new JPanel();
        amount = new JTextField();
        jLabel3 = new JLabel();
        recipeTitle = new JTextField();

        ingredient = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipeInstructions = new javax.swing.JTextArea();
        mainIngredient = new javax.swing.JComboBox();
        mealCatagory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jScrollPane2 = new javax.swing.JScrollPane();
        listIngredients = new javax.swing.JTextArea();
        actualPanel = new JPanel();
        addIngredientIcon = new ImageIcon("src/addIngredient.gif");
        addIngredientIconO = new ImageIcon("src/addIngredientO.gif");
        addIngredientLabel = new JLabel(addIngredientIcon);
        
        addRecipeIcon = new ImageIcon("src/addRecipe.gif");
        addRecipeIconO = new ImageIcon("src/addRecipeO.gif");
        addRecipeLabel = new JLabel(addRecipeIcon);
        
   
        
        addIngredientButton();
        addRecipeButton();

        jLabel3.setText("Amount");

        

        jLabel2.setText("Ingredient");

        jLabel1.setText("Recipe Title:");

        jLabel4.setText("Recipe Instructions:");

        recipeInstructions.setColumns(10);
        recipeInstructions.setRows(5);
        recipeInstructions.setLineWrap(true);
        recipeInstructions.setWrapStyleWord(true);
        recipeInstructions.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        mainIngredient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Meat", "Dairy", "Sweets", "Bread" }));

        mealCatagory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Breakfast", "Lunch", "Dinner", "Dessert" }));

        jLabel5.setText("Main Ingredient");

        jLabel6.setText("Meal Catagory");


        listIngredients.setColumns(20);
        listIngredients.setRows(5);
        jScrollPane2.setViewportView(listIngredients);
        panCreate.setBackground(bgColor);
        javax.swing.GroupLayout panCreateLayout = new javax.swing.GroupLayout(panCreate);
        panCreate.setLayout(panCreateLayout);
        panCreateLayout.setHorizontalGroup(
            panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCreateLayout.createSequentialGroup()
                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCreateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(recipeInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCreateLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mainIngredient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mealCatagory, 0, 105, Short.MAX_VALUE)))
                            .addGroup(panCreateLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(addRecipeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panCreateLayout.createSequentialGroup()
                        .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panCreateLayout.createSequentialGroup()
                                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(addIngredientLabel))
                                .addGap(18, 18, 18)
                                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(recipeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panCreateLayout.createSequentialGroup()
                                        .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ingredient, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panCreateLayout.setVerticalGroup(
            panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCreateLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(recipeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addIngredientLabel)
                    .addComponent(ingredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recipeInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCreateLayout.createSequentialGroup()
                        .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(mealCatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(mainIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addRecipeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(actualPanel);
        actualPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        panCreate.setSize(new Dimension(480,670));
        panCreate.validate();
        panCreate.doLayout();
        actualPanel.setBackground(bgColor);
        actualPanel.setBorder(new TitledBorder("Add Recipe"));
        actualPanel.validate();
        actualPanel.doLayout();

       
    }// </editor-fold>//GEN-END:initComponents

    private void addRecipeActionPerformed(MouseEvent evt) {//GEN-FIRST:event_addAllActionPerformed
        
        
        
        recipeTitle.setText(" ");
        ingredient.setText(" ");
        amount.setText(" ");
        listIngredients.setText(" ");
        recipeInstructions.setText(" ");
        mealCatagory.setSelectedIndex(0);
        mainIngredient.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(null,"You have added a Recipe!");
    }//GEN-LAST:event_addAllActionPerformed

    private void addIngredientActionPerformed(MouseEvent evt) {//GEN-FIRST:event_addIngredientActionPerformed
        // TODO add your handling code here:
        String ing, amnt, total, newline;
        ing = ingredient.getText();
        amnt = amount.getText();
        total = (ing + " " + amnt);
        newline = "\n";
        
        listIngredients.append(total + newline);
        
        ingredient.setText(" ");
        amount.setText(" ");
        
    }//GEN-LAST:event_addIngredientActionPerformed
    
    public JPanel getAddRecipePanel()
    {
    	return actualPanel;
    }
    
    public JPanel setAddRecipePanelDimensions()
    {
        actualPanel.setSize(new Dimension(600,670));
        actualPanel.setPreferredSize(new Dimension(600,670));
        return actualPanel;
    }
    
    private void addIngredientButton()
    {
    	addIngredientLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				addIngredientLabel.setIcon(addIngredientIconO);			
			}
		});
			
		addIngredientLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				addIngredientLabel.setIcon(addIngredientIcon);
			}
		});
			
		addIngredientLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addIngredientActionPerformed(e);
			}
		});
    }
    private void addRecipeButton()
    {
    	addRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				addRecipeLabel.setIcon(addRecipeIconO);			
			}
		});
			
		addRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				addRecipeLabel.setIcon(addRecipeIcon);
			}
		});
			
		addRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addRecipeActionPerformed(e);
			}
		});
    }
}