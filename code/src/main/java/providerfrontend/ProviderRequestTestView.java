package providerfrontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

public class ProviderRequestTestView {
   private static void providerSideBar(Container pane) {
      // creating the whole side panel
      JPanel sidePanel = new JPanel();
      sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
      sidePanel.setBorder(BorderFactory.createTitledBorder(""));
      
      // creating the button panel to organize the location of the buttons
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
      JButton button = new JButton("Patient Overview");
      buttonPanel.add(button);
      button = new JButton("Patient Visit");
      buttonPanel.add(button);
      button = new JButton("Prescribe");
      buttonPanel.add(button);
      button = new JButton("Request a Test");
      buttonPanel.add(button);
      button = new JButton("View Test Results");
      buttonPanel.add(button);
      button = new JButton("Referrals");
      buttonPanel.add(button);
      sidePanel.add(buttonPanel);
      
      // adding the side panel to the layout
      pane.add(sidePanel, BorderLayout.WEST);
   }
   
   private static void topBarPatientInformation(Container pane) {
      // creating the top panel to store all the information
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

      // creating the buttonPanel with the Home and Logout buttons
      JPanel buttonPanel = new JPanel();
      JButton button = new JButton("Home");
      buttonPanel.setLayout(new BorderLayout());
      buttonPanel.add(button, BorderLayout.WEST);
      button = new JButton("Logout");
      buttonPanel.add(button, BorderLayout.EAST);
      topPanel.add(buttonPanel);

      // creating the panel with the patient's Name
      JPanel patientPanel = new JPanel();
      patientPanel.setBorder(BorderFactory.createTitledBorder(""));
      patientPanel.setPreferredSize(new Dimension(500, 50));
      patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.X_AXIS));

      // displaying the patient's name
      JLabel patientName = new JLabel("Patient's name");
      patientName.setFont(patientName.getFont().deriveFont(35f));
      patientPanel.add(patientName);

      JPanel patientInformation = new JPanel();
      patientInformation.setLayout(new GridLayout(1, 4));

      // displaying the patient's gender
      JPanel gender = new JPanel();
      gender.setLayout(new BoxLayout(gender, BoxLayout.Y_AXIS));
      JLabel sexTitle = new JLabel("SEX");
      sexTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      gender.add(sexTitle);
      JLabel patientGender = new JLabel("-");
      patientGender.setAlignmentX(Component.CENTER_ALIGNMENT);
      gender.add(patientGender);
      patientInformation.add(gender);

      // displaying the patient's date of birth
      JPanel dateOfBirth = new JPanel();
      dateOfBirth.setLayout(new BoxLayout(dateOfBirth, BoxLayout.Y_AXIS));
      JLabel dateOfBirthTitle = new JLabel("DOB");
      dateOfBirthTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      dateOfBirth.add(dateOfBirthTitle);
      JLabel patientDateOfBirth = new JLabel("MM-DD-YY");
      patientDateOfBirth.setAlignmentX(Component.CENTER_ALIGNMENT);
      dateOfBirth.add(patientDateOfBirth);
      patientInformation.add(dateOfBirth);

      // displaying the patient's Primary Care Physician
      JPanel primaryCarePhysician = new JPanel();
      primaryCarePhysician.setLayout(new BoxLayout(primaryCarePhysician, BoxLayout.Y_AXIS));
      JLabel pcpTitle = new JLabel("PCP");
      pcpTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      primaryCarePhysician.add(pcpTitle);
      JLabel pcpName = new JLabel("Dr. Ima NotReal");
      pcpName.setAlignmentX(Component.CENTER_ALIGNMENT);
      primaryCarePhysician.add(pcpName);
      patientInformation.add(primaryCarePhysician);

      // displaying the patient's allergies
      JPanel allergies = new JPanel();
      allergies.setLayout(new BoxLayout(allergies, BoxLayout.Y_AXIS));
      JLabel allergiesTitle = new JLabel("Allergies");
      allergiesTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      allergies.add(allergiesTitle);
      JLabel allergiesList = new JLabel("None");
      allergiesList.setAlignmentX(Component.CENTER_ALIGNMENT);
      allergies.add(allergiesList);
      patientInformation.add(allergies);

      patientPanel.add(patientInformation);
      // adding the name panel to the main panel
      topPanel.add(patientPanel);

      // adding the top Panel to the contianer that was passed in to the function
      pane.add(topPanel, BorderLayout.NORTH);
   }
   
   public void patientRequestPanel(Container pane) {
      // creating the panel for the request section
      JPanel requestATest = new JPanel();
      requestATest.setLayout(new GridLayout(4,1));
      
      // creating the test name and date panel
      JPanel testAndDate = new JPanel();
      testAndDate.setLayout(new BoxLayout(testAndDate, BoxLayout.X_AXIS));
      testAndDate.setBorder(BorderFactory.createTitledBorder(""));

      // searchable test area
      JPanel testArea = new JPanel();
      testArea.setLayout(new GridLayout(3,1));

      // creating and adding the label for the search box
      JLabel testLabel = new JLabel();
      testLabel.setText("Test Name");
      testArea.add(testLabel);
      
      // creating the list of tests
      ArrayList<String> testNames = new ArrayList<String>();
      testNames.add("Complete Blood Count(CBC)");
      testNames.add("Prothrombin Time");
      testNames.add("Basic Metabolic Panel");
      testNames.add("Comprehensive Metabolic Panel");
      testNames.add("Lipid Panel");
      testNames.add("Liver Panel");
      testNames.add("Thyroid Stimulating Hormone");
      testNames.add("Hemoglobin A1C");
      
      // creating the searchable drop down menu
      StringSearchable searchable = new StringSearchable(testNames);
      AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);

      // adding the dropdown menu to the medication panel
      testArea.add(combo);
      
      // adding an invisible panel for formation
      testArea.add(new JPanel());
      
      // adding the testing area to the test and date panel
      testAndDate.add(testArea);
      
      // JPanel for date picket
      JPanel datePicker = new JPanel();
      datePicker.setLayout(new GridLayout(3,1));
      JLabel dateLabel = new JLabel();
      dateLabel.setText("Date of Request");
      datePicker.add(dateLabel);
      
      // creating boxes for the date to be entered
      JPanel dateEnter = new JPanel();
      dateEnter.setLayout(new FlowLayout(FlowLayout.LEFT));
      JTextArea day = new JTextArea();
      day.setBorder(BorderFactory.createLineBorder(null));
      day.setText("DD");
      day.setEditable(true);
      JTextArea month = new JTextArea();
      month.setText("MM");
      month.setEditable(true);
      month.setBorder(BorderFactory.createLineBorder(null));
      JTextArea year = new JTextArea();
      year.setText("YYYY");
      year.setEditable(true);
      year.setBorder(BorderFactory.createLineBorder(null));
      dateEnter.add(month);
      dateEnter.add(day);
      dateEnter.add(year);
      datePicker.add(dateEnter);
      datePicker.add(new JPanel());
      testAndDate.add(new JPanel());
      
      testAndDate.add(datePicker);
      
      // adding the test and date area to the main panel
      requestATest.add(testAndDate);
      
      // creating the reason for test panel
      JPanel reasonForTest = new JPanel();
      reasonForTest.setBorder(BorderFactory.createTitledBorder("Reason for test"));
      JTextArea testReason = new JTextArea(4,45);
      testReason.setText("");
      testReason.setEditable(true);
      testReason.setLineWrap(true);
      JScrollPane scroll = new JScrollPane(testReason);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      reasonForTest.add(scroll, BorderLayout.WEST);

      requestATest.add(reasonForTest);
      
      JPanel labAndFastingPanel = new JPanel();
      labAndFastingPanel.setLayout(new BoxLayout(labAndFastingPanel, BoxLayout.X_AXIS));
      labAndFastingPanel.setBorder(BorderFactory.createTitledBorder(""));
      
      // creating the lab drop down menu
      JPanel labPanel = new JPanel ();
      labPanel.setLayout(new GridLayout(3,1));
      JLabel labLabel = new JLabel ();
      labLabel.setText("Lab Name");
      labPanel.add(labLabel);
      JComboBox labOptions = new JComboBox (new Object[] { "", "LabCorp", "Quest", "Baylor Health Center", "Clinical Pathology Labotories" });
      labPanel.add(labOptions);
      
      labAndFastingPanel.add(labPanel);

      // Creating the fasting switch
      JPanel fastingPanel = new JPanel();
      fastingPanel.setLayout(new GridLayout(3,1));
      fastingPanel.add(new JPanel());
      JToggleButton toggleButton = new JToggleButton("Click Here if Fasting is Required");
      fastingPanel.add(toggleButton);
      
      labAndFastingPanel.add(fastingPanel);
      
      requestATest.add(labAndFastingPanel);
      
      // creating the notes and generate button panel
      JPanel notesAndSubmit = new JPanel();
      notesAndSubmit.setBorder(BorderFactory.createTitledBorder("Notes for Lab"));
      notesAndSubmit.setLayout(new GridLayout(1, 2));
      
      // creating the notes section
      JPanel notes = new JPanel();
      notes.setLayout(new GridLayout(1, 1));
      
      // creating the notes entered text area
      JTextArea notesEntered = new JTextArea(4, 10);
      notesEntered.setText("");
      notesEntered.setEditable(true);
      notesEntered.setLineWrap(true);
      scroll = new JScrollPane(notesEntered);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      notes.add(scroll);
      
      // adding the notes to the notes and submit section
      notesAndSubmit.add(notes);
      
      // creating a panel for the submit button
      JPanel submitPanel = new JPanel();
      submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.LINE_AXIS));
      submitPanel.add(new JPanel());
      submitPanel.add(new JButton("Generate"));
      submitPanel.add(new JPanel());
      
      // adding the submit panel to the notes and submit panel
      notesAndSubmit.add(submitPanel);
      
      // adding notes and submit to the main prescribe panel
      requestATest.add(notesAndSubmit);
      
      // adding the request a test panel to the container passed in
      pane.add(requestATest);
   }
   
   public void createAndShowProviderRequestTestView() {
      // creating the frame for the screen
      JFrame frame = new JFrame("Request a Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(750, 500));

      // creating the panes within the screen
      providerSideBar(frame.getContentPane());
      topBarPatientInformation(frame.getContentPane());
      patientRequestPanel(frame.getContentPane());

      // allowing the contents of the screen to be seen
      frame.pack();
      frame.setVisible(true);
   }
}
