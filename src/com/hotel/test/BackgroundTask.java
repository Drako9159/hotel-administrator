package com.hotel.test;

import javax.swing.*;

public class BackgroundTask extends SwingWorker<Void, String> {
    private JDialog dialog;
    private JLabel label;

    public BackgroundTask(JDialog dialog, JLabel label) {
        this.dialog = dialog;
        this.label = label;
    }

    @Override
    protected Void doInBackground() throws Exception {
        // Coloca aquí la tarea que debe ejecutarse en segundo plano
        // en este ejemplo, vamos a simular una tarea que tarda 5 segundos
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            publish("Procesando... " + i + " de 5 segundos.");
        }
        return null;
    }

    @Override
    protected void process(java.util.List<String> messages) {
        // Actualiza el texto del JLabel en el JDialog con el mensaje más reciente
        label.setText(messages.get(messages.size() - 1));
    }

    @Override
    protected void done() {
        // Cierra el JDialog cuando la tarea se completa
        dialog.dispose();
    }
}