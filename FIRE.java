import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class FIRE extends JFrame {
    static double prin;
    static double year;
    static double roi;
    static double cont;
    static double target;
    static String fr;
    static double factor;
    private JTabbedPane tabbedPane1;
    private JButton endBal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel calcLabel;
    private javax.swing.JPanel JPanel;
    private JRadioButton moBut;
    private JRadioButton yrBut;
    private JLabel target0;
    private JLabel start0;
    private JLabel roi0;
    private JLabel cont0;
    private JTextField userTarg0;
    private JTextField userStart0;
    private JTextField userROI0;
    private JTextField userYrCont;
    private JButton termButton;
    private JLabel timeLabel;
    private JLabel termTitle;
    private JLabel contTitle;
    private JLabel target1;
    private JLabel start1;
    private JLabel time1;
    private JLabel roi1;
    private JLabel freq1;
    private JPanel userTarg1;
    private JLabel contLabel;
    private JTextField userTarg2;
    private JTextField userStart1;
    private JTextField userYrCount1;
    private JTextField userROI1;
    private JButton contButton;
    private JRadioButton contMoBut;
    private JRadioButton contYrBut;
    private JLabel welcomeMessage;
    private JLabel optA;
    private JLabel optB;
    private JLabel optC;
    private double factor1;
    private String freqNoti = "";


    public FIRE() {
        setContentPane(JPanel);

        ButtonGroup bgEB = new ButtonGroup();
        bgEB.add(moBut);
        bgEB.add(yrBut);
        ButtonGroup bgCR = new ButtonGroup();
        bgCR.add(contMoBut);
        bgCR.add(contYrBut);
        endBal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moBut.isSelected()) {
                    factor = 12;
                } else {
                    factor = 1;
                }
                double endBal = endBalance(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()), (Double.parseDouble(textField3.getText())) / 100, factor, Double.parseDouble(textField4.getText()));
                endBal = roundMoney(endBal);
                calcLabel.setText("Ending Balance: $" + endBal);
            }
        });
        termButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double term0 = invTerm(Double.parseDouble(userTarg0.getText()), Double.parseDouble(userStart0.getText()), Double.parseDouble(userROI0.getText()) / 100, Double.parseDouble(userYrCont.getText()));
                term0 = roundMoney(term0);
                timeLabel.setText("To accumulate $" + userTarg0.getText() + " with this investing regiment, you will need " + term0 + " years.");
            }
        });
        contButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (contMoBut.isSelected()) {
                    freqNoti = "month"; // set up concluding message
                } else {
                    freqNoti = "year";
                }
                factor1 = setFreq(freqNoti);
                cont = regPeriod(Double.parseDouble(userTarg2.getText()), Double.parseDouble(userStart1.getText()), Double.parseDouble(userYrCount1.getText()), Double.parseDouble(userROI1.getText()) / 100, factor1);
                cont = roundMoney(cont);
                if (cont == 0.0) {
                    cont = regPeriod(Double.parseDouble(userTarg2.getText()), Double.parseDouble(userStart1.getText()), Double.parseDouble(userYrCount1.getText()), Double.parseDouble(userROI1.getText()) / 100, 1);
                    cont = cont / 12;
                    cont = roundMoney(cont);
                }
                contLabel.setText("To accumulate $" + userTarg2.getText() + " in " + userYrCount1.getText() + " years, you will need to invest $" + cont + " per " + freqNoti + ".");
            }
        });
    }

    public static double endBalance(double prin, double year, double roi, double factor, double cont) {
        return prin * Math.pow((1 + (roi / factor)), year * factor) + ((cont) * Math.pow((1 + (roi / factor)), year * factor) - (cont)) / (roi / factor);
    }

    public static double invTerm(double s, double p, double r, double c) { //s = target, p = principle, r = yearly return, c = yearly contribution
        return (Math.log((s * r) / (p * r + c) + c / (p * r + c))) / (Math.log(r + 1));
    }

    public static double regPeriod(double s, double p, double t, double r, double n) {
        return ((r / n) * (Math.pow(n, n * t) * s - p * Math.pow((r + n), n * t))) / ((Math.pow(r + n, n * t) - Math.pow(n, n * t)));
    }

    public static int setFreq(String freq) {
        if (freq.startsWith("m") || freq.startsWith("M")) {
            return 12;
        } else {
            return 1;
        }
    }

    public static double perc(double roi) {
        return roi / 100;
    }

    public static double roundMoney(double vald) {
        vald = vald * 100;
        int vali = (int) vald;
        double valdn = (double) vali;
        return valdn / 100;
    }


    public static void main(String[] args) {
        JFrame frame = new FIRE();
        frame.setSize(1600, 325);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        JPanel = new JPanel();
        JPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1 = new JTabbedPane();
        JPanel.add(tabbedPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final javax.swing.JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Welcome Page", panel1);
        optA = new JLabel();
        Font optAFont = this.$$$getFont$$$(null, -1, 16, optA.getFont());
        if (optAFont != null) optA.setFont(optAFont);
        optA.setText("Ending Balance:");
        panel1.add(optA, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        optB = new JLabel();
        Font optBFont = this.$$$getFont$$$(null, -1, 16, optB.getFont());
        if (optBFont != null) optB.setFont(optBFont);
        optB.setText("Investment Term:");
        panel1.add(optB, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        optC = new JLabel();
        Font optCFont = this.$$$getFont$$$(null, -1, 16, optC.getFont());
        if (optCFont != null) optC.setFont(optCFont);
        optC.setText("Contribution Regiment:");
        panel1.add(optC, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 14, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Calculate how much an investment will be worth given the investment's parameters, contributions, rate of contributions, and time.");
        panel1.add(label1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, -1, 14, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Calculate how many years it will take to accrue a target amount based on the investment and contribution routine.");
        panel1.add(label2, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, -1, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Calculate how much you will need to invest in a routine in order to achieve your desired goal in your desired time-frame.");
        panel1.add(label3, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        welcomeMessage = new JLabel();
        Font welcomeMessageFont = this.$$$getFont$$$(null, Font.BOLD, 36, welcomeMessage.getFont());
        if (welcomeMessageFont != null) welcomeMessage.setFont(welcomeMessageFont);
        welcomeMessage.setText("The F.I.R.E Calculator");
        panel1.add(welcomeMessage, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$(null, -1, 14, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("The (F)inicially (I)ndependent, (R)etire (E)arly calculator is a tool to help users plan and time financial goals.");
        panel1.add(label4, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$(null, -1, 14, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("The tool allows the below calculator tabs, with a description provided below.");
        panel1.add(label5, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final javax.swing.JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(8, 5, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Ending Balance", panel2);
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$(null, -1, 16, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setText("Term (Years)");
        panel2.add(label6, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        Font label7Font = this.$$$getFont$$$(null, -1, 16, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setText("Annual Expected Return (percentage)");
        panel2.add(label7, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        Font label8Font = this.$$$getFont$$$(null, -1, 16, label8.getFont());
        if (label8Font != null) label8.setFont(label8Font);
        label8.setText("Additional Contribution");
        panel2.add(label8, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        Font label9Font = this.$$$getFont$$$(null, -1, 16, label9.getFont());
        if (label9Font != null) label9.setFont(label9Font);
        label9.setText("Contribution Frequency");
        panel2.add(label9, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        endBal = new JButton();
        Font endBalFont = this.$$$getFont$$$(null, -1, 16, endBal.getFont());
        if (endBalFont != null) endBal.setFont(endBalFont);
        endBal.setText("Calculate");
        panel2.add(endBal, new GridConstraints(6, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        panel2.add(textField1, new GridConstraints(1, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField2 = new JTextField();
        panel2.add(textField2, new GridConstraints(2, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField3 = new JTextField();
        panel2.add(textField3, new GridConstraints(3, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField4 = new JTextField();
        panel2.add(textField4, new GridConstraints(4, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        calcLabel = new JLabel();
        Font calcLabelFont = this.$$$getFont$$$(null, Font.BOLD, 24, calcLabel.getFont());
        if (calcLabelFont != null) calcLabel.setFont(calcLabelFont);
        calcLabel.setText("Ending Balance:");
        panel2.add(calcLabel, new GridConstraints(7, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        Font label10Font = this.$$$getFont$$$(null, -1, 16, label10.getFont());
        if (label10Font != null) label10.setFont(label10Font);
        label10.setText("Starting Balance");
        panel2.add(label10, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        moBut = new JRadioButton();
        moBut.setText("Monthly");
        panel2.add(moBut, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        yrBut = new JRadioButton();
        yrBut.setText("Yearly");
        panel2.add(yrBut, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        Font label11Font = this.$$$getFont$$$(null, Font.BOLD, 36, label11.getFont());
        if (label11Font != null) label11.setFont(label11Font);
        label11.setText("Ending Balance Calculator");
        panel2.add(label11, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final javax.swing.JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(7, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Investment Term", panel3);
        target0 = new JLabel();
        Font target0Font = this.$$$getFont$$$(null, -1, 16, target0.getFont());
        if (target0Font != null) target0.setFont(target0Font);
        target0.setText("Target Ending Balance");
        panel3.add(target0, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        start0 = new JLabel();
        Font start0Font = this.$$$getFont$$$(null, -1, 16, start0.getFont());
        if (start0Font != null) start0.setFont(start0Font);
        start0.setText("Starting Balance");
        panel3.add(start0, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        roi0 = new JLabel();
        Font roi0Font = this.$$$getFont$$$(null, -1, 16, roi0.getFont());
        if (roi0Font != null) roi0.setFont(roi0Font);
        roi0.setText("Annual Expected Return (percentage)");
        panel3.add(roi0, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cont0 = new JLabel();
        Font cont0Font = this.$$$getFont$$$(null, -1, 16, cont0.getFont());
        if (cont0Font != null) cont0.setFont(cont0Font);
        cont0.setText("Additional Contribution (PER YEAR)");
        panel3.add(cont0, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userTarg0 = new JTextField();
        panel3.add(userTarg0, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userStart0 = new JTextField();
        panel3.add(userStart0, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userROI0 = new JTextField();
        panel3.add(userROI0, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userYrCont = new JTextField();
        panel3.add(userYrCont, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        termButton = new JButton();
        Font termButtonFont = this.$$$getFont$$$(null, -1, 16, termButton.getFont());
        if (termButtonFont != null) termButton.setFont(termButtonFont);
        termButton.setText("Calculate");
        panel3.add(termButton, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        timeLabel = new JLabel();
        Font timeLabelFont = this.$$$getFont$$$(null, -1, 14, timeLabel.getFont());
        if (timeLabelFont != null) timeLabel.setFont(timeLabelFont);
        timeLabel.setText("");
        panel3.add(timeLabel, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        termTitle = new JLabel();
        Font termTitleFont = this.$$$getFont$$$("Calibri", Font.BOLD, 36, termTitle.getFont());
        if (termTitleFont != null) termTitle.setFont(termTitleFont);
        termTitle.setText("Investment Time-Length Calculator");
        panel3.add(termTitle, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userTarg1 = new JPanel();
        userTarg1.setLayout(new GridLayoutManager(8, 3, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Contribution Regiment", userTarg1);
        contTitle = new JLabel();
        Font contTitleFont = this.$$$getFont$$$("Calibri", Font.BOLD, 36, contTitle.getFont());
        if (contTitleFont != null) contTitle.setFont(contTitleFont);
        contTitle.setText("Contribution Regiment");
        userTarg1.add(contTitle, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        target1 = new JLabel();
        Font target1Font = this.$$$getFont$$$(null, -1, 16, target1.getFont());
        if (target1Font != null) target1.setFont(target1Font);
        target1.setText("Target Ending Balance");
        userTarg1.add(target1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        start1 = new JLabel();
        Font start1Font = this.$$$getFont$$$(null, -1, 16, start1.getFont());
        if (start1Font != null) start1.setFont(start1Font);
        start1.setText("Starting Balance");
        userTarg1.add(start1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        time1 = new JLabel();
        Font time1Font = this.$$$getFont$$$(null, -1, 16, time1.getFont());
        if (time1Font != null) time1.setFont(time1Font);
        time1.setText("Term (Years)");
        userTarg1.add(time1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        roi1 = new JLabel();
        Font roi1Font = this.$$$getFont$$$(null, -1, 16, roi1.getFont());
        if (roi1Font != null) roi1.setFont(roi1Font);
        roi1.setText("Annual Expected Return (percentage)");
        userTarg1.add(roi1, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        freq1 = new JLabel();
        Font freq1Font = this.$$$getFont$$$(null, -1, 16, freq1.getFont());
        if (freq1Font != null) freq1.setFont(freq1Font);
        freq1.setText("Contribution Frequency");
        userTarg1.add(freq1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userTarg2 = new JTextField();
        userTarg1.add(userTarg2, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userStart1 = new JTextField();
        userTarg1.add(userStart1, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userYrCount1 = new JTextField();
        userTarg1.add(userYrCount1, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userROI1 = new JTextField();
        userTarg1.add(userROI1, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        contButton = new JButton();
        Font contButtonFont = this.$$$getFont$$$(null, -1, 16, contButton.getFont());
        if (contButtonFont != null) contButton.setFont(contButtonFont);
        contButton.setText("Calculate");
        userTarg1.add(contButton, new GridConstraints(6, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contMoBut = new JRadioButton();
        contMoBut.setText("Monthly");
        userTarg1.add(contMoBut, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contYrBut = new JRadioButton();
        contYrBut.setText("Yearly");
        userTarg1.add(contYrBut, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contLabel = new JLabel();
        Font contLabelFont = this.$$$getFont$$$(null, -1, 14, contLabel.getFont());
        if (contLabelFont != null) contLabel.setFont(contLabelFont);
        contLabel.setText("");
        userTarg1.add(contLabel, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
