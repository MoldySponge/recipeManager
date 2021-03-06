package recipeManager;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;

public class RecipeManager {
	private JFrame frame;
	
	private int stage = 1;
	
	/*actual panel to add*/
	private JPanel selectRecipe;
	private JPanel viewRecipies;
	private JPanel editIngredients;
	private JPanel addRecipe;
	
	/*button images*/
	private JLabel closeLabel;
	private ImageIcon closeIcon;
	private ImageIcon closeIconO;
	
	private JLabel newRecipeLabel;
	private ImageIcon newRecipeIcon;
	private ImageIcon newRecipeIconO;	
	
	private JLabel homeLabel;
	private ImageIcon homeIcon;
	private ImageIcon homeIconO;
	/*main color for the panels/frame*/
	private Color bgColor = new Color(255, 255, 255);
	
	/*classes which contain the panels for each and their names*/
	private EditIngredients editIngredientsPanel;
	private ViewRecipies viewRecipiesPanel;
	private SelectRecipe selectRecipePanel;
	private AddRecipe addRecipePanel;
	
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	private ArrayList<Recipe> selectedRecipes = new ArrayList<Recipe>();
	protected Recipe currentRecipe;
	private int currentRecipePos;
	private boolean deleteable = true;
		
	private boolean bool = true;
	public RecipeManager() {
		createWindow();
	}
		
	public void createWindow() {
		
		try{
			recipes = Recipe.readFromFile();
		}catch(IOException e){
			if(recipes == null)
				bool = false;
		}
		catch(ClassNotFoundException e)
		{
			
		}
		
		
		//Create and set up the window. 
		frame = new JFrame("Recipe Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*initialize classes for each section*/
		editIngredientsPanel = new EditIngredients();
		viewRecipiesPanel = new ViewRecipies();
		selectRecipePanel = new SelectRecipe();
		addRecipePanel = new AddRecipe();
		
		/*display the main frame and set the size and bgcolor etc*/
		frame.setSize(820,700);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(bgColor);	       
		frame.setVisible(true);
		
	    /*get the returned panel from each class and place it into
	     * the panel to be placed on frame
	     */
		selectRecipe = selectRecipePanel.getSelectRecipePanel();	
		viewRecipies = viewRecipiesPanel.getViewRecipiesPanel();
		editIngredients = editIngredientsPanel.getEditIngredientsPanel();
		addRecipe = addRecipePanel.getAddRecipePanel();
		
		/*set the initial stage (should be 1)*/
		setPanelStage(stage);
	}
	
	private void setPanelStage(int stage) {
		
		
		if(stage == 1) {
		
			/*add main buttons to the top of the panel*/
			frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			viewRecipies = viewRecipiesPanel.setViewRecipiesPanelDimensions();
			newRecipeButton();			       
			closeButton();
			homeButtonListeners();
			ComponentMover cm = new ComponentMover(frame, homeLabel);
			addGoButtonClickedListener();
			
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			frame.add(newRecipeLabel, c);
			c.gridx = 1;
			frame.add(homeLabel, c);
			c.anchor = GridBagConstraints.FIRST_LINE_END;	
			frame.add(closeLabel, c);			       
			
			/*add recipe selection panel to the frame*/
			if(selectedRecipes.isEmpty()) {
				selectRecipePanel.addSelectedRecipesToPanel(recipes);
			}
			else
				selectRecipePanel.addSelectedRecipesToPanel(selectedRecipes);
			
			addListenerLoop();
			selectRecipe = selectRecipePanel.setSelectRecipePanelDimensions();
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.PAGE_START;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			
			/*add viewrecipies panel to the frame*/
			
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(viewRecipies, c);
			/*refresh the panels and frame and place the layout*/
			frame.validate();
			frame.getContentPane().doLayout();
		}
		
		if(stage == 2) {
			/*fill out the top of the frame again for buttons like close etc*/
			frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();			
			newRecipeButton();			
			closeButton();
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			frame.add(newRecipeLabel, c);
			frame.add(homeLabel, c);
			c.anchor = GridBagConstraints.FIRST_LINE_END;	       
			frame.add(closeLabel, c);
			//frame.validate();			       
			 	
			/*adding the select recipe panel*/
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			

			/*adding the viewrecipies panel*/		
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(viewRecipies, c); 			       

			/*add the editingredients panel*/
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 2;
			frame.add(editIngredients, c);
			
			/*do the frame layout etc*/
			frame.getContentPane().doLayout();
		}
		
		if(stage == 3) {
			//add main buttons to the top of the panel
			frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();			
			newRecipeButton();			       
			closeButton();
			homeButtonListeners();
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			//frame.add(newRecipeLabel, c);
			frame.add(homeLabel, c);
			c.anchor = GridBagConstraints.FIRST_LINE_END;	
			frame.add(closeLabel, c);			       
			
			//add recipe selection panel to the frame
			selectRecipe = selectRecipePanel.setSelectRecipePanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			
			//add viewrecipies panel to the frame
		
			addRecipe = addRecipePanel.setAddRecipePanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(addRecipe, c);
			//refresh the panels and frame and place the layout
			addRecipeListener();
			frame.getContentPane().doLayout();
		}
	
	}
	
			
	private void closeButton() {		
	/*adds listeners for the close button*/
		closeIcon = new ImageIcon("src/close.gif");
		closeIconO = new ImageIcon("src/closeO.gif");
		closeLabel = new JLabel(closeIcon);		
			
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeLabel.setIcon(closeIconO);			
			}
		});
			
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				closeLabel.setIcon(closeIcon);
			}
		});
			
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
	}
	/*adds listeners for the newrecipe button*/
	private void newRecipeButton() {
		newRecipeIcon = new ImageIcon("src/newRecipe.gif");
		newRecipeIconO = new ImageIcon("src/newRecipeO.gif");
		newRecipeLabel = new JLabel(newRecipeIcon);		
			
		newRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newRecipeLabel.setIcon(newRecipeIconO);			
			}
		});
			
		newRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				newRecipeLabel.setIcon(newRecipeIcon);
			}
		});
			
		newRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stage = 3;
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				setPanelStage(stage);
			}
		});
		
	}
	/*addHomeButtonstuff*/
	private void homeButtonListeners() {
		homeIcon = new ImageIcon("src/home.gif");
		homeIconO = new ImageIcon("src/homeO.gif");
		homeLabel = new JLabel(homeIcon);		
			
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				homeLabel.setIcon(homeIconO);			
			}
		});
			
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				homeLabel.setIcon(homeIcon);
			}
		});
			
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stage = 1;
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				setPanelStage(stage);
			}
		});
		
	}
	//Added listener for when placing in a new recipe, then writes the recipe out to file
	private void addRecipeListener() {
		addRecipePanel.addRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(addRecipePanel.create) {
				stage = 1;
				recipes.add(addRecipePanel.getNewRecipe());
				try {
					Recipe.writeToFile(recipes);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();				
				setPanelStage(stage);
				}
				else {
					JFrame messagePane = new JFrame();
					JOptionPane.showMessageDialog(messagePane,"Please correctly input the recipe, only blank fields allowed is the imagePath");
				}
			}
		});		
	}
	
	private void addListenerLoop() {
		for(int i = 0;i < selectRecipePanel.currentLabels.size();i++) {
			addViewRecipeListener(i);
		}
	}
	
	private void populateSelectedRecipes(String lookFor) {
		boolean addSelectedRecipe = true;
		for(int i = 0; i < recipes.size();i++) {
			if(recipes.get(i).getTitle().toLowerCase().contains(lookFor.toLowerCase())) {
				selectedRecipes.add(recipes.get(i));
			}			
		}
		for(int i = 0; i < recipes.size();i++) {
			if(recipes.get(i).getCategory().toLowerCase().contains(lookFor.toLowerCase())) {
				for(int j = 0;j < selectedRecipes.size();j++) {
					if(selectedRecipes.get(j).getTitle().compareToIgnoreCase(recipes.get(i).getTitle()) == 0){
						addSelectedRecipe = false;
					}
					if(addSelectedRecipe == true){
						selectedRecipes.add(recipes.get(i));
					}
				}
				
			}
		}
		for(int i = 0; i < recipes.size();i++) {
			if(recipes.get(i).getMainIngredient().toLowerCase().contains(lookFor.toLowerCase())) {
				for(int j = 0;j < selectedRecipes.size();j++) {
					if(selectedRecipes.get(j).getTitle().compareToIgnoreCase(recipes.get(i).getTitle()) == 0){
						addSelectedRecipe = false;
					}
					if(addSelectedRecipe == true){
						selectedRecipes.add(recipes.get(i));
					}
				}
				
			}
		}
	}
	
	private void addViewRecipeListener(final int i) {
		selectRecipePanel.currentLabels.get(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				selectRecipePanel.currentLabels.get(i).setBackground(new Color(0, 153, 204));
				selectRecipePanel.currentLabels.get(i).setForeground(Color.white);
				selectRecipePanel.currentLabels.get(i).setBorder(BorderFactory.createLoweredSoftBevelBorder());
			}
		});
			
		selectRecipePanel.currentLabels.get(i).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				selectRecipePanel.currentLabels.get(i).setBackground(new Color(176,224,230));
				selectRecipePanel.currentLabels.get(i).setForeground(Color.black);
			}
		});
		selectRecipePanel.currentLabels.get(i).addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				viewRecipiesPanel.emptyPanel();
				viewRecipies.validate();
				viewRecipies.repaint();
				currentRecipe = selectRecipePanel.currentRecipes.get(i);
				currentRecipePos = i;
				viewRecipiesPanel.viewRecipe(selectRecipePanel.currentRecipes.get(i));
				viewRecipies.validate();
				viewRecipies.repaint();
				deleteable = true;
				deleteButtonListener();
				commentButtonListener();
				voteButtonListener();
				
			}
		});
	}
	
	private void addGoButtonClickedListener() {
		selectRecipePanel.goButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!selectedRecipes.isEmpty()) {
					selectedRecipes.clear();
				}
				populateSelectedRecipes(selectRecipePanel.searchCriteria.getText());
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				setPanelStage(stage);
			}
		});
	}	
	private void commentButtonListener() {				
		viewRecipiesPanel.commentLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				recipes.set(currentRecipePos, currentRecipe);
				try {
					Recipe.writeToFile(recipes);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				viewRecipiesPanel.emptyPanel();
				viewRecipies.validate();
				viewRecipies.repaint();
				viewRecipiesPanel.viewRecipe(currentRecipe);
				viewRecipies.validate();
				viewRecipies.repaint();
				deleteable = true;
				deleteButtonListener();
				commentButtonListener();
				voteButtonListener();
			}
		});
	}
	
	private void deleteButtonListener() {
		viewRecipiesPanel.deleteLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(deleteable){
				recipes.remove(currentRecipePos);
				try {
					Recipe.writeToFile(recipes);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				}
				viewRecipiesPanel.emptyPanel();
				viewRecipies.validate();
				viewRecipies.repaint();
				currentRecipePos = 0;
				deleteable = false;
				currentRecipe = null;
				stage = 1;
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				setPanelStage(stage);
			}
		});
	}	
	
	
	private void voteButtonListener() {
				viewRecipiesPanel.nickLabel1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					currentRecipe.setVotes(1.0);
					recipes.set(currentRecipePos, currentRecipe);
					try {
						Recipe.writeToFile(recipes);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					viewRecipiesPanel.emptyPanel();
					viewRecipies.validate();
					viewRecipies.repaint();
					viewRecipiesPanel.viewRecipe(currentRecipe);
					viewRecipies.validate();
					viewRecipies.repaint();
					deleteable = true;
					deleteButtonListener();
					commentButtonListener();
					voteButtonListener();
					
				}
			});
				viewRecipiesPanel.nickLabel2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					currentRecipe.setVotes(2.0);
					recipes.set(currentRecipePos, currentRecipe);
					try {
						Recipe.writeToFile(recipes);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					viewRecipiesPanel.emptyPanel();
					viewRecipies.validate();
					viewRecipies.repaint();
					viewRecipiesPanel.viewRecipe(currentRecipe);
					viewRecipies.validate();
					viewRecipies.repaint();
					deleteable = true;
					deleteButtonListener();
					commentButtonListener();
					voteButtonListener();
				}
			});
				viewRecipiesPanel.nickLabel3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					currentRecipe.setVotes(3.0);
					recipes.set(currentRecipePos, currentRecipe);
					try {
						Recipe.writeToFile(recipes);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					viewRecipiesPanel.emptyPanel();
					viewRecipies.validate();
					viewRecipies.repaint();
					viewRecipiesPanel.viewRecipe(currentRecipe);
					viewRecipies.validate();
					viewRecipies.repaint();
					deleteable = true;
					deleteButtonListener();
					commentButtonListener();
					voteButtonListener();
				}
			});
				viewRecipiesPanel.nickLabel4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					currentRecipe.setVotes(4.0);
					recipes.set(currentRecipePos, currentRecipe);
					try {
						Recipe.writeToFile(recipes);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					viewRecipiesPanel.emptyPanel();
					viewRecipies.validate();
					viewRecipies.repaint();
					viewRecipiesPanel.viewRecipe(currentRecipe);
					viewRecipies.validate();
					viewRecipies.repaint();
					deleteable = true;
					deleteButtonListener();
					commentButtonListener();
					voteButtonListener();
				}
			});
				viewRecipiesPanel.nickLabel5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					currentRecipe.setVotes(5.0);
					recipes.set(currentRecipePos, currentRecipe);
					try {
						Recipe.writeToFile(recipes);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					viewRecipiesPanel.emptyPanel();
					viewRecipies.validate();
					viewRecipies.repaint();
					viewRecipiesPanel.viewRecipe(currentRecipe);
					viewRecipies.validate();
					viewRecipies.repaint();
					deleteable = true;
					deleteButtonListener();
					commentButtonListener();
					voteButtonListener();
				}
			});
		
	}
	
		
	public JPanel createRectPanel (int x, int y) {
	
		JPanel tempPanel = new JPanel(new GridBagLayout());
		tempPanel.setMinimumSize(new Dimension(x,y));
		tempPanel.setMaximumSize(new Dimension(x,y));
		tempPanel.setPreferredSize(new Dimension(x,y));
	    
		return tempPanel;
			
	}
}