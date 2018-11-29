package main;

import main.vehicles.cars.Car;
import main.vehicles.cars.Saab95;
import main.vehicles.cars.Volvo240;
import main.vehicles.transport.Scania;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    // To keep track of a singel cars position
    Point carPoint = new Point();

    // TODO: Make this general for all cars
    public void moveIt(int x, int y){
        carPoint.x = x;
        carPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            saabImage = getImage(new Saab95());
            scaniaImage = getImage(new Scania());
            volvoImage = getImage(new Volvo240());
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
    }


    public static enum OSType {
        Windows, MacOS, Linux;
    }

    

    private static OSType detectedOS;

    public BufferedImage getImage(Car car){
        String path = "";
        try {
            switch (getOperatingSystemType()) {
                case Windows:
                    path = "Laboration1\\src\\pics\\" + car.getClass().getSimpleName() + ".jpg";
                    break;
                case Linux:
                case MacOS:
                    path = "src/pics/" + car.getClass().getSimpleName() + ".jpg";
                    break;
            }
            return ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println("Image not found");
            return null;
        }
    }

    private OSType getOperatingSystemType() {
        if (detectedOS == null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                detectedOS = OSType.MacOS;
            } else if (OS.indexOf("win") >= 0) {
                detectedOS = OSType.Windows;
            } else
                detectedOS = OSType.Linux;
        }
        return detectedOS;
    }
}