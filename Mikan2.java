import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Mikan2 {

    private JFrame jf = null;
    private JPanel cp = null;
    private JLabel jl = null;
    private JButton jb1 = null;
    private JButton jb2 = null;
    private JButton jb3 = null;
    private JButton jb4 = null;
    private JPanel p = null;
    private int i = 2, k;

    private JFrame getJFrame() {
        if (jf == null) {
            jf = new JFrame();
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(640, 240);
            jf.setLocationRelativeTo(null);
            jf.setContentPane(getJContentPane());
            jf.setTitle("素因数判別プログラム");
        }
        return jf;
    }

    private JPanel getJContentPane() {
        if (cp == null) {
            cp = new JPanel();
            cp.setLayout(new GridLayout(2, 1));
            cp.add(getJLabel());
            cp.add(getJPanel());
        }
        return cp;
    }

    private JLabel getJLabel() {
        if (jl == null) {
            jl = new JLabel();
            Pf(i);
        }
        return jl;
    }

    private JButton getJButton() {
        jb1 = new JButton();
        jb2 = new JButton();
        jb3 = new JButton();
        jb4 = new JButton();
        jb1.setText("+1ボタン");
        jb1.addActionListener(new MyActionListener1());

        jb2.setText("+10ボタン");
        jb2.addActionListener(new MyActionListener2());

        jb3.setText("+100ボタン");
        jb3.addActionListener(new MyActionListener3());

        jb4.setText("+リセットボタン");
        jb4.addActionListener(new MyActionListener4());
        if (k == 0)
            return jb1;
        if (k == 1)
            return jb2;
        if (k == 2)
            return jb3;
        if (k == 3)
            return jb4;
        return null;
    }

    private JPanel getJPanel() {
        // パネルをGridLayout(行,列)で作成
        p = new JPanel(new GridLayout(1, 4));
        for (k = 0; k < 4; k++)
            p.add(getJButton());
        return p;
    }

    class MyActionListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            i += 1;
            Pf(i);
        }
    }

    class MyActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            i += 10;
            Pf(i);
        }
    }

    class MyActionListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            i += 100;
            Pf(i);
        }
    }

    class MyActionListener4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            i = 2;
            Pf(i);
        }
    }

    private void Pf(int i) {
        String Disass = null;
        int j = 2, l = i, flag = 0;
        for (j = 2; j < i; j++) {
            if (i % j == 0) {
                flag = 1;
                break;
            }
        }

        if (flag == 0)
            jl.setText(Integer.toString(i) + "は素数です");
        else {
            flag = 0;
            while (true) {
                if (l % j == 0) {
                    if (flag == 0) {
                        Disass = (Integer.toString(j));
                        flag = 1;
                    } else {
                        Disass += ("×" + Integer.toString(j));
                    }
                    l /= j;
                    j = 1;
                }
                if (j > l)
                    break;
                j++;
            }
            jl.setText(Integer.toString(i) + "=" + Disass);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Mikan2 application = new Mikan2();
                application.getJFrame().setVisible(true);
            }
        });
    }
}