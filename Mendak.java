//Final GUI
//UNCOMMENT CLOSE CONFIRMATION.....done
//ANALYSE LIMITATIONS
//TODO: REMOVE FOCUS FROM ALL COMPONENTS.....done
//DEBUG NULL POINTER EXCEPTION ....done
import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//buttons 00838f
public class Mendak extends LogicHolder implements ActionListener, ItemListener
{
//ih9
    public static Point mouseDownCompCoords;
    public static JFrame Frame = new JFrame("Jskrnbindra Temp name");
    public static PrintWriter pw;
    public Color color = new Color(0);
    public JRadioButton RBNewFile,RBNewDB,ExitAsk;
    public static boolean AllowNewFile=false,AllowNewDB=false,AskOnExit=true;
    public static String DBUNAME="";
    public static String DBPASS="";
    public static String DEFAULTDBNAME="red";
    public static String DEFAULTTBLNAME="blue";
    public static String LastNS="";
    public static String LastRMN="";
    public static String LastURL="";
    
    JButton CloseButton,MinimizeButton,BtnNSCnvrt,BtnRMNCnvrt,BtnURLCnvrt,SaveButton,SaveButtonDB,CnvrtButtonDB,ResetButton,SettingsButton,HelpButton;
    JPanel PnlTopPanel,PnlDefaultButtonsHolder,PnlButtonHolder,PnlMenuHolder,PnlRightButtonsHolder,PnlMainBody,PnlComponentsHolder,PnlComponentsGrid;
    JPanel tbhNSL, tbhNSR, tbhRMNL, tbhRMNR, tahURLL, tahURLR, jcbhNSL, jcbhNSR, btnhCnvrt1, btnhCnvrt2, btnhCnvrt3,PnlLeftColumn,PnlMiddleColumn,PnlRightColumn,RightClmnUP,LeftClmnUP,PnlBottomHolder;
    JPanel PnlBottomHolderL,PnlBottomHolderR,PnlBottomHolderR2,PnlBHLGridResolver,PnlBHLBtmContainer,PnlSaveBtnHolder,PnlCardSave,PnlCardCnvrt,PnlCardHolder,PnlRightBottom,PnlRBRGrid,PnlRBRGrid2,PnlBHRGridResolver,PnlBHRGridResolver2,PnlBHRGridResolver3;
    JPanel PnlBHRGridResolverC,PnlBHRGridResolverC2,PnlBHRGridResolverC3,PnlLeftBig,PnlSubLeftBig,PnlSubLeftBig1,PnlSubLeftBig2,PnlSubLeftBig3,PnlSubLeftDown;
    JComboBox jcbNSLeft,jcbNSRight;
    JLabel AppName,tempSettings,tempHelp,tempReset,test,lblTest,DBname,Tblname,Clmnname,TblnameC2,ClmnnameC3;
    JTextField NSLeft,NSRight,RMNLeft,RMNRight,FilePathAcceptor,DBAcceptor,TblAcceptor,ClmnAcceptor,DBAcceptorC2,TblAcceptorC2,ClmnAcceptorC3;
    JTextArea URLLeft, URLRight;
    public String NSTypesLeft [] = {"Binary (2)","Octal (8)","Decimal (10)","Hexadecimal (16)"};
    JTextField temptf = new JTextField("sadfa",15);
    File ErrorLogger = new File("ErrorLog.txt");
    
    GridLayout grid21 = new GridLayout(2,1);
    GridLayout grid43 = new GridLayout(4,3);
    GridLayout grid22 = new GridLayout(2,2);
    FlowLayout flowMenuHolder = new FlowLayout();
    FlowLayout flowtbh = new FlowLayout();
    BorderLayout border = new BorderLayout();
    BorderLayout borderUP = new BorderLayout();
    BorderLayout borderMenuHolder = new BorderLayout();
    BorderLayout borderMainBody = new BorderLayout(); 
    BorderLayout BLComponentsGrid = new BorderLayout();
    BorderLayout BLLeftColumn = new BorderLayout();
    BorderLayout BLMidColumn = new BorderLayout();
    BorderLayout BLRightColumn = new BorderLayout();
    BorderLayout BLComponentsHolder = new BorderLayout();
    BorderLayout BLBottomHolder = new BorderLayout();
    BorderLayout BLGridResolver = new BorderLayout();
    BorderLayout BLRGridResolver = new BorderLayout();
    BorderLayout BLRGridResolver2 = new BorderLayout();
    BorderLayout BLRGridResolver3 = new BorderLayout();
    BorderLayout BLBHLBC = new BorderLayout();
    BorderLayout BLCSBtnholder = new BorderLayout();
    BorderLayout BLDBSaveHolder = new BorderLayout();
    BorderLayout BLBHR = new BorderLayout();
    BorderLayout BLBHR2 = new BorderLayout();
    BorderLayout BLRGridResolverC = new BorderLayout();
    BorderLayout BLRGridResolverC2 = new BorderLayout();
    BorderLayout BLRGridResolverC3 = new BorderLayout();
    BorderLayout BLDBCnvrtHolderC2 = new BorderLayout();
    BorderLayout BLCSBtnholderC2 = new BorderLayout();
    BorderLayout BLLeftBig = new BorderLayout();
    BorderLayout BLSubLeft = new BorderLayout();
    BorderLayout BLSubLeft1 = new BorderLayout();
    BorderLayout BLSubLeft2 = new BorderLayout();
    BorderLayout BLSubLeft3 = new BorderLayout();
    CardLayout cardlayout = new CardLayout();
    
    
    Font ButtonFont = new Font("SansSerif",Font.PLAIN,16);
    Font TitleBarButtonsFont = new Font("SansSerif",Font.PLAIN,13);
    Font TextAreaFont = new Font("SansSerif",Font.PLAIN,13);
    Font TextBoxFont = new Font("SansSerif",Font.PLAIN,24);
    Font BorderTitleFont = new Font("SansSerif",Font.PLAIN,15);
    Font LabelFont = new Font("SansSerif",Font.PLAIN,13);
    Font HeadersFont = new Font("SansSerif",Font.PLAIN,17);
    Font UtterSmallFont = new Font("SansSerif",Font.PLAIN,12);
    Font SettingsTextBoxFont = new Font("SansSerif",Font.PLAIN,18);
    
    Dimension DefButtonsDim = new Dimension(35,13);
   
    ImageIcon CardSwitcherIcon = new ImageIcon("CardSwitcherButton2.png");
    ImageIcon CardSwitcherIcon2 = new ImageIcon("CardSwitcherButton.png");
    
    public JButton CardSwitcher = new JButton(CardSwitcherIcon);
    public JButton CardSwitcherC2 = new JButton(CardSwitcherIcon2);
    
    
   
    Mendak()
    {      
        
    mouseDownCompCoords = null;
    Frame.setUndecorated(true);
    Frame.setSize(500,500);
    Frame.getContentPane().setBackground(color.decode("#1e1e1e"));
    Frame.setBounds(0, 0, 900, 550);
    Frame.setLayout(border);
    Frame.setLocationRelativeTo(null);

    CloseButton = new JButton();
    CloseButton.setBorder(null);
    CloseButton.setBorderPainted(false);
    CloseButton.setPreferredSize(DefButtonsDim); 
    CloseButton.setMargin(new Insets(0,0,0,0));
    CloseButton.setBackground(color.decode("#F13846"));
    CloseButton.setFocusPainted(false);
    CloseButton.setFont(TitleBarButtonsFont);
    CloseButton.setForeground(color.decode("#ffffff"));
    CloseButton.addActionListener(this);
    
    PnlTopPanel = new JPanel();
    PnlTopPanel.setLayout(grid21);
    PnlTopPanel.setBackground(color.decode("#1e1e1e"));

    
    PnlMenuHolder = new JPanel();
    PnlMenuHolder.setLayout(borderMenuHolder);
    flowMenuHolder.setHgap(30);
    PnlMenuHolder.setBackground(color.decode("#333333"));//keep color
    
    AppName = new JLabel("Mendak Converter");
    AppName.setBorder(new EmptyBorder(0,10,0,0));
    AppName.setForeground(color.decode("#ffffff"));
    AppName.setFont(TitleBarButtonsFont);
    
    //temporary replacements for image buttons
   /* tempHelp = new JLabel("Help");
    tempReset = new JLabel("Reset");
    tempSettings = new JLabel("Settings");
    tempHelp.setForeground(color.decode("#ffffff"));
    tempReset.setForeground(color.decode("#ffffff"));
    tempSettings.setForeground(color.decode("#ffffff"));
    */
    ResetButton = new JButton("Reset");
    ResetButton.setBackground(color.decode("#333333"));
    ResetButton.setForeground(color.decode("#ffffff"));
    ResetButton.setPreferredSize(new Dimension(60,15));
    ResetButton.setFont(TitleBarButtonsFont);
    ResetButton.setBorder(null);
    ResetButton.setFocusPainted(false);
    ResetButton.addActionListener(this);
    
    SettingsButton = new JButton("Settings");
    SettingsButton.setBackground(color.decode("#333333"));
    SettingsButton.setForeground(color.decode("#ffffff"));
    SettingsButton.setPreferredSize(new Dimension(60,15));
    SettingsButton.setFont(TitleBarButtonsFont);
    SettingsButton.setBorder(null);
    SettingsButton.setFocusPainted(false);
    SettingsButton.addActionListener(this);
    
    HelpButton = new JButton("Help");
    HelpButton.setBackground(color.decode("#333333"));
    HelpButton.setForeground(color.decode("#ffffff"));
    HelpButton.setPreferredSize(new Dimension(60,15));
    HelpButton.setFont(TitleBarButtonsFont);
    HelpButton.setBorder(null);
    HelpButton.setFocusPainted(false);
    HelpButton.addActionListener(this);
    
    
    PnlRightButtonsHolder = new JPanel();
    PnlRightButtonsHolder.setLayout(flowMenuHolder);
    PnlRightButtonsHolder.setBackground(color.decode("#333333"));//keep color
    PnlRightButtonsHolder.setBorder(new EmptyBorder(0,0,0,33));
    PnlRightButtonsHolder.add(ResetButton);
    PnlRightButtonsHolder.add(SettingsButton);
    PnlRightButtonsHolder.add(HelpButton);
    
    PnlMenuHolder.add(AppName,borderMenuHolder.CENTER);
    PnlMenuHolder.add(PnlRightButtonsHolder,borderMenuHolder.EAST);


    MinimizeButton = new JButton("");
    MinimizeButton.setBorder(null);
    MinimizeButton.setBorderPainted(false);
    MinimizeButton.setPreferredSize(DefButtonsDim); 
    MinimizeButton.setMargin(new Insets(0,0,0,0));
    MinimizeButton.setBackground(color.decode("#2670df"));
    MinimizeButton.setFocusPainted(false);
    MinimizeButton.setFont(TitleBarButtonsFont);
    MinimizeButton.setForeground(color.decode("#ffffff"));
    MinimizeButton.addActionListener(this);
    
        
    PnlDefaultButtonsHolder = new JPanel();
    PnlDefaultButtonsHolder.setLayout(borderUP);
    PnlDefaultButtonsHolder.setBackground(color.decode("#1e1e1e"));
    
    PnlButtonHolder = new JPanel();
    PnlButtonHolder.setBackground(color.decode("#1e1e1e"));
    PnlButtonHolder.add(MinimizeButton);
    PnlButtonHolder.add(CloseButton);
    
    PnlDefaultButtonsHolder.add(PnlButtonHolder,borderUP.EAST);
    
    PnlTopPanel.add(PnlDefaultButtonsHolder);
    PnlTopPanel.add(PnlMenuHolder);
    
    PnlMainBody = new JPanel();
    PnlMainBody.setLayout(borderMainBody);
    PnlMainBody.setBorder(new EmptyBorder(20,0,0,0));
    PnlMainBody.setBackground(color.decode("#1e1e1e"));
    
    test = new JLabel("Buckingham Palace Hillsi");
    
    //PnlComponentsGrid is actually BorderLayout
    
    PnlComponentsGrid = new JPanel();
    PnlComponentsGrid.setLayout(BLComponentsGrid);
    PnlComponentsGrid.setBorder(new EmptyBorder(0,13,0,54));
    PnlComponentsGrid.setBackground(color.decode("#1e1e1e"));
    
    PnlLeftColumn = new JPanel();
    PnlLeftColumn.setLayout(BLLeftColumn);
    
    PnlRightColumn = new JPanel();
    PnlRightColumn.setLayout(BLRightColumn);
    
    PnlMiddleColumn = new JPanel();
    PnlMiddleColumn.setLayout(BLMidColumn);
    
    
    
    
    NSLeft = new JTextField(14);
    NSRight = new JTextField(14);
    RMNLeft = new JTextField(14);
    RMNRight = new JTextField(14);
   /*
   TODO:
   1. add clean flat design to all textboxes and JCBs
   2. Switch from GridLayout to BorderLayout in the ComponentsGrid to resize the middle column
   3. Use buttons column as BorderLayout's center and textboxes as east and west components.
   */
    NSLeft.setFont(TextBoxFont);
    NSLeft.setBorder(null);
    NSLeft.setMargin(new Insets(0,0,0,0));
    //NSLeft.setPreferredSize(new Dimension(3,12));
    
    NSRight.setFont(TextBoxFont);
    NSRight.setBorder(null);
    NSRight.setMargin(new Insets(0,0,0,0));
    
    RMNLeft.setFont(TextBoxFont);
    RMNLeft.setBorder(null);
    RMNLeft.setMargin(new Insets(0,0,0,0));
    
    RMNRight.setFont(TextBoxFont);
    RMNRight.setBorder(null);
    RMNRight.setMargin(new Insets(0,0,0,0));
    
    URLLeft = new JTextArea(7,25);
    URLLeft.setFont(TextAreaFont);
    URLLeft.setBorder(null);
    URLLeft.setMargin(new Insets(0,0,0,0));
    
    JScrollPane ScrollPane = new JScrollPane(URLLeft);
    ScrollPane.setBorder(null);
    
    URLRight = new JTextArea(7,25);
    URLRight.setFont(TextAreaFont);
    URLRight.setBorder(null);
    URLRight.setMargin(new Insets(0,0,0,0));
    
    JScrollPane ScrollPane2 = new JScrollPane(URLRight);
    ScrollPane2.setBorder(null);
    
    jcbNSLeft = new JComboBox(NSTypesLeft);
    jcbNSLeft.setBorder(null);
    jcbNSLeft.setBackground(color.decode("#555555"));
    jcbNSLeft.setForeground(color.decode("#ffffff"));
    jcbNSLeft.setPreferredSize(new Dimension(193,30));
    jcbNSLeft.setSelectedIndex(2);
    jcbNSLeft.addItemListener(this);
    
    jcbNSRight = new JComboBox(NSTypesLeft);
    jcbNSRight.setBorder(null);
    jcbNSRight.setBackground(color.decode("#555555"));
    jcbNSRight.setForeground(color.decode("#ffffff"));
    jcbNSRight.setPreferredSize(new Dimension(193,30));
    jcbNSRight.addItemListener(this);

    BtnNSCnvrt = new JButton("CONVERT");
    BtnNSCnvrt.setPreferredSize(new Dimension(93,30));
    BtnNSCnvrt.setBackground(color.decode("#00838f"));
    BtnNSCnvrt.setForeground(color.decode("#ffffff"));
    BtnNSCnvrt.setFocusPainted(false);
    BtnNSCnvrt.addActionListener(this);
    
    BtnRMNCnvrt = new JButton("CONVERT");
    BtnRMNCnvrt.setPreferredSize(new Dimension(93,30));
    BtnRMNCnvrt.setBackground(color.decode("#00838f"));
    BtnRMNCnvrt.setForeground(color.decode("#ffffff"));
    BtnRMNCnvrt.setFocusPainted(false);
    BtnRMNCnvrt.addActionListener(this);
    
    BtnURLCnvrt = new JButton("CONVERT");
    BtnURLCnvrt.setPreferredSize(new Dimension(93,30));
    BtnURLCnvrt.setBackground(color.decode("#00838f"));
    BtnURLCnvrt.setForeground(color.decode("#ffffff"));
    BtnURLCnvrt.setFocusPainted(false);
    BtnURLCnvrt.addActionListener(this);
 
    tbhNSL = new JPanel();
    tbhNSR = new JPanel();
    tbhRMNL = new JPanel();
    tbhRMNR = new JPanel();
    tahURLL = new JPanel();
    tahURLR = new JPanel();
    jcbhNSL = new JPanel();
    jcbhNSR = new JPanel();
    btnhCnvrt1 = new JPanel();
    btnhCnvrt2 = new JPanel();
    btnhCnvrt3 = new JPanel();
  
    btnhCnvrt1.setBorder(new EmptyBorder(0,0,50,0));
    btnhCnvrt2.setBackground(color.decode("#1e1e1e"));
    btnhCnvrt3.setBackground(color.decode("#1e1e1e"));
    
    jcbhNSL.setBackground(color.decode("#1e1e1e"));
    jcbhNSR.setBackground(color.decode("#1e1e1e"));
    tbhNSL.setBackground(color.decode("#1e1e1e"));
    tbhNSR.setBackground(color.decode("#1e1e1e"));
    tbhRMNL.setBackground(color.decode("#1e1e1e"));
    tbhRMNR.setBackground(color.decode("#1e1e1e"));
    
    tbhNSL.add(NSLeft);
    tbhNSR.add(NSRight);
    tbhRMNL.add(RMNLeft);
    tbhRMNR.add(RMNRight);
    jcbhNSL.add(jcbNSLeft);
    jcbhNSR.add(jcbNSRight);
    tahURLL.add(ScrollPane);
    tahURLR.add(ScrollPane2);
    btnhCnvrt1.add(BtnNSCnvrt);
    btnhCnvrt2.add(BtnRMNCnvrt);
    btnhCnvrt3.add(BtnURLCnvrt);
      
    LeftClmnUP = new JPanel();
    LeftClmnUP.setLayout(grid21);

    LeftClmnUP.add(tbhNSL);
    LeftClmnUP.add(jcbhNSL);  
   
    RightClmnUP = new JPanel();
    RightClmnUP.setLayout(grid21);
  
    RightClmnUP.add(tbhNSR);
    RightClmnUP.add(jcbhNSR);
    
    
    PnlLeftColumn.add(LeftClmnUP,BLLeftColumn.NORTH);
    PnlLeftColumn.add(tbhRMNL,BLLeftColumn.CENTER);
    PnlLeftColumn.add(tahURLL,BLLeftColumn.SOUTH);
    
    BLRightColumn.setHgap(0);
    PnlRightColumn.add(RightClmnUP,BLRightColumn.NORTH);
    PnlRightColumn.add(tbhRMNR,BLRightColumn.CENTER);
    PnlRightColumn.add(tahURLR,BLRightColumn.SOUTH);
    PnlRightColumn.setBackground(color.decode("#1e1e1e"));
    btnhCnvrt1.setBackground(color.decode("#1e1e1e"));
    PnlMiddleColumn.add(btnhCnvrt1,BLMidColumn.NORTH);
    PnlMiddleColumn.add(btnhCnvrt2,BLMidColumn.CENTER);
    PnlMiddleColumn.add(btnhCnvrt3,BLMidColumn.SOUTH);
      /*
REDUNDANT
    PnlComponentsGrid.add(tbhNSL);
    PnlComponentsGrid.add(btnhCnvrt1);
    PnlComponentsGrid.add(tbhNSR);
    PnlComponentsGrid.add(jcbhNSL);
    PnlComponentsGrid.add(new JLabel("Oh yeah"));
    PnlComponentsGrid.add(jcbhNSR);
    PnlComponentsGrid.add(tbhRMNL);
    PnlComponentsGrid.add(btnhCnvrt2);
    PnlComponentsGrid.add(tbhRMNR);
    PnlComponentsGrid.add(tahURLL);
    PnlComponentsGrid.add(btnhCnvrt3);
    PnlComponentsGrid.add(tahURLR);
    */
    PnlComponentsGrid.add(PnlLeftColumn,BLComponentsGrid.WEST);
    PnlComponentsGrid.add(PnlMiddleColumn,BLComponentsGrid.CENTER);
    PnlComponentsGrid.add(PnlRightColumn,BLComponentsGrid.EAST);
   
    PnlComponentsHolder = new JPanel();
    PnlComponentsHolder.setLayout(BLComponentsHolder);
    PnlComponentsHolder.setBackground(color.decode("#1e1e1e"));
   
    PnlBottomHolder = new JPanel();
    PnlBottomHolder.setLayout(BLBottomHolder);
    PnlBottomHolder.setBackground(color.decode("#1e1e1e"));
    PnlBottomHolder.setBorder(new EmptyBorder(15,13,18,0));
    
    PnlBottomHolderL = new JPanel();
    PnlBottomHolderL.setBackground(color.decode("#1e1e1e"));
    
    PnlBottomHolderR = new JPanel();
    PnlBottomHolderR.setBackground(color.decode("#1e1e1e"));
    
    JButton ji = new JButton("dadgadgadgadsgsadf");
    SaveButton = new JButton("SAVE");
    
    SaveButton.setPreferredSize(new Dimension(93,30));
    SaveButton.setBackground(color.decode("#00838f"));
    SaveButton.setForeground(color.decode("#ffffff"));
    SaveButton.setFocusPainted(false);
    SaveButton.addActionListener(this);
    JPanel PnlBHLGrid = new JPanel();
    
    JLabel lblFiler = new JLabel("Paste the path of the file here:");
    lblFiler.setFont(LabelFont);
    lblFiler.setForeground(color.decode("#999999"));
    
    FilePathAcceptor = new JTextField(12);
    FilePathAcceptor.setFont(TextBoxFont);
    FilePathAcceptor.setBorder(null);
    FilePathAcceptor.setMargin(new Insets(0,0,0,0));
    
    PnlBHLGrid.setBackground(color.decode("#1e1e1e"));
    
    PnlBHLGridResolver = new JPanel();
    PnlBHLGridResolver.setLayout(BLGridResolver);
    PnlBHLGridResolver.setBackground(color.decode("#1e1e1e"));
    
    PnlBHLGridResolver.add(lblFiler,BLGridResolver.NORTH);
    PnlBHLGridResolver.add(FilePathAcceptor,BLGridResolver.SOUTH);
    
    PnlBHLBtmContainer = new JPanel();
    PnlBHLBtmContainer.setLayout(BLBHLBC);
    PnlBHLBtmContainer.setBackground(color.decode("#1e1e1e"));
    PnlBHLBtmContainer.setBorder(new EmptyBorder(0,13,0,0));
    
    JLabel Ortext = new JLabel("OR");
    Ortext.setFont(ButtonFont);
    Ortext.setBorder(new EmptyBorder(0,12,0,12));
    Ortext.setForeground(color.decode("#ffffff"));
    
    RBNewFile = new JRadioButton("Create new file",false);
    RBNewFile.setFont(LabelFont);
    RBNewFile.setForeground(color.decode("#ffffff"));
    RBNewFile.setBackground(color.decode("#1e1e1e"));
    RBNewFile.addItemListener(this);
    
    
    PnlSaveBtnHolder = new JPanel();
    PnlSaveBtnHolder.add(SaveButton);
    PnlSaveBtnHolder.setBorder(new EmptyBorder(10,0,0,0));
    PnlSaveBtnHolder.setBackground(color.decode("#1e1e1e"));
    
    PnlBHLBtmContainer.add(PnlSaveBtnHolder,BLBHLBC.WEST);
    PnlBHLBtmContainer.add(Ortext,BLBHLBC.CENTER);
    PnlBHLBtmContainer.add(RBNewFile,BLBHLBC.EAST);
    
    PnlBHLGrid.add(PnlBHLGridResolver);
    
    PnlBottomHolderL.setLayout(grid21);
   
    PnlBottomHolderL.add(PnlBHLGrid);
    PnlBottomHolderL.add(PnlBHLBtmContainer);
    
    PnlRBRGrid = new JPanel();
    PnlRBRGrid.setLayout(grid22);
    
    
    
    PnlRightBottom = new JPanel();
    PnlRightBottom.setBackground(color.decode("#1e1e1e"));
    //PnlRightBottom.setBorder(new EmptyBorder(0,0,0,0));
    /*TODO: 
    1. Set bottom right holder with titled border 
    2. all set , set the empty border to the inside panel added
    3. add empty border left to the PnlBottomHoderR
    */
    
    LineBorder lnbrdr = new LineBorder(color.decode("#14464c"),1,true);
    TitledBorder tborder = new TitledBorder(lnbrdr,"Store results in a file",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,BorderTitleFont,color.decode("#8c8080"));
    PnlBottomHolderL.setBorder(tborder);
    
    LineBorder lnbrdr2 = new LineBorder(color.decode("#14464c"),1,true);
    TitledBorder tborder2 = new TitledBorder(lnbrdr2,"Store results in a Database",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,BorderTitleFont,color.decode("#8c8080"));
    PnlBottomHolderR.setBorder(tborder2);
    
    // gridresolver here
    DBname = new JLabel("Database Name:");
    DBname.setFont(LabelFont);
    DBname.setForeground(color.decode("#999999"));
    
    DBAcceptor = new JTextField(8);
    DBAcceptor.setFont(TextBoxFont);
    DBAcceptor.setBorder(null);
    DBAcceptor.setMargin(new Insets(0,0,0,0));
    
    
    PnlBHRGridResolver = new JPanel();
    PnlBHRGridResolver.setLayout(BLRGridResolver);
    PnlBHRGridResolver.setBackground(color.decode("#1e1e1e"));
    PnlBHRGridResolver.setBorder(new EmptyBorder(8,12,0,0));
    
    PnlBHRGridResolver.add(DBname,BLRGridResolver.NORTH);
    PnlBHRGridResolver.add(DBAcceptor,BLRGridResolver.SOUTH);
    
    PnlRBRGrid.add(PnlBHRGridResolver);
    // gridresolver here
    
     // gridresolver here
    Tblname = new JLabel("Table Name:");
    Tblname.setFont(LabelFont);
    Tblname.setForeground(color.decode("#999999"));
    
    
    TblAcceptor = new JTextField(8);
    TblAcceptor.setFont(TextBoxFont);
    TblAcceptor.setBorder(null);
    TblAcceptor.setMargin(new Insets(0,0,0,0));
    
    PnlBHRGridResolver2 = new JPanel();
    PnlBHRGridResolver2.setLayout(BLRGridResolver2);
    PnlBHRGridResolver2.setBackground(color.decode("#1e1e1e"));
    PnlBHRGridResolver2.setBorder(new EmptyBorder(8,32,0,0));
    
    PnlBHRGridResolver2.add(Tblname,BLRGridResolver2.NORTH);
    PnlBHRGridResolver2.add(TblAcceptor,BLRGridResolver2.SOUTH);
    
    PnlRBRGrid.add(PnlBHRGridResolver2);
    // gridresolver here
    
    
    
     // gridresolver here
    Clmnname = new JLabel("Column Name:");
    Clmnname.setFont(LabelFont);
    Clmnname.setForeground(color.decode("#999999"));
    
    ClmnAcceptor = new JTextField(8);
    ClmnAcceptor.setFont(TextBoxFont);
    ClmnAcceptor.setBorder(null);
    ClmnAcceptor.setMargin(new Insets(0,0,0,0));
    
    PnlBHRGridResolver3 = new JPanel();
    PnlBHRGridResolver3.setLayout(BLRGridResolver3);
    PnlBHRGridResolver3.setBackground(color.decode("#1e1e1e"));
    PnlBHRGridResolver3.setBorder(new EmptyBorder(4,12,10,0));
    
    
    PnlBHRGridResolver3.add(Clmnname,BLRGridResolver3.NORTH);
    PnlBHRGridResolver3.add(ClmnAcceptor,BLRGridResolver3.SOUTH);
    
    PnlRBRGrid.add(PnlBHRGridResolver3);
    // gridresolver here
    
     // gridresolver here
     
    SaveButtonDB = new JButton("SAVE");
    SaveButtonDB.setPreferredSize(new Dimension(93,30));
    SaveButtonDB.setBackground(color.decode("#00838f"));
    SaveButtonDB.setForeground(color.decode("#ffffff"));
    SaveButtonDB.setFocusPainted(false);
    SaveButtonDB.addActionListener(this);
    
    JPanel SaveButtonDBHolder = new JPanel();
    SaveButtonDBHolder.setBackground(color.decode("#1e1e1e"));
    SaveButtonDBHolder.add(SaveButtonDB);
    
    
    JLabel Ortext2 = new JLabel("OR",null,JLabel.CENTER);
    Ortext2.setFont(ButtonFont);
    Ortext2.setBorder(new EmptyBorder(0,15,0,20));
    Ortext2.setForeground(color.decode("#ffffff"));
   
    
    RBNewDB = new JRadioButton("Create new Table",false);
    RBNewDB.setFont(LabelFont);
    RBNewDB.setForeground(color.decode("#ffffff"));
    RBNewDB.setBorder(new EmptyBorder(0,0,0,0));
    RBNewDB.setFocusPainted(false);
    RBNewDB.addItemListener(this);
    RBNewDB.setBackground(color.decode("#1e1e1e"));
    
    JPanel PnlDBSaveHolder = new JPanel();
    PnlDBSaveHolder.setLayout(BLDBSaveHolder);
    PnlDBSaveHolder.setBorder(null);
    PnlDBSaveHolder.setBackground(color.decode("#1e1e1e"));
    
    PnlDBSaveHolder.add(SaveButtonDBHolder,BLDBSaveHolder.NORTH);
    PnlDBSaveHolder.add(Ortext2,BLDBSaveHolder.WEST);
    PnlDBSaveHolder.add(RBNewDB,BLDBSaveHolder.CENTER);
    PnlRBRGrid.setBackground(color.decode("#1e1e1e"));
    PnlRBRGrid.add(PnlDBSaveHolder);
    
    // gridresolver here
    
    JPanel PnlCSBtnHolder = new JPanel();
    PnlCSBtnHolder.setLayout(BLCSBtnholder);
    PnlCSBtnHolder.setBackground(color.decode("#1e1e1e"));
    
    CardSwitcher.setPreferredSize(new Dimension(20,20));
    CardSwitcher.setBackground(color.decode("#1e1e1e"));
    CardSwitcher.setBorder(null);
    CardSwitcher.setFocusPainted(false);
    CardSwitcher.setForeground(color.decode("#ffffff"));
    CardSwitcher.addActionListener(this);
    
    PnlCSBtnHolder.add(CardSwitcher,BLCSBtnholder.NORTH);
    
    PnlBottomHolderR.setLayout(BLBHR);
    
    PnlBottomHolderR.add(PnlRBRGrid,BLBHR.CENTER);
    PnlBottomHolderR.add(PnlCSBtnHolder,BLBHR.EAST);
    
    PnlCardHolder = new JPanel();
    PnlCardHolder.setLayout(cardlayout);
    PnlCardHolder.setBackground(color.decode("#1e1e1e"));
    
    /*
    CardSwitcher2.setPreferredSize(new Dimension(20,20));
    CardSwitcher2.setBackground(color.decode("#1e1e1e"));
    CardSwitcher2.setBorder(null);
    CardSwitcher2.setFocusPainted(false);
    CardSwitcher2.setForeground(color.decode("#ffffff"));
    CardSwitcher2.addActionListener(this);
    */
    
    PnlCardSave = new JPanel();
    PnlCardSave.setBackground(color.decode("#1e1e1e"));
    PnlCardCnvrt = new JPanel();
    PnlCardCnvrt.setBackground(color.decode("#1e1e1e"));
    
    
    //Card layout second thingy here
    
    
    PnlBottomHolderR2 = new JPanel();
    PnlBottomHolderR2.setBackground(color.decode("#1e1e1e"));
    PnlBottomHolderR2.setLayout(BLBHR2);
    
    LineBorder lnbrdr3 = new LineBorder(color.decode("#14464c"),1,true);
    TitledBorder tborder3 = new TitledBorder(lnbrdr2,"Convert values from Database",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,BorderTitleFont,color.decode("#8c8080"));
    PnlBottomHolderR2.setBorder(tborder3);
    
    
    PnlRBRGrid2 = new JPanel();
    PnlRBRGrid2.setLayout(grid22);
    PnlRBRGrid2.setBackground(color.decode("#1e1e1e"));
    
     //22222 gridresolver here
  JLabel  DBnameC2 = new JLabel("Database Name:");
    DBnameC2.setFont(LabelFont);
    DBnameC2.setForeground(color.decode("#999999"));
    
    DBAcceptorC2 = new JTextField(8);
    DBAcceptorC2.setFont(TextBoxFont);
    DBAcceptorC2.setBorder(null);
    DBAcceptorC2.setMargin(new Insets(0,0,0,0));
    
    PnlBHRGridResolverC = new JPanel();
    PnlBHRGridResolverC.setLayout(BLRGridResolverC);
    PnlBHRGridResolverC.setBackground(color.decode("#1e1e1e"));
    PnlBHRGridResolverC.setBorder(new EmptyBorder(8,12,0,0));
    
    PnlBHRGridResolverC.add(DBnameC2,BLRGridResolverC.NORTH);
    PnlBHRGridResolverC.add(DBAcceptorC2,BLRGridResolverC.SOUTH);
    
    PnlRBRGrid2.add(PnlBHRGridResolverC);
    //22222 gridresolver here
    
     //22222222 gridresolver here
    TblnameC2 = new JLabel("Table Name:");
    TblnameC2.setFont(LabelFont);
    TblnameC2.setForeground(color.decode("#999999"));
    
    TblAcceptorC2 = new JTextField(8);
    TblAcceptorC2.setFont(TextBoxFont);
    TblAcceptorC2.setBorder(null);
    TblAcceptorC2.setMargin(new Insets(0,0,0,0));
    
    PnlBHRGridResolverC2 = new JPanel();
    PnlBHRGridResolverC2.setLayout(BLRGridResolverC2);
    PnlBHRGridResolverC2.setBackground(color.decode("#1e1e1e"));
    PnlBHRGridResolverC2.setBorder(new EmptyBorder(8,32,0,0));
    
    PnlBHRGridResolverC2.add(TblnameC2,BLRGridResolverC2.NORTH);
    PnlBHRGridResolverC2.add(TblAcceptorC2,BLRGridResolverC2.SOUTH);
    
    PnlRBRGrid2.add(PnlBHRGridResolverC2);
    //2222222 gridresolver here
    
    
    
     // gridresolver here
    ClmnnameC3 = new JLabel("Column Name:");
    ClmnnameC3.setFont(LabelFont);
    ClmnnameC3.setForeground(color.decode("#999999"));
    
    
    ClmnAcceptorC3 = new JTextField(8);
    ClmnAcceptorC3.setFont(TextBoxFont);
    ClmnAcceptorC3.setBorder(null);
    ClmnAcceptorC3.setMargin(new Insets(0,0,0,0));
    
    PnlBHRGridResolverC3 = new JPanel();
    PnlBHRGridResolverC3.setLayout(BLRGridResolverC3);
    PnlBHRGridResolverC3.setBackground(color.decode("#1e1e1e"));
    PnlBHRGridResolverC3.setBorder(new EmptyBorder(4,12,10,0));
    
    
    PnlBHRGridResolverC3.add(ClmnnameC3,BLRGridResolverC3.NORTH);
    PnlBHRGridResolverC3.add(ClmnAcceptorC3,BLRGridResolverC3.SOUTH);
    
    PnlRBRGrid2.add(PnlBHRGridResolverC3);
    // gridresolver here
    
     // gridresolver here
     
    CnvrtButtonDB = new JButton("CONVERT");
    CnvrtButtonDB.setPreferredSize(new Dimension(93,30));
    CnvrtButtonDB.setBackground(color.decode("#00838f"));
    CnvrtButtonDB.setForeground(color.decode("#ffffff"));
    CnvrtButtonDB.setFocusPainted(false);
    CnvrtButtonDB.addActionListener(this);
    
    JPanel CnvrtButtonDBHolder = new JPanel();
    CnvrtButtonDBHolder.add(CnvrtButtonDB);
    
    CnvrtButtonDBHolder.setBackground(color.decode("#1e1e1e"));
    
    Font LabelFontSmall = new Font("SansSerif",Font.PLAIN,10);
    
    JLabel lblStorer = new JLabel("Stores results");
    lblStorer.setFont(LabelFontSmall);
    lblStorer.setForeground(color.decode("#999999"));
    
    JLabel lblStorer2 = new JLabel("in same table");
    lblStorer2.setFont(LabelFontSmall);
    lblStorer2.setForeground(color.decode("#999999"));
    
    JPanel PnlLabelsHolder = new JPanel();
    PnlLabelsHolder.setLayout(new GridLayout(4,1));
    PnlLabelsHolder.setBackground(color.decode("#1e1e1e"));
    
    PnlLabelsHolder.add(lblStorer);
    PnlLabelsHolder.add(lblStorer2);
    
    
    JPanel PnlDBCnvrtHolder = new JPanel();
    PnlDBCnvrtHolder.setLayout(BLDBCnvrtHolderC2);
    PnlDBCnvrtHolder.setBorder(null);
    
    PnlDBCnvrtHolder.add(CnvrtButtonDBHolder,BLDBCnvrtHolderC2.CENTER);
    PnlDBCnvrtHolder.add(PnlLabelsHolder,BLDBCnvrtHolderC2.EAST);
    
    PnlRBRGrid2.add(PnlDBCnvrtHolder);
    // gridresolver here
    
    
    JPanel PnlCSBtnHolderC2 = new JPanel();
    PnlCSBtnHolderC2.setLayout(BLCSBtnholderC2);
    PnlCSBtnHolderC2.setBackground(color.decode("#1e1e1e"));
    
    CardSwitcherC2.setPreferredSize(new Dimension(20,20));
    CardSwitcherC2.setBackground(color.decode("#1e1e1e"));
    CardSwitcherC2.setBorder(null);
    CardSwitcherC2.setFocusPainted(false);
    CardSwitcherC2.setForeground(color.decode("#ffffff"));
    CardSwitcherC2.addActionListener(this);
    
    PnlCSBtnHolderC2.add(CardSwitcherC2,BLCSBtnholderC2.NORTH);
    
    PnlBottomHolderR2.add(PnlRBRGrid2,BLBHR2.CENTER);
    PnlBottomHolderR2.add(PnlCSBtnHolderC2,BLBHR2.EAST);
     
    
    /*TODO:
    1. SaveCard ready and added to save card panel
    2. Implement the card layout and test with taking convert card as test panel
    3. On success build the convert card and add to the convert card and implement card layout.
    4. goto the west of the jfarme
    */
    
    
   // PnlCardSave.add(PnlBottomHolderR);
  //  PnlCardCnvrt.add(CardSwitcher2);
  
    PnlRightBottom.add(PnlCardHolder);
    
    
    PnlCardHolder.add(PnlBottomHolderR,"SaveCard");
    PnlCardHolder.add(PnlBottomHolderR2,"ConvertCard");
    
    
    PnlBottomHolder.add(PnlBottomHolderL,BLBottomHolder.WEST);
    PnlBottomHolder.add(PnlRightBottom,BLBottomHolder.CENTER);
    
    PnlComponentsHolder.add(PnlComponentsGrid, BLComponentsHolder.CENTER);
    PnlComponentsHolder.add(PnlBottomHolder, BLComponentsHolder.SOUTH); 
    
    //THE THINGS ON THE LEFT SIDE HERE
    
    PnlLeftBig = new JPanel();
    PnlLeftBig.setLayout(BLLeftBig);
    
    PnlSubLeftBig = new JPanel();
    PnlSubLeftBig.setLayout(BLSubLeft);
    
    PnlSubLeftBig1 = new JPanel();
    PnlSubLeftBig1.setLayout(BLSubLeft1);
   
    PnlSubLeftBig2 = new JPanel();
    PnlSubLeftBig2.setLayout(BLSubLeft2);
    
    PnlSubLeftBig3 = new JPanel();
    PnlSubLeftBig3.setLayout(BLSubLeft3);
    
    ImageIcon imgtest = new ImageIcon("putter6.png");
    
    
    JLabel NSHeader = new JLabel(imgtest);
    NSHeader.setFont(HeadersFont);
    NSHeader.setForeground(color.decode("#333333"));
    JLabel NSExplainer = new JLabel();
    NSExplainer.setFont(LabelFontSmall);
    NSExplainer.setForeground(color.decode("#ffffff"));
   /* 
    JLabel RMNHeader = new JLabel();
    RMNHeader.setFont(HeadersFont);
    RMNHeader.setForeground(color.decode("#333333"));
    JLabel RMNExplainer = new JLabel("Convert");
    RMNExplainer.setFont(LabelFontSmall);
    RMNExplainer.setForeground(color.decode("#ffffff"));
    
    JLabel URLHeader = new JLabel("Play with URLs");
    URLHeader.setFont(HeadersFont);
    URLHeader.setForeground(color.decode("#333333"));
    JLabel URLExplainer = new JLabel("ENCODE");
    URLExplainer.setFont(LabelFontSmall);
    URLExplainer.setForeground(color.decode("#ffffff"));
    
    PnlSubLeftBig3.add(URLHeader,BLSubLeft3.NORTH);
    PnlSubLeftBig3.add(URLExplainer,BLSubLeft3.SOUTH);
    
    PnlSubLeftBig2.add(RMNHeader,BLSubLeft2.NORTH);
    PnlSubLeftBig2.add(RMNExplainer,BLSubLeft2.SOUTH);
    */
    PnlSubLeftBig1.add(NSHeader,BLSubLeft1.NORTH);
    PnlSubLeftBig1.add(NSExplainer,BLSubLeft1.SOUTH);
    
    
    PnlSubLeftBig.add(PnlSubLeftBig1,BLSubLeft.NORTH);
    PnlSubLeftBig.add(PnlSubLeftBig2,BLSubLeft.CENTER);
    PnlSubLeftBig.add(PnlSubLeftBig3,BLSubLeft.SOUTH);
    /*
    PnlSubLeftDown = new JPanel();
    PnlSubLeftDown.setLayout(grid21);
    
    JLabel lblRightsReserved = new JLabel("All rights reserved.");
    lblRightsReserved.setFont(UtterSmallFont);
    lblRightsReserved.setForeground(color.decode("#333333"));
    
    JLabel lblDeveloperCredit = new JLabel("Developed by");
    lblDeveloperCredit.setFont(UtterSmallFont);
    lblDeveloperCredit.setForeground(color.decode("#333333"));
    
    JLabel lblDeveloperCredit2 = new JLabel("Jskrnbindra");
    lblDeveloperCredit2.setFont(UtterSmallFont);
    lblDeveloperCredit2.setForeground(color.decode("#ffffff"));
    
    JPanel Devjoiner = new JPanel();
    Devjoiner.setLayout(new GridLayout(1,2));
    
    Devjoiner.add(lblDeveloperCredit);
    Devjoiner.add(lblDeveloperCredit2);
    
    PnlSubLeftDown.add(lblRightsReserved);
    PnlSubLeftDown.add(Devjoiner);
    */
    PnlLeftBig.add(PnlSubLeftBig,BLLeftBig.NORTH);
    PnlLeftBig.setBackground(color.decode("#1e1e1e"));
    //PnlLeftBig.add(PnlSubLeftDown,BLLeftBig.SOUTH);
    
    ////////////////////////////////////
    /*
    TODO:
    1. Correct too long labels in the leftpanel
    2. Add copyright Symbol
    3. Set color scheme
    4. connect backend
    */
    PnlMainBody.add(PnlLeftBig,borderMainBody.WEST);
    PnlMainBody.add(PnlComponentsHolder,borderMainBody.CENTER);
    
    
    
    Frame.add(PnlTopPanel,border.NORTH);
    Frame.add(PnlMainBody,border.CENTER);
    Frame.setVisible(true);
        
    } 
    
    public void actionPerformed(ActionEvent performedEvent)
    {  
      //These events change the CardSwitcher
      //DO NOT EDIT
       if(performedEvent.getSource()==CardSwitcher)
       cardlayout.show(PnlCardHolder,"ConvertCard"); 
       
       if(performedEvent.getSource()==CardSwitcherC2)
       cardlayout.show(PnlCardHolder,"SaveCard"); 
        //DO NOT EDIT
        
        //These events close and minimise the application
        //DO NOT EDIT
       if(performedEvent.getSource()==CloseButton)
       {
           if(AskOnExit){
           String []options={"yes, exit","Oh No!"};
          int ExitConfirmation = JOptionPane.showOptionDialog(Frame,"The application will exit, are you sure you want to proceed?","Application Close Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
       if(ExitConfirmation == JOptionPane.YES_OPTION)
         System.exit(0);}
         else
         System.exit(0);
       }
       
       if(performedEvent.getSource()==MinimizeButton)
       Frame.setState(Frame.ICONIFIED);
        //DO NOT EDIT
//Number System CONVERT button 

       if(performedEvent.getSource()==BtnNSCnvrt)  
       {
         //INPUT VALIDATION PENDING...check for numbers of system other than specified in the JCBs
         //empty check +
        if(!NSLeft.getText().isEmpty()&&!NSRight.getText().isEmpty())
            JOptionPane.showMessageDialog(Frame, "One of the textboxes needs to be empty to store the result in.", "Error", JOptionPane.ERROR_MESSAGE);

         if(NSLeft.getText().isEmpty()&&NSRight.getText().isEmpty())
             JOptionPane.showMessageDialog(Frame, "Both textboxes can not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
     
        if((NSLeft.getText().isEmpty()&&!NSRight.getText().isEmpty())||(!NSLeft.getText().isEmpty()&&NSRight.getText().isEmpty()))
        {  //same jcb check    
          if(jcbNSLeft.getSelectedIndex()==jcbNSRight.getSelectedIndex()) 
             JOptionPane.showMessageDialog(Frame, "Same Number Systems selected on both sides.", "Error", JOptionPane.ERROR_MESSAGE);
         
          else{    
         int leftSelection=-1,rightSelection=-1;
         //from thingy
        switch(jcbNSLeft.getSelectedIndex())
        {
          case 0:
          leftSelection=0;
          break;
          case 1:
          leftSelection=1;
          break;
          case 2:
          leftSelection=2;
          break;
          case 3:
          leftSelection=3;
          break;
        }
          switch(jcbNSRight.getSelectedIndex())
        {
          case 0:
          rightSelection=0;
          break;
          case 1:
          rightSelection=1;
          break;
          case 2:
          rightSelection=2;
          break;
          case 3:
          rightSelection=3;
          break;
        }
        if(!NSLeft.getText().isEmpty())
        {
            //convert left to right
            
            //Binary to all 
            if(leftSelection==0 && rightSelection==1){
            NSRight.setText(CnvrtBinaryToOctal(NSLeft.getText()));
            LastNS=NSRight.getText();
            }
            if(leftSelection==0 && rightSelection==2){
            NSRight.setText(String.valueOf(CnvrtBinaryToDecimal(NSLeft.getText())));
            LastNS=NSRight.getText();
            }
            if(leftSelection==0 && rightSelection==3){
            NSRight.setText(CnvrtBinaryToHex(NSLeft.getText()));
            LastNS=NSRight.getText();
            }
            
            //Octal to all
            if(leftSelection==1 && rightSelection==0){
            NSRight.setText(CnvrtOctalToBinary(NSLeft.getText()).substring(0,CnvrtOctalToBinary(NSLeft.getText()).length()-1));
            LastNS=NSRight.getText();
            }
            
            if(leftSelection==1 && rightSelection==2){
            NSRight.setText(String.valueOf(CnvrtOctalToDecimal(NSLeft.getText())));
            LastNS=NSRight.getText();
            }
            
            if(leftSelection==1 && rightSelection==3){
            NSRight.setText(CnvrtOctalToHex(NSLeft.getText()));
            LastNS=NSRight.getText();
            }
            
            //Decimal to all
            if(leftSelection==2 && rightSelection==0){
            NSRight.setText(CnvrtDecimalToBinary(Long.parseLong(NSLeft.getText())).substring(0,CnvrtDecimalToBinary(Long.parseLong(NSLeft.getText())).length()-1));
            LastNS=NSRight.getText();
            }
            
            if(leftSelection==2 && rightSelection==1){
            NSRight.setText(CnvrtDecimalToOctal(Long.parseLong(NSLeft.getText())));
            LastNS=NSRight.getText();
            }
            
            if(leftSelection==2 && rightSelection==3){
            NSRight.setText(CnvrtDecimalToHex(Long.parseLong(NSLeft.getText())));
            LastNS=NSRight.getText();
            }
            
            //Hexadecimal to all
            if(leftSelection==3 && rightSelection==0){
            NSRight.setText(CnvrtHexToBinary(NSLeft.getText()).substring(0,CnvrtHexToBinary(NSLeft.getText()).length()-1));
            LastNS=NSRight.getText();
            }
            
            if(leftSelection==3 && rightSelection==1){
            NSRight.setText(CnvrtHexToOctal(NSLeft.getText()));
            LastNS=NSRight.getText();
            }
            
            if(leftSelection==3 && rightSelection==2){
            NSRight.setText(String.valueOf(CnvrtHexToDecimal(NSLeft.getText())));
            LastNS=NSRight.getText();
            }
            
        }
        
         if(!NSRight.getText().isEmpty())
        {
            //convert right to left
            
            //Binary to all 
            if(rightSelection==0 && leftSelection==1){
            NSLeft.setText(CnvrtBinaryToOctal(NSRight.getText()));
            LastNS=NSLeft.getText();
            }
            
            if(rightSelection==0 && leftSelection==2){
            NSLeft.setText(String.valueOf(CnvrtBinaryToDecimal(NSRight.getText())));
            LastNS=NSLeft.getText();
            }
            
            
            if(rightSelection==0 && leftSelection==3){
            NSLeft.setText(CnvrtBinaryToHex(NSRight.getText()));
            LastNS=NSLeft.getText();
            }
            
            
            //Octal to all
            if(rightSelection==1 && leftSelection==0){
            NSLeft.setText(CnvrtOctalToBinary(NSRight.getText()).substring(0,CnvrtOctalToBinary(NSRight.getText()).length()-1));
            LastNS=NSLeft.getText();
            }
            
            
            if(rightSelection==1 && leftSelection==2){
            NSLeft.setText(String.valueOf(CnvrtOctalToDecimal(NSRight.getText())));
            LastNS=NSLeft.getText();
            }
            
            
            if(rightSelection==1 && leftSelection==3){
            NSLeft.setText(CnvrtOctalToHex(NSRight.getText()));
            LastNS=NSLeft.getText();
            }
            
            
            //Decimal to all
            if(rightSelection==2 && leftSelection==0){
            NSLeft.setText(CnvrtDecimalToBinary(Long.parseLong(NSRight.getText())).substring(0,CnvrtDecimalToBinary(Long.parseLong(NSRight.getText())).length()-1));
            LastNS=NSLeft.getText();
            }
            
            
            if(rightSelection==2 && leftSelection==1){
            NSLeft.setText(CnvrtDecimalToOctal(Long.parseLong(NSRight.getText())));
            LastNS=NSLeft.getText();
            }
            
            
            if(rightSelection==2 && leftSelection==3){
            NSLeft.setText(CnvrtDecimalToHex(Long.parseLong(NSRight.getText())));
            LastNS=NSLeft.getText();
            }
            
            
            //Hexadecimal to all
            if(rightSelection==3 && leftSelection==0){
            NSLeft.setText(CnvrtHexToBinary(NSRight.getText()).substring(0,CnvrtHexToBinary(NSRight.getText()).length()-1));
            LastNS=NSLeft.getText();
            }
            
            
            if(rightSelection==3 && leftSelection==1){
            NSLeft.setText(CnvrtHexToOctal(NSRight.getText()));
            LastNS=NSLeft.getText();
            }
            
            
            if(rightSelection==3 && leftSelection==2){
            NSLeft.setText(String.valueOf(CnvrtHexToDecimal(NSRight.getText())));
            LastNS=NSLeft.getText();
            }
            
            
        }
        System.out.println(leftSelection +"-->"+rightSelection);
        
       }     
       
        }
        //empty check -
       }
        
       
       //For ROMAN to INT Converter
      if(performedEvent.getSource()==BtnRMNCnvrt)
      {
        //empty check +
        if(!RMNLeft.getText().isEmpty()&&!RMNRight.getText().isEmpty())
            JOptionPane.showMessageDialog(Frame, "One of the textboxes needs to be empty to store the result in.", "Error", JOptionPane.ERROR_MESSAGE);
        
         if(RMNLeft.getText().isEmpty()&&RMNRight.getText().isEmpty())
             JOptionPane.showMessageDialog(Frame, "Both textboxes can not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        
        //empty check -
        
        if((RMNLeft.getText().isEmpty()&&!RMNRight.getText().isEmpty())||(!RMNLeft.getText().isEmpty()&&RMNRight.getText().isEmpty()))
        {
            //either has text and other is empty
             
              boolean isRoman=false;
              boolean isNumber=false;
              boolean isInvalid=false;
              boolean isNotRoman=false;
              boolean isNotNumber=false;
              char tempchar;
              String t="";
              
           if(!RMNRight.getText().isEmpty())
            {
              t=RMNRight.getText().toUpperCase();
              
              if(!t.contains("I")&&!t.contains("V")&&!t.contains("X")&&!t.contains("L")&&!t.contains("C")&&!t.contains("D")&&!t.contains("M")&&!t.contains("0")&&!t.contains("1")&&!t.contains("2")&&!t.contains("3")&&!t.contains("4")&&!t.contains("5")&&!t.contains("6")&&!t.contains("7")&&!t.contains("8")&&!t.contains("9"))
              {     
             JOptionPane.showMessageDialog(Frame, "The value entered by you seems to be invalid!", "Error - Invalid input", JOptionPane.ERROR_MESSAGE);
              
              isInvalid=true;
              }
              else
              {
                 for(int c = 0;c<t.length();c++)
                 {
                     tempchar = t.charAt(c);
                  if(tempchar!='I'&&tempchar!='V'&&tempchar!='X'&&tempchar!='L'&&tempchar!='C'&&tempchar!='D'&&tempchar!='M'&&tempchar!='0'&&tempchar!='1'&&tempchar!='2'&&tempchar!='3'&&tempchar!='4'&&tempchar!='5'&&tempchar!='6'&&tempchar!='7'&&tempchar!='8'&&tempchar!='9')
                    {
             JOptionPane.showMessageDialog(Frame, "The value entered by you seems to be invalid!", "Error - Invalid input", JOptionPane.ERROR_MESSAGE);
              
                      isInvalid=true;  break;
                        }
                        else if(tempchar=='I'||tempchar=='V'||tempchar=='X'||tempchar=='L'||tempchar=='C'||tempchar=='D'||tempchar=='M')
                        {
                            //both valid after number there is a roman
                            //this part is pending
                            
                        }
                  }
                  
              }
              if(!isInvalid){
                  //is not invalid input
              if(t.contains("I")||t.contains("V")||t.contains("X")||t.contains("L")||t.contains("C")||t.contains("D")||t.contains("M"))
              {
              for(int c = 0;c<t.length();c++)
              {
                  tempchar = t.charAt(c);
                  if(tempchar=='I'||tempchar=='V'||tempchar=='X'||tempchar=='L'||tempchar=='C'||tempchar=='D'||tempchar=='M')
                  isRoman=true;
                  else
                  {isRoman=false;break;}
              }   
              if(isRoman){
              //Right to left conversion       
             RMNLeft.setText(String.valueOf(CnvrtRomanToInteger(RMNRight.getText())));
             LastRMN = RMNLeft.getText();
            //  System.out.println("RighT IS ROMAN convert to NUmber");
              
              }   
              }
              else{
                  //else may be number
             
              if(t.contains("0")||t.contains("1")||t.contains("2")||t.contains("3")||t.contains("4")||t.contains("5")||t.contains("6")||t.contains("7")||t.contains("8")||t.contains("9"))
              {
                  for(int c = 0;c<t.length();c++)
              {
                  tempchar = t.charAt(c);
                  if(tempchar=='1'||tempchar=='2'||tempchar=='3'||tempchar=='4'||tempchar=='5'||tempchar=='6'||tempchar=='7'||tempchar=='8'||tempchar=='9'||tempchar=='0')
                  isNumber=true;
                  else
                  {isNumber=false;break;}
              }   
              if(isNumber)   
              if(Integer.parseInt(t)<4000)
              {
                     //Right to left conversion       
             RMNLeft.setText(CnvrtIntegerToRoman(Integer.parseInt(RMNRight.getText())));
             LastRMN = RMNLeft.getText();
              
              //System.out.println("RighT IS Number convert to Roman");
              }
              else
              System.out.println("Roman numbers exist only upto 3999. Enter a number between 0 and 3999.");   
              }
              
              }//else maybe number ends
               //check if roman
              } 
            //  else
             // System.out.println("Matlab kuch bhi enter karoge?Enter a valid input.");
              //is not invalid ends
            }//roman right filled
             
             //if left roman has text
            if(!RMNLeft.getText().isEmpty())
             {
              t=RMNLeft.getText().toUpperCase();
              
              if(!t.contains("I")&&!t.contains("V")&&!t.contains("X")&&!t.contains("L")&&!t.contains("C")&&!t.contains("D")&&!t.contains("M")&&!t.contains("0")&&!t.contains("1")&&!t.contains("2")&&!t.contains("3")&&!t.contains("4")&&!t.contains("5")&&!t.contains("6")&&!t.contains("7")&&!t.contains("8")&&!t.contains("9"))
              {     
             JOptionPane.showMessageDialog(Frame, "The value entered by you seems to be invalid!", "Error - Invalid input", JOptionPane.ERROR_MESSAGE);
              
              isInvalid=true;
              }
              else
              {
                 for(int c = 0;c<t.length();c++)
                 {
                     tempchar = t.charAt(c);
                  if(tempchar!='I'&&tempchar!='V'&&tempchar!='X'&&tempchar!='L'&&tempchar!='C'&&tempchar!='D'&&tempchar!='M'&&tempchar!='0'&&tempchar!='1'&&tempchar!='2'&&tempchar!='3'&&tempchar!='4'&&tempchar!='5'&&tempchar!='6'&&tempchar!='7'&&tempchar!='8'&&tempchar!='9')
                    {
             JOptionPane.showMessageDialog(Frame, "The value entered by you seems to be invalid!", "Error - Invalid input", JOptionPane.ERROR_MESSAGE);
              
                      isInvalid=true;  break;
                        }
                        else if(tempchar=='I'||tempchar=='V'||tempchar=='X'||tempchar=='L'||tempchar=='C'||tempchar=='D'||tempchar=='M')
                        {
                            //both valid after number there is a roman
                            //this part is pending
                            
                        }
                  }
                  
              }
              if(!isInvalid){
                  //is not invalid input
              if(t.contains("I")||t.contains("V")||t.contains("X")||t.contains("L")||t.contains("C")||t.contains("D")||t.contains("M"))
              {
              for(int c = 0;c<t.length();c++)
              {
                  tempchar = t.charAt(c);
                  if(tempchar=='I'||tempchar=='V'||tempchar=='X'||tempchar=='L'||tempchar=='C'||tempchar=='D'||tempchar=='M')
                  isRoman=true;
                  else
                  {isRoman=false;break;}
              }   
              if(isRoman)      {
                  RMNRight.setText(String.valueOf(CnvrtRomanToInteger(RMNLeft.getText())));
             LastRMN = RMNRight.getText();
                  
             // System.out.println("Left IS ROMAN convert to NUmber");
                  
              }
              }
              else{
                  //else may be number
             
              if(t.contains("0")||t.contains("1")||t.contains("2")||t.contains("3")||t.contains("4")||t.contains("5")||t.contains("6")||t.contains("7")||t.contains("8")||t.contains("9"))
              {
                  for(int c = 0;c<t.length();c++)
              {
                  tempchar = t.charAt(c);
                  if(tempchar=='1'||tempchar=='2'||tempchar=='3'||tempchar=='4'||tempchar=='5'||tempchar=='6'||tempchar=='7'||tempchar=='8'||tempchar=='9'||tempchar=='0')
                  isNumber=true;
                  else
                  {isNumber=false;break;}
              }   
              if(isNumber)   
              if(Integer.parseInt(t)<4000){
                  
                  RMNRight.setText(CnvrtIntegerToRoman(Integer.parseInt(RMNLeft.getText())));
                  LastRMN = RMNRight.getText();
                  
            //  System.out.println("Left IS Number convert to Roman");
                  
              }
              
              else
              System.out.println("Roman numbers exist only upto 3999. Enter a number between 0 and 3999.");   
              }
              
              }//else maybe number ends
               //check if roman
              } 
            //  else
             // System.out.println("Matlab kuch bhi enter karoge?Enter a valid input.");
              //is not invalid ends
            }//roman Left filled
                  
           }//either textbox filled
                  
            
        }//ROMAN ends
        
      
       
       //For playing with URLs
      if(performedEvent.getSource()==BtnURLCnvrt)
      {
        //empty check +
        if(!URLLeft.getText().isEmpty()&&!URLRight.getText().isEmpty())
                    JOptionPane.showMessageDialog(Frame, "One of the textboxes needs to be empty to store the result in.", "Error", JOptionPane.ERROR_MESSAGE);
         if(URLLeft.getText().isEmpty()&&URLRight.getText().isEmpty())
             JOptionPane.showMessageDialog(Frame, "Both textboxes can not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
       
        if((URLLeft.getText().isEmpty()&&!URLRight.getText().isEmpty())||(!URLLeft.getText().isEmpty()&&URLRight.getText().isEmpty()))
        {
            //Encoded/decoded URL check
        if(!URLLeft.getText().isEmpty()){
            
        if(URLLeft.getText().contains(" "))
        {
         URLRight.setText(EncodeURL(URLLeft.getText()));
         LastURL= URLRight.getText();
         // System.out.println("left to be encoded");
        }
        
        else if(!URLLeft.getText().contains(" ")){
        URLRight.setText(DecodeURL(URLLeft.getText()));
         LastURL= URLRight.getText();
          //System.out.println("Already encoded");
            
        }
          }
            else {
        if(URLRight.getText().contains(" ")){
        URLLeft.setText(EncodeURL(URLRight.getText()));
        LastURL=URLLeft.getText();    
        //System.out.println("Right to be encoded");
        }
        else if(!URLRight.getText().contains(" ")){
        URLLeft.setText(DecodeURL(URLRight.getText()));
        LastURL=URLLeft.getText();    
        System.out.println("Already encoded");
        }
        
            }
        }
        //empty check -
        
      }
        
    if(performedEvent.getSource()==SaveButton){
        
        if(!FilePathAcceptor.getText().isEmpty()){
            
            if(!AllowNewFile)//if radio button not checked, do not create new file
            {
               System.out.println(AllowNewFile);
               FilePathAcceptor.setText("J:\\java bitch\\My Swings\\Finaliser\\"+FilePathAcceptor.getText());
               AllowNewFile=false; 
                  try{
pw = new PrintWriter(new FileOutputStream(FilePathAcceptor.getText(),true));

pw.println(NSLeft.getText());
pw.println(NSRight.getText());
pw.println(RMNLeft.getText());
pw.println(RMNRight.getText());
pw.println(URLLeft.getText());
pw.println(URLRight.getText());
   JOptionPane.showMessageDialog(Frame, "Results saved successfully at "+FilePathAcceptor.getText(), "Results Saved!", JOptionPane.INFORMATION_MESSAGE);

}
catch(FileNotFoundException e)
{
    try{
   PrintWriter RR = new PrintWriter(new FileOutputStream(ErrorLogger,true));

RR.println(e);}
catch(Exception fe){}

   JOptionPane.showMessageDialog(Frame, "No file found with the given path. Please provide a valid filepath or select the create new file option.", "Error", JOptionPane.ERROR_MESSAGE);
    
}

finally
{
    
pw.close();
AllowNewFile=false; 

        }
            }
            else{
                //if radio checked ,create new file
               System.out.println(AllowNewFile);
                
        try{
pw = new PrintWriter(new FileOutputStream(FilePathAcceptor.getText(),true));

pw.println(NSLeft.getText());
pw.println(NSRight.getText());
pw.println(RMNLeft.getText());
pw.println(RMNRight.getText());
pw.println(URLLeft.getText());
pw.println(URLRight.getText());
   JOptionPane.showMessageDialog(Frame, "Results saved successfully at "+FilePathAcceptor.getText(), "Results Saved!", JOptionPane.INFORMATION_MESSAGE);

}
catch(FileNotFoundException e)
{
   //PrintWriter RR = new PrintWriter(new FileOutputStream(ErrorLogger,true));

//RR.println(e);

   JOptionPane.showMessageDialog(Frame, "Oops! Something went wrong, the error has been logged and will be fixed soon.", "Error", JOptionPane.ERROR_MESSAGE);
    
}

finally
{
    
pw.close();
AllowNewFile=false; 

        }
            }
        }
        else{
    
   JOptionPane.showMessageDialog(Frame, "You need to enter the path of the file to save result in.", "Error", JOptionPane.ERROR_MESSAGE);
    
        }
       
    }
        if(performedEvent.getSource()==SaveButtonDB)
        {
            if(DBUNAME.isEmpty()||DBPASS.isEmpty())
            JOptionPane.showMessageDialog(Frame,"Looks like database configuration is missing. Go to Settings tab to configure your database to be used with this application.","Database Configuration Error!",JOptionPane.ERROR_MESSAGE);
//            System.out.println("Database not configured");
            else{
            
            if(!AllowNewDB)//if radio button not checked, do not create new DB
            {
                  DBAcceptorC2.setEnabled(true);
                TblAcceptorC2.setEnabled(true);
                ClmnAcceptorC3.setEnabled(true);
               System.out.println(AllowNewDB);
                   if(DBAcceptor.getText().isEmpty()||TblAcceptor.getText().isEmpty()||ClmnAcceptor.getText().isEmpty())
   JOptionPane.showMessageDialog(Frame, "Inadequate information provided.", "Error", JOptionPane.ERROR_MESSAGE);
    
           else{
               //all three fields filled
              try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBAcceptor.getText(),DBUNAME,DBPASS);
               Statement cmd = con.createStatement();
               cmd.executeUpdate("insert into "+TblAcceptor.getText()+" ("+ClmnAcceptor.getText()+") values('"+LastNS+","+LastRMN+","+LastURL+"')");
               con.close();    
              }
              catch(Exception e){}
           }
               AllowNewDB=false; 
            }
            else if(AllowNewDB){
                //if radio checked ,create new DB
                DBAcceptor.setEnabled(false);
                TblAcceptor.setEnabled(false);
                ClmnAcceptor.setEnabled(false);
                 try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook",DBUNAME,DBPASS);
               Statement cmd = con.createStatement();
               
               //cmd.executeUpdate("create database "+DEFAULTDBNAME);
               //cmd.executeUpdate("use " + DEFAULTDBNAME);
               cmd.executeUpdate("create table "+DEFAULTTBLNAME+"(Serial int,Output varchar(500))");
               cmd.executeUpdate("insert into "+DEFAULTTBLNAME+" (Output) values('"+LastNS+","+LastRMN+","+LastURL+"')");
               con.close();    
              }
              catch(Exception e){System.out.println(e);}
              
             
                }
        }
        }
        if(performedEvent.getSource()==CnvrtButtonDB)
        {
            if(DBUNAME.isEmpty()||DBPASS.isEmpty())
             JOptionPane.showMessageDialog(Frame,"Looks like database configuration is missing. Go to Settings tab to configure your database to be used with this application.","Database Configuration Error!",JOptionPane.ERROR_MESSAGE);
            //System.out.println("Database not configured");
            else
            {
                     try{
               Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBAcceptorC2.getText(),DBUNAME,DBPASS);
               Statement SelectCmd = con.createStatement();
               
             ResultSet queryResult =  SelectCmd.executeQuery("select " + ClmnAcceptorC3.getText()+" from "+TblAcceptorC2.getText());
               Statement UpdateCmd = con.createStatement();
             
             while(queryResult.next())
             {
                  String ValueFromDB = queryResult.getString("Output");
                  System.out.println(queryResult.getString("Output"));
                  System.out.println(ValueFromDB);
                  System.out.println(CnvrtBinaryToDecimal(ValueFromDB));
                  UpdateCmd.executeUpdate("update "+TblAcceptorC2.getText()+" set Output='"+String.valueOf(CnvrtBinaryToDecimal(ValueFromDB))+"' where Output='"+queryResult.getString("Output")+"'");
                  
             }
             JOptionPane.showMessageDialog(Frame,"Conversion complete. Resets stored in the same location.","Conversion Succeeded!",JOptionPane.INFORMATION_MESSAGE);
              }
              catch(Exception e){System.out.println(e);}
                
        }
        }
        if(performedEvent.getSource()==ResetButton){
            NSLeft.setText(null);
            NSRight.setText(null);
            RMNLeft.setText(null);
            RMNRight.setText(null);
            NSRight.setText(null);
            URLLeft.setText(null);
            URLRight.setText(null);
            FilePathAcceptor.setText(null);
            DBAcceptor.setText(null);
            TblAcceptor.setText(null);
            ClmnAcceptor.setText(null);
            DBAcceptorC2.setText(null);
            TblAcceptorC2.setText(null);
            ClmnAcceptorC3.setText(null);
        }
        if(performedEvent.getSource()==SettingsButton)
        {
          JTextField DBUNAMEacceptor = new JTextField(14);
          DBUNAMEacceptor.setFont(SettingsTextBoxFont);
          DBUNAMEacceptor.setBorder(null);
          DBUNAMEacceptor.setMargin(new Insets(0,0,0,0));
          
          
          JPasswordField DBPASSacceptor = new JPasswordField(14);
          DBPASSacceptor.setEchoChar('*');
          DBPASSacceptor.setFont(SettingsTextBoxFont);
          DBPASSacceptor.setBorder(null);
          DBPASSacceptor.setMargin(new Insets(0,0,0,0));
          
          ExitAsk = new JRadioButton("Ask confirmation on exit everytime.",true);
          ExitAsk.addItemListener(this);

          JTextField DEFAULTTBLNAMEacceptor = new JTextField(14);
          DEFAULTTBLNAMEacceptor.setFont(SettingsTextBoxFont);
          DEFAULTTBLNAMEacceptor.setBorder(null);
          DEFAULTTBLNAMEacceptor.setMargin(new Insets(0,0,0,0));
          
         

Object[] message = {
    "Database Username", DBUNAMEacceptor,
    "Database Password", DBPASSacceptor,
    "Default new table name", DEFAULTTBLNAMEacceptor,
    "", ExitAsk,
};
//String buttontexttest[]={"Save Configuration","Cancel"};
int option = JOptionPane.showConfirmDialog(Frame, message, "Settings - Application Configuration", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION)
{
    DBUNAME = DBUNAMEacceptor.getText();
    DBPASS = DBPASSacceptor.getText();
    //String value3 = field3.getText();
    DEFAULTTBLNAME = DEFAULTTBLNAMEacceptor.getText();
}
    
        }
        if(performedEvent.getSource()==HelpButton)
        {
            
String[] HelpLabels = {
    "A quick guide to using Mendak Converter."," ",
    "Enter the values in the textboxes and click on the respective convert buttons.",
    "The application will detect the type of data entered and convert it to the corresponding type",
    "Inorder to convert the values, on of the textboxes needs to be empty to store the result of the conversion.",
    "In case to Encod/Decode URLs, enter a valid URL.",
    "For storing results in a text file, paste the path of the file to save the result in.",
    "Or if the file is not in the root directory of the application, select the \"Create new file\" option.",
    "For storing results in Database table, first of all you need to configure the application to work with your MySql instance on your computer",
    "This application only supports MySql databases and you need to have a separate Interface to access that instance.",
    "You can not query your database using this application nor does this application shows any of the resultsets within itself",
    "Enter a valid database name, Table name and the column name to store the result in.",
    "Comma separated Last converted values in the application will be stored in the mentioned column",
    "To convert the values from database table, enter the details of the column and be sure the app is configured to the DB.",
    "The converted values will be stored in the same column and table"," ",
    "Thank you for using Mendak Converter."
    
};
//String buttontexttest[]={"Save Configuration","Cancel"};
int option = JOptionPane.showConfirmDialog(Frame, HelpLabels, "Help - Mendak Converter", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);


        }
    }
    public void itemStateChanged(ItemEvent ChangedStateEvent)
    {
        if(ChangedStateEvent.getSource()==RBNewFile)
        if(ChangedStateEvent.getStateChange()==1)
        AllowNewFile=true;
        if(ChangedStateEvent.getSource()==RBNewDB){
        if(ChangedStateEvent.getStateChange()==1)
        {AllowNewDB=true;System.out.println(AllowNewDB);}
        else{AllowNewDB=false;System.out.println(AllowNewDB);}}
        if(ChangedStateEvent.getSource()==ExitAsk){
        if(ChangedStateEvent.getStateChange()==1)
        {AskOnExit=true;System.out.println(AskOnExit);}
        else{AskOnExit=false;System.out.println(AskOnExit);}}
        
        
            if(ChangedStateEvent.getStateChange()==1)
///use less code below
  switch(ChangedStateEvent.getItemSelectable().toString())
  {
   
            case "Binary (2)":
           
              //Binary selected
              System.out.println("bin");
            
            case "Octal (8)":
           
              //Otal selected
              System.out.println("Octal");
            
            case "Decimal (10)":
           
              //Otal selected
              System.out.println("Decimal");
            
            case "Hexadecimal (16)":
            
              //Otal selected
              System.out.println("Hexadecimal");
            
  }
      
     /*   if(ChangedStateEvent.getSource()==jcbNSLeft)
        {
          switch(jcbNSLeft.getSelectedItem().toString())
          {
            case "Binary (2)":
            if(ChangedStateEvent.getStateChange()==1)
            {
              //Binary selected
              System.out.println("bin");
            }
            case "Octal (8)":
            if(ChangedStateEvent.getStateChange()==1)
            {
              //Otal selected
              System.out.println("Octal");
            }
            case "Decimal (10)":
            if(ChangedStateEvent.getStateChange()==1)
            {
              //Otal selected
              System.out.println("Decimal");
            }
            case "Hexadecimal (16)":
            if(ChangedStateEvent.getStateChange()==1)
            {
              //Otal selected
              System.out.println("Hexadecimal");
            }
          }*/
        }
     
    
    public static void main(String jskrn[])
    {
    Mendak bf =  new Mendak();
     
     
    Frame.addMouseListener(new MouseListener(){
    public void mouseReleased(MouseEvent e) {
    mouseDownCompCoords = null;
    }
    public void mousePressed(MouseEvent e) {
    mouseDownCompCoords = e.getPoint();
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
    }
    });
     
    Frame.addMouseMotionListener(new MouseMotionListener(){
    public void mouseMoved(MouseEvent e) {
    }
     
    public void mouseDragged(MouseEvent e) {
    Point currCoords = e.getLocationOnScreen();
    Frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
    });
    
    }
}       