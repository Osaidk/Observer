package observer2;

import javax.swing.*;
import java.awt.*;

public class OriginalColorPanel extends ColorPanel{
    protected Color color;

    public OriginalColorPanel(Color color) {
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
        Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
        this.setColor(newColor);
    }
}
