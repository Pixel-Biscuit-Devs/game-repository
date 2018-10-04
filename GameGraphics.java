package main;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class GameGraphics extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3712190895199107520L;

	public BufferedImage scaleImage(BufferedImage imgToScale, double scaleX, double scaleY) {
		BufferedImage imgScaled = new BufferedImage((int) (imgToScale.getWidth() * scaleX),
				(int) (imgToScale.getHeight() * scaleY), BufferedImage.TYPE_INT_ARGB);
		AffineTransform at = new AffineTransform();
		at.scale(scaleX, scaleY);
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		imgScaled = scaleOp.filter(imgToScale, imgScaled);

		return imgScaled;
	}

	public BufferedImage scaleImage(BufferedImage imgToScale, double scale) {
		BufferedImage imgScaled = new BufferedImage((int) (imgToScale.getWidth() * scale),
				(int) (imgToScale.getHeight() * scale), BufferedImage.TYPE_INT_ARGB);
		AffineTransform at = new AffineTransform();
		at.scale(scale, scale);
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		imgScaled = scaleOp.filter(imgToScale, imgScaled);

		return imgScaled;
	}
}
