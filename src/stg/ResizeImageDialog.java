package stg;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ResizeImageDialog extends JDialog {
    private BufferedImage originalImage;
    private BufferedImage resizedImage;

    private JLabel previewLabel;
    private JTextField widthTextField;
    private JTextField heightTextField;

    public ResizeImageDialog(JFrame parent, BufferedImage image) {
        super(parent, "Redimensionner l'image", true);
        this.originalImage = image;
        this.resizedImage = image; // Par défaut, l'image redimensionnée est la même que l'image originale

        JPanel contentPane = new JPanel(new BorderLayout());

        // Créer un panneau pour la prévisualisation de l'image
        previewLabel = new JLabel(new ImageIcon(originalImage));
        contentPane.add(previewLabel, BorderLayout.CENTER);

        // Créer des champs de saisie pour la largeur et la hauteur
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Largeur :"));
        widthTextField = new JTextField(Integer.toString(originalImage.getWidth()), 5);
        inputPanel.add(widthTextField);
        inputPanel.add(new JLabel("Hauteur :"));
        heightTextField = new JTextField(Integer.toString(originalImage.getHeight()), 5);
        inputPanel.add(heightTextField);
        contentPane.add(inputPanel, BorderLayout.SOUTH);

        // Ajouter le contenu du panneau à la boîte de dialogue
        this.setContentPane(contentPane);

        this.pack();
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
    }

    public BufferedImage getResizedImage() {
        return resizedImage;
    }

    public int getDesiredWidth() {
        try {
            return Integer.parseInt(widthTextField.getText());
        } catch (NumberFormatException e) {
            return originalImage.getWidth();
        }
    }

    public int getDesiredHeight() {
        try {
            return Integer.parseInt(heightTextField.getText());
        } catch (NumberFormatException e) {
            return originalImage.getHeight();
        }
    }
}
