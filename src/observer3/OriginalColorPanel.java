package observer3;

import javax.swing.*;
import java.awt.*;

public class OriginalColorPanel extends ColorPanel implements Observer{
    private Color color;
    private float Hue;
    private float Sat;
    private float Bri;

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


    public void setAttributes(float Hue, float Sat, float Bri) {
        Color newColor = Color.getHSBColor(Hue, Sat, Bri);
        this.setColor(newColor);
    }

    @Override
    public void PushUpdate(JSlider hueSlider, JSlider saturationSlider, JSlider brightnessSlider) {
        Hue = (float) hueSlider.getValue() / 100;
        Sat = (float) saturationSlider.getValue() / 100;
        Bri = (float) brightnessSlider.getValue() / 100;
        setAttributes(Hue, Sat, Bri);
    }

    public float getHue() {
        return this.Hue;
    }

    public float getSat() {
        return this.Sat;
    }

    public float getBri() {
        return this.Bri;
    }
}
