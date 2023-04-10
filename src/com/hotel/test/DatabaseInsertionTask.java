package com.hotel.test;

public class DatabaseInsertionTask implements Runnable {

    private WaitingDialog waitingDialog;

    public DatabaseInsertionTask(WaitingDialog waitingDialog) {
        this.waitingDialog = waitingDialog;
    }

    @Override
    public void run() {
        // Insertar los datos en la base de datos
        //insertarDatosEnLaBaseDeDatos();

        // Ocultar el diálogo de espera
        waitingDialog.hide();
    }



}