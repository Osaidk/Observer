package observer3;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener {
    private Color color;
    private OriginalColorPanel originalPanel;


    public ComplementaryColorPanel(Color color, OriginalColorPanel original) {
        super(color);
        this.color = color;
        this.originalPanel = original;
        originalPanel.addPropertyChangeListener(this);
    }

    public void setColor(Color newColor) {
        super.setColor(newColor);
    }

    protected void paintComponent(Graphics g) {
        this.setBackground(color);
        super.paintComponent(g);
    }


    public void setAttributes (float Hue, float Sat, float Bri) {
        Color newColor = Color.getHSBColor(Hue, Sat, Bri);
        this.setColor(newColor);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //System.out.println("hello");
        float Hue = originalPanel.getHue();
        float complementaryHue = Hue - (float) 0.5;
        if (complementaryHue < 0) {
            complementaryHue = complementaryHue + 1;
        }
        setAttributes(complementaryHue, originalPanel.getSat(), originalPanel.getBri());
    }
}
