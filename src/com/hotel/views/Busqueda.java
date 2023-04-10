package com.hotel.views;


import com.hotel.controller.GuestController;
import com.hotel.controller.ReservationController;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.EventObject;
import java.util.Optional;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes;
    private JTable tbReservas;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHuesped;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;
    private ReservationController reservationController;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Busqueda() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);


        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);


        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(325, 62, 290, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);


        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 13));
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("NÚMERO DE RESERVA");
        modelo.addColumn("FECHA DE ENTRADA");
        modelo.addColumn("FECHA DE SALIDA");
        modelo.addColumn("VALOR");
        modelo.addColumn("FORMA DE PAGO");
        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
        scroll_table.setVisible(true);

        tbHuespedes = new JTable();
        tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 13));
        modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
        modeloHuesped.addColumn("NÚMERO DE HUESPED");
        modeloHuesped.addColumn("NOMBRE");
        modeloHuesped.addColumn("APELLIDO");
        modeloHuesped.addColumn("FECHA DE NACIMIENTO");
        modeloHuesped.addColumn("NACIONALIDAD");
        modeloHuesped.addColumn("TELEFONO");
        modeloHuesped.addColumn("NÚMERO DE RESERVA");

        /*
        int nonEditableColumnIndex = 2; // ejemplo: columna 2 no editable
        tbHuespedes.getColumnModel().getColumn(nonEditableColumnIndex).setCellEditor(null);
        */


        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
        panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);
/*
        chargeTableReservations();
        chargeTableGuests();*/
        chargeTableReservations();
        chargeTableGuests();

        //activeThreads();

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);
            }
        });

        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int value = panel.getSelectedIndex();

                if (value == 0) {
                    if (txtBuscar.getText().isEmpty()) {
                        cleanTable(modelo);
                        chargeTableReservations();
                        return;
                    }
                    searchReservation(Integer.parseInt(txtBuscar.getText()));
                } else if (value == 1) {
                    if (txtBuscar.getText().isEmpty()) {
                        cleanTable(modeloHuesped);
                        chargeTableGuests();
                        return;
                    }
                    searchGuest(Integer.parseInt(txtBuscar.getText()));
                }
            }
        });
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int value = panel.getSelectedIndex();
                if (value == 0) {
                    updateReservation(tbReservas, modelo);
                } else if (value == 1) {
                    updateGuest(tbHuespedes, modeloHuesped);
                }
            }
        });
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        JPanel btnEliminar = new JPanel();
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int value = panel.getSelectedIndex();
                if (value == 0) {
                    deleteReservation(tbReservas, modelo);
                } else if (value == 1) {
                    deleteGuest(tbHuespedes, modeloHuesped);
                }
            }
        });
        contentPane.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);
    }

    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }


    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    private void chargeTableReservations() {
        ReservationController reservations = new ReservationController();
        reservations.listar().forEach(e -> this.modelo.addRow(new Object[]{e.getId(),
                e.getCheck_in(),
                e.getCheck_out(),
                e.getValue(),
                e.getPayment_method()}));
    }

    private void searchReservation(Integer id) {
        ReservationController reservationController = new ReservationController();
        if (reservationController.search(id).isEmpty()) {
            //JOptionPane.showMessageDialog(this, "No se encontraron resultados con ese ID");
            new ToastInfo("Sin resultados");
            return;
        }
        cleanTable(modelo);
        reservationController.search(id).forEach(e -> this.modelo.addRow(new Object[]{e.getId(),
                e.getCheck_in(),
                e.getCheck_out(),
                e.getValue(),
                e.getPayment_method()}));
    }

    private void searchGuest(Integer id) {
        GuestController guestController = new GuestController();
        if (guestController.search(id).isEmpty()) {
            //JOptionPane.showMessageDialog(this, "No se encontraron resultados con ese ID");
            new ToastInfo("Sin resultados");
            return;
        }
        cleanTable(modeloHuesped);
        guestController.search(id).forEach(e -> this.modeloHuesped.addRow(new Object[]{e.getId(),
                e.getFirst_name(), e.getLast_name(), e.getDate_of_birth(), e.getNationality(), e.getTelephone(),
                e.getReservation_id()}));
    }

    public void chargeTableGuests() {
        GuestController guest = new GuestController();
        guest.listar().forEach(e -> this.modeloHuesped.addRow(new Object[]{e.getId(),
                e.getFirst_name(), e.getLast_name(), e.getDate_of_birth(), e.getNationality(), e.getTelephone(),
                e.getReservation_id()}));
    }

    private void cleanTable(DefaultTableModel model) {
        model.getDataVector().clear();
    }

    private boolean haveSelectedRow(JTable table) {
        return table.getSelectedRowCount() == 0 || table.getSelectedColumnCount() == 0;
    }

    private void deleteReservation(JTable table, DefaultTableModel model) {
        if (haveSelectedRow(table)) {
            //JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            new ToastInfo("Elige un item");
            return;
        }
        Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 0).toString());
                    ReservationController reservationController = new ReservationController();
                    int cantidadEliminada = reservationController.delete_reservation(id);
                    model.removeRow(table.getSelectedRow());
                    //JOptionPane.showMessageDialog(this, cantidadEliminada + " Item eliminado con éxito!");
                    new ToastInfo(cantidadEliminada + " eliminado con éxito!");
                }, () ->  //JOptionPane.showMessageDialog(this, "Por favor, elije un item")//
                        new ToastInfo("Elige un item"));
    }

    private void deleteGuest(JTable table, DefaultTableModel model) {
        if (haveSelectedRow(table)) {
            //JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            new ToastInfo("Elige un item");
            return;
        }
        Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 0).toString());
                    GuestController guestController = new GuestController();
                    int cantidadEliminada = guestController.delete_guest(id);
                    model.removeRow(table.getSelectedRow());
                    //JOptionPane.showMessageDialog(this, cantidadEliminada + " Item eliminado con éxito!");
                    new ToastInfo(cantidadEliminada + " eliminado con éxito!");
                }, () ->//JOptionPane.showMessageDialog(this, "Por favor, elije un item")
                        new ToastInfo("Elige un item"));
    }

    private void updateReservation(JTable table, DefaultTableModel model) {
        if (haveSelectedRow(table)) {
            //JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            new ToastInfo("Elige un item");
            return;
        }

        Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 0).toString());
                    String check_in = (String) model.getValueAt(table.getSelectedRow(), 1);
                    String check_out = (String) model.getValueAt(table.getSelectedRow(), 2);
                    String value = (String) model.getValueAt(table.getSelectedRow(), 3);
                    String payment_method = (String) model.getValueAt(table.getSelectedRow(), 4);
                    ReservationController reservationController = new ReservationController();
                    int cantidadActualizada = reservationController.update_reservation(id, check_in, check_out, value, payment_method);
                    //JOptionPane.showMessageDialog(this, cantidadActualizada + " Item actualizado con éxito!");
                    new ToastInfo(cantidadActualizada + " actualizado con éxito!");
                }, () -> //JOptionPane.showMessageDialog(this, "Por favor, elije un item")
                        new ToastInfo("Elige un item"));
    }

    private void updateGuest(JTable table, DefaultTableModel model) {
        if (haveSelectedRow(table)) {
            //JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            new ToastInfo("Elige un item");
            return;
        }
        Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 0).toString());
                    String first_name = (String) model.getValueAt(table.getSelectedRow(), 1);
                    String last_name = (String) model.getValueAt(table.getSelectedRow(), 2);
                    String date_of_birth = (String) model.getValueAt(table.getSelectedRow(), 3);
                    String nationality = (String) model.getValueAt(table.getSelectedRow(), 4);
                    String telephone = (String) model.getValueAt(table.getSelectedRow(), 5);
                    Integer reservation_id = Integer.valueOf(model.getValueAt(table.getSelectedRow(), 6).toString());
                    GuestController guestController = new GuestController();
                    int cantidadActualizada = guestController.update_guest(id, first_name, last_name, date_of_birth,
                            nationality, telephone, reservation_id);
                    //JOptionPane.showMessageDialog(this, cantidadActualizada + " Item actualizado con éxito!");
                    new ToastInfo(cantidadActualizada + " actualizado con éxito!");
                }, () -> //JOptionPane.showMessageDialog(this, "Por favor, elije un item")
                        new ToastInfo("Elige un item"));
    }
}