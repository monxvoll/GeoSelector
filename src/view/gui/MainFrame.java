package view.gui;

import view.listeners.LocationListener;
import model.Country;
import model.Department;
import model.City;
import model.GeoService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JComboBox<Country> countryBox;
    private JComboBox<Department> departmentBox;
    private JComboBox<City> cityBox;
    private GeoService geoService;
    private LocationListener locationListener;

    public MainFrame() {
        setUndecorated(true);
        setTitle("Location Selector");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        geoService = new GeoService();


        JPanel titleBar = new JPanel();
        titleBar.setBackground(new Color(30, 30, 30));
        titleBar.setPreferredSize(new Dimension(getWidth(), 35));
        titleBar.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("GeoSelector");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));

        JButton closeButton = new JButton("X");
        closeButton.setForeground(new Color(255, 19, 150));
        closeButton.setBackground(new Color(30, 30, 30));
        closeButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        closeButton.setFocusPainted(false);

        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(new Color(41, 40, 40));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButton.setBackground(new Color(30, 30, 30));
            }
        });

        closeButton.addActionListener(e -> System.exit(0));

        titleBar.add(titleLabel, BorderLayout.WEST);
        titleBar.add(closeButton, BorderLayout.EAST);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(45, 45, 45));

        Font labelFont = new Font("Courier New", Font.PLAIN, 17);

        countryBox = createStyledComboBox();
        departmentBox = createStyledComboBox();
        cityBox = createStyledComboBox();

        JLabel countryLabel = new JLabel("Select Country :");
        JLabel departmentLabel = new JLabel("Select Department :");
        JLabel cityLabel = new JLabel("Select City :");

        countryLabel.setFont(labelFont);
        departmentLabel.setFont(labelFont);
        cityLabel.setFont(labelFont);
        countryLabel.setForeground(new Color(199, 199, 186));
        departmentLabel.setForeground(new Color(199, 199, 186));
        cityLabel.setForeground(new Color(199, 199, 186));

        panel.add(countryLabel);
        panel.add(countryBox);
        panel.add(departmentLabel);
        panel.add(departmentBox);
        panel.add(cityLabel);
        panel.add(cityBox);

        add(titleBar, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        
        locationListener = new LocationListener(geoService, countryBox, departmentBox, cityBox);
        geoService.loadCountries(countryBox);

        countryBox.addActionListener(locationListener.getCountryBoxListener());
        departmentBox.addActionListener(locationListener.getDepartmentBoxListener());



    }

    private <T> JComboBox<T> createStyledComboBox() {
        JComboBox<T> comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        comboBox.setBackground(new Color(41, 40, 40));
        comboBox.setForeground(new Color(148, 223, 255));
        comboBox.setFocusable(false);

        ((JLabel) comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        return comboBox;
    }



    public void showWindow() {
        setVisible(true);
    }
}
