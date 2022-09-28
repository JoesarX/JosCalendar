package main;

//import com.toedter.calendar.JMonthChooser;
//import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JosCalendar {

    //public JMonthChooser MonthChooser;
    public JComboBox MonthChooser;
    //public JYearChooser YearChooser;
    public JSpinner YearChooser;
    public Color colorON;
    public Color colorOFF;
    public Color colorTheme;
    public ArrayList calendario = new ArrayList<DiaCalendar>();
    public ArrayList diasSemana = new ArrayList<JLabel>();
    public JLabel MesLabel;
    public int largo;
    public int alto;

    class DiaCalendar {

        public JPanel panelDia;
        public JLabel labelDia;
        public JTextArea areaDia;

        /*public Color colorON;
        public Color colorOFF;
        public Color colorTheme;*/
        public DiaCalendar() {
            this.panelDia = new JPanel();
            this.labelDia = new JLabel("Buenas", SwingConstants.LEFT);
            this.areaDia = new JTextArea();

            panelDia.setBackground(colorOFF);
            panelDia.setSize(150, 70);
            panelDia.setLayout(null);

            Font fontLabel = new Font("Tahoma", Font.BOLD, 18);
            panelDia.add(labelDia);
            labelDia.setFont(fontLabel);
            labelDia.setForeground(colorTheme);
            //labelDia.setLocation(0, 0);
            labelDia.setSize(150, 20);
            //labelDia.setBackground(colorTry);
            //labelDia.setBack

            panelDia.add(areaDia);
            //areaDia.setLocation(0,20);
            areaDia.setSize(150, 55);
            areaDia.setBorder(null);
            areaDia.setEditable(false);
            areaDia.setBackground(colorOFF);
            areaDia.setText("");
            //areaDia.setEditable(true);
            areaDia.setForeground(colorON);
        }

        public DiaCalendar(int x, int y, Color colorOn, Color colorOff, Color colorTheme, int largo, int alto) {
            this.panelDia = new JPanel();
            this.labelDia = new JLabel("Buenas", SwingConstants.LEFT);
            this.areaDia = new JTextArea();

            panelDia.setBackground(colorOFF);
            panelDia.setSize(largo, alto);
            panelDia.setLayout(null);
            panelDia.setLocation(x, y);

            Font fontLabel = new Font("Tahoma", Font.BOLD, 18);
            panelDia.add(labelDia);
            labelDia.setFont(fontLabel);
            labelDia.setForeground(colorON);
            labelDia.setLocation(5, 0);
            labelDia.setSize(largo - 10, 20);
            //labelDia.setBackground(colorTry);
            //labelDia.setBack

            panelDia.add(areaDia);
            areaDia.setLocation(0, 22);
            areaDia.setSize(largo, alto - 22);
            areaDia.setBorder(null);
            areaDia.setEditable(false);
            areaDia.setBackground(colorOFF);
            areaDia.setEditable(true);
            areaDia.setText(" 1)aaaaaaaaaaaaa\n 2)bbbbbbbbb\n 3)cccccccccc");
            areaDia.setForeground(colorOFF);
        }

        public void reload(int x, int y, int largo, int alto) {
            panelDia.setSize(largo, alto);
            panelDia.setLocation(x, y);
            labelDia.setSize(largo - 10, 20);
            areaDia.setSize(largo, alto - 22);
        }

        public JPanel getPanelDia() {
            return panelDia;
        }

        public void setPanelDia(JPanel panelDia) {
            this.panelDia = panelDia;
        }

        public JLabel getLabelDia() {
            return labelDia;
        }

        public void setLabelDia(JLabel labelDia) {
            this.labelDia = labelDia;
        }

        public JTextArea getAreaDia() {
            return areaDia;
        }

        public void setAreaDia(JTextArea areaDia) {
            this.areaDia = areaDia;
        }

    }
    private JPanel panel;

    public JosCalendar(JPanel panel) {
        this.panel = panel;
        panel.setLayout(null);
        colorON = new Color(234, 234, 234);
        colorOFF = new Color(60, 63, 65);
        colorTheme = new Color(255, 102, 204);
        CreateCalendar();
    }

    public JosCalendar(JPanel panel, Color colorON, Color colorOFF, Color colorTheme) {
        this.panel = panel;
        panel.setLayout(null);
        this.colorON = colorON;
        this.colorOFF = colorOFF;
        this.colorTheme = colorTheme;
        CreateCalendar();
    }

    public void updateCalendar() {
        String Result = "";
        int year = (int) (YearChooser.getValue());
        int month = (MonthChooser.getSelectedIndex()) + 1;
        System.out.println("MES: " + month);
        System.out.println("YEAR: " + year);
        String date_string = "1-" + month + "-" + year;
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date;
        int diaStart = 0;
        try {
            date = formatter.parse(date_string);
            System.out.println("Date value: " + date);
            System.out.println("PRIMER DIA: " + date.getDay());
            diaStart = date.getDay();
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        int dias = 0;
        String nombreMes = "";
        switch (month) {
            case 1: {
                dias = 31;
                nombreMes = "E N E R O";
            }
            break;
            case 2: {
                if (year % 4 == 0) {
                    dias = 29;
                } else {
                    dias = 28;
                }
                nombreMes = "F E B R E R O";
            }
            break;
            case 3: {
                dias = 31;
                nombreMes = "M A R Z O ";
            }
            break;
            case 4: {
                dias = 30;
                nombreMes = "A B R I L ";
            }
            break;
            case 5: {
                dias = 31;
                nombreMes = "M A Y O";
            }
            break;
            case 6: {
                dias = 30;
                nombreMes = "J U N I O";
            }
            break;
            case 7: {
                dias = 31;
                nombreMes = "J U L I O ";
            }
            break;
            case 8: {
                dias = 31;
                nombreMes = "A G O S T O";
            }
            break;
            case 9: {
                dias = 30;
                nombreMes = "S E P T I E M B R E";
            }
            break;
            case 10: {
                dias = 31;
                nombreMes = "O C T U B R E";
            }
            break;
            case 11: {
                dias = 30;
                nombreMes = "N O V I E M B R E ";
            }
            break;
            case 12: {
                dias = 31;
                nombreMes = "D I C I E M B R E";
            }
            break;
        }
        largo = (panel.getWidth() - 50) / 7;
        alto = (panel.getHeight() - 120) / 6;
        int initialX = 10;
        int initialY = 80;
        MesLabel.setSize((panel.getWidth()) - 490, 35);
        MesLabel.setLocation(245, 5);
        int xo = 10;
        int yo = 50;
        for (int j = 0; j < 7; j++) {
            ((JLabel)(diasSemana.get(j))).setSize(largo, 20);
            ((JLabel)(diasSemana.get(j))).setLocation(xo, yo);
            xo += largo + 5;
        }
        
        for (int j = 0; j < calendario.size(); j++) {
            ((DiaCalendar) (calendario.get(j))).getPanelDia().setBackground(colorOFF);
            ((DiaCalendar) (calendario.get(j))).getAreaDia().setBackground(colorOFF);
            ((DiaCalendar) (calendario.get(j))).getAreaDia().setText("");
            ((DiaCalendar) (calendario.get(j))).getLabelDia().setText("");

            if (((j) % 7 == 0) && j != 0) {
                initialY += alto + 5;
                initialX = 10;
            }
            DiaCalendar buenas = new DiaCalendar(initialX, initialY, colorON, colorOFF, colorTheme, largo, alto);

            ((DiaCalendar) (calendario.get(j))).reload(initialX, initialY, largo, alto);
            initialX += largo + 5;

        }
        MesLabel.setText(nombreMes);
        System.out.println("after reset");
        for (int i = 0; i < dias; i++) {
            System.out.println((i + diaStart));
            ((DiaCalendar) (calendario.get(i + diaStart))).getPanelDia().setBackground(colorTheme);
            ((DiaCalendar) (calendario.get(i + diaStart))).getAreaDia().setBackground(colorON);
            //((DiaCalendar) (calendario.get(i + diaStart))).getAreaDia().setText(" 1)aaaaaaaaaaaaa\n 2)bbbbbbbbb\n 3)cccccccccc");
            String numero = Integer.toString(i + 1);
            ((DiaCalendar) (calendario.get(i + diaStart))).getLabelDia().setText(numero);

            //calendario.get(i + diaStart).setBackground(colorON);
            //String texo = " " + (i + 1) + ")\n";
            //((DiaCalendar)(calendario.get(i + diaStart))).getLabelDia().setText((i+1));
            //alendario.get(i + diaStart).setText(texo);
        }
        System.out.println("good");
    }

    public void CreateCalendar() {
        panel.setBackground(colorOFF);
        Font fontChooser = new Font("Tahoma", Font.PLAIN, 14);
        largo = (panel.getWidth() - 50) / 7;
        alto = (panel.getHeight() - 120) / 6;

        //MONTH CHOOSER
        /*MonthChooser = new JMonthChooser();
        MonthChooser.setSize(180, 40);
        MonthChooser.setFont(fontChooser);
        this.panel.add(MonthChooser);
        MonthChooser.setLocation(5, 5);*/
        String monthEspanol[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        MonthChooser = new JComboBox(monthEspanol);
        MonthChooser.setFont(fontChooser);
        panel.add(MonthChooser);
        MonthChooser.setSize(140, 35);
        MonthChooser.setLocation(5, 5);

        //YEAR CHOOSER
        /*YearChooser = new JYearChooser();
        YearChooser.setFont(fontChooser);
        this.panel.add(YearChooser);
        YearChooser.setLocation(150, 5);
        YearChooser.setSize(70, 30);*/
        YearChooser = new JSpinner();
        YearChooser.setFont(fontChooser);
        YearChooser.setValue(2022);
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(YearChooser, "#");
        YearChooser.setEditor(editor);
        panel.add(YearChooser);
        YearChooser.setSize(90, 35);
        YearChooser.setLocation(150, 5);

        //MONTH LABEL
        MesLabel = new JLabel("M E S", SwingConstants.CENTER);
        Font fontMonth = new Font("Tahoma", Font.BOLD, 35);
        MesLabel.setFont(fontMonth);
        MesLabel.setForeground(colorON);
        panel.add(MesLabel);
        MesLabel.setSize((panel.getWidth()) - 490, 35);
        MesLabel.setLocation(245, 5);

        //DAYS OF THE WEEK
        String Dias[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        int x = 10;
        int y = 50;
        for (int j = 0; j < 7; j++) {
            JLabel dia = new JLabel(Dias[j], SwingConstants.CENTER);
            diasSemana.add(dia);
            Font fontDia = new Font("Tahoma", Font.BOLD, 20);
            dia.setFont(fontDia);
            dia.setForeground(colorTheme);
            panel.add(dia);
            dia.setSize(largo, 20);
            dia.setLocation(x, y);
            x += largo + 5;
        }

        int initialX = 10;
        int initialY = 80;

        for (int i = 1; i <= 42; i++) {
            if (((i - 1) % 7 == 0) && i != 1) {
                initialY += alto + 5;
                initialX = 10;
            }
            DiaCalendar buenas = new DiaCalendar(initialX, initialY, colorON, colorOFF, colorTheme, largo, alto);
            initialX += largo + 5;
            panel.add(buenas.getPanelDia());
            calendario.add(buenas);
        }
    }

}
