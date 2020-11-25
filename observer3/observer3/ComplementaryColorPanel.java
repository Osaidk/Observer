package observer3;

import javax.swing.*;
import java.awt.*;

public class ComplementaryColorPanel extends ColorPanel {
    private Color color;

    public ComplementaryColorPanel(Color color) {
        super(color);
        this.color = color;
    }

    public void setColor(Color newColor) {
        super.setColor(newColor);
    }

    protected void paintComponent(Graphics g) {
        this.setBackground(color);
        super.paintComponent(g);
    }

    @Override
    public void PushUpdate(JSlider hueSlider, JSlider saturationSlider, JSlider brightnessSlider) {
        float newHue = (float) hueSlider.getValue() / 100;
        float newSaturation = (float) saturationSlider.getValue() / 100;
        float newBrightness = (float) brightnessSlider.getValue() / 100;
        float complementaryHue = newHue - (float) 0.5;
        if (complementaryHue < 0) {
            complementaryHue = complementaryHue + 1;
        }
        Color newColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
        this.setColor(newColor);
    }
}
