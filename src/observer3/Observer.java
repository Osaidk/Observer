package observer3;

import javax.swing.*;

public interface Observer {
    void PushUpdate(JSlider hueSlider, JSlider saturationSlider, JSlider brightnessSlider);
}
