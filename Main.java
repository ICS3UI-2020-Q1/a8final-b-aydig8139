import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JLabel counterLabel;

  JTextField numOutput;

  JButton countButton;
  JButton resetButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();

    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the counter labels
    counterLabel = new JLabel("Counter:");

    //layout the label by setting the coordinate and size 
    counterLabel.setBounds(220,250,70,20);

    //initialize the input text fields
    numOutput = new JTextField("0");

    //set the size and location of the textfield
    numOutput.setBounds(300, 250, 200, 20);

    //disable the textfield so the user cannot type in it
    numOutput.setEnabled(false);

    //initialize the buttons
    countButton = new JButton("Count");
    resetButton = new JButton("Reset");

    //set the size and location of the buttons
    countButton.setBounds(220, 200, 130, 20);
    resetButton.setBounds(370, 200, 130, 20);

    //add an action listener to the buttons
    countButton.addActionListener(this);
    resetButton.addActionListener(this);

    //set the action command on the buttons
    countButton.setActionCommand("count");
    resetButton.setActionCommand("reset");

    //add the buttons to the panel
    mainPanel.add(countButton);
    mainPanel.add(resetButton);

    //add the text field to the panel
    mainPanel.add(numOutput);

    //add the label to the main panel 
    mainPanel.add(counterLabel);

    //add the panel to the window
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //write an if statement that will run once the count button is clicked
    if(command.equals("count")){

      //get the text from the textfield and change it into an integer
      String number = numOutput.getText();
      int num = Integer.parseInt(number);

      //add one to the integer in the textfield
      num = num + 1;

      //write an if statement that will run only if the num variable is less than or equal to 10
      if(num <= 10){

        //display the num variable on the screen every time the user clicks the count button
        numOutput.setText("" + num);
      }

    }else if(command.equals("reset")){
      
      //display 0 if the user clicks reset 
      numOutput.setText("0");
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
